package com.melvin.home.view;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.melvin.base.mvp.BaseActivity;
import com.melvin.base.mvp.BasePresenter;
import com.melvin.common.callback.OnConfirmCallBackListener;
import com.melvin.common.router.RouterConfig;
import com.melvin.home.R;
import com.melvin.home.R2;
import com.melvin.home.adapter.HomeAdapter;
import com.melvin.home.adapter.ListActivityAdapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

@Route(path = RouterConfig.LIST)
public class ListActivity extends BaseActivity<BasePresenter> {

    @BindView(R2.id.list_recyclerview)
    RecyclerView recyclerView;

    @Override
    protected BasePresenter createPresenter() {
        return new BasePresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.home_activity_list;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        ListActivityAdapter listActivityAdapter = new ListActivityAdapter(this);
        recyclerView.setAdapter(listActivityAdapter);
        listActivityAdapter.setOnConfirmCallBackListener(new OnConfirmCallBackListener<Integer>() {
            @Override
            public void callback(Integer integer) {
                dispatchFunc(integer);
            }
        });
    }

    private void dispatchFunc(int pos) {
        switch (pos) {
            case 0://lrecyclerviwe
                ARouter.getInstance().build(RouterConfig.L_RECYCLERVIEW).navigation();
                break;
        }
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }
}
