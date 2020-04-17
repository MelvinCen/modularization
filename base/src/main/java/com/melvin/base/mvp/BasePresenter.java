package com.melvin.base.mvp;


import com.melvin.base.base_interface.IModel;
import com.melvin.base.base_interface.IPresenter;
import com.melvin.base.base_interface.IView;

import org.jetbrains.annotations.NotNull;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<V extends IView, M extends IModel> implements IPresenter {

    //引用View
    protected V mRootView;
    //引用model
    protected M mIModel;

    //Rxjava调用生成的变量存储器
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public BasePresenter(V mRootView) {
        this.mRootView = mRootView;
        this.mIModel = createModel();

    }

    @Override
    public M createModel() {
        return null;
    }


    @Override
    public void onCreate(@NotNull LifecycleOwner owner) {
    }

    @Override
    public void onStart(@NotNull LifecycleOwner owner) {

    }

    @Override
    public void onResume(@NotNull LifecycleOwner owner) {

    }

    @Override
    public void onPause(@NotNull LifecycleOwner owner) {

    }

    @Override
    public void onStop(@NotNull LifecycleOwner owner) {
        //页面停止时，解除订阅
        unDispose();
    }

    @Override
    public void onDestroy(@NotNull LifecycleOwner owner) {
        if (mRootView != null) {
            this.mRootView = null;
        }
        if (mIModel != null) {
            mIModel = null;
        }
        mCompositeDisposable = null;
    }

    @Override
    public void onLifecycleChanged(@NotNull LifecycleOwner owner, @NotNull Lifecycle.Event event) {

    }

    @Override
    public void addDispose(Disposable disposable) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void unDispose() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }

    /**
     * 注意：该容器在onStop时终止
     * @return
     */
    @Override
    public CompositeDisposable getAPICompositeDisposable() {
        return mCompositeDisposable;
    }


}
