package com.coder.codermanager.Activity.Home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.coder.codermanager.Adapter.homePmListAdapter;
import com.coder.codermanager.Data.homePmListData;
import com.coder.codermanager.R;

import java.util.ArrayList;

public class homePMActivity extends AppCompatActivity {

    private homePMActivity context;
    private RecyclerView home_pm_recyclerview;
    private ArrayList<homePmListData> myDataset;
    private homePmListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pm);

        setTitle("PM管理事項");
        context = this;
        findview();
        setRecyclerview();

    }


    private void setRecyclerview() {
        myDataset = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            myDataset.add(new homePmListData(String.valueOf(i)));
        }

        mAdapter = new homePmListAdapter(context, myDataset);

        //方向一定要設才有效果
        final LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        home_pm_recyclerview.setLayoutManager(layoutManager);

        home_pm_recyclerview.setAdapter(mAdapter);

    }

    private void findview() {
        home_pm_recyclerview = (RecyclerView) findViewById(R.id.home_pm_recyclerview);
    }
}
