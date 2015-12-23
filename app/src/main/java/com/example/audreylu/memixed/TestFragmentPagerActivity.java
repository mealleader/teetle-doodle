package com.example.audreylu.memixed;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by audreylu on 2015/12/9.
 */
public class TestFragmentPagerActivity extends FragmentActivity {
    private static final String TAG = "TestFragmentPager";
    private static final int NUM_FRAG = 4;

    ViewPager mViewPager;
    TextView mClickTv;

    MyFragmentAdapter mAdapter;
    int mCurPage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_pager);

        mViewPager = (ViewPager)findViewById(R.id.viewpager);
        mClickTv = (TextView)findViewById(R.id.tv_switch);
        mClickTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurPage++;
                if (mCurPage == NUM_FRAG){
                    mCurPage = 0;
                }
                mViewPager.setCurrentItem(mCurPage);
            }
        });

        mAdapter = new MyFragmentAdapter(super.getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setSelectPage(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void setSelectPage(int index) {
        mViewPager.setCurrentItem(index);
    }

    class MyFragmentAdapter extends FragmentPagerAdapter{

        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Log.i(TAG, "call getItem:" + position);
            return createFragment(position);
        }

        @Override
        public int getCount() {
            return NUM_FRAG;
        }

        private Fragment createFragment(int pos){
            TestVPFragment frag = new TestVPFragment();
            Bundle args = new Bundle();
            frag.setArguments(args);
            args.putString("name", "" + pos);
            return frag;
        }
    }
}
