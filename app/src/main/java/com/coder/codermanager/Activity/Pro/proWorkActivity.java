package com.coder.codermanager.Activity.Pro;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.coder.codermanager.Adapter.proWorkListAdapter;
import com.coder.codermanager.Data.proWorkData;
import com.coder.codermanager.Date.MyDate;
import com.coder.codermanager.R;
import com.coder.codermanager.Interface.windowSoftInputModeInterface;

import net.cachapa.expandablelayout.ExpandableLinearLayout;

import java.util.ArrayList;
import java.util.Calendar;

public class proWorkActivity extends AppCompatActivity implements windowSoftInputModeInterface {

    private proWorkActivity context;
    private ImageView image_up;
    private boolean isopen = false;
    private ExpandableLinearLayout expandableLayout;
    private RecyclerView pro_work_recyclerview;
    private ArrayList<proWorkData> myDataset;
    private proWorkListAdapter mAdapter;

    private Spinner pro_work_selete;
    private ArrayAdapter<String> pro_work_selete_spinnerAdapter;

    private Spinner pro_work_time;
    private ArrayAdapter<String> pro_work_time_spinnerAdapter;
    private TextView text_pro_work_1;
    private TextView text_pro_work_2;
    private Calendar calender;
    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_work_);
        context = this;
        setCalender();
        setTitle("工作日誌");
        findview();
        setRecyclerview();
        setSpinner();
        initEvent();
    }

    private void setCalender() {
        year = MyDate.getInstance().year();
        month = MyDate.getInstance().month();
        day = MyDate.getInstance().day();
    }

    private void setSpinner() {

        pro_work_selete_spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.pro_work_selete));
        pro_work_selete_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        pro_work_selete.setAdapter(pro_work_selete_spinnerAdapter);


        pro_work_time_spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.pro_work_time));
        pro_work_time_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        pro_work_time.setAdapter(pro_work_time_spinnerAdapter);
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
        pro_work_recyclerview.setLayoutManager(layoutManager);

        pro_work_recyclerview.setAdapter(mAdapter);
    }

    private void initEvent() {
        text_pro_work_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datedialog = new DatePickerDialog(context, android.R.style.Theme_DeviceDefault_Dialog_Alert, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        text_pro_work_1.setText(year + "-" + (month + 1) + "-" + day);
                    }
                }, year, month, day);
                datedialog.show();
            }
        });

        text_pro_work_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datedialog = new DatePickerDialog(context, android.R.style.Theme_DeviceDefault_Dialog_Alert, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        text_pro_work_2.setText(year + "-" + (month + 1) + "-" + day);
                    }
                }, year, month, day);
                datedialog.show();
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

    private void findview() {

        text_pro_work_1 = (TextView) findViewById(R.id.text_pro_work_1);
        text_pro_work_2 = (TextView) findViewById(R.id.text_pro_work_2);

        pro_work_selete = (Spinner) findViewById(R.id.pro_work_selete);
        pro_work_time = (Spinner) findViewById(R.id.pro_work_time);

        image_up = (ImageView) findViewById(R.id.image_up);
        expandableLayout = (net.cachapa.expandablelayout.ExpandableLinearLayout) findViewById(R.id.expandableLayout);//伸縮
        pro_work_recyclerview = (RecyclerView) findViewById(R.id.pro_work_recyclerview);
    }

    @Override
    public void hideSoft(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


}
