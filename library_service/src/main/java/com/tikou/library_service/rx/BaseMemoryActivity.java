package com.tikou.library_service.rx;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import rx.Subscription;
/**
 * Created by Tikou on 2016/10/19.
 * 作者：TianNuo
 * 邮箱：1320917731@qq.com
 * 说明：//rx订阅管理一种是继承提供的BaseMemoryActivity或者fragment，还有一种是通过serviece类进行管理不建议
 * 参考：
 */

public class BaseMemoryActivity extends AppCompatActivity{
    private ArrayList<Subscription> subscriptions;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subscriptions=new ArrayList<>();
    }
    //开启一个请求的保存用于内存泄露保护
    protected void startToSubscribe(Subscription subscription){
        if (subscriptions!=null){
            subscriptions.add(subscription);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unsubscribe();
    }


    protected void unsubscribe() {
        for (Subscription subscription:subscriptions){
            //注意一般情况下，这个方法不会调用的，rx的next会自动取消订阅，只有再网络延迟很大的情况下才有可能触发
            if (subscription != null && !subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
        }

        subscriptions=null;
    }
}
