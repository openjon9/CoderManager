package com.coder.codermanager.Activity.Client;

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

import com.coder.codermanager.Adapter.clentListAdapter;
import com.coder.codermanager.Data.clientData;
import com.coder.codermanager.Date.MyDate;
import com.coder.codermanager.Interface.windowSoftInputModeInterface;
import com.coder.codermanager.R;

import net.cachapa.expandablelayout.ExpandableLinearLayout;

import java.util.ArrayList;

public class clientClientActivity extends AppCompatActivity implements windowSoftInputModeInterface {

    private clientClientActivity context;
    private RecyclerView client_recyclerview;
    private ImageView image_up;
    private ExpandableLinearLayout expandableLayout;
    private Spinner client_time;
    private Spinner client_select;
    private ArrayAdapter<String> clent_select_spinnerAdapter;
    private ArrayAdapter<String> clent_time_spinnerAdapter;
    private boolean isopen = false;
    private ArrayList<clientData> myDataset;
    private clentListAdapter mAdapter;
    private TextView text_client_client_1;
    private TextView text_client_client_2;
    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_client);
        setCalender();
        setTitle("客戶");
        context = this;
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

    private void initEvent() {

        text_client_client_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datedialog = new DatePickerDialog(context, android.R.style.Theme_DeviceDefault_Dialog_Alert, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        text_client_client_1.setText(year + "-" + (month + 1) + "-" + day);
                    }
                }, year, month, day);
                datedialog.show();
            }
        });

        text_client_client_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datedialog = new DatePickerDialog(context, android.R.style.Theme_DeviceDefault_Dialog_Alert, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        text_client_client_2.setText(year + "-" + (month + 1) + "-" + day);
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

    private void setSpinner() {
        clent_select_spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.client_select));
        clent_select_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        client_select.setAdapter(clent_select_spinnerAdapter);


        clent_time_spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.client_time));
        clent_time_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        client_time.setAdapter(clent_time_spinnerAdapter);
    }

    private void setRecyclerview() {
        myDataset = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            myDataset.add(new clientData(String.valueOf(i),String.valueOf(i)));
        }

        mAdapter = new clentListAdapter(context, myDataset);

        //方向一定要設才有效果
        final LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        client_recyclerview.setLayoutManager(layoutManager);

        client_recyclerview.setAdapter(mAdapter);
    }

    private void findview() {

        text_client_client_1 = (TextView) findViewById(R.id.text_client_client_1);
        text_client_client_2 = (TextView) findViewById(R.id.text_client_client_2);

        client_select = (Spinner) findViewById(R.id.client_select);
        client_time = (Spinner) findViewById(R.id.client_time);

        image_up = (ImageView) findViewById(R.id.image_up);
        expandableLayout = (net.cachapa.expandablelayout.ExpandableLinearLayout) findViewById(R.id.expandableLayout);//伸縮
        client_recyclerview = (RecyclerView) findViewById(R.id.client_recyclerview);
    }

    @Override
    public void hideSoft(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
