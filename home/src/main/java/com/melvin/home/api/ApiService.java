package com.melvin.home.api;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    //初始化设备
    @POST("/minipms/api/")
    Observable<ResponseBody> requestInitDevice(@Body BaseRequestBean requestBean);
}
