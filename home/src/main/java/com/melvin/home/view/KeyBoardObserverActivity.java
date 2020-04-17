package com.melvin.home.view;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.melvin.base.mvp.BaseActivity;
import com.melvin.base.mvp.BasePresenter;
import com.melvin.common.router.RouterConfig;
import com.melvin.home.R;
import com.melvin.home.R2;
import com.melvin.tool.keyboard_height.KeyboardHeightObserver;
import com.melvin.tool.keyboard_height.KeyboardHeightProvider;
import com.orhanobut.logger.Logger;

import butterknife.BindView;

/**
 * 监听软键盘弹起 在adjustNothing模式下
 * 一般用AndroidBug5497Workaround
 */
@Route(path = RouterConfig.KEY_BOARD_OBSERVER)
public class KeyBoardObserverActivity extends BaseActivity<BasePresenter> implements KeyboardHeightObserver {

    @BindView(R2.id.root_layout)
    RelativeLayout rootLayout;

    @BindView(R2.id.et_key_board_observer)
    EditText editText;

    private KeyboardHeightProvider keyboardHeightProvider;
    private int oriBottomMargin;

    @Override
    protected BasePresenter createPresenter() {
        return new BasePresenter(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.home_activity_key_board_observer;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        keyboardHeightProvider = new KeyboardHeightProvider(this);

        rootLayout.post(new Runnable() {
            @Override
            public void run() {
                keyboardHeightProvider.start();
                //  获取元素的初始位置
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) rootLayout.getLayoutParams();
                oriBottomMargin = layoutParams.bottomMargin;
                Logger.e("oriBottomMargin - " + oriBottomMargin);
            }
        });

//        KeyBoardUtils.showKeyBoard(editText);
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void onKeyboardHeightChanged(int height, int orientation) {
        Logger.e("height - " + height + ",orientation - " + orientation);
    }

    @Override
    protected void onResume() {
        super.onResume();
        keyboardHeightProvider.setKeyboardHeightObserver(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        keyboardHeightProvider.setKeyboardHeightObserver(null);
    }

    @Override
    protected void onDestroy() {
        keyboardHeightProvider.close();
        super.onDestroy();

    }
}
