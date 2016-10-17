package com.tikou.new_studydemo.javamodel.builder;

import android.util.Log;

/**
 * Created by Tikou on 2016/10/11.
 * 作者：TianNuo
 * 邮箱：1320917731@qq.com
 * 说明：
 * 参考：
 */

public class BuilderTest {
    private String a;
    private String b;
    private int c;
    private void show(){
        Log.i("BuilderTest","show-->"+a+b+c);
    }

    public  class Builder{
        String a;
        String b;
        int c;

        public Builder setA(String sa){
            this.a=sa;
            return this;
        }

        public Builder setB(String sb){
            this.b=sb;
            return this;
        }

        public Builder setC(int ic){
            this.c=ic;
            return this;
        }

        public BuilderTest creat(){
            BuilderTest test=new BuilderTest();
            test.a=a;
            test.b=b;
            test.c=c;
            return test;
        }

    }
}
