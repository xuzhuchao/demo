package com.xzc.androiddemo.utils;


import android.app.Activity;

import java.util.Stack;

public class ActivityManager {

    private static Stack<Activity> activityStack;
    private static ActivityManager activityManager;


    /**
     * 获取activity栈中有多少个activity
     */
    public int getActivityStackSize() {

        return activityStack.size();
    }

    /**
     * 获取activity的栈
     */
    public Stack<Activity> getActivityStack() {
        return activityStack;
    }

    /**
     * 初始化activity管理器
     */
    public static ActivityManager getActivityManager() {

        if (activityManager == null) {
            activityManager = new ActivityManager();
        }
        return activityManager;
    }

    //将当前Activity推入栈中
    public void pushActivity(Activity activity) {

        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    //获得当前栈顶Activity
    public Activity currentActivity() {

        Activity activity = null;
        if (!activityStack.isEmpty()) {
            activity = activityStack.lastElement();
        }
        return activity;
    }

    //退出栈顶Activity
    public void popActivity(Activity activity) {
        if (activity != null) {
            activity.finish();
            activityStack.remove(activity);
            activity = null;
        }
    }


    public void removeActivity(Activity activity) {

//		LogUtils.i(TAG, "pop point activity");
        if (activity != null) {
            LogUtils.i(getClass().getName(), activity);
            activity.finish();
            activityStack.remove(activity);
            activity = null;
        }
    }

    //退出栈中所有Activity
    public void popAllActivityException(Class<?> cls) {

        while (true) {
            Activity activity = currentActivity();
            if (activity == null) {
                break;
            }

            if (activity.getClass().equals(cls)) {
                if (activityStack.size() == 1) {
                    popActivity(activity);
                    break;
                }
            }

            popActivity(activity);
        }
    }

    public void popAllActivities() {
        if (activityStack != null) {
            for (Activity activity : activityStack) {
                LogUtils.i("popAllActivities-->", activity.getClass().getName());
                activity.finish();
            }
        }
    }

    //退出其他的activity
    public void popOtherActivities(Class<?> cls) {

        if (null != activityStack) {
            for (Activity activity : activityStack) {
                if (!activity.getClass().equals(cls)) {
                    LogUtils.i("popAllActivities-->", activity.getClass().getName());
                    activity.finish();
                }
            }
        }
    }


}
