package com.example.audreylu.memixed;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import fr.northborders.AnimationPlayground.DrawPath.ProgressActivity;

/**
 * Created by audreylu on 2015/4/15.
 */
public class MainActivity extends Activity implements View.OnClickListener{

    private Button mBtnStart;
    private Button mBtnStop;
    private Button mBtnBind;
    private Button mBtnUnBind;
    private TextView mTvTest;
    private Button mBtnProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnStart = (Button)findViewById(R.id.btn_start);
        mBtnStop = (Button)findViewById(R.id.btn_stop);
        mBtnBind = (Button)findViewById(R.id.btn_bind);
        mBtnUnBind = (Button)findViewById(R.id.btn_unbind);
        mTvTest = (TextView)findViewById(R.id.tv_display);
        mBtnProgress = (Button)findViewById(R.id.btn_progress);

        mBtnStart.setOnClickListener(this);
        mBtnStop.setOnClickListener(this);
        mBtnBind.setOnClickListener(this);
        mBtnUnBind.setOnClickListener(this);
        mBtnProgress.setOnClickListener(this);

        addSpannableString();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                startService(new Intent(this, TestService.class));
                break;

            case R.id.btn_progress:
                startProgress();
                break;
        }
    }

    private void addSpannableString()
    {
        SpannableString ss = new SpannableString("hello world");

        // font
        ss.setSpan(new TypefaceSpan("monospace"), 0, 2, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        ss.setSpan(new TypefaceSpan("serif"), 3, 4, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        mTvTest.setText(ss);

    }

    private void startProgress()
    {
        Intent intent = new Intent(this, TestFragmentPagerActivity.class);
        startActivity(intent);
    }
}
