package com.melvin.home.view;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.melvin.base.mvp.BaseActivity;
import com.melvin.base.mvp.BasePresenter;
import com.melvin.base.utils.ToastUtils;
import com.melvin.common.callback.OnConfirmCallBackListener;
import com.melvin.common.router.RouterConfig;
import com.melvin.home.R;
import com.melvin.home.R2;
import com.melvin.home.adapter.EdittextListActivityAdapter;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * 列表中有多个输入框多个edittext
 */
@Route(path = RouterConfig.EDITTEXT_LIST)
public class EdittextListActivity extends BaseActivity<BasePresenter> {

    @BindView(R2.id.home_recyclerview_multi_edittext)
    RecyclerView recyclerView;
    @Override
    protected BasePresenter createPresenter() {
        return new BasePresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.home_activity_edittext_list;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        EdittextListActivityAdapter edittextListActivityAdapter = new EdittextListActivityAdapter(this, makeData());
        recyclerView.setAdapter(edittextListActivityAdapter);

    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    public List<String> makeData(){
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            datas.add(""+i);
        }
        return datas;
    }
}
