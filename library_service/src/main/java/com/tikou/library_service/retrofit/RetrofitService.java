package com.tikou.library_service.retrofit;
import com.tikou.library_service.moddle.Index;
import com.tikou.library_service.moddle.JWTBean;
import com.tikou.library_service.moddle.RegisterBean;
import com.tikou.library_service.moddle.TestBean;
import okhttp3.RequestBody;
import retrofit2.http.Body;
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
    //"email"
    public interface postRegisterEmailService{
        @POST("register")
        Observable<RegisterBean> postRegisterEmail(@Query("type") String type, @Body RequestBody requestBody);

    }
    //login
    public interface postLoginService{
        @POST("login")
        Observable<JWTBean> postLogin(@Body RequestBody requestBody);

    }

    //zh
    public interface postIndexService{
        @POST("index")
        Observable<Index> postIndex(@Query("type") String type,@Query("key") String key);
    }

    public interface getIndexService{
        @GET("index")
        Observable<Index> getIndex(@Query("type") String type,@Query("key") String key);
    }
}
