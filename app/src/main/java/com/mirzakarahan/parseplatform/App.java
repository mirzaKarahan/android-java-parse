package com.mirzakarahan.parseplatform;

import android.app.Application;

import com.parse.Parse;

public class App extends Application{

    @Override
    public void onCreate() {
        Parse.initialize(new Parse.Configuration.Builder(this)
        .applicationId("c1f8e5081e1506137fea6b8f85d40620d50d7d3c")
        .clientKey("3f1269aea55fd74bdad08e8c2ef853649ce108d3")
        .server("http://13.58.213.75:80/parse")
        .build()
        );
        super.onCreate();
    }
}
