package com.melvin.base.mvp;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import com.jakewharton.rxbinding3.view.RxView;
import com.jakewharton.rxbinding3.widget.RxTextView;
import com.melvin.base.utils.ErrorTransformTool;
import com.melvin.tool.RxLifeCycleUtils;

import java.util.concurrent.TimeUnit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

public abstract class BaseToolsActivity extends AppCompatActivity {

    /**
     * 简化查找view
     *
     * @param id
     * @param <E>
     * @return
     */
    @SuppressWarnings("unchecked")
    public final <E extends View> E f(int id) {
        try {
            return (E) findViewById(id);
        } catch (ClassCastException ex) {
            return null;
        }
    }

    @SuppressLint("CheckResult")
    public void avoidDoubleClick(View view, Consumer<Unit> consumer) {

        RxView.clicks(view)
                .throttleFirst(1, TimeUnit.SECONDS)
                .compose(RxLifeCycleUtils.bindUntilEvent(this, Lifecycle.Event.ON_DESTROY))
                .subscribe(consumer, ErrorTransformTool.makeErrorConsumer());

    }

    @SuppressLint("CheckResult")
    public void textChangeListener(TextView view, Consumer<CharSequence> consumer) {

        RxTextView.textChanges(view)
                .compose(RxLifeCycleUtils.bindUntilEvent(this, Lifecycle.Event.ON_DESTROY))
                .subscribe(consumer, ErrorTransformTool.makeErrorConsumer());

    }
//
//    /**
//     * 页面回退键
//     *
//     * @param view
//     */
//    @SuppressLint("CheckResult")
//    public void PageTitleBackKey(View view) {
//        RxView.clicks(view)
//                .throttleFirst(1, TimeUnit.SECONDS)
//                .compose(RxLifeCycleUtils.bindUntilEvent(this, Lifecycle.Event.ON_DESTROY))
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Unit>() {
//                    @Override
//                    public void accept(Unit unit) throws Exception {
//                        finish();
//                    }
//                });
//    }
//
//    @SuppressLint("CheckResult")
//    public void setCanBackTitle(TitleBar view, String title) {
//        RxView.clicks(view.getLeftImageView())
//                .throttleFirst(1, TimeUnit.SECONDS)
//                .compose(RxLifeCycleUtils.bindUntilEvent(this, Lifecycle.Event.ON_DESTROY))
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Unit>() {
//                    @Override
//                    public void accept(Unit unit) throws Exception {
//                        finish();
//                    }
//                });
//
//        view.setMidText(title);
//    }
//
//    /**
//     * @param intent
//     * @param requestCode
//     */
//    public void jumpForResult(Intent intent, int requestCode) {
//        startActivityForResult(intent, requestCode);
//    }
//
//    /**
//     * 隐藏状态栏
//     *
//     * @param
//     **/
//    public void fullScreen() {
//        //竖屏
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        //全屏
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//    }

}
