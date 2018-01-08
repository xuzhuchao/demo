package com.xzc.androiddemo.base;

import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.xzc.androiddemo.R;
import com.xzc.androiddemo.utils.ActivityManager;
import com.xzc.androiddemo.utils.LogUtils;

/**
 * Created by Administrator on 2017-02-15.
 */

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";

    private ActivityManager activityManager = ActivityManager.getActivityManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        LogUtils.i(TAG, "******" + this.getClass().getSimpleName() + "onCreate() invoked!******");

        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
//			getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//			SystemBarTintManager tintManager = new SystemBarTintManager(this);
//			tintManager.setStatusBarTintEnabled(false);
//			tintManager.setStatusBarTintResource(R.color.background_theme);// 通知栏所需颜色
        }

        activityManager.pushActivity(this);
//		overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);  //启动动画

    }


    @Override
    protected void onStart() {
        LogUtils.i(TAG, "******" + this.getClass().getSimpleName() + "onStart() invoked!******");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        LogUtils.i(TAG, "******" + this.getClass().getSimpleName() + "onRestart() invoked!******");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        LogUtils.i(TAG, "******" + this.getClass().getSimpleName() + "onResume() invoked!******");
        super.onResume();
    }

    @Override
    protected void onPause() {
        LogUtils.i(TAG, "******" + this.getClass().getSimpleName() + "onPause() invoked!******");
        super.onPause();
    }

    @Override
    protected void onStop() {
        LogUtils.i(TAG, "******" + this.getClass().getSimpleName() + "onStop() invoked!******");
        super.onStop();
    }

    @Override
    protected void onDestroy() {

        LogUtils.i(TAG, "******" + this.getClass().getSimpleName() + "onDestroy() invoked!******");
        super.onDestroy();
        activityManager.removeActivity(this);
    }


    @Override
    public void onBackPressed() {
        finish();
		overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out );
        super.onBackPressed();
    }
}
