package com.example.rtyui.mvcdemo.Adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rtyui.mvcdemo.R;

import java.util.List;

/**
 * Created by rtyui on 2018/5/14.
 */

public class BookAdapter extends BaseAdapter{

    public List<String> strings;
    public Context context;

    public BookAdapter(Context context, List<String> strings){
        this.context = context;
        this.strings = strings;
    }

    @Override
    public int getCount() {
        if (strings == null)
            return 0;
        else
            return strings.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item, null);
            viewHolder = new ViewHolder();
            viewHolder.txt = convertView.findViewById(R.id.txt);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txt.setText(strings.get(position));
        return convertView;
    }


    private class ViewHolder{
        public TextView txt;
    }
}
