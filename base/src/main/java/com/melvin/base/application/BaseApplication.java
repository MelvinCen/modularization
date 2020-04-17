package com.melvin.base.application;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import com.alibaba.android.arouter.launcher.ARouter;
import com.melvin.base.BuildConfig;
import com.melvin.tool.AppUtils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public abstract class BaseApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        init();

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        //路由退出
        ARouter.getInstance().destroy();

        AppUtils.recycle();
    }

    public abstract void initMoudleApp(Application application);

    public abstract void initMoudleData(Application application);


    /**
     * 初始化操作
     */
    public void init() {
        AppUtils.init(this);
        setLogDebugable();
        initARouter();

        //初始化thread和handler
        mMainThreadId = android.os.Process.myTid();
        mMainThread = Thread.currentThread();
        mMainThreadHandler = new Handler();
        mMainLooper = getMainLooper();

    }

    /**
     * 初始化打印日志
     */
    public void setLogDebugable() {

        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return IsDebugNow();
            }
        });
    }

    /**
     * 初始化Arouter路由
     */
    private void initARouter() {
        // 初始化 ARouter
        if (IsDebugNow()) {// 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this);
    }

    public boolean IsDebugNow() {
        return BuildConfig.isDebug;
    }

    //主线程Handler
    public static Handler mMainThreadHandler;
    //主线程ID
    public static int mMainThreadId = -1;
    //主线程
    public static Thread mMainThread;
    //主线程Looper
    public static Looper mMainLooper;
    public static Handler getMainThreadHandler() {
        return mMainThreadHandler;
    }

    public static int getMainThreadId() {
        return mMainThreadId;
    }

    public static Thread getMainThread() {
        return mMainThread;
    }

    public static Looper getMainThreadLooper() {
        return mMainLooper;
    }


}
