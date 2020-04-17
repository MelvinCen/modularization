package com.melvin.tool;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityUtils {

    private ActivityUtils() {
    }

    private static ActivityUtils instance = new ActivityUtils();
    private static List<Activity> activities = new ArrayList<Activity>();

    public static ActivityUtils getInstance() {
        return instance;
    }

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activities.size(); i < size; i++) {
            if (null != activities.get(i)) {
                activities.get(i).finish();
            }
        }
        activities.clear();
    }

    /**
     * 结束所有Activity,除homeactivity外
     */
    public void finishActivityExtraHome() {
        for (int i = 0, size = activities.size(); i < size; i++) {
            if (null != activities.get(i) && !activities.get(i).getClass().getSimpleName().equals("HomeActivity")) {
                activities.get(i).finish();
            }
        }
    }


    public boolean isAllActivityFinish() {
        for (int i = 0, size = activities.size(); i < size; i++) {
            if (null != activities.get(i) && !activities.get(i).isFinishing()) {
                return false;
            }
        }
        return true;
    }

    public Activity getCurrentActivity() {

        return activities.get(activities.size() - 1);
    }

}