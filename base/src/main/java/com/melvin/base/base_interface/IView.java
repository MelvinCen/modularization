package com.melvin.base.base_interface;

import android.content.Context;

import io.reactivex.disposables.Disposable;

public interface IView {

    void addDispose(Disposable disposable);

    void showLoading();

    void hideLoading();

    Context getContext();
}
