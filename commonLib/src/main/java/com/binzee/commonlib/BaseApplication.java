package com.binzee.commonlib;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author 狐彻
 * 2020/11/13 15:28
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(this);
    }
}
