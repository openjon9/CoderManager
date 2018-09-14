package com.coder.codermanager.Activity.Home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.coder.codermanager.Activity.Pro.proWorkActivity;
import com.coder.codermanager.R;

public class homeTodoClickActivity extends AppCompatActivity {

    private homeTodoClickActivity context;
    private TextView text_home_todo_workSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_todo_click);

        context = this;
        findview();
        initEvent();
    }

    private void initEvent() {

        text_home_todo_workSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context,proWorkActivity.class);//帶入個別欄位工作紀錄數量到工作日誌
                startActivity(intent);
            }
        });

    }

    private void findview() {

        text_home_todo_workSave = (TextView) findViewById(R.id.text_home_todo_workSave);

    }

}
