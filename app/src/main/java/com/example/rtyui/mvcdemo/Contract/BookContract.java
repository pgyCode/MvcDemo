package com.example.rtyui.mvcdemo.Contract;

import java.util.List;

/**
 * Created by rtyui on 2018/5/14.
 */

public interface BookContract {

    interface Model{
        List<String> init();
        void add(String str);
    }

    interface Controller{
        void init();
        void add(String str);
    }
}
