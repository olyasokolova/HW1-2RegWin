package com.app.nik.regwindow;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ShareActionProvider;

public class SecondActivity extends AppCompatActivity {
    private class DrawerItemClickListener implements ListView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }
    private ShareActionProvider shareActionProvider;
    private String[] titles;
    private ListView drawerList;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private int currentPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        titles = getResources().getStringArray(R.array.titles);
        drawerList = findViewById(R.id.drawer);
        drawerLayout = findViewById(R.id.drawerLayout);
        drawerList.setAdapter(
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,titles));
        drawerList.setOnItemClickListener(new DrawerItemClickListener());
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.addDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportFragmentManager().addOnBackStackChangedListener(
                new FragmentManager.OnBackStackChangedListener() {
                    @Override
                    public void onBackStackChanged() {
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        Fragment fragment = fragmentManager.findFragmentByTag("visible_fragment");
                        if(fragment instanceof TopFragment)
                            currentPosition=0;
                        if(fragment instanceof FirstFoodFragment)
                            currentPosition=1;
                        if(fragment instanceof SecondFoodFragment)
                            currentPosition=2;
                        if (fragment instanceof SaladFragment)
                            currentPosition=3;
                        if (fragment instanceof DrinkFragment)
                            currentPosition=4;
                        setActionBarTitle(currentPosition);
                        drawerList.setItemChecked(currentPosition,true);
                    }
                }
        );
        }
    private void selectItem(int position){
        currentPosition = position;
        Fragment fragment;
        switch (position)
        {
            case 1:
                fragment = new FirstFoodFragment();
                break;
            case 2:
                fragment = new SecondFoodFragment();
                break;
            case 3:
                fragment = new SaladFragment();
                break;
            case 4:
                fragment = new DrinkFragment();
                break;
                default:
                    fragment = new TopFragment();
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame,fragment,"visible_fragment");
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
        setActionBarTitle(position);
        drawerLayout.closeDrawer(drawerList);

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean drawerOpen = drawerLayout.isDrawerOpen(drawerList);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }
    private void setActionBarTitle(int position){
        String title;
        if(position==0)
            title = getResources().getString(R.string.app_name);
        else
            title = titles[position];
        getSupportActionBar().setTitle(title);
    }
}
