package com.shizy.launchmodedemo;

import android.os.Bundle;
import android.util.Log;

import org.androidannotations.annotations.EActivity;

/**
 * Created by shizhongyong on 5/26/2016.
 */
@EActivity(R.layout.activity_main)
public class StandardActivity extends BaseActivity {

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("", "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("", "onRestoreInstanceState");
    }
}
