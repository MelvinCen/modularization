package com.melvin.home.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.melvin.base.mvp.BaseActivity;
import com.melvin.base.mvp.BasePresenter;
import com.melvin.base.widget.LoadingDialogBuilder;
import com.melvin.home.R;
import com.melvin.home.R2;
import com.melvin.home.api.ApiService;
import com.melvin.home.api.BaseRequestBean;
import com.melvin.network.client.NetWorkManager;
import com.orhanobut.logger.Logger;

import java.io.IOException;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class NetWorkActivity extends BaseActivity<BasePresenter> {

    @BindView(R2.id.bt_test)
    TextView testBt;

    @Override
    protected BasePresenter createPresenter() {
        return new BasePresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.home_activity_net_work;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        testBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetWorkManager.getInstance()
                        .createApi(ApiService.class)
                        .requestInitDevice(new BaseRequestBean())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<ResponseBody>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                                Logger.e("d - " + d);
                            }

                            @Override
                            public void onNext(ResponseBody stringBaseResponse) {
                                try {
                                    Logger.e("stringBaseResponse- " + stringBaseResponse.string());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                Logger.e("e - " + e.toString());
                            }

                            @Override
                            public void onComplete() {
                                Logger.e("onComplete - ");
                            }
                        });
            }
        });
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        Dialog dialog = LoadingDialogBuilder.init(this, "");
        dialog.show();
    }

}
