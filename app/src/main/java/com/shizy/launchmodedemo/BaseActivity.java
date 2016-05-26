package com.shizy.launchmodedemo;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

/**
 * Created by shizhongyong on 5/26/2016.
 */
@EActivity
public class BaseActivity extends AppCompatActivity {

    @Click({R.id.standard, R.id.singleTop, R.id.singleTask, R.id.singleInstance})
    protected void onClick(View view) {
        switch (view.getId()) {
            case R.id.standard:
                StandardActivity_.intent(this).start();
                break;
            case R.id.singleTop:
                SingleTopActivity_.intent(this).start();
                break;
            case R.id.singleTask:
                SingleTaskActivity_.intent(this).start();
                break;
            case R.id.singleInstance:
                SingleInstanceActivity_.intent(this).start();
                break;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("", "shizy---onCreate----");
        Log.d("", "shizy---taskId: " + getTaskId() + "  ||| hashCode: " + hashCode());
        dumpTaskAffinity();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("", "shizy---onNewIntent----");
        Log.d("", "shizy---taskId: " + getTaskId() + "  ||| hashCode: " + hashCode());
        dumpTaskAffinity();
    }

    protected void dumpTaskAffinity() {
        try {
            ActivityInfo info = this.getPackageManager()
                    .getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
            Log.d("", "shizy---taskAffinity:" + info.taskAffinity);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
