package com.coder.codermanager.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.coder.codermanager.R;

public class TodoActivity extends AppCompatActivity {

    private TodoActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        setTitle("代辦事項");
        context = this;
        findview();

    }

    private void findview() {

    }


}
