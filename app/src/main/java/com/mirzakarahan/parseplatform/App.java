package com.mirzakarahan.parseplatform;

import android.app.Application;

import com.parse.Parse;

public class App extends Application{

    @Override
    public void onCreate() {
        Parse.initialize(new Parse.Configuration.Builder(this)
        .applicationId("applicationId")
        .clientKey("clientKey")
        .server("http://server/parse")
        .build()
        );
        super.onCreate();
    }
}
