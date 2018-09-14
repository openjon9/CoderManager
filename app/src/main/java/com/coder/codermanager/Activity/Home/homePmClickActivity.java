package com.coder.codermanager.Activity.Home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.coder.codermanager.Activity.Pro.proWorkActivity;
import com.coder.codermanager.R;

public class homePmClickActivity extends AppCompatActivity {

    private homePmClickActivity context;
    private TextView text_home_pm_workSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pm_click);

        context = this;
        findview();
        initEvent();
    }

    private void initEvent() {
        text_home_pm_workSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,proWorkActivity.class);
                startActivity(intent);
            }
        });
    }

    private void findview() {

        text_home_pm_workSave=(TextView)findViewById(R.id.text_home_pm_workSave);

    }


}
