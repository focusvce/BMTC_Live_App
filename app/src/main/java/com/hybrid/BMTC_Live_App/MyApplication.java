package com.hybrid.BMTC_Live_App;

import android.app.Application;
import android.content.Context;

/**
 * Created by adarsh on 17/3/16.
 */
public class MyApplication extends Application {
    private static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }
    public static MyApplication getInstance(){
        return myApplication;
    }
    public static Context getAppContext(){
        return myApplication.getApplicationContext();
    }
}
