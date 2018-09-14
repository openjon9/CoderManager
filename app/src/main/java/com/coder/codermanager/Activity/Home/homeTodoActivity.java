package com.coder.codermanager.Activity.Home;

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

import com.coder.codermanager.Adapter.homeTodoListAdapter;
import com.coder.codermanager.Data.homeTodoData;
import com.coder.codermanager.Date.MyDate;
import com.coder.codermanager.Interface.windowSoftInputModeInterface;
import com.coder.codermanager.R;

import net.cachapa.expandablelayout.ExpandableLinearLayout;

import java.util.ArrayList;

public class homeTodoActivity extends AppCompatActivity implements windowSoftInputModeInterface {

    private homeTodoActivity context;
    private ImageView image_up;
    private Spinner home_todo_select;
    private ArrayAdapter<String> home_todo_select_spinnerAdapter;
    private Spinner home_todo_project;
    private ArrayAdapter<String> home_todo_project_spinnerAdapter;
    private Spinner home_todo_type;
    private ArrayAdapter<String> home_todo_type_spinnerAdapter;
    private Spinner home_todo_priority;
    private ArrayAdapter<String> home_todo_priority_spinnerAdapter;
    private ExpandableLinearLayout expandableLayout;
    private boolean isopen = false;
    private Spinner home_todo_principal;
    private ArrayAdapter<String> home_todo_principal_spinnerAdapter;
    private Spinner home_todo_testUser;
    private ArrayAdapter<String> home_todo_testUser_spinnerAdapter;
    private RecyclerView home_todo_recyclerview;
    private ArrayList<homeTodoData> myDataset;
    private homeTodoListAdapter mAdapter;
    private Spinner home_todo_time;
    private ArrayAdapter<String> home_todo_time_spinnerAdapter;
    private TextView text_home_todo_1;
    private TextView text_home_todo_2;
    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_todo);
        setCalender();
        setTitle("代辦事項");
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

        text_home_todo_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datedialog = new DatePickerDialog(context, android.R.style.Theme_DeviceDefault_Dialog_Alert, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        text_home_todo_1.setText(year + "-" + (month + 1) + "-" + day);
                    }
                }, year, month, day);
                datedialog.show();
            }
        });

        text_home_todo_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datedialog = new DatePickerDialog(context, android.R.style.Theme_DeviceDefault_Dialog_Alert, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        text_home_todo_2.setText(year + "-" + (month + 1) + "-" + day);
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
        home_todo_select_spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.home_todo_select));
        home_todo_select_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        home_todo_select.setAdapter(home_todo_select_spinnerAdapter);


        home_todo_project_spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.home_todo_project));
        home_todo_project_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        home_todo_project.setAdapter(home_todo_project_spinnerAdapter);

        home_todo_type_spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.home_todo_type));
        home_todo_type_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        home_todo_type.setAdapter(home_todo_type_spinnerAdapter);

        home_todo_priority_spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.home_todo_priority));
        home_todo_priority_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        home_todo_priority.setAdapter(home_todo_priority_spinnerAdapter);


        home_todo_principal_spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.home_todo_principal));
        home_todo_principal_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        home_todo_principal.setAdapter(home_todo_principal_spinnerAdapter);

        home_todo_testUser_spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.home_todo_testUser));
        home_todo_testUser_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        home_todo_testUser.setAdapter(home_todo_testUser_spinnerAdapter);

        home_todo_time_spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.home_todo_time));
        home_todo_time_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        home_todo_time.setAdapter(home_todo_time_spinnerAdapter);
    }

    private void setRecyclerview() {
        myDataset = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            myDataset.add(new homeTodoData(String.valueOf(i)));
        }

        mAdapter = new homeTodoListAdapter(context, myDataset);

        //方向一定要設才有效果
        final LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        home_todo_recyclerview.setLayoutManager(layoutManager);

        home_todo_recyclerview.setAdapter(mAdapter);
    }

    private void findview() {

        image_up = (ImageView) findViewById(R.id.image_up);


        home_todo_select = (Spinner) findViewById(R.id.home_todo_select);
        home_todo_project = (Spinner) findViewById(R.id.home_todo_project);
        home_todo_type = (Spinner) findViewById(R.id.home_todo_type);
        home_todo_priority = (Spinner) findViewById(R.id.home_todo_priority);
        home_todo_time=(Spinner)findViewById(R.id.home_todo_time);
        home_todo_principal = (Spinner) findViewById(R.id.home_todo_principal);
        home_todo_testUser = (Spinner) findViewById(R.id.home_todo_testUser);

        text_home_todo_1=(TextView)findViewById(R.id.text_home_todo_1);
        text_home_todo_2=(TextView)findViewById(R.id.text_home_todo_2);

        expandableLayout = (net.cachapa.expandablelayout.ExpandableLinearLayout) findViewById(R.id.expandableLayout);//伸縮
        home_todo_recyclerview = (RecyclerView) findViewById(R.id.home_todo_recyclerview);
    }


    @Override
    public void hideSoft(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
