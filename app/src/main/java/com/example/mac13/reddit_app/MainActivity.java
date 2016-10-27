package com.example.mac13.reddit_app;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ViewPager viewPager;
    TextView textViewTab1, textViewTab2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        overridePendingTransition(R.anim.activity_open_translate, R.anim.activity_close_scale);
        setContentView(R.layout.activity_main);

        textViewTab1 = (TextView) findViewById(R.id.textViewTab1);
        textViewTab2 = (TextView) findViewById(R.id.textViewTab2);

        textViewTab1.setOnClickListener(this);
        textViewTab2.setOnClickListener(this);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position==0) {
                    textViewTab1.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.textColor));
                    textViewTab2.setTextColor(Color.BLACK);

                }
                else{
                    textViewTab1.setTextColor(Color.BLACK);
                    textViewTab2.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.textColor));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textViewTab1:
                viewPager.setCurrentItem(0, true);


                break;
            case R.id.textViewTab2:
                viewPager.setCurrentItem(1, true);
                break;
        }
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return new RandomColorFragment();
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
//        overridePendingTransition(R.anim.activity_open_scale, R.anim.activity_close_translate);
    }
}

