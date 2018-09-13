package com.coder.codermanager.Activity.Client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.coder.codermanager.R;

public class clientClientClickActivity extends AppCompatActivity {

    private clientClientClickActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_client_click);

        context = this;
        findview();
    }

    private void findview() {

    }
}
