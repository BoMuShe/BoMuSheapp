package com.bomushe.tlm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Bottom_nav extends AppCompatActivity implements ViewPager.OnPageChangeListener,BottomNavigationView.OnNavigationItemSelectedListener{
    private BottomNavigationView navigationView;
    private ViewPager viewPager;
    private Home home = new Home();
    private Community community  = new Community();
    private My my = new My();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);

        viewPager = findViewById(R.id.home_viewpager);
        viewPager.addOnPageChangeListener(this);//监听viewPager页面变化
        navigationView = findViewById(R.id.bottomnavigationview);
        navigationView.setOnNavigationItemSelectedListener(this);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                switch (position){
                    case 0:
                        return home;
                    case 1:
                        return community;
                    case 2:
                        return my;
                }
                return null;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        navigationView.getMenu().getItem(position).setChecked(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        //menu/navigation.xml里加的android:orderInCategory属性就是下面item.getOrder()取的值
        viewPager.setCurrentItem(menuItem.getOrder());
        return true;
    }
}

