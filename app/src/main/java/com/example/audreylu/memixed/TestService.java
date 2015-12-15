package com.example.audreylu.memixed;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by audreylu on 2015/4/15.
 */
public class TestService extends Service {
    private static String TAG = "TestService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "start service");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "stop service");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    class TestBinder extends Binder{

    }
}
