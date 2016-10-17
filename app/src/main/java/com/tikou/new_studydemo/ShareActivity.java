package com.tikou.new_studydemo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tikou.library_umeng.ScreenUtils;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Tikou on 2016/10/12.
 * 作者：TianNuo
 * 邮箱：1320917731@qq.com
 * 说明：第三方分享测试案例
 * 参考：
 */

public class ShareActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qqshare);
        findViewById(R.id.btn_share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
            }
        });

    }

    private void share() {
        new ShareAction(ShareActivity.this).withText("老司机交流群")
              //  .withMedia(new UMImage(this,"http://a.hiphotos.baidu.com/image/h%3D200/sign=64175659840a19d8d403830503fb82c9/e7cd7b899e510fb3a78c787fdd33c895d0430c44.jpg"))
                .withTargetUrl("https://github.com/")
               // .withMedia(new UMImage(this,R.mipmap.ic_launcher))
                .withMedia(new UMImage(this, ScreenUtils.getWindowImg(this)))
                .setDisplayList(SHARE_MEDIA.QQ,SHARE_MEDIA.QZONE,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.WEIXIN_CIRCLE,SHARE_MEDIA.SINA)
                .setCallback(null).open();

    }


    /**
     * 截屏
     */
    private File getWindowImg() {
            String fname = Environment.getExternalStorageDirectory() + File.separator + "share.png";
            File file= new File(fname);
            View view = getWindow().getDecorView().getRootView();
                view.setDrawingCacheEnabled(true);
                view.buildDrawingCache();
                Bitmap bitmap = view.getDrawingCache();
                if (bitmap != null) {
                    try {
                        FileOutputStream out = new FileOutputStream(fname);
                        if (bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)) {
                                return file;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
            return null;


    }


}
