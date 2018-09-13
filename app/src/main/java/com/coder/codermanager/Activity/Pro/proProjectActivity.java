package com.coder.codermanager.Activity.Pro;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;


import com.coder.codermanager.Adapter.proProjectListAdapter;
import com.coder.codermanager.Data.proProjectData;
import com.coder.codermanager.R;
import com.coder.codermanager.Interface.windowSoftInputModeInterface;

import net.cachapa.expandablelayout.ExpandableLinearLayout;

import java.util.ArrayList;

public class proProjectActivity extends AppCompatActivity implements windowSoftInputModeInterface {

    private proProjectActivity context;
    private EditText ed_pro;
    private ImageView image_up;
    private LinearLayout linear;
    private ExpandableLinearLayout expandableLayout;
    private Boolean isopen = false;
    private RecyclerView pro_recyclerview;
    private proProjectListAdapter mAdapter;
    private ArrayList<proProjectData> myDataset;

    private Spinner pro_project_start_time;
    private ArrayAdapter<String> pro_project_start_time_spinnerAdapter;

    private Spinner pro_project_select;
    private ArrayAdapter<String> pro_project_select_spinnerAdapter;

    private Spinner pro_project_client;
    private ArrayAdapter<String> pro_project_client_spinnerAdapter;

    private Spinner pro_project_client_window;
    private ArrayAdapter<String> pro_project_client_window_spinnerAdapter;

    private Spinner pro_project_leader;
    private ArrayAdapter<String> pro_project_leader_spinnerAdapter;

    private Spinner pro_project_execution;
    private ArrayAdapter<String> pro_project_execution_spinnerAdapter;

    private Spinner pro_project_tester;
    private ArrayAdapter<String> pro_project_tester_spinnerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_project);
        context = this;
        setTitle("專案");
        findview();
        setRecyclerview();
        setSpinner();
        initEvent();

    }

    private void setSpinner() {

        pro_project_start_time_spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_layout,R.id.text_spinner,getResources().getStringArray(R.array.pro_project_statrt_time));
        pro_project_start_time_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        pro_project_start_time.setAdapter(pro_project_start_time_spinnerAdapter);

        pro_project_select_spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_layout,R.id.text_spinner,getResources().getStringArray(R.array.pro_project_select));
        pro_project_select_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        pro_project_select.setAdapter(pro_project_select_spinnerAdapter);


        pro_project_client_spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_layout,R.id.text_spinner,getResources().getStringArray(R.array.pro_project_client));
        pro_project_client_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        pro_project_client.setAdapter(pro_project_client_spinnerAdapter);

        pro_project_client_window_spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_layout,R.id.text_spinner,getResources().getStringArray(R.array.pro_project_client_window));
        pro_project_client_window_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        pro_project_client_window.setAdapter(pro_project_client_window_spinnerAdapter);

        pro_project_leader_spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_layout,R.id.text_spinner,getResources().getStringArray(R.array.pro_project_leader));
        pro_project_leader_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        pro_project_leader.setAdapter(pro_project_leader_spinnerAdapter);


        pro_project_execution_spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_layout,R.id.text_spinner,getResources().getStringArray(R.array.pro_project_execution));
        pro_project_execution_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        pro_project_execution.setAdapter(pro_project_execution_spinnerAdapter);

        pro_project_tester_spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_layout,R.id.text_spinner,getResources().getStringArray(R.array.pro_project_tester));
        pro_project_tester_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        pro_project_tester.setAdapter(pro_project_tester_spinnerAdapter);


    }

    private void setRecyclerview() {
        myDataset = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            myDataset.add(new proProjectData(String.valueOf(i)));
        }

        mAdapter = new proProjectListAdapter(context, myDataset);

        //方向一定要設才有效果
        final LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        pro_recyclerview.setLayoutManager(layoutManager);

        pro_recyclerview.setAdapter(mAdapter);
    }

    private void initEvent() {


        pro_project_start_time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent,  View view, int position, long id) {
//                TextView text_spinner = (TextView) view.findViewById(R.id.text_spinner);
//                text_spinner.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


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


    @Override
    protected void onResume() {
        super.onResume();
    }

    /********點空白區域隱藏鍵盤********/
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//
//        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
//            View v = getCurrentFocus();
//            if (isShouldHideInput(v, ev)) {
//                if (hideInputMethod(this, v)) {
//                    return true; //隐藏键盘时，其他控件不响应点击事件==》注释则不拦截点击事件
//                }
//            }
//        }
//
//        return super.dispatchTouchEvent(ev);
//    }
//
//    public static boolean isShouldHideInput(View v, MotionEvent event) {
//        if (v != null && (v instanceof EditText)) {
//            int[] leftTop = {0, 0};
//            v.getLocationInWindow(leftTop);
//            int left = leftTop[0], top = leftTop[1], bottom = top + v.getHeight(), right = left
//                    + v.getWidth();
//            if (event.getX() > left && event.getX() < right
//                    && event.getY() > top && event.getY() < bottom) {
//                // 保留点击EditText的事件
//                return false;
//            } else {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static Boolean hideInputMethod(Context context, View v) {
//        InputMethodManager imm = (InputMethodManager) context
//                .getSystemService(Context.INPUT_METHOD_SERVICE);
//        if (imm != null) {
//            return imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
//        }
//        return false;
//    }
    private void findview() {

        pro_project_select=(Spinner)findViewById(R.id.pro_project_select);
        pro_project_start_time = (Spinner) findViewById(R.id.pro_project_start_time);
        pro_project_client=(Spinner)findViewById(R.id.pro_project_client);
        pro_project_client_window=(Spinner)findViewById(R.id.pro_project_client_window);
        pro_project_leader=(Spinner)findViewById(R.id.pro_project_leader);
        pro_project_execution=(Spinner)findViewById(R.id.pro_project_execution);
        pro_project_tester=(Spinner)findViewById(R.id.pro_project_tester);

        ed_pro = (EditText) findViewById(R.id.ed_pro);
        image_up = (ImageView) findViewById(R.id.image_up);
        linear = (LinearLayout) findViewById(R.id.linear);
        expandableLayout = (net.cachapa.expandablelayout.ExpandableLinearLayout) findViewById(R.id.expandableLayout);//伸縮
        pro_recyclerview = (RecyclerView) findViewById(R.id.pro_recyclerview);

    }


    @Override
    public void hideSoft(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
