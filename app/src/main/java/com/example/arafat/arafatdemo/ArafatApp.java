package com.example.arafat.arafatdemo;

import android.app.Application;

import com.example.arafat.arafatdemo.util.utilLog;

/**
 * Created by Arafat on 2/6/2017.
 */

public class ArafatApp extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        utilLog.setDebug(true);

    }
}
