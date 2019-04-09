package com.example.gimnasdual.AsyncTask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadTask extends AsyncTask<Void, Integer, Bitmap> {

    private static  int mProgressBarMax;
    private ImageView[] imatges; //Array de imatgeviews
    private Bitmap[] a = new Bitmap[1]; //Array de bitmaps
    private URL[] url = new URL[1];


    public DownloadTask(ImageView[] im){
        //mProgressDialog = pd;
        imatges = im;
    }

    // Do the task in background/non UI thread
    protected Bitmap doInBackground(Void... voids) {

        try{

            // Cargo les URLS
            for (int i=0;i<url.length;i++){
                url[i] = new URL("http://www.gimnasiostamonica.com/images/custom/section-bg-4.jpg");
            }

            //Crido el metode carregar fotos
            for (int i=0;i<url.length;i++){
                carregar_foto(i);
            }

        }catch(Exception e){
            Log.d("Hola",e.toString());
        }
        return null;

        }

    private void carregar_foto(int i) throws IOException {

        //Crido els metodes que em retrorna una bitmap i la guardo en una array de bitmaps
        a[i] =  download_Image(url[i]);
        //Crido el metode publica progress
        publishProgress(i);
    }


    private void descarregar(String nom_imatge,Bitmap bit) {


        try {
            //nom de la ruta
            String sFolder = Environment.getExternalStorageDirectory().getAbsolutePath() + "/ExempleDescargues";
            File f = new File(sFolder);

            //comprovo si la ruta existeix i sino existeix la creo
            if(!f.isDirectory()) {
                String newFolder = "/ExempleDescargues";
                String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
                File myNewFolder = new File(extStorageDirectory + newFolder);
                myNewFolder.mkdir();
            }

            //Coloco la ruta de la imatge
            String localFilename = sFolder + "/" + nom_imatge + ".jpg";
            ///Creo la imatge
            File img = new File(localFilename);

            FileOutputStream fos = null;

            //Omplo la imatge en el fitxer
            try {
                fos = new FileOutputStream(img);
                bit.compress(Bitmap.CompressFormat.PNG, 100, fos);
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("Descarregar",e.getMessage());
            } finally {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }catch (Exception e){}
    }



    public static Bitmap download_Image(URL url) {

        //Guardo una imatge d'una URL a una bitmap

        Bitmap bm = null;
        try {
            URL aURL = url;
            URLConnection conn = aURL.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
        } catch (IOException e) {
            Log.e("Hub","Error getting the image from server : " + e.getMessage().toString());
        }
        return bm;
    }


    private void imprimir_foto(int i){
        //El nom de la imatge és el seu numero
        String nom = ""+i;
        //Guardo la imatge en el fitxer
        descarregar(nom,a[i]);
        //Mostro la imatge
        imatges[i].setImageBitmap(a[i]);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {

        //Seleciono quina imatge mostrare

        switch (values[0]){
            case(0):
                imprimir_foto(0);
                //pro.setProgress(20);
                break;
            /*case(1):
                imprimir_foto(1);
                pro.setProgress(40);
                break;
            case(2):
                imprimir_foto(2);
                pro.setProgress(60);
                break;
            case(3):
                imprimir_foto(3);
                pro.setProgress(80);
                break;
            case(4):
                imprimir_foto(4);
                pro.setProgress(100);
                break;*/
        }

    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
    }

}

