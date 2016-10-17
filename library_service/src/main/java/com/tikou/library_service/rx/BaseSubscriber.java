package com.tikou.library_service.rx;

import android.util.Log;

import rx.Subscriber;

/**
 * Created by Administrator on 2016/10/17 0017.
 * 作者：TianNuo
 * 邮箱：1320917731@qq.com
 * 数据返回的基类
 */

public abstract class BaseSubscriber<T> extends Subscriber<T>{
    @Override
    public void onCompleted() {
        Log.i("RxRe","onCompleted");
    }

    @Override
    public void onError(Throwable e) {
        Log.i("RxRe","onError");
    }


}
