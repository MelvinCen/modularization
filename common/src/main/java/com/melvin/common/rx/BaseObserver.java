package com.melvin.common.rx;


import android.accounts.NetworkErrorException;

import com.melvin.base.base_interface.IView;
import com.melvin.tool.AppUtils;
import com.melvin.tool.NetworkStatusUtils;
import com.orhanobut.logger.Logger;




import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 封装Observer的基类
 */
public abstract class BaseObserver<T> implements Observer<T> {

    protected abstract void onBaseError(Throwable t);

    protected abstract void onBaseNext(T data);
    //默认不需要加载框
    private boolean needDialog = false;

    private IView mView;

    public BaseObserver(IView view) {
        this.mView = view;
    }
    public BaseObserver(IView view,boolean showDialog) {
        this.mView = view;
        this.needDialog = showDialog;
    }

    @Override
    public void onSubscribe(Disposable d) {
        if (NetworkStatusUtils.isNetworkAvailable(AppUtils.getContext())) {
            //添加
            mView.addDispose(d);
            //显示进度条
            if (needDialog) {
                mView.showLoading();
            }
        } else {
            onError(new NetworkErrorException("无网络连接"));
            d.dispose();
        }
    }

    @Override
    public void onNext(T value) {
        Logger.e("onNext" + value.toString());
        //成功
        //先关闭进度条
        mView.hideLoading();
        //再回调出去
        onBaseNext(value);

    }

    @Override
    public void onError(Throwable e) {
        Logger.e("onError - " + e.toString());
        //关闭进度条
        if (needDialog) {
            mView.hideLoading();
        }
        onBaseError(e);
    }

    @Override
    public void onComplete() {
        Logger.e("onComplete");

    }


}