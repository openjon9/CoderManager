package com.coder.codermanager.Activity.Home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.coder.codermanager.Adapter.homePendingTestListAdapter;
import com.coder.codermanager.Data.homePendingTestData;
import com.coder.codermanager.R;

import java.util.ArrayList;
import java.util.List;

public class homePendingTestActivity extends AppCompatActivity {

    private homePendingTestActivity context;
    private RecyclerView pending_test_recyclerview;
    private homePendingTestListAdapter adapter;
    private List<homePendingTestData> mdata;

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

        mdata = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mdata.add(new homePendingTestData(String.valueOf(i)));
        }


        adapter = new homePendingTestListAdapter(context, mdata);

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        pending_test_recyclerview.setLayoutManager(layoutManager);
        pending_test_recyclerview.setAdapter(adapter);

    }

    private void findview() {

        pending_test_recyclerview = (RecyclerView) findViewById(R.id.pending_test_recyclerview);
    }
}
