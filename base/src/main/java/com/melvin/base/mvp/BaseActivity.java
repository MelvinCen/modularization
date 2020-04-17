package com.melvin.base.mvp;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.melvin.base.base_interface.IActivity;
import com.melvin.base.base_interface.IPresenter;
import com.melvin.base.widget.LoadingDialogBuilder;
import com.melvin.tool.ActivityUtils;

import androidx.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.Disposable;


public abstract class BaseActivity<P extends IPresenter> extends BaseToolsActivity implements IActivity {


    protected P mPresenter;
    private Unbinder unBind;
    //加载进度框
    public Dialog loadingProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //布局
        setContentView(getLayoutId());
        //绑定P层
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
        //Arouter注入
        ARouter.getInstance().inject(this);
        //绑定生命周期
        getLifecycle().addObserver(mPresenter);
        //绑定黄油刀
        unBind = ButterKnife.bind(this);
        //初始化
        initView(savedInstanceState);
        initData(savedInstanceState);
        //添加当前页面到集合中
        ActivityUtils.getInstance().addActivity(this);


    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        //界面停止隐藏加载框
        hideLoading();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        //销毁加载框
        loadingProgressDialog = null;
        //解除黄油刀
        unBind.unbind();
        //解除绑定生命周期
        getLifecycle().removeObserver(mPresenter);
        //在保存中移除本界面
        ActivityUtils.getInstance().removeActivity(this);
        super.onDestroy();
    }


    /**
     * 创建presenter
     *
     * @return
     */
    protected abstract P createPresenter();

    /**
     * 使用p层的容器存订阅的dispose
     *
     * @param disposable
     */
    @Override
    public void addDispose(Disposable disposable) {
        mPresenter.addDispose(disposable);
    }

    @Override
    public void showLoading() {
        if (loadingProgressDialog != null && loadingProgressDialog.isShowing()) {
            return;
        }
        if (loadingProgressDialog == null) {
            loadingProgressDialog = LoadingDialogBuilder.init(this, null);
        }
        loadingProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        if (loadingProgressDialog != null && loadingProgressDialog.isShowing()) {
            loadingProgressDialog.dismiss();
        }
    }

    @Override
    public Context getContext() {
        return this;
    }

}
