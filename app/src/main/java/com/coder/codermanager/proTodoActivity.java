package com.coder.codermanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class proTodoActivity extends AppCompatActivity {

    private proTodoActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_todo);

        context = this;
        setTitle("代辦事項管理");
        findview();
        setRecyclerview();
        initEvent();
    }

    private void initEvent() {

    }

    private void setRecyclerview() {

    }

    private void findview() {

    }
}
