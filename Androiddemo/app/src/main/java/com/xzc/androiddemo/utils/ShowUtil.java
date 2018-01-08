package com.xzc.androiddemo.utils;

import android.view.Gravity;
import android.widget.Toast;

import com.xzc.androiddemo.MyApplication;

public class ShowUtil {
	private static Toast mToast;

	public static void showToast( String text) {
		cancelLastToast();
		mToast = Toast.makeText(MyApplication.mAppContext, text, Toast.LENGTH_SHORT);
		mToast.setGravity(Gravity.CENTER, 0, 0);
		mToast.show();
	}

	/*取消上一次toast*/
	private static void cancelLastToast() {
		if (mToast != null) {
			mToast.cancel();
			mToast = null;
		}
	}
	
	public static void showToast(int id) {
		cancelLastToast();
		mToast = Toast.makeText(MyApplication.mAppContext, id, Toast.LENGTH_SHORT);
		mToast.setGravity(Gravity.CENTER, 0, 0);
		mToast.show();
	}
}
