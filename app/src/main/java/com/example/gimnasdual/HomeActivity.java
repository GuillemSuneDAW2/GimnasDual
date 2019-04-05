package com.example.gimnasdual;

import android.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.gimnasdual.fragments.CategoriesFragment;
import com.example.gimnasdual.fragments.EsdevenimentsFragment;
import com.example.gimnasdual.fragments.SalesFragment;

public class HomeActivity extends AppCompatActivity {

    private Toolbar appbar;
    private DrawerLayout drawerLayout;
    private NavigationView navView;
    private int provaMerge = 0;
    private int prova2Merge2 = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        appbar = findViewById(R.id.appbar);
        setSupportActionBar(appbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = findViewById(R.id.drawer_layout);

        navView = findViewById(R.id.navview);
        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        boolean fragmentTransaction = false;
                        Fragment fragment = null;

                        switch (menuItem.getItemId()) {
                            case R.id.navView_secc1:
                                fragment = new CategoriesFragment();
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.content_frame, fragment).addToBackStack("categories")
                                        .commit();

                                menuItem.setChecked(true);
                                getSupportActionBar().setTitle(menuItem.getTitle());
                                break;
                            case R.id.navView_secc2:
                                fragment = new EsdevenimentsFragment();
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.content_frame, fragment).addToBackStack("esdeveniments")
                                        .commit();

                                menuItem.setChecked(true);
                                getSupportActionBar().setTitle(menuItem.getTitle());
                                break;
                            case R.id.navView_secc3:
                                fragment = new SalesFragment();
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.content_frame, fragment).addToBackStack("sales")
                                        .commit();

                                menuItem.setChecked(true);
                                getSupportActionBar().setTitle(menuItem.getTitle());
                                break;
                            case R.id.navView_secc4:
                                Toast.makeText(HomeActivity.this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.navView_secc5:
                                Toast.makeText(HomeActivity.this, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                                break;
                        }
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    @Override
    public void onBackPressed() {
        final FragmentManager fm = getFragmentManager();
        final int count = fm.getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
        } else {
            fm.popBackStack();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
