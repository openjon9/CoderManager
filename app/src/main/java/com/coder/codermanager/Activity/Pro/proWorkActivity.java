package com.coder.codermanager.Activity.Pro;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import com.coder.codermanager.Adapter.proWorkListAdapter;
import com.coder.codermanager.Data.proWorkData;
import com.coder.codermanager.R;
import com.coder.codermanager.Interface.windowSoftInputModeInterface;

import net.cachapa.expandablelayout.ExpandableLinearLayout;

import java.util.ArrayList;

public class proWorkActivity extends AppCompatActivity implements windowSoftInputModeInterface {

    private proWorkActivity context;
    private ImageView image_up;
    private boolean isopen = false;
    private ExpandableLinearLayout expandableLayout;
    private RecyclerView workrecord_recyclerview;
    private ArrayList<proWorkData> myDataset;
    private proWorkListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_work_);
        context = this;
        setTitle("工作日誌");
        findview();
        setRecyclerview();
        initEvent();
    }

    private void setRecyclerview() {
        myDataset = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            myDataset.add(new proWorkData(String.valueOf(i)));
        }

        mAdapter = new proWorkListAdapter(context, myDataset);

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
                hideSoft(image_up);
            }

        });
    }

    private void findview() {
        image_up = (ImageView) findViewById(R.id.image_up);
        expandableLayout = (net.cachapa.expandablelayout.ExpandableLinearLayout) findViewById(R.id.expandableLayout);//伸縮
        workrecord_recyclerview = (RecyclerView) findViewById(R.id.workrecord_recyclerview);
    }

    @Override
    public void hideSoft(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }



}
