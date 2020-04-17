package com.melvin.base.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;


interface ChainSetter<VH> {

    VH setText(int viewId, CharSequence text);

    VH setTextColor(int viewId, @ColorInt int textColor);

    VH setImageResource(int viewId, @DrawableRes int resId);

    VH setImageDrawable(int viewId, Drawable drawable);

    VH setImageBitmap(int viewId, Bitmap bitmap);

    VH setBackgroundColor(int viewId, @ColorInt int bgColor);

    VH setBackgroundResource(int viewId, @DrawableRes int bgRes);

    VH setAlpha(int viewId, @FloatRange(from = 0.0, to = 1.0) float value);

    VH setVisibility(int viewId, int visibility);

    VH setTag(int viewId, Object tag);

    VH setEnabled(int viewId, boolean enabled);

    VH setChecked(int viewId, boolean checked);

    VH setOnClickListener(int viewId, View.OnClickListener listener);

    VH setOnLongClickListener(int viewId, View.OnLongClickListener listener);

    VH setOnTouchListener(int viewId, View.OnTouchListener listener);

}
