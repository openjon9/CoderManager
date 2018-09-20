package com.coder.codermanager.DoubleFragment;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.coder.codermanager.Activity.Pro.proTodoActivity;
import com.coder.codermanager.Adapter.homeHomeListAdapter;
import com.coder.codermanager.Adapter.homePendingTestListAdapter;
import com.coder.codermanager.Adapter.homePmListAdapter;
import com.coder.codermanager.Adapter.homeTodoListAdapter;
import com.coder.codermanager.Data.homeHomeData;
import com.coder.codermanager.Data.homePendingTestData;
import com.coder.codermanager.Data.homePmListData;
import com.coder.codermanager.Data.homeTodoData;
import com.coder.codermanager.Date.MyDate;
import com.coder.codermanager.Interface.windowSoftInputModeInterface;
import com.coder.codermanager.R;

import net.cachapa.expandablelayout.ExpandableLinearLayout;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment_1 extends Fragment implements windowSoftInputModeInterface {

    private View viewContent;
    private int mType = 0;
    private String mTitle;

    private RecyclerView homeRecyclerView;
    private ImageView down_image;
    private ArrayList<homeHomeData> mlist;
    private homeHomeListAdapter home_mAdapter;

    private ImageView image_up;
    private Spinner home_todo_select, home_todo_project, home_todo_type, home_todo_priority, home_todo_time, home_todo_principal, home_todo_testUser;
    private TextView text_home_todo_1, text_home_todo_2;
    private ExpandableLinearLayout expandableLayout;
    private RecyclerView home_todo_recyclerview;
    private ArrayList<homeTodoData> myDataset_todo;
    private homeTodoListAdapter home_todo_Adapter;
    private int year;
    private int month;
    private int day;
    private boolean isopen = false;
    private ArrayAdapter<String> home_todo_select_spinnerAdapter;
    private ArrayAdapter<String> home_todo_project_spinnerAdapter;
    private ArrayAdapter<String> home_todo_type_spinnerAdapter;
    private ArrayAdapter<String> home_todo_priority_spinnerAdapter;
    private ArrayAdapter<String> home_todo_principal_spinnerAdapter;
    private ArrayAdapter<String> home_todo_testUser_spinnerAdapter;
    private ArrayAdapter<String> home_todo_time_spinnerAdapter;
    private RecyclerView home_pm_recyclerview;


    private ArrayList<homePmListData> myDataset_pm;
    private homePmListAdapter home_pm_mAdapter;

    private RecyclerView pending_test_recyclerview;
    private ArrayList<homePendingTestData> mdata_Pend;
    private homePendingTestListAdapter pending__test_adapter;



    public ContentFragment_1() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        setCalender();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        switch (mType) {
            case 0:
                viewContent = inflater.inflate(R.layout.activity_home_home, container, false);
                findview(mType, viewContent);
                initData(mType);
                setRecyclerview(mType);
                initEvent(mType);
                break;
            case 1:
                viewContent = inflater.inflate(R.layout.activity_home_todo, container, false);
                findview(mType, viewContent);
                initData(mType);
                setRecyclerview(mType);
                setSpinner();
                initEvent(mType);

                break;
            case 2:
                viewContent = inflater.inflate(R.layout.activity_home_pm, container, false);
                findview(mType, viewContent);
                initData(mType);
                setRecyclerview(mType);

                break;
            case 3:
                viewContent = inflater.inflate(R.layout.activity_home_pending_test, container, false);
                findview(mType, viewContent);
                initData(mType);
                setRecyclerview(mType);

                break;
        }


//        viewContent = inflater.inflate(R.layout.fragment_content_fragment_1, container, false);
//        TextView textView = (TextView) viewContent.findViewById(R.id.tv_content);
//        textView.setText(this.mTitle);

        return viewContent;
    }

    @Override
    public void onStart() {
        super.onStart();




    }

    private void findview(int mType, View viewContent) {
        switch (mType) {
            case 0:
                homeRecyclerView = (RecyclerView) viewContent.findViewById(R.id.homeRecyclerView);
                down_image = (ImageView) viewContent.findViewById(R.id.down_image);

                break;
            case 1:
                image_up = (ImageView) viewContent.findViewById(R.id.image_up);

                home_todo_select = (Spinner) viewContent.findViewById(R.id.home_todo_select);
                home_todo_project = (Spinner) viewContent.findViewById(R.id.home_todo_project);
                home_todo_type = (Spinner) viewContent.findViewById(R.id.home_todo_type);
                home_todo_priority = (Spinner) viewContent.findViewById(R.id.home_todo_priority);
                home_todo_time = (Spinner) viewContent.findViewById(R.id.home_todo_time);
                home_todo_principal = (Spinner) viewContent.findViewById(R.id.home_todo_principal);
                home_todo_testUser = (Spinner) viewContent.findViewById(R.id.home_todo_testUser);

                text_home_todo_1 = (TextView) viewContent.findViewById(R.id.text_home_todo_1);
                text_home_todo_2 = (TextView) viewContent.findViewById(R.id.text_home_todo_2);

                expandableLayout = (net.cachapa.expandablelayout.ExpandableLinearLayout) viewContent.findViewById(R.id.expandableLayout);//伸縮
                home_todo_recyclerview = (RecyclerView) viewContent.findViewById(R.id.home_todo_recyclerview);
                break;
            case 2:
                home_pm_recyclerview = (RecyclerView) viewContent.findViewById(R.id.home_pm_recyclerview);
                break;
            case 3:
                pending_test_recyclerview = (RecyclerView) viewContent.findViewById(R.id.pending_test_recyclerview);
                break;

        }
    }

    private void setSpinner() {
        home_todo_select_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.home_todo_select));
        home_todo_select_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        home_todo_select.setAdapter(home_todo_select_spinnerAdapter);


        home_todo_project_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.home_todo_project));
        home_todo_project_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        home_todo_project.setAdapter(home_todo_project_spinnerAdapter);

        home_todo_type_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.home_todo_type));
        home_todo_type_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        home_todo_type.setAdapter(home_todo_type_spinnerAdapter);

        home_todo_priority_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.home_todo_priority));
        home_todo_priority_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        home_todo_priority.setAdapter(home_todo_priority_spinnerAdapter);


        home_todo_principal_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.home_todo_principal));
        home_todo_principal_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        home_todo_principal.setAdapter(home_todo_principal_spinnerAdapter);

        home_todo_testUser_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.home_todo_testUser));
        home_todo_testUser_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        home_todo_testUser.setAdapter(home_todo_testUser_spinnerAdapter);

        home_todo_time_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.home_todo_time));
        home_todo_time_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        home_todo_time.setAdapter(home_todo_time_spinnerAdapter);
    }

    private void initEvent(int mType) {
        switch (mType) {
            case 0:
               // click1();
                break;
            case 1:
                click2();
                break;
            case 2:
                break;
            case 3:
                break;
        }


    }


    private void initData(int mType) {

        switch (mType) {
            case 0:
                mlist = new ArrayList<>();
                for (int i = 0; i < 9; i++) {
                    mlist.add(new homeHomeData(String.valueOf(i)));
                }
                break;
            case 1:
                myDataset_todo = new ArrayList<>();
                for (int i = 0; i < 100; i++) {
                    myDataset_todo.add(new homeTodoData(String.valueOf(i)));
                }
                break;
            case 2:
                myDataset_pm = new ArrayList<>();
                for (int i = 0; i < 100; i++) {
                    myDataset_pm.add(new homePmListData(String.valueOf(i)));
                }
                break;
            case 3:
                mdata_Pend = new ArrayList<>();
                for (int i = 0; i < 100; i++) {
                    mdata_Pend.add(new homePendingTestData(String.valueOf(i)));
                }

                break;
        }

    }


    private void setRecyclerview(int mType) {
        LinearLayoutManager layoutManager;
        switch (mType) {
            case 0:
                home_mAdapter = new homeHomeListAdapter(getContext(), mlist);

                layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                homeRecyclerView.setLayoutManager(layoutManager);
                homeRecyclerView.setAdapter(home_mAdapter);

                setHeaderView(homeRecyclerView);
                break;
            case 1:
                home_todo_Adapter = new homeTodoListAdapter(getContext(), myDataset_todo);

                layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                home_todo_recyclerview.setLayoutManager(layoutManager);

                home_todo_recyclerview.setAdapter(home_todo_Adapter);
                break;
            case 2:
                home_pm_mAdapter = new homePmListAdapter(getContext(), myDataset_pm);

                //方向一定要設才有效果
                layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                home_pm_recyclerview.setLayoutManager(layoutManager);

                home_pm_recyclerview.setAdapter(home_pm_mAdapter);
                break;
            case 3:
                pending__test_adapter = new homePendingTestListAdapter(getContext(), mdata_Pend);

                layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                pending_test_recyclerview.setLayoutManager(layoutManager);
                pending_test_recyclerview.setAdapter(pending__test_adapter);
                break;
        }

    }


    private void setHeaderView(RecyclerView view) {
        View header = LayoutInflater.from(getContext()).inflate(R.layout.home_home_item_2, view, false);
        home_mAdapter.setmHeaderView(header);
    }

    private void click2() {
        text_home_todo_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datedialog = new DatePickerDialog(getContext(), android.R.style.Theme_DeviceDefault_Dialog_Alert, new DatePickerDialog.OnDateSetListener() {
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

                DatePickerDialog datedialog = new DatePickerDialog(getContext(), android.R.style.Theme_DeviceDefault_Dialog_Alert, new DatePickerDialog.OnDateSetListener() {
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

    private void click1() {

        down_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (home_mAdapter.getItemCount() == 3) {
                    home_mAdapter.addItemNum(mlist.size());

                    down_image.setImageDrawable(getResources().getDrawable(R.drawable.ic_arrow_upward));
                    home_mAdapter.notifyDataSetChanged();

                } else {
                    home_mAdapter.addItemNum(3);
                    down_image.setImageDrawable(getResources().getDrawable(R.drawable.ic_arrow_downward));

                    home_mAdapter.notifyDataSetChanged();
                }

            }
        });
    }


    public void setType(int mType) {
        this.mType = mType;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    @Override
    public void hideSoft(View view) {
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void setCalender() {
        year = MyDate.getInstance().year();
        month = MyDate.getInstance().month();
        day = MyDate.getInstance().day();

    }
}
