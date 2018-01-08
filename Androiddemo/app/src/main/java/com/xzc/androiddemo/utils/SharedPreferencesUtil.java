package com.xzc.androiddemo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.xzc.androiddemo.MyApplication;

public class SharedPreferencesUtil {
	/**
	 * 
	 * Title: clearSharedPreferencesInfo<br>
	 * Description: 删除指定sp中的数据<br>
	 * Depend : TODO <br>
	 * @param itemName
	 * @since JDK 1.7
	 */
	public static void clearSharedPreferencesInfo(String itemName) {
		SharedPreferences sp = MyApplication.mAppContext.getSharedPreferences(itemName, Context.MODE_PRIVATE);
		Editor edit = sp.edit();
		edit.clear().commit();
	}

	/** 保存用户的id */
	public static void setUid(String uid) {
		SharedPreferences sp = MyApplication.mAppContext.getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putString("uid", uid).commit();
	}

	/** 获取用户的id */
	public static String getUid() {
		SharedPreferences sp = MyApplication.mAppContext.getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
		return sp.getString("uid", "");
	}

	/** 保存用户的token */
	public static void setToken(String Token) {
		SharedPreferences sp = MyApplication.mAppContext.getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putString("Token", Token).commit();
	}

	/** 获取用户的token */
	public static String getToken() {
		SharedPreferences sp = MyApplication.mAppContext.getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
		return sp.getString("Token", "");
	}

	/** 保存用户的昵称 */
	public static void setNickname(String nickname) {
		SharedPreferences sp = MyApplication.mAppContext.getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putString("nickname", nickname).commit();
	}

	/** 获取用户的昵称 */
	public static String getNickname() {
		SharedPreferences sp = MyApplication.mAppContext.getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
		return sp.getString("nickname", "");
	}
	
	/** 保存用户的头像 */
	public static void setAvatar(String avatar) {
		SharedPreferences sp = MyApplication.mAppContext.getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putString("avatar", avatar).commit();
	}
	/** 获取用户的头像 */
	public static String getAvatar() {
		SharedPreferences sp = MyApplication.mAppContext.getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
		return sp.getString("avatar", "");
	}


	/** 保存用户所在的纬度 */
	public static void setLatitude(String lat) {
		SharedPreferences sp = MyApplication.mAppContext.getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putString("lat", lat).commit();
	}

	/** 获取用户所在的纬度 */
	public static String getLatitude() {
		SharedPreferences sp = MyApplication.mAppContext.getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
		return sp.getString("lat", "");
	}

	/** 保存用户所在的经度 */
	public static void setLongitude(String lng) {
		SharedPreferences sp = MyApplication.mAppContext.getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putString("lng", lng).commit();
	}

	/** 获取用户所在的经度 */
	public static String getLongitude() {
		SharedPreferences sp = MyApplication.mAppContext.getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
		return sp.getString("lng", "");
	}
	/** 保存App下载路径 */
	public static void setApppath(String appPath) {
		SharedPreferences sp = MyApplication.mAppContext.getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putString("appPath", appPath).commit();
	}

	/** 获取App下载路径 */
	public static String getApppath() {
		SharedPreferences sp = MyApplication.mAppContext.getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
		return sp.getString("appPath", "");
	}


	/** 保存用户屏幕的高度 */
	public static void setScreenHeight(int ScreenHeight) {
		SharedPreferences sp = MyApplication.mAppContext.getSharedPreferences("System", Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putInt("ScreenHeight", ScreenHeight).commit();
	}

	/** 获取用户屏幕的高度 */
	public static int getScreenHeight() {
		SharedPreferences sp = MyApplication.mAppContext.getSharedPreferences("System", Context.MODE_PRIVATE);
		return sp.getInt("ScreenHeight", -1);
	}


	/** 获取用户屏幕的宽度 */
	public static int getScreenWidth() {
		SharedPreferences sp = MyApplication.mAppContext.getSharedPreferences("System", Context.MODE_PRIVATE);
		return sp.getInt("Width", -1);
	}
	/** 保存用户屏幕的宽度 */
	public static void setScreenWidth( int ScreenWidth) {
		SharedPreferences sp = MyApplication.mAppContext.getSharedPreferences("System", Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putInt("ScreenWidth", ScreenWidth).commit();
	}
	
	/** 保存用户是否第一次启动 */
	public static void setIsFristStart(String booleanValue) {
		SharedPreferences sp = MyApplication.mAppContext.getSharedPreferences("System", Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putString("isFristStart", booleanValue).commit();
	}

	/** 获取用户是否第一次启动 */
	public static String getIsFristStart() {
		SharedPreferences sp = MyApplication.mAppContext.getSharedPreferences("System", Context.MODE_PRIVATE);
		return sp.getString("isFristStart", "");
	}

	/** 获取所有城市的json串 */
	public static String getAllCityJson() {
		SharedPreferences sp = MyApplication.mAppContext.getSharedPreferences("System", Context.MODE_PRIVATE);
		return sp.getString("AllCityJson", "");
	}
	/** 保存所有城市的json串*/
	public static void setAllCityJson( String AllCityJson) {
		SharedPreferences sp = MyApplication.mAppContext.getSharedPreferences("System", Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putString("AllCityJson", AllCityJson).commit();
	}


}
