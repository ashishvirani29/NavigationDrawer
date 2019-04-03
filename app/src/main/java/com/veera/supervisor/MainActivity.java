package com.veera.supervisor;

import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import static android.view.Gravity.LEFT;

public class MainActivity extends AppCompatActivity {
    ImageView btnOpenDrawer;
    RecyclerView navigarionrecyclerview;
    DrawerLayout drawerLayout;
    public DrawerAdapter drawerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigarionrecyclerview = findViewById(R.id.navigarionrecyclerview);
        btnOpenDrawer = findViewById(R.id.btnOpenDrawer);
        drawerLayout = findViewById(R.id.drawerLayout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);


        btnOpenDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCloseDrawer();
            }
        });
        setMenuAdapter();

    }

    private void setMenuAdapter() {
        drawerAdapter = new DrawerAdapter(MainActivity.this);
        navigarionrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        navigarionrecyclerview.setAdapter(drawerAdapter);
        replaceFragment(new HomeFragment());
        drawerAdapter.setItemClickCallback(new callbackListener<Integer, String, String, String>() {
            @Override
            public void onClickCallBack(Integer position, String videoID, String tkn, String authentication) {
                switch (position){
                    case 0:
                        replaceFragment(new HomeFragment());
                        break;
                    case 1:
                        replaceFragment(new HomeFragment());
                        break;
                    case 2:
                        replaceFragment(new HomeFragment());
                        break;
                    case 3:
                        replaceFragment(new HomeFragment());
                        break;
                    case 4:
                        replaceFragment(new HomeFragment());
                        break;
                    case 5:
                        replaceFragment(new HomeFragment());
                        break;
                }
                openCloseDrawer();
            }
        });
    }

    private void openCloseDrawer() {
        if (drawerLayout.isDrawerOpen(LEFT)) drawerLayout.closeDrawer(LEFT);
        else drawerLayout.openDrawer(LEFT);
    }

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.framelayout, fragment)
                .commit();
    }
}
