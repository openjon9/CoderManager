package com.coder.codermanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.coder.codermanager.Adapter.ProjectListAdapter;
import com.coder.codermanager.Adapter.workRecordListAdapter;
import com.coder.codermanager.Data.workRecordData;

import net.cachapa.expandablelayout.ExpandableLinearLayout;

import java.util.ArrayList;

public class workRecordActivity extends AppCompatActivity {

    private workRecordActivity context;
    private ImageView image_up;
    private boolean isopen = false;
    private ExpandableLinearLayout expandableLayout;
    private RecyclerView workrecord_recyclerview;
    private ArrayList<workRecordData> myDataset;
    private workRecordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_record);
        context = this;
        setTitle("工作日誌");
        findview();
        setRecyclerview();
        initEvent();
    }

    private void setRecyclerview() {
        myDataset = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            myDataset.add(new workRecordData(String.valueOf(i)));
        }

        mAdapter = new workRecordListAdapter(context, myDataset);

        //方向一定要設才有效果
        final LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        workrecord_recyclerview.setLayoutManager(layoutManager);

        workrecord_recyclerview.setAdapter(mAdapter);
    }

    private void initEvent() {
        image_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isopen) {
                    isopen = false;
                    image_up.setImageDrawable(getResources().getDrawable(R.drawable.ic_arrow_downward));
                    expandableLayout.toggle();
                } else {
                    isopen = true;
                    image_up.setImageDrawable(getResources().getDrawable(R.drawable.ic_arrow_upward));

                    expandableLayout.toggle();
                }
            }
        });
    }

    private void findview() {
        image_up = (ImageView) findViewById(R.id.image_up);
        expandableLayout = (net.cachapa.expandablelayout.ExpandableLinearLayout) findViewById(R.id.expandableLayout);//伸縮
        workrecord_recyclerview = (RecyclerView) findViewById(R.id.workrecord_recyclerview);
    }


}
