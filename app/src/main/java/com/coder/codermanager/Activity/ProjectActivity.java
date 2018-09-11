package com.coder.codermanager.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.coder.codermanager.Adapter.ProjectListAdapter;
import com.coder.codermanager.Data.ProData;
import com.coder.codermanager.R;

import net.cachapa.expandablelayout.ExpandableLinearLayout;

import java.util.ArrayList;

public class ProjectActivity extends AppCompatActivity {

    private ProjectActivity context;
    private EditText ed_pro;
    private ImageView image_up;
    private LinearLayout linear;
    private ExpandableLinearLayout expandableLayout;
    private Boolean isopen = false;
    private RecyclerView pro_recyclerview;
    private ProjectListAdapter mAdapter;
    private ArrayList<ProData> myDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        context = this;
        setTitle("專案");
        findview();
        setRecyclerview();
        initEvent();

    }

    private void setRecyclerview() {
        myDataset = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            myDataset.add(new ProData(String.valueOf(i)));
        }

        mAdapter = new ProjectListAdapter(context, myDataset);

        //方向一定要設才有效果
        final LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        pro_recyclerview.setLayoutManager(layoutManager);

        pro_recyclerview.setAdapter(mAdapter);
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


    @Override
    protected void onResume() {
        super.onResume();
    }

    /********點空白區域隱藏鍵盤********/
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {
                if (hideInputMethod(this, v)) {
                    return true; //隐藏键盘时，其他控件不响应点击事件==》注释则不拦截点击事件
                }
            }
        }

        return super.dispatchTouchEvent(ev);
    }

    public static boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            v.getLocationInWindow(leftTop);
            int left = leftTop[0], top = leftTop[1], bottom = top + v.getHeight(), right = left
                    + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public static Boolean hideInputMethod(Context context, View v) {
        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            return imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
        return false;
    }

    private void findview() {
        ed_pro = (EditText) findViewById(R.id.ed_pro);
        image_up = (ImageView) findViewById(R.id.image_up);
        linear = (LinearLayout) findViewById(R.id.linear);
        expandableLayout = (net.cachapa.expandablelayout.ExpandableLinearLayout) findViewById(R.id.expandableLayout);//伸縮
        pro_recyclerview = (RecyclerView) findViewById(R.id.pro_recyclerview);

    }


}
