package com.tikou.library_service.retrofit;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
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
 * 调用测试案例
 * ServiceHelper.toSubscribe(ServiceHelper.creatHeadService(RetrofitService.postRegisterEmailService.class).postRegisterEmail("email"
 ,ServiceHelper.creatRequestBody2("pid","00000000000","email","13851373551@qq.com","password","123456")), new BaseSubscriber<RegisterBean>() {
@Override
public void onNext(RegisterBean registerBean) {
Log.i("RxRe",registerBean.toString());
}
});
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
                        //.header("Authorization",ApiUrl.Token)
                        .header("Content-Type","application/json")
                        .header("Accept","application/json")
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
     * 上传json数据RequestBody
     * jsonObject
     * @param jsonObject
     * @return
     */
    public static RequestBody creatRequestBody(JsonObject jsonObject){
        return RequestBody.create(MediaType.parse("application/json;charset=utf-8"),new Gson().toJson(jsonObject));
    }

    /**
     * 上传json数据RequestBody第二种方式
     * 参数注意奇数位是key，偶数位是value,一一对应
     * @param keyValue
     * @return
     */
    public static RequestBody creatRequestBody2(String... keyValue){
        JsonObject jsonObject=new JsonObject();
        for (int i=0;i<keyValue.length;i++){
            if (i%2==0){
            jsonObject.addProperty(keyValue[i],keyValue[i+1]);
            }
        }
        return RequestBody.create(MediaType.parse("application/json;charset=utf-8"),new Gson().toJson(jsonObject));
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
