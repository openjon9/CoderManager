package com.coder.codermanager.Activity.Pro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.coder.codermanager.R;

public class proTodoClickActivity extends AppCompatActivity {

    private proTodoClickActivity context;
    private TextView text_pro_todo_workSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_todo_click);

        context = this;
        findview();
        initEvent();

    }

    private void initEvent() {

        text_pro_todo_workSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context,proWorkActivity.class); //帶入工作紀錄數量
                startActivity(intent);
            }
        });

    }

    private void findview() {

        text_pro_todo_workSave = (TextView) findViewById(R.id.text_pro_todo_workSave);

    }
}
