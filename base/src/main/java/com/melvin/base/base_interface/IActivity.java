package com.melvin.base.base_interface;

import android.os.Bundle;

public interface IActivity extends IView{

    /**
     * 添加布局文件
     *
     * @return
     */
    int getLayoutId();

    /**
     * 初始化view等
     */
    void initView(Bundle savedInstanceState);

    /**
     * 初始化数据等
     */
    void initData(Bundle savedInstanceState);


}
