package com.tikou.new_studydemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tikou.new_studydemo.t_class.Apple;
import com.tikou.new_studydemo.t_class.Fruit;
import com.tikou.new_studydemo.t_class.RedApple;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tikou on 2016/10/10.
 * 作者：TianNuo
 * 邮箱：1320917731@qq.com
 * 说明：
 * 参考：
 */

public class T_Activity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Class a=new ArrayList<Integer>().getClass();
/*
        List<? super Apple> list=new ArrayList<>();
        list.add(new Apple());
        list.add(new Fruit());
        list.add(new RedApple());

        List<? extends Apple> list1=new ArrayList<>();
        list.add(new Apple());
        list.add(new Fruit());
        list.add(new RedApple());*/
    }
}
