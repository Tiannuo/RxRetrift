package com.tikou.library_service.rx;
import com.tikou.library_service.moddle.ErrorMsgBean;
import com.tikou.library_service.utils.ErrorHandler;
import rx.Subscriber;

/**
 * Created by Administrator on 2016/10/17 0017.
 * 作者：TianNuo
 * 邮箱：1320917731@qq.com
 * 数据返回的基类事件订阅者
 */

public  abstract class BaseSubscriber<T> extends Subscriber<T>{
    @Override
    public void onCompleted() {
    }
    @Override
        public void onError(Throwable e) {
        ErrorMsgBean errorMsgBean= ErrorHandler.handle(e);
    }
}
