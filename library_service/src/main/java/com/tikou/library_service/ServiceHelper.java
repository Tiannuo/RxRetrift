package com.tikou.library_service;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tikou on 2016/10/17.
 * 作者：TianNuo
 * 邮箱：1320917731@qq.com
 * 说明：retrofit2构建
 * 参考：
 */

public class ServiceHelper {

    public static <T> T creatBaseService(T t){
        OkHttpClient.Builder builder=new OkHttpClient.Builder();
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request=chain.request();
                Request.Builder rBuilder=request.newBuilder()
                        .method(request.method(),request.body())
                        //添加请求头
                        .header("Authorization",ApiUrl.Token);
                return chain.proceed(rBuilder.build());
            }
        });

        OkHttpClient okHttpClient=builder.build();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ApiUrl.BaseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return t;
    }
}
