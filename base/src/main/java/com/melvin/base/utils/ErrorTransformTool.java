package com.melvin.base.utils;

import android.accounts.NetworkErrorException;
import android.net.ParseException;

import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.melvin.base.error.ApiException;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;

import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.functions.Consumer;
import retrofit2.HttpException;

public class ErrorTransformTool {

    /**
     * 将错误转换成文字
     *
     * @param t
     * @return
     */
    public static String transformException(Throwable t) {

        if (t instanceof NetworkErrorException) {

            return "网络连接错误";

        } else if (t instanceof UnknownHostException || t instanceof ConnectException) {

            return "连接服务器失败";

        } else if (t instanceof SocketTimeoutException || t instanceof TimeoutException) {

            return "请求超时";

        } else if (t instanceof JsonSyntaxException) {

            return "数据解析错误";

        } else if (t instanceof JsonParseException
                || t instanceof JSONException
                || t instanceof ParseException) {   //  解析错误

            return "数据解析错误";

        } else if (t instanceof NoRouteToHostException) {

            return "服务器异常";

        } else if (t instanceof NullPointerException) {

            return "数据为null异常";

        } else if (t instanceof HttpException) {//403 checked Exception

            return "HTTP异常";

        } else {

            return "未知错误";

        }
    }

    /**
     * 根据异常获取错误msg
     *
     * @param t
     * @return
     */
    public static String getErrorMsg(Throwable t) {

        if (t instanceof ApiException) {

            return StringUtils.isNotBlank(((ApiException) t).getErrorMsg()) ? ((ApiException) t).getErrorMsg() : "未知错误";

        } else {

            return transformException(t);

        }
    }

    /**
     * 是否是自定义异常
     *
     * @param t
     * @return
     */
    public static boolean isApiException(Throwable t) {
        return t instanceof ApiException;
    }

    /**
     * 处理一些统一的错误
     *
     * @param throwable
     * @return
     */
    public static void toastByError(Throwable throwable, String defaultErrorMsg) {

        if (throwable instanceof TimeoutException) {

//            ToastUtils.showToastSafe(R.string.common_waitting_over_time_pls_retry);

        } else if (throwable instanceof ApiException) {

//            ToastUtils.showToastSafe(StringUtils.isNotBlank(((ApiException) throwable).getmErrorMsg()) ? ((ApiException) throwable).getmErrorMsg() : ResourceUtil.getString(R.string.common_error_happen));

        } else {

//            ToastUtils.showToastSafe(StringUtils.isNotBlank(defaultErrorMsg) ? defaultErrorMsg : ResourceUtil.getString(R.string.common_error_happen));

        }
    }

    /**
     * 制造错误的接收
     *
     * @return
     */
    public static Consumer<Throwable> makeErrorConsumer() {
        return new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

                toastByError(throwable, null);

            }
        };
    }
}
