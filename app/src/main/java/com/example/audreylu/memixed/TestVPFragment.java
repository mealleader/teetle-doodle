package com.example.audreylu.memixed;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.logging.Logger;

/**
 * Created by audreylu on 2015/12/14.
 */
public class TestVPFragment extends Fragment {
    private String mFragmentName = "";
    private static final String TAG = "TestVPFragment";
    private TextView mNameTv;
    private ImageView mContentIv;

    public TestVPFragment(){

    }

    @Override
    public void onAttach(Activity activity) {
        Log.i(TAG, mFragmentName + " onAttach, instance: " + String.valueOf(this));
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, mFragmentName + " onCreateView, instance: " + String.valueOf(this));
        View contactsLayout = inflater.inflate(R.layout.fragment_test_vp, container, false);
        mNameTv = (TextView)contactsLayout.findViewById(R.id.tv_name);
        mContentIv = (ImageView)contactsLayout.findViewById(R.id.iv_content);
        Bundle args = getArguments();
        if (args != null){

            if (args.getString("name") != null){
                mFragmentName = args.getString("name");
                mNameTv.setText(mFragmentName);
            }

        }
        return contactsLayout;
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, mFragmentName + " onDestroyView, instance: " + String.valueOf(this));
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, mFragmentName + " onDestroy, instance: " + String.valueOf(this));
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i(TAG, mFragmentName + " onDetach, instance: " + String.valueOf(this));
        super.onDetach();
    }

    public void update(int resId){

    }
}
