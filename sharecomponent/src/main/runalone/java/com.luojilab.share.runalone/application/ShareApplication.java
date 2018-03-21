package com.luojilab.share.runalone.application;

import android.app.Application;
import android.widget.Toast;

/**
 * Created by mrzhang on 2017/8/16.
 */

public class ShareApplication extends Application {

    @Override
    public void onCreate() {
        Toast.makeText(this,this.getClass().getSimpleName(),Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

}