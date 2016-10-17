package com.tikou.library_service.retrofit;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Tikou on 2016/10/17.
 * 作者：TianNuo
 * 邮箱：1320917731@qq.com
 * 说明：retrofit2构建
 * 参考：
 */

public class ServiceHelper {
    /**
     * 添加请求头的基类方法
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T creatHeadService(Class<T> t){
        OkHttpClient.Builder builder=new OkHttpClient.Builder();
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request=chain.request();
                Request.Builder rBuilder=request.newBuilder()
                        .method(request.method(),request.body())
                        //添加请求头
                        .header("Authorization",ApiUrl.Token)
                        ;
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
        return retrofit.create(t);
    }

    /**
     * 没有请求头的基类方法
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T createNoHeadService(final Class<T> clazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(clazz);
    }

    /**
     * 开启一个请求
     * @param o
     * @param s
     * @param <T>
     */
    public static <T> void toSubscribe(Observable<T> o, Subscriber<T> s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }
}
