package com.melvin.list;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.melvin.base.mvp.BaseActivity;
import com.melvin.base.mvp.BasePresenter;
import com.melvin.common.router.RouterConfig;
import com.melvin.list.adapter.LrecyclerviewExampleAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import butterknife.BindView;

/**
 * LRecyclerview
 */
@Route(path = RouterConfig.L_RECYCLERVIEW)
public class LrecyclerViewActivity extends BaseActivity<BasePresenter> {

    @BindView(R2.id.lrecyclerview)
    LRecyclerView mLrecyclerview;
    private LrecyclerviewExampleAdapter lrecyclerviewExampleAdapter;
    private LRecyclerViewAdapter lRecyclerViewAdapter;

    @Override
    protected BasePresenter createPresenter() {
        return new BasePresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.list_activity_lrecycler_view;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        initRecyclerview();
    }

    private void initRecyclerview() {
        lrecyclerviewExampleAdapter = new LrecyclerviewExampleAdapter(this);
        lRecyclerViewAdapter = new LRecyclerViewAdapter(lrecyclerviewExampleAdapter);
        mLrecyclerview.setAdapter(lRecyclerViewAdapter);

        mLrecyclerview.setHasFixedSize(true);
        mLrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        //设置加载动画
        mLrecyclerview.setRefreshProgressStyle(ProgressStyle.LineSpinFadeLoader);
        mLrecyclerview.setLoadingMoreProgressStyle(ProgressStyle.LineSpinFadeLoader);
        //设置头部加载颜色
        mLrecyclerview.setHeaderViewColor(R.color.common_gray9, R.color.common_gray9, R.color.common_white);
        mLrecyclerview.setFooterViewColor(com.melvin.common.R.color.common_gray9, com.melvin.common.R.color.common_gray9, com.melvin.common.R.color.common_white);
        //设置加载箭头
        mLrecyclerview.setArrowImageView(R.drawable.ic_pulltorefresh_arrow);
        //刷新
        mLrecyclerview.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                //清空数据
                clearListData();
                //加载数据
                List<String> strings = makeFakeData(true);
                loadData(strings);
            }
        });
        //加载
        mLrecyclerview.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                //加载数据
                List<String> strings = makeFakeData(false);
                loadData(strings);
            }
        });

    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mLrecyclerview.forceToRefresh();
    }

    public void loadData(List<String> datas) {
        lrecyclerviewExampleAdapter.addAll(datas);
        mLrecyclerview.refreshComplete(datas.size());
        lRecyclerViewAdapter.notifyDataSetChanged();
    }

    public void clearListData() {
        lrecyclerviewExampleAdapter.clear();
        lRecyclerViewAdapter.notifyDataSetChanged();
    }

    public List<String> makeFakeData(boolean refresh) {
        List<String> datas = new ArrayList<>();
        if (refresh) {
            for (int i = 0; i < 10; i++) {
                datas.add(i + "");
            }
        } else {
            String s = lrecyclerviewExampleAdapter.getDataList().get(lrecyclerviewExampleAdapter.getDataList().size() - 1);
            int last = Integer.parseInt(s);
            for (int i = last; i < last + 10; i++) {
                datas.add(i + "");
            }
        }
        return datas;
    }
}
