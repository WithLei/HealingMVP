package com.android.renly.healingmvp.service;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

public class RetrofitServiceManager {
    private static final int DEFAULT_TIME_OUT = 5; //超时时间 5s
    private static final int DEFAULT_READ_TIME_OUT = 10;
    private Retrofit mRetrofit;
    private RetrofitServiceManager(){
        // 创建okhttpcient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);//连接超时时间
        builder.readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);//读操作超时时间
        // 添加公共参数拦截器
        HttpNetWorkInterceptor interceptor = new HttpNetWorkInterceptor();
        builder.addInterceptor(interceptor);
    }

    class HttpNetWorkInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (true){
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
                Log.d("print","no network");
            }

            Response originalResponse = chain.proceed(request);
            if (true) {
                // 有网络的时候读接口上的@Headers里的配置，可以在这里进行统一的配置
                String cacheControl = request.cacheControl().toString();
                return originalResponse.newBuilder()
                        .header("token","llala")
                        .build();
            } else {
                return originalResponse.newBuilder()
                        .header("token","")
                        .build();
            }
        }
    }
}
