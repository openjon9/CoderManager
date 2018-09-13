package com.coder.codermanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class homePendingTestActivity extends AppCompatActivity {

    private homePendingTestActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pending_test);

        setTitle("待測試");
        context = this;
        findview();
        setRecyclerview();
    }

    private void setRecyclerview() {

    }

    private void findview() {

    }
}
