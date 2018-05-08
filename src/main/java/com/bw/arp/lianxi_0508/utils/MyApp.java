package com.bw.arp.lianxi_0508.utils;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by ARP on 2018/5/4.
 */

public class MyApp extends Application {
    private static MyApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
        Fresco.initialize(this);
        ImageLoaderConfiguration build = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoaderConfiguration defaultcof = ImageLoaderConfiguration.createDefault(getApplicationContext());
        ImageLoader.getInstance().init(build);


    }
    public static MyApp getInstance(){
        return mInstance;
    };

}
