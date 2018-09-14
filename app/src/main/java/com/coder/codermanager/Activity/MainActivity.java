package com.coder.codermanager.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.coder.codermanager.Activity.Home.homeHomeActivity;
import com.coder.codermanager.homeTodoActivity;
import com.coder.codermanager.Activity.Pro.proWorkActivity;
import com.coder.codermanager.Activity.Pro.proProjectActivity;
import com.coder.codermanager.R;
import com.coder.codermanager.Activity.Pro.proTodoActivity;
import com.coder.codermanager.Activity.Client.clientClientActivity;
import com.coder.codermanager.Activity.Client.clientContactPersonActivity;
import com.coder.codermanager.Activity.Home.homePMActivity;
import com.coder.codermanager.Activity.Home.homePendingTestActivity;

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
        Intent intent = new Intent(context, homeHomeActivity.class);
        startActivity(intent);
    }

    //代辦事項
    public void btn_todo(View view) {
        Intent intent = new Intent(context, homeTodoActivity.class);
        startActivity(intent);
    }

    //PM管理事項
    public void btn_PM(View view) {
        Intent intent = new Intent(context, homePMActivity.class);
        startActivity(intent);
    }

    //待測試事項
    public void btn_tested(View view) {
//        Intent intent = new Intent(context, TestActivity.class);
//        startActivity(intent);


        Intent intent = new Intent(context, homePendingTestActivity.class);
        startActivity(intent);
    }

    //客戶管理
    public void btn_Customer(View view) {
        Intent intent = new Intent(context, clientClientActivity.class);
        startActivity(intent);
    }

    //聯絡人管理
    public void btn_Contact(View view) {
        Intent intent = new Intent(context, clientContactPersonActivity.class);
        startActivity(intent);
    }

    //專案管理
    public void btn_Project(View view) {
        Intent intent = new Intent(context, proProjectActivity.class);
        startActivity(intent);
    }

    //代辦事項管理
    public void btn_Todomanagment(View view) {

        Intent intent = new Intent(context, proTodoActivity.class);
        startActivity(intent);

    }

    //工作日誌
    public void btn_worklog(View view) {
        Intent intent = new Intent(context, proWorkActivity.class);
        startActivity(intent);
    }
}
