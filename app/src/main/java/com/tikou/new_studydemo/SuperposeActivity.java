package com.tikou.new_studydemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;

import android.widget.TextView;

/**
 * Created by Tikou on 2016/10/14.
 * 作者：TianNuo
 * 邮箱：1320917731@qq.com
 * 说明：重叠布局添加判断
 * 参考：
 */

public class SuperposeActivity extends AppCompatActivity{
    FrameLayout ll_contain;
    ImageView iv_seek,iv_seek1;
    TextView tv_seek;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.superpose);
        ll_contain= (FrameLayout) findViewById(R.id.ll_contain);
        iv_seek= (ImageView) findViewById(R.id.iv_seek);
        tv_seek= (TextView) findViewById(R.id.tv_seek);
        iv_seek1= (ImageView) findViewById(R.id.iv_seek2);
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        tv_seek.setText("ll_contain="+ll_contain.getX()+"   "+ll_contain.getY()
                +"iv_seek="+iv_seek.getX()+"   "+iv_seek.getY()
        );
        int mWidth_seek=iv_seek.getMeasuredWidth();
        int mHeight_seek=iv_seek.getMeasuredHeight();
        int mWidth_seek1=iv_seek1.getMeasuredWidth();
        int mHeight_seek1=iv_seek1.getMeasuredHeight();


        Log.i("SuperposeActivity","ll_contain="+ll_contain.getX()+"   "+ll_contain.getY()
                +"iv_seek="+iv_seek.getX()+"   "+iv_seek.getY());
    }

}
