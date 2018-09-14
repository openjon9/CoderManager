package com.coder.codermanager.Activity.Pro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.coder.codermanager.R;

public class proProjectClickActivity extends AppCompatActivity {

    private proProjectClickActivity context;
    private TextView text_pro_project_toDoNumber;
    private TextView text_pro_project_toDoBug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_project_click);

        context = this;
        setTitle("代辦事項管理");
        findview();
        initEvent();
    }

    private void initEvent() {

        text_pro_project_toDoNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context,proTodoActivity.class); //放入個別欄位代辦數量
                startActivity(intent);
            }
        });

        text_pro_project_toDoBug.setOnClickListener(new View.OnClickListener() { //放入個別欄位代辦BUG數量
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context,proTodoActivity.class);
                startActivity(intent);
            }
        });

    }

    private void findview() {

        text_pro_project_toDoNumber=(TextView)findViewById(R.id.text_pro_project_toDoNumber);
        text_pro_project_toDoBug=(TextView)findViewById(R.id.text_pro_project_toDoBug);
    }


}
