package com.melvin.quick_dev;

import android.app.Application;

import com.melvin.base.application.BaseApplication;

public class AppApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化组件application
        initMoudleApp(this);
        initMoudleData(this);

    }

    @Override
    public void initMoudleApp(Application application) {
        //未实现
    }

    @Override
    public void initMoudleData(Application application) {
        //未实现
    }
}
