package com.melvin.common.rx;

import com.melvin.base.base_interface.IView;
import com.melvin.base.bean.BaseResponse;
import com.melvin.base.error.ApiException;
import com.melvin.base.utils.ErrorTransformTool;


public abstract class ErrorBaseObserver<T> extends BaseObserver<T> {

    public ErrorBaseObserver(IView view) {
        super(view);
    }
    public ErrorBaseObserver(IView view,boolean showDialog) {
        super(view,showDialog);
    }

    @Override
    protected void onBaseError(Throwable t) {

        if (t instanceof ApiException) {

            onApiException((ApiException) t);

        } else {
            String error = ErrorTransformTool.transformException(t);
            showErrorToast(error);
        }

    }

    /**
     * 显示错误
     *
     * @param error
     */
    private void showErrorToast(String error) {
//        ToastUtils.showToastSafe(error);
    }

    /**
     * 自定义异常的处理
     *
     * @param e
     */
    protected void onApiException(ApiException e) {
        if (BaseResponse.tokenOverTime(e.getErrorCode())) {

//            AppUtils.ReLogin();

        } else {
            //非token过期的自定义异常
            onApiExceptionWithoutTokenOverTime(e);
        }
    }

    /**
     * 非token过期的自定义异常
     *
     * @param e
     */
    protected void onApiExceptionWithoutTokenOverTime(ApiException e) {

//        ToastUtils.showToastSafe(StringUtils.isNotBlank(e.getmErrorMsg()) ? e.getmErrorMsg() : ResourceUtil.getString(R.string.common_error_happen));

    }


}
