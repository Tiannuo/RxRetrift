package com.tikou.new_studydemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import rx.Subscription;

/**
 * Created by Administrator on 2016/10/18 0018.
 * 作者：TianNuo
 * 邮箱：1320917731@qq.com
 *
 */

public class BaseActivity extends AppCompatActivity{
    protected Subscription mSubscription;
    @Override
    protected void onDestroy() {
        super.onDestroy();
       if (mSubscription!=null&&!mSubscription.isUnsubscribed()){
           mSubscription.unsubscribe();
           Log.i("rx","1subscription.unsubscribe");
        }

    }
}
