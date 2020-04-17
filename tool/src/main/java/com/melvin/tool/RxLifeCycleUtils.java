package com.melvin.tool;

import com.trello.lifecycle2.android.lifecycle.AndroidLifecycle;
import com.trello.rxlifecycle3.LifecycleTransformer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

public class RxLifeCycleUtils {

    private RxLifeCycleUtils() {
        throw new IllegalStateException("Can't instance the RxLifeCycleUtils");
    }

    public static <T> LifecycleTransformer<T> bindToLifeCyCle(LifecycleOwner lifecycleOwner) {

        return AndroidLifecycle.createLifecycleProvider(lifecycleOwner).bindToLifecycle();

    }

    public static <T> LifecycleTransformer<T> bindUntilEvent(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {

        return AndroidLifecycle.createLifecycleProvider(lifecycleOwner).bindUntilEvent(event);

    }

}
