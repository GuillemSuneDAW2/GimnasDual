package com.example.gimnasdual.AsyncTask;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class DownloadTask extends AsyncTask<URL,Integer,List<Bitmap>> {

    private static  int mProgressBarMax;

    private ProgressBar mProgressBarDownload;
    private LinearLayout mLL;
    private Context mContext;


    public DownloadTask(Context c, ProgressBar pb, LinearLayout ll){
        //mProgressDialog = pd;
        mContext = c;
        mProgressBarDownload=pb;
        mLL = ll;
    }

    // Before the tasks execution
    protected void onPreExecute(){

        mProgressBarDownload.setProgress(0);
        //mProgressBarDownload.setMax(PROGRESS_BAR_MAX);
    }

    // Do the task in background/non UI thread
    protected List<Bitmap> doInBackground(URL...urls){

        mProgressBarMax = urls.length;
        //URL url = urls[0];
        URLConnection connection = null;
        List<Bitmap> bitmaps = new ArrayList<>();

        // Loop through the urls
        for(int i=0;i<mProgressBarMax;i++){
            URL currentURL = urls[i];
            // So download the image from this url
            try{
                // Initialize a new http url connection
                connection = (URLConnection) currentURL.openConnection();

                // Connect the http url connection
                connection.connect();

                // Get the input stream from http url connection
                InputStream inputStream = connection.getInputStream();

                // Initialize a new BufferedInputStream from InputStream
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

                // Convert BufferedInputStream to Bitmap object
                Bitmap bmp = BitmapFactory.decodeStream(bufferedInputStream);

                // Add the bitmap to list
                bitmaps.add(bmp);

                // Publish the async task progress
                // Added 1, because index start from 0
                publishProgress((int) (((i+1) / (float) mProgressBarMax) * 100));
                if(isCancelled()){
                    break;
                }

            }catch(IOException e){
                e.printStackTrace();
            }finally{
                // Disconnect the http url connection
                //connection.disconnect();
            }
        }
        // Return bitmap list
        return bitmaps;
    }

    // On progress update
    protected void onProgressUpdate(Integer... progress){
        // Update the progress bar
        mProgressBarDownload.setProgress(progress[0]);
    }

    // On AsyncTask cancelled
    protected void onCancelled(){
        Toast.makeText(mContext,"Task Cancelled.",Toast.LENGTH_LONG).show();
    }

    // When all async task done
    protected void onPostExecute(List<Bitmap> result){


        // Remove all views from linear layout
        mLL.removeAllViews();

        // Loop through the bitmap list
        for(int i=0;i<result.size();i++){
            Bitmap bitmap = result.get(i);
//            // Save the bitmap to internal storage
//            Uri imageInternalUri = saveImageToInternalStorage(bitmap,i);
            // Display the bitmap from memory
            addNewImageViewToLayout(bitmap);
//            // Display bitmap from internal storage
//            addNewImageViewToLayout(imageInternalUri);
        }

    }


    // Custom method to add a new image view using bitmap
    protected void addNewImageViewToLayout(Bitmap bitmap){
        // Initialize a new ImageView widget
        ImageView iv = new ImageView(mContext);

        // Set an image for ImageView
        iv.setImageBitmap(bitmap);

        // Create layout parameters for ImageView
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 500);

        // Add layout parameters to ImageView
        iv.setLayoutParams(lp);

        // Finally, add the ImageView to layout
        mLL.addView(iv);
    }
}

