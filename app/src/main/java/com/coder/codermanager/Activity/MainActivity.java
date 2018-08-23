package com.coder.codermanager.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.coder.codermanager.Adapter.HomeListAdapter;
import com.coder.codermanager.Data.homeData;
import com.coder.codermanager.ProjectActivity;
import com.coder.codermanager.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private MainActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        setTitle("後台管理系統");
        findview();

        initData();
        init();
        initEvent();
    }

    private void initData() {

    }

    private void init() {


    }

    private void initEvent() {


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void findview() {

    }

    //首頁資訊
    public void btn_bome(View view) {
        Intent intent = new Intent(context, HomeActivity.class);
        startActivity(intent);
    }

    //代辦事項
    public void btn_todo(View view) {
        Intent intent = new Intent(context, TodoActivity.class);
        startActivity(intent);
    }

    //PM管理事項
    public void btn_PM(View view) {

    }

    //待測試事項
    public void btn_tested(View view) {

    }

    //客戶管理
    public void btn_Customer(View view) {

    }

    //聯絡人管理
    public void btn_Contact(View view) {

    }

    //專案管理
    public void btn_Project(View view) {
        Intent intent = new Intent(context, ProjectActivity.class);
        startActivity(intent);
    }

    //代辦事項管理
    public void btn_Todomanagment(View view) {

    }

    //工作日誌
    public void btn_worklog(View view) {

    }
}
