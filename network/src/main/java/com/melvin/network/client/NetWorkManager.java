package com.melvin.network.client;

import android.util.ArrayMap;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.melvin.network.UrlConstants;
import com.melvin.network.utils.HttpLogger;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetWorkManager {

    private OkHttpClient mOkHttpClient;
    private Retrofit mRetrofit;

    private boolean mOpenDebug;

    private NetWorkManager() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLogger());
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        this.mOkHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .build();

        this.mRetrofit = new Retrofit.Builder()
                .baseUrl(UrlConstants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//使用rxjava
                .addConverterFactory(GsonConverterFactory.create())//使用Gson
                .client(mOkHttpClient)
                .build();
    }

    private static class NetWorkManagerHolder {
        private static final NetWorkManager INSTANCE = new NetWorkManager();
    }

    public static NetWorkManager getInstance() {
        return NetWorkManagerHolder.INSTANCE;
    }

    //保存ApiService对象
    private ArrayMap<Class<?>, Object> apiServiceMap = new ArrayMap<>();
    public <T> T createApi(Class<T> clazz) {
        if (clazz == null) {
            throw new RuntimeException("Api service is null!");
        }
        if (apiServiceMap.get(clazz) == null) {
            apiServiceMap.put(clazz, mRetrofit.create(clazz));
        }
        return (T) apiServiceMap.get(clazz);
    }

    public void openDebug(boolean open){
        mOpenDebug = open;
    }


}
