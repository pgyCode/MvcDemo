package com.example.rtyui.mvcdemo.Controller;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.rtyui.mvcdemo.Adapter.BookAdapter;
import com.example.rtyui.mvcdemo.Contract.BookContract;
import com.example.rtyui.mvcdemo.Model.BookModel;
import com.example.rtyui.mvcdemo.R;

import java.util.List;

public class BookActivity extends AppCompatActivity implements BookContract.Controller {

    private BookContract.Model model;

    private ListView lst;
    private BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book);

        model = BookModel.getInstance();
        lst = findViewById(R.id.lst);
        init();

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add("测试添加");
            }
        });
    }

    @Override
    public void init() {
        new AsyncTask<Void, Void, List<String>>(){

            @Override
            protected List<String> doInBackground(Void... voids) {
                return model.init();
            }

            @Override
            protected void onPostExecute(List<String> strings) {
                super.onPostExecute(strings);
                bookAdapter = new BookAdapter(BookActivity.this, strings);
                lst.setAdapter(bookAdapter);
            }
        }.execute();
    }

    @Override
    public void add(final String str) {
        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                 model.add(str);
                 return null;
            }

            @Override
            protected void onPostExecute(Void avoid) {
                super.onPostExecute(avoid);
                bookAdapter.notifyDataSetChanged();
            }
        }.execute();
    }
}
