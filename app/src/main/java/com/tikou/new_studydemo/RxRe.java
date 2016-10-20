package com.tikou.new_studydemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.WindowManager;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.tikou.library_service.moddle.AcceptBean;
import com.tikou.library_service.moddle.Index;
import com.tikou.library_service.moddle.JWTBean;
import com.tikou.library_service.moddle.RegisterBean;
import com.tikou.library_service.retrofit.RetrofitService;
import com.tikou.library_service.retrofit.ServiceHelper;
import com.tikou.library_service.rx.BaseSubscriber;
/**
 * Created by Tikou on 2016/10/18.
 * 作者：TianNuo
 * 邮箱：1320917731@qq.com
 * 说明：
 * 参考：
 */
public class RxRe extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //rxre();
        WindowManager.LayoutParams layoutParams=new WindowManager.LayoutParams();
        layoutParams.alpha=0.2f;
        // getWindow().setAttributes(layoutParams);
        rxreee();
    }
    private void rxreee() {
       startToSubscribe(ServiceHelper.toSubscribe(ServiceHelper.createNoHeadService(RetrofitService.getIndexService.class).getIndex("top", "9e05423f7ac6acf6d0dce3425c4ea9fe"),
               new BaseSubscriber<Index>() {
                   @Override
                   public void onNext(Index index) {
                       Log.e("index",index.getResult().getStat());
                   }
               }
       ));


    }
    private void rxre() {
        /*JSONObject jsonObject = new JSONObject();
        jsonObject.put("pid", "01858091123");
        jsonObject.put("password", "123456");
        jsonObject.put("email", "1320917731@qq.com");
*/
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("pid","01858091123");
        jsonObject.addProperty("email","133913731@qq.com");
        jsonObject.addProperty("password","123456");
        AcceptBean acceptBean=new AcceptBean("01858091123","1234123731@qq.com","123456");
        Log.i("RxRe",acceptBean.toString());
        Gson gson=new Gson();
        String content=gson.toJson(acceptBean);
       /* content=gson.toJson(jsonObject);*/
        //RequestBody.create(MediaType.parse("application/json;charset=utf-8"),gson.toJson(jsonObject))
        content=jsonObject.toString();
        Log.i("RxRe","content"+content);
        Log.i("RxRe","JsonObject"+jsonObject.toString());


        ServiceHelper.toSubscribe(ServiceHelper.creatHeadService(RetrofitService.postRegisterEmailService.class).postRegisterEmail("email"
                ,ServiceHelper.jsonRequestBody2("pid","00000000000","email","13851373551@qq.com","password","123456")), new BaseSubscriber<RegisterBean>() {
            @Override
            public void onNext(RegisterBean registerBean) {
                Log.i("RxRe",registerBean.toString());
            }
        });


        ServiceHelper.toSubscribe(ServiceHelper.creatHeadService(RetrofitService.postLoginService.class).postLogin(
                ServiceHelper.jsonRequestBody2( "username", "13429674496","password", "123456","pid", "00000000000","clientType", "ANDROID")
        ), new BaseSubscriber<JWTBean>() {
            @Override
            public void onNext(JWTBean jwtBean) {
                Log.i("RxRe","jwtBean"+jwtBean.toString());
            }
        });


    }
}