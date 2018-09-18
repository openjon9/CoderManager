package com.coder.codermanager.DoubleFragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.coder.codermanager.Adapter.proProjectListAdapter;
import com.coder.codermanager.Data.proProjectData;
import com.coder.codermanager.Date.MyDate;
import com.coder.codermanager.Interface.windowSoftInputModeInterface;
import com.coder.codermanager.R;

import net.cachapa.expandablelayout.ExpandableLinearLayout;

import java.util.ArrayList;

/**
 * Created by Rey on 2018/9/18.
 */

public class ContentFragment_3 extends Fragment implements windowSoftInputModeInterface {


    private int year;
    private int month;
    private int day;
    private int mType;
    private String mTitle;
    private View viewContent;
    private Spinner pro_project_select,pro_project_start_time,pro_project_client,pro_project_client_window,pro_project_leader,pro_project_execution,pro_project_tester;
    private EditText ed_pro;
    private TextView text_pro_project_1,text_pro_project_2;
    private ImageView image_up;
    private LinearLayout linear;
    private ExpandableLinearLayout expandableLayout;
    private RecyclerView pro_recyclerview;
    private ArrayList<proProjectData> myDataset_proProject;
    private proProjectListAdapter pro_Adapter;
    private ArrayAdapter<String> pro_project_start_time_spinnerAdapter;
    private ArrayAdapter<String> pro_project_select_spinnerAdapter;
    private ArrayAdapter<String> pro_project_client_spinnerAdapter;
    private ArrayAdapter<String> pro_project_client_window_spinnerAdapter;
    private ArrayAdapter<String> pro_project_leader_spinnerAdapter;
    private ArrayAdapter<String> pro_project_execution_spinnerAdapter;
    private ArrayAdapter<String> pro_project_tester_spinnerAdapter;
    private boolean isopen = false;

    public ContentFragment_3() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        setCalender();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        switch (mType) {
            case 0:
                viewContent = inflater.inflate(R.layout.activity_pro_project, container, false);
                findview(mType, viewContent);
                initData(mType);
                setRecyclerview(mType);
                setSpinner(mType);
                initEvent(mType);
                break;
            case 1:
                viewContent = inflater.inflate(R.layout.activity_pro_todo, container, false);
                findview(mType, viewContent);
                initData(mType);
                setRecyclerview(mType);
                setSpinner(mType);
                initEvent(mType);
                break;
            case 2:

                break;

        }

        return viewContent;
    }

    private void findview(int mType, View viewContent) {
        switch (mType) {
            case 0:
                pro_project_select = (Spinner) viewContent.findViewById(R.id.pro_project_select);
                pro_project_start_time = (Spinner) viewContent.findViewById(R.id.pro_project_start_time);
                pro_project_client = (Spinner) viewContent.findViewById(R.id.pro_project_client);
                pro_project_client_window = (Spinner) viewContent.findViewById(R.id.pro_project_client_window);
                pro_project_leader = (Spinner) viewContent.findViewById(R.id.pro_project_leader);
                pro_project_execution = (Spinner) viewContent.findViewById(R.id.pro_project_execution);
                pro_project_tester = (Spinner) viewContent.findViewById(R.id.pro_project_tester);

                ed_pro = (EditText) viewContent.findViewById(R.id.ed_pro);
                text_pro_project_1 = (TextView) viewContent.findViewById(R.id.text_pro_project_1);
                text_pro_project_2 = (TextView) viewContent.findViewById(R.id.text_pro_project_2);

                image_up = (ImageView) viewContent.findViewById(R.id.image_up);
                linear = (LinearLayout) viewContent.findViewById(R.id.linear);
                expandableLayout = (net.cachapa.expandablelayout.ExpandableLinearLayout) viewContent.findViewById(R.id.expandableLayout);//伸縮
                pro_recyclerview = (RecyclerView) viewContent.findViewById(R.id.pro_recyclerview);
                break;
            case 1:
                break;
            case 2:
                break;
        }
    }

    private void initData(int mType) {
        switch (mType) {
            case 0:
                myDataset_proProject = new ArrayList<>();
                for (int i = 0; i < 100; i++) {
                    myDataset_proProject.add(new proProjectData(String.valueOf(i)));
                }
                break;
            case 1:
                break;
            case 2:
                break;
        }
    }

    private void setRecyclerview(int mType) {

        switch (mType) {
            case 0:
                pro_Adapter = new proProjectListAdapter(getContext(), myDataset_proProject);

                //方向一定要設才有效果
                final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                pro_recyclerview.setLayoutManager(layoutManager);

                pro_recyclerview.setAdapter(pro_Adapter);
                break;
            case 1:
                break;
            case 2:
                break;
        }
    }


    private void setSpinner(int mType) {
        switch (mType) {
            case 0:
                pro_project_start_time_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.pro_project_statrt_time));
                pro_project_start_time_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
                pro_project_start_time.setAdapter(pro_project_start_time_spinnerAdapter);

                pro_project_select_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.pro_project_select));
                pro_project_select_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
                pro_project_select.setAdapter(pro_project_select_spinnerAdapter);


                pro_project_client_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.pro_project_client));
                pro_project_client_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
                pro_project_client.setAdapter(pro_project_client_spinnerAdapter);

                pro_project_client_window_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.pro_project_client_window));
                pro_project_client_window_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
                pro_project_client_window.setAdapter(pro_project_client_window_spinnerAdapter);

                pro_project_leader_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.pro_project_leader));
                pro_project_leader_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
                pro_project_leader.setAdapter(pro_project_leader_spinnerAdapter);


                pro_project_execution_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.pro_project_execution));
                pro_project_execution_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
                pro_project_execution.setAdapter(pro_project_execution_spinnerAdapter);

                pro_project_tester_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.pro_project_tester));
                pro_project_tester_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
                pro_project_tester.setAdapter(pro_project_tester_spinnerAdapter);
                break;
            case 1:
                break;
            case 2:
                break;
        }
    }

    private void initEvent(int mType) {
        switch (mType) {
            case 0:
                click_1();
                break;
            case 1:
                break;
            case 2:
                break;
        }
    }

    private void click_1() {
        text_pro_project_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datedialog = new DatePickerDialog(getContext(), android.R.style.Theme_DeviceDefault_Dialog_Alert, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        text_pro_project_1.setText(year + "-" + (month + 1) + "-" + day);
                    }
                }, year, month, day);
                datedialog.show();
            }
        });


        text_pro_project_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datedialog = new DatePickerDialog(getContext(), android.R.style.Theme_DeviceDefault_Dialog_Alert, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        text_pro_project_2.setText(year + "-" + (month + 1) + "-" + day);
                    }
                }, year, month, day);
                datedialog.show();
            }
        });



        pro_project_start_time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
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


    public void setType(int mType) {
        this.mType = mType;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }


    private void setCalender() {
        year = MyDate.getInstance().year();
        month = MyDate.getInstance().month();
        day = MyDate.getInstance().day();
    }

    @Override
    public void hideSoft(View view) {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
