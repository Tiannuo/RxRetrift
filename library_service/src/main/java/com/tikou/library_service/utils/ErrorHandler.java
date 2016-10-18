package com.tikou.library_service.utils;

import com.google.gson.Gson;
import com.tikou.library_service.moddle.ErrorMsgBean;

import java.io.IOException;

import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by Tikou on 2016/10/18.
 * 作者：TianNuo
 * 邮箱：1320917731@qq.com
 * 说明：异常处理
 * 参考：
 */

public class ErrorHandler {

    public static ErrorMsgBean handle(Throwable throwable) {
        //请求成功，但是响应吗错误
        if (throwable instanceof HttpException) {
            HttpException error = (HttpException) throwable;
            try {
                return new Gson().fromJson(error.response().errorBody().string(),
                        ErrorMsgBean.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (throwable instanceof IOException){
            //网络请求失败
        }
        else {
            throwable.printStackTrace();
        }
        return null;
    }

}
