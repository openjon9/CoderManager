package com.coder.codermanager.Activity.Home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.coder.codermanager.Adapter.HomeListAdapterTest;
import com.coder.codermanager.Adapter.homeHomeListAdapter;
import com.coder.codermanager.Data.homeHomeData;
import com.coder.codermanager.R;

import java.util.ArrayList;

public class homeHomeActivity extends AppCompatActivity {

    private RecyclerView homeRecyclerView;
    private HomeListAdapterTest homeAdapter;
    private homeHomeActivity context;
    private ArrayList<homeHomeData> mlist;
    private ImageView down_image;
    private homeHomeListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_home);
        context = this;
        setTitle("首頁");
        findview();

        initData();
        setRecyclerview();
        initEvent();

    }

    private void setRecyclerview() {
        mAdapter = new homeHomeListAdapter(context, mlist);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        homeRecyclerView.setLayoutManager(layoutManager);
        homeRecyclerView.setAdapter(mAdapter);

        setHeaderView(homeRecyclerView);
       // setFooterView(homeRecyclerView);
    }


    private void initData() {
        mlist = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            mlist.add(new homeHomeData());
        }
    }


    private void setHeaderView(RecyclerView view) {
        View header = LayoutInflater.from(this).inflate(R.layout.home_home_item_2, view, false);
        mAdapter.setmHeaderView(header);
    }

    private void setFooterView(RecyclerView view) {
        View footer = LayoutInflater.from(this).inflate(R.layout.home_home_item_2, view, false);
        mAdapter.setmFooterView(footer);
    }


    private void initEvent() {

        down_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (mAdapter.getItemCount() == 1) {
                    mAdapter.addItemNum(mlist.size());

                    down_image.setImageDrawable(getResources().getDrawable(R.drawable.ic_arrow_upward));
                    mAdapter.notifyDataSetChanged();

                } else {
                    mAdapter.addItemNum(1);
                    down_image.setImageDrawable(getResources().getDrawable(R.drawable.ic_arrow_downward));

                    mAdapter.notifyDataSetChanged();
                }

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void findview() {

        homeRecyclerView = (RecyclerView) findViewById(R.id.homeRecyclerView);
        down_image = (ImageView) findViewById(R.id.down_image);

    }
}
