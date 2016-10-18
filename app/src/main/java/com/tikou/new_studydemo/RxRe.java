package com.tikou.new_studydemo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.tikou.library_service.retrofit.ServiceHelper;
import com.tikou.library_service.rx.BaseSubscriber;
import com.tikou.library_service.retrofit.RetrofitService;

import com.tikou.library_service.moddle.TestBean;

import rx.Observable;

/**
 * Created by Administrator on 2016/10/17 0017.
 * 作者：TianNuo
 * 邮箱：1320917731@qq.com
 */

public class RxRe extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rx();
    }

    private void rx() {
        Observable<TestBean> observable= ServiceHelper.createNoHeadService(RetrofitService.getMessService.class).getMess("oRxl_wj-Sh65Edqh_zEVfqiTh6qw");
        ServiceHelper.toSubscribe(observable, new BaseSubscriber<TestBean>() {
            @Override
            public void onNext(TestBean testBean) {
                Log.i("RxRe","getMessService--->"+testBean.toString());
            }
        });

        ServiceHelper.toSubscribe(ServiceHelper.creatHeadService(RetrofitService.postMessService.class).postMess("oRxl_wj-Sh65Edqh_zEVfqiTh6qw"),
                new BaseSubscriber<TestBean>() {
                    @Override
                    public void onNext(TestBean testBean) {
                        Log.i("RxRe","postMessService--->"+testBean.toString());
                    }
                }
        );

    }


}
