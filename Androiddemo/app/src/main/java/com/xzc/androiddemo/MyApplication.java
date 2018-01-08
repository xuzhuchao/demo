/**
 * Copyright (C) 2016 Hyphenate Inc. All rights reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xzc.androiddemo;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
//import android.support.multidex.MultiDex;

//import com.pgyersdk.crash.PgyCrashManager;

import com.xzc.androiddemo.utils.LogUtils;

import java.util.Iterator;
import java.util.List;

//import cn.jpush.android.api.JPushInterface;

//import com.easemob.redpacketsdk.RedPacket;

public class MyApplication extends Application {

    public static Context mAppContext;
    private static MyApplication instance;



    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = this;
        instance = this;
//        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
//            @Override
//            public void uncaughtException(Thread thread, Throwable ex) {
//
//                LogUtils.i("线程ID=" + thread.getId());
//                LogUtils.i("线程name=" + thread.getName());
//                LogUtils.i("异常信息=" + ex.getMessage());
//                LogUtils.i("异常信息ex=" + ex);
//            }
//        });

    }

    public static MyApplication getInstance() {
        return instance;
    }


}
