package com.project.Year;

import android.app.Application;

import com.firebase.client.Firebase;

public class FirebaseUsage extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
