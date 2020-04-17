package com.melvin.home.view;

import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.melvin.base.utils.RecyclerViewDividerTool;
import com.melvin.common.callback.OnConfirmCallBackListener;
import com.melvin.base.mvp.BaseActivity;
import com.melvin.base.mvp.BasePresenter;
import com.melvin.common.router.RouterConfig;
import com.melvin.home.R;
import com.melvin.home.R2;
import com.melvin.home.adapter.HomeAdapter;
import com.melvin.home.constant.HomeFuncDataName;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * 主页，功能增加在HomeFuncDataName配置数据
 */
public class MainActivity extends BaseActivity<BasePresenter> {

    @BindView(R2.id.home_list)
    RecyclerView recyclerView;

    @Override
    protected BasePresenter createPresenter() {
        return new BasePresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.home_activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        initRecyclerView();
    }

    private void initRecyclerView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new RecyclerViewDividerTool(10));
        recyclerView.setHasFixedSize(true);
        HomeAdapter homeAdapter = new HomeAdapter(this);
        recyclerView.setAdapter(homeAdapter);
        homeAdapter.setOnConfirmCallBackListener(new OnConfirmCallBackListener<Integer>() {
            @Override
            public void callback(Integer integer) {
                dispatchFunc(homeAdapter.getDatas().get(integer));
            }
        });
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    private void dispatchFunc(String func) {
        switch (func) {
            case HomeFuncDataName.LIST://列表
                ARouter.getInstance().build(RouterConfig.LIST).navigation();
                break;
            case HomeFuncDataName.KEY_BOARD_OBSERVER://监听软键盘弹起
                ARouter.getInstance().build(RouterConfig.KEY_BOARD_OBSERVER).navigation();
                break;
            case HomeFuncDataName.EDITTEXT_LIST://列表中有多个输入框
                ARouter.getInstance().build(RouterConfig.EDITTEXT_LIST).navigation();
                break;
        }
    }
}
