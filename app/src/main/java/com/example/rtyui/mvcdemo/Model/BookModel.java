package com.example.rtyui.mvcdemo.Model;

import com.example.rtyui.mvcdemo.Contract.BookContract;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by rtyui on 2018/5/14.
 */

public class BookModel implements BookContract.Model {

    //使用单例模式，防止出现多份数据
    private static Object object = new Object();
    public static BookModel instance;
    public static BookModel getInstance() {
        synchronized (object){
            if (instance == null)
                return new BookModel();
            else
                return instance;
        }
    }

    public List<String> strings = null;

    @Override
    public List<String> init() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        strings = new LinkedList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        strings.add("6");
        strings.add("7");
        strings.add("8");
        return strings;
    }

    @Override
    public void add(String str) {
        strings.add(str);
    }
}
