package com.coder.codermanager.Test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.coder.codermanager.R;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    private TestActivity context;
    private RecyclerView test_recyclerview;
    private CourseAdapter adapter;
    private ArrayList<Nugget> nuggetsList;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        context = this;
        findview();
        nuggetsList = new ArrayList<>(); //直排的物件
        list = new ArrayList<>();//橫排的物件
        for (int i=0;i<10;i++){
            list.add("999888");
        }

        for (int i = 0; i < 100; i++) {
            nuggetsList.add(new Nugget(list));
        }

        setRecyclerview();
    }

    private void setRecyclerview() {


        //设置这个可以避免重复的增删造成而外的浪费资源
        test_recyclerview.setHasFixedSize(true); // 不會改變寬高的時候用 当需要改变宽高的时候就用notifyDataSetChanged()去整体刷新一下
        LinearLayoutManager llm = new LinearLayoutManager(context);
        test_recyclerview.setLayoutManager(llm);
        adapter = new CourseAdapter(context, nuggetsList);
        test_recyclerview.setAdapter(adapter);

    }

    private void findview() {

        test_recyclerview = (RecyclerView) findViewById(R.id.test_recyclerview);

    }

}
