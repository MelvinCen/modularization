package com.melvin.tool;


import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import androidx.annotation.NonNull;

/**
 * <p>Utils初始化相关 </p>
 */
public class AppUtils {

    private static Context context;

    private AppUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(Context context) {
        AppUtils.context = context.getApplicationContext();
    }

    public static void recycle() {
        context = null;
    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    public static Context getContext() {
        if (context != null) return context;
        throw new NullPointerException("u should init first");
    }

    /**
     * View获取Activity的工具
     *
     * @param view view
     * @return Activity
     */
    public static
    @NonNull
    Activity getActivity(View view) {
        Context context = view.getContext();

        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }

        throw new IllegalStateException("View " + view + " is not attached to an Activity");
    }

    /**
     * 检查对象不为null
     * @param obj
     * @return
     */
    public static boolean checkNotNull(Object obj) {
        return obj != null;
    }

    /**
     * 跳转到登录页面，重新登录
     */
    public static void ReLogin() {
//        SharedPreferenceUtil.getInstance().logoutClearData();
//        ARouter.getInstance().build(RouterConfig.CARD_LOGIN_PAGE).withFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK).navigation();
    }

    /**
     * 获取机器内所有应用基础信息
     *
     * @param context
     * @return
     */
    public static ArrayList<HashMap<String, Object>> getPackageItems(Context context) {
        PackageManager pckMan = context.getPackageManager();
        ArrayList<HashMap<String, Object>> items = new ArrayList<HashMap<String, Object>>();

        List<PackageInfo> packageInfo = pckMan.getInstalledPackages(0);

        for (PackageInfo pInfo : packageInfo) {

            HashMap<String, Object> item = new HashMap<String, Object>();

            item.put("appimage", pInfo.applicationInfo.loadIcon(pckMan));
            item.put("packageName", pInfo.packageName);
            item.put("versionCode", pInfo.versionCode);
            item.put("versionName", pInfo.versionName);
            item.put("appName", pInfo.applicationInfo.loadLabel(pckMan).toString());

            items.add(item);

        }

        return items;
    }


    /**
     * 判断当前的线程是不是在主线程
     *
     * @return
     */
//    public static boolean isRunInMainThread() {
//        return android.os.Process.myTid() == BaseApplication.getMainThreadId();
//    }

    /**
     * 在主线程执行runnable
     */
//    public static boolean post(Runnable runnable) {
//        return getHandler().post(runnable);
//    }

    /**
     * 获取主线程的handler
     */
//    public static Handler getHandler() {
//        return BaseApplication.getMainThreadHandler();
//    }

}