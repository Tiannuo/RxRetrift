package com.tikou.new_studydemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.tikou.library_service.moddle.Index;
import com.tikou.library_service.moddle.JWTBean;
import com.tikou.library_service.retrofit.RetrofitService;
import com.tikou.library_service.retrofit.ServiceHelper;
import com.tikou.library_service.rx.BaseMemoryActivity;
import com.tikou.library_service.rx.BaseSubscriber;

/**
 * Created by Tikou on 2016/10/19.
 * 作者：TianNuo
 * 邮箱：1320917731@qq.com
 * 说明：
 * 参考：
 */

public class RxMemoryActivity extends BaseMemoryActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*startToSubscribe(ServiceHelper.toSubscribe(ServiceHelper.createNoHeadService(RetrofitService.postIndexService.class).postIndex("top", "9e05423f7ac6acf6d0dce3425c4ea9fe"), new BaseSubscriber<Index>() {
            @Override
            public void onNext(Index index) {
                Log.e("index",index.toString());
            }
        }));*/

        startToSubscribe(ServiceHelper.toSubscribe(ServiceHelper.createNoHeadService(RetrofitService.postLoginService.class).postLogin(ServiceHelper.jsonRequestBody2("username", "13429674496", "password", "123456", "pid", "00000000000", "clientType", "ANDROID")
        ), new BaseSubscriber<JWTBean>() {
            @Override
            public void onNext(JWTBean jwtBean) {
                Log.e("RxMemoryActivity",jwtBean.getRefresh_token());
            }
        }));

    }




}
