package com.example.audreylu.memixed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.List;


/**
 * A listview with a header which could be zoom in/out by special touch event
 */
public class ZoomHeaderListView extends ListView {

    private RelativeLayout mHeaderView;
    private ListView mContentView;

    public ZoomHeaderListView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public ZoomHeaderListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public ZoomHeaderListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle)
    {
        LayoutInflater.from(context).inflate(R.layout.activity_zoom_header, this, true);
        mHeaderView = (RelativeLayout)findViewById(R.id.rl_header);
        mContentView = (ListView)findViewById(R.id.lv_bottom);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev)
    {
        return super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev)
    {
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    protected void onLayout(boolean b, int i, int i2, int i3, int i4) {

    }


}
