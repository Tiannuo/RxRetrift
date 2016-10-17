package com.tikou.library_service.retrofit;

import com.tikou.library_service.moddle.TestBean;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/10/17 0017.
 * 作者：TianNuo
 * 邮箱：1320917731@qq.com
 */

public class RetrofitService {
    public interface getMessService{
        @GET("user/getCount")
        Observable<TestBean> getMess(@Query("openid") String openId);
    }

    public interface postMessService{
        @POST("user/getCount")
        Observable<TestBean> postMess(@Query("openid") String openId);
    }

}
