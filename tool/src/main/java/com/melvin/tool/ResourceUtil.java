package com.melvin.tool;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import java.io.ByteArrayOutputStream;

public class ResourceUtil {
    /**
     * 获取values文件夹下定义的color
     *
     * @param color
     * @return
     */
    public static int getColor(int color) {
        return AppUtils.getContext().getResources().getColor(color);
    }

    /**
     * 获取values文件夹下定义的string
     *
     * @param string
     * @return
     */
    public static String getString(int string) {
        return AppUtils.getContext().getResources().getString(string);
    }

    /**
     * 获取values文件夹下定义的dimen
     *
     * @param dimen
     * @return 返回对应的px值
     */
    public static float getDimen(int dimen) {
        return AppUtils.getContext().getResources().getDimension(dimen);
    }

    public static Drawable getDrawable(int drawable) {
        return AppUtils.getContext().getResources().getDrawable(drawable, null);
    }

    /**
     * 获取values文件夹下定义的array-string
     *
     * @param array
     * @return 返回对应的String[]
     */
    public static String[] getStringArray(int array) {
        return AppUtils.getContext().getResources().getStringArray(array);
    }

    /**
     * 图片转byte数组
     *
     * @param bitmap
     * @return
     */
    public static byte[] bitmap2Bytes(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        return baos.toByteArray();
    }

    /**
     * byte数组转图片
     *
     * @param data
     * @return
     */
    public static Bitmap byte2Bitmap(byte[] data) {
        return BitmapFactory.decodeByteArray(data, 0, data.length);
    }

}
