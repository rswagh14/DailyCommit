package com.example.rahul.codekulpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Rahul on 11/29/2016.
 */

public class MyAdapter extends BaseAdapter {


    private Context context;
    private String []nums;
    private LayoutInflater inflater;
    private buttonclicklisternerinterface digitclicked;

    public interface buttonclicklisternerinterface{
        void onclicked(String Digit);

    }

    public MyAdapter(Context context, String[] nums, buttonclicklisternerinterface digitclicked) {
        this.context = context;
        this.nums = nums;
        this.digitclicked = digitclicked;

        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return nums.length;
    }

    @Override
    public Object getItem(int position) {
        return nums[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;
        if(convertView == null) view  = inflater.inflate(R.layout.custom_list,null,false);
        else view  = convertView;

        ((Button)view.findViewById(R.id.btnCalc)).setText(nums[position]);
        view.findViewById(R.id.btnCalc).setOnClickListener(this::clicked);

        return view;
    }

    private void clicked(View view) {

        Button btn = (Button)view;
        if(digitclicked!=null) digitclicked.onclicked(btn.getText().toString());

    }
}