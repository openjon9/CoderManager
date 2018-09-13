package com.coder.codermanager.Activity.Home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.coder.codermanager.R;

public class homePmClickActivity extends AppCompatActivity {

    private homePmClickActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pm_click);

        context = this;
        findview();
    }

    private void findview() {

    }


}
