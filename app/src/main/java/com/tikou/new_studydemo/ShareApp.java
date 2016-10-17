package com.tikou.new_studydemo;

import android.app.Application;

import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by Tikou on 2016/10/12.
 * 作者：TianNuo
 * 邮箱：1320917731@qq.com
 * 说明：
 * 参考：
 */

public class ShareApp extends Application{
    //各个平台的配置，建议放在全局Application或者程序入口vv
    {
        //微信 wx12342956d1cab4f9,a5ae111de7d9ea137e88a5e02c07c94d
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        //豆瓣RENREN平台目前只能在服务器端配置
        //新浪微博
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad");
        PlatformConfig.setQQZone("1105750506", "cgJQ0DA4H1PCWMGD");


    }


    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);
      //  Config.REDIRECT_URL="";
    }
}
