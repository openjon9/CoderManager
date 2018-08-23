package com.coder.codermanager.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.coder.codermanager.Adapter.HomeListAdapter;
import com.coder.codermanager.Data.homeData;
import com.coder.codermanager.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private ListView homelist;
    private HomeListAdapter homeAdapter;
    private HomeActivity context;
    private ArrayList<homeData> mlist;
    private TextView UnDate;
    private View HeadView;
    private ImageView down_image;
    private ArrayList<String> titlelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        context = this;
        setTitle("首頁");
        findview();

//        titlelist = new ArrayList<>();
//        titlelist.add("11");
//        titlelist.add("22");

        initData();
        init();
        initEvent();
    }


    private void initData() {
        mlist = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            mlist.add(new homeData());
        }
    }

    private void init() {
        homelist.setDivider(null);//去掉分隔線
        homeAdapter = new HomeListAdapter(context, mlist);

        View v = getLayoutInflater().inflate(R.layout.homeitem2, null);
        UnDate = (TextView) v.findViewById(R.id.UnDate);

       // homelist.addHeaderView(HeadView);
        homelist.addHeaderView(v, new homeData().getUnDate(), false);

        //homelist.addFooterView(footView);
        homelist.setAdapter(homeAdapter);

    }

    private void initEvent() {

        down_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (homeAdapter.getCount() == 1) {
                    homeAdapter.addItemNum(mlist.size());
                    down_image.setImageDrawable(getResources().getDrawable(R.drawable.ic_arrow_downward));

                    homeAdapter.notifyDataSetChanged();
//                    homelist.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            homelist.smoothScrollToPosition(mlist.size() - 1);//有滾動效果 防止異常在線程中使用
//                        }
//                    });
                    // homelist.setSelection(mlist.size()-1); //沒有滾動效果
                } else {
                    homeAdapter.addItemNum(1);

                    down_image.setImageDrawable(getResources().getDrawable(R.drawable.ic_arrow_upward));
                    homeAdapter.notifyDataSetChanged();
//                    homelist.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            homelist.smoothScrollToPosition(mlist.size() - 1);
//                        }
//                    });
                    //  homelist.setSelection(mlist.size()-1);
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

        homelist = (ListView) findViewById(R.id.homelist);
        down_image=(ImageView)findViewById(R.id.down_image);
       // HeadView = getLayoutInflater().inflate(R.layout.footview, null);
      //  down_image = (ImageView) HeadView.findViewById(R.id.down_image);
    }
}
