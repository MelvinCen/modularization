package com.melvin.common.rx;


import com.melvin.base.bean.BaseResponse;
import com.melvin.base.error.ApiException;

import io.reactivex.functions.Function;

/**
 * 变换: 将服务器返回的原始数据剥离成我们最终想要的数据
 * 将BaseResponse<T> 转换成 T
 */

public class HttpFunction<T> implements Function<BaseResponse<T>, T> {

    @Override
    public T apply(BaseResponse<T> response) throws Exception {
        if (response.isRequestSuccess()) {
            return response.getData();
        } else {
            throw new ApiException(response.getCode(), response.getMessage());
        }

    }

}