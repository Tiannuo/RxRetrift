package com.tikou.new_studydemo.javamodel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tikou.new_studydemo.javamodel.builder.BuilderTest;


/**
 * Created by Tikou on 2016/10/11.
 * 作者：TianNuo
 * 邮箱：1320917731@qq.com
 * 说明：设计模式学习
 * 参考：
 */

public class JavaModelActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  BuilderTest t1=new BuilderTest.Builder().setA("t1a").setB("t2a").setC(1).creat();
        BuilderTest bt1=new BuilderTest();
        BuilderTest.Builder t1=new BuilderTest().new Builder();
    }
}
