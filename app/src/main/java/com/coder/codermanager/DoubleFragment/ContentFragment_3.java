package com.coder.codermanager.DoubleFragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.coder.codermanager.Adapter.proProjectListAdapter;
import com.coder.codermanager.Adapter.proTodoListAdapter;
import com.coder.codermanager.Adapter.proWorkListAdapter;
import com.coder.codermanager.Data.proProjectData;
import com.coder.codermanager.Data.proTodoData;
import com.coder.codermanager.Data.proWorkData;
import com.coder.codermanager.Date.MyDate;
import com.coder.codermanager.Interface.windowSoftInputModeInterface;
import com.coder.codermanager.R;

import net.cachapa.expandablelayout.ExpandableLinearLayout;

import java.util.ArrayList;
import java.util.List;

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
    private Spinner pro_project_select, pro_project_start_time, pro_project_client, pro_project_client_window, pro_project_leader, pro_project_execution, pro_project_tester;
    private EditText ed_pro;
    private TextView text_pro_project_1, text_pro_project_2;
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
    private Spinner pro_todo_selete, pro_todo_project, pro_todo_type, pro_todo_priority;
    private RecyclerView pro_todo_recyclerview;
    private ArrayList<proTodoData> myDataset_proTodo;
    private proTodoListAdapter pro_todo_Adapter;
    private ArrayAdapter<String> pro_todo_selete_spinnerAdapter;
    private ArrayAdapter<String> pro_todo_project_spinnerAdapter;
    private ArrayAdapter<String> pro_todo_type_spinnerAdapter;
    private ArrayAdapter<String> pro_todo_priority_spinnerAdapter;
    private TextView text_pro_work_1, text_pro_work_2;
    private Spinner pro_work_selete, pro_work_time;
    private RecyclerView pro_work_recyclerview;
    private ArrayList<proWorkData> myDataset_proWork;
    private proWorkListAdapter pro_work_Adapter;
    private ArrayAdapter<String> pro_work_selete_spinnerAdapter;
    private ArrayAdapter<String> pro_work_time_spinnerAdapter;
    private ImageView pro_todo_add;
    private RadioGroup rg0, rg1, rg2;
    private boolean isSelect = false;
    private RadioButton rb1, rb2, rb3, rb4, rb5, rb6;
    private CheckBox cb_0, cb_1, cb_2, cb_3, cb_4, cb_5, cb_6;
    private RadioButton rb0_1, rb0_2, rb0_3, rb0_4;
    private TextView pro_principal_add, pro_testUser_add;
    private TextView startTime_add, esfinishTime_add, compleTime_add;
    private Button btn_yes, btn_no;
    private AlertDialog add_dialog;
    private String[] array;
    private AlertDialog dialog;


    public ContentFragment_3() {
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
                viewContent = inflater.inflate(R.layout.activity_pro_work_, container, false);
                findview(mType, viewContent);
                initData(mType);
                setRecyclerview(mType);
                setSpinner(mType);
                initEvent(mType);
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
                pro_todo_selete = (Spinner) viewContent.findViewById(R.id.pro_todo_selete);
                pro_todo_project = (Spinner) viewContent.findViewById(R.id.pro_todo_project);
                pro_todo_type = (Spinner) viewContent.findViewById(R.id.pro_todo_type);
                pro_todo_priority = (Spinner) viewContent.findViewById(R.id.pro_todo_priority);

                image_up = (ImageView) viewContent.findViewById(R.id.image_up);
                pro_todo_add = (ImageView) viewContent.findViewById(R.id.pro_todo_add);
                pro_todo_recyclerview = (RecyclerView) viewContent.findViewById(R.id.pro_todo_recyclerview);

                expandableLayout = (net.cachapa.expandablelayout.ExpandableLinearLayout) viewContent.findViewById(R.id.expandableLayout);//伸縮
                break;
            case 2:
                text_pro_work_1 = (TextView) viewContent.findViewById(R.id.text_pro_work_1);
                text_pro_work_2 = (TextView) viewContent.findViewById(R.id.text_pro_work_2);

                pro_work_selete = (Spinner) viewContent.findViewById(R.id.pro_work_selete);
                pro_work_time = (Spinner) viewContent.findViewById(R.id.pro_work_time);

                image_up = (ImageView) viewContent.findViewById(R.id.image_up);
                expandableLayout = (net.cachapa.expandablelayout.ExpandableLinearLayout) viewContent.findViewById(R.id.expandableLayout);//伸縮
                pro_work_recyclerview = (RecyclerView) viewContent.findViewById(R.id.pro_work_recyclerview);
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
                myDataset_proTodo = new ArrayList<>();
                for (int i = 0; i < 100; i++) {
                    myDataset_proTodo.add(new proTodoData(String.valueOf(i)));
                }
                break;
            case 2:
                myDataset_proWork = new ArrayList<>();
                for (int i = 0; i < 100; i++) {
                    myDataset_proWork.add(new proWorkData(String.valueOf(i)));
                }

                break;
        }
    }

    private void setRecyclerview(int mType) {
        LinearLayoutManager layoutManager;
        switch (mType) {
            case 0:
                pro_Adapter = new proProjectListAdapter(getContext(), myDataset_proProject);

                //方向一定要設才有效果
                layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                pro_recyclerview.setLayoutManager(layoutManager);

                pro_recyclerview.setAdapter(pro_Adapter);
                break;
            case 1:
                pro_todo_Adapter = new proTodoListAdapter(getContext(), myDataset_proTodo);

                //方向一定要設才有效果
                layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                pro_todo_recyclerview.setLayoutManager(layoutManager);

                pro_todo_recyclerview.setAdapter(pro_todo_Adapter);
                break;
            case 2:
                pro_work_Adapter = new proWorkListAdapter(getContext(), myDataset_proWork);

                //方向一定要設才有效果
                layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                pro_work_recyclerview.setLayoutManager(layoutManager);

                pro_work_recyclerview.setAdapter(pro_work_Adapter);
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

                pro_todo_selete_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.pro_todo_selete));
                pro_todo_selete_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
                pro_todo_selete.setAdapter(pro_todo_selete_spinnerAdapter);


                pro_todo_project_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.pro_todo_project));
                pro_todo_project_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
                pro_todo_project.setAdapter(pro_todo_project_spinnerAdapter);

                pro_todo_type_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.pro_todo_type));
                pro_todo_type_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
                pro_todo_type.setAdapter(pro_todo_type_spinnerAdapter);

                pro_todo_priority_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.pro_todo_priority));
                pro_todo_priority_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
                pro_todo_priority.setAdapter(pro_todo_priority_spinnerAdapter);
                break;
            case 2:
                pro_work_selete_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.pro_work_selete));
                pro_work_selete_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
                pro_work_selete.setAdapter(pro_work_selete_spinnerAdapter);


                pro_work_time_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.pro_work_time));
                pro_work_time_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
                pro_work_time.setAdapter(pro_work_time_spinnerAdapter);
                break;
        }
    }

    private void initEvent(int mType) {
        switch (mType) {
            case 0:
                click_1();
                break;
            case 1:
                click_2();
                break;
            case 2:
                click_3();
                break;
        }
    }

    private void click_3() {
        text_pro_work_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datedialog = new DatePickerDialog(getContext(), android.R.style.Theme_DeviceDefault_Dialog_Alert, new DatePickerDialog.OnDateSetListener() {
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

                DatePickerDialog datedialog = new DatePickerDialog(getContext(), android.R.style.Theme_DeviceDefault_Dialog_Alert, new DatePickerDialog.OnDateSetListener() {
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

    private String TAG = "RaButton";

    private void click_2() {

        pro_todo_add.setOnClickListener(new View.OnClickListener() {
            public ArrayAdapter<String> add_pro_todo_select_1_spinnerAdapter;
            public Spinner add_pro_todo_select_1;

            @Override
            public void onClick(View view) {

                View mview = LayoutInflater.from(getContext()).inflate(R.layout.add_pro_todo, null);
                btn_yes = (Button) mview.findViewById(R.id.btn_yes);
                btn_no = (Button) mview.findViewById(R.id.btn_no);

                pro_principal_add = (TextView) mview.findViewById(R.id.pro_principal_add);
                pro_testUser_add = (TextView) mview.findViewById(R.id.pro_testUser_add);

                add_pro_todo_select_1 = (Spinner) mview.findViewById(R.id.add_pro_todo_select_1);
                add_pro_todo_select_1_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.add_pro_todo_select_1));
                add_pro_todo_select_1_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
                add_pro_todo_select_1.setAdapter(add_pro_todo_select_1_spinnerAdapter);

                cb_0 = (CheckBox) mview.findViewById(R.id.cb_0);
                cb_1 = (CheckBox) mview.findViewById(R.id.cb_1);
                cb_2 = (CheckBox) mview.findViewById(R.id.cb_2);
                cb_3 = (CheckBox) mview.findViewById(R.id.cb_3);
                cb_4 = (CheckBox) mview.findViewById(R.id.cb_4);
                cb_5 = (CheckBox) mview.findViewById(R.id.cb_5);
                cb_6 = (CheckBox) mview.findViewById(R.id.cb_6);

                rg0 = (RadioGroup) mview.findViewById(R.id.rg0);
                rg1 = (RadioGroup) mview.findViewById(R.id.rg1);
                rg2 = (RadioGroup) mview.findViewById(R.id.rg2);

                rb0_1 = (RadioButton) mview.findViewById(R.id.rb0_1);
                rb0_2 = (RadioButton) mview.findViewById(R.id.rb0_2);
                rb0_3 = (RadioButton) mview.findViewById(R.id.rb0_3);
                rb0_4 = (RadioButton) mview.findViewById(R.id.rb0_4);
                rb1 = (RadioButton) mview.findViewById(R.id.rb1);
                rb2 = (RadioButton) mview.findViewById(R.id.rb2);
                rb3 = (RadioButton) mview.findViewById(R.id.rb3);
                rb4 = (RadioButton) mview.findViewById(R.id.rb4);
                rb5 = (RadioButton) mview.findViewById(R.id.rb5);
                rb6 = (RadioButton) mview.findViewById(R.id.rb6);

                startTime_add = (TextView) mview.findViewById(R.id.startTime_add);
                esfinishTime_add = (TextView) mview.findViewById(R.id.esfinishTime_add);
                compleTime_add = (TextView) mview.findViewById(R.id.compleTime_add);


                rg0.setOnCheckedChangeListener(new MyRadioGroupListener());
                rg1.setOnCheckedChangeListener(new MyRadioGroupListener());
                rg2.setOnCheckedChangeListener(new MyRadioGroupListener());

                cb_0.setOnCheckedChangeListener(new MycheckBoxListener());
                cb_1.setOnCheckedChangeListener(new MycheckBoxListener());
                cb_2.setOnCheckedChangeListener(new MycheckBoxListener());
                cb_3.setOnCheckedChangeListener(new MycheckBoxListener());
                cb_4.setOnCheckedChangeListener(new MycheckBoxListener());
                cb_5.setOnCheckedChangeListener(new MycheckBoxListener());
                cb_6.setOnCheckedChangeListener(new MycheckBoxListener());

                btn_yes.setOnClickListener(new MyClickListener());
                btn_no.setOnClickListener(new MyClickListener());
                startTime_add.setOnClickListener(new MyClickListener());
                esfinishTime_add.setOnClickListener(new MyClickListener());
                compleTime_add.setOnClickListener(new MyClickListener());
                pro_principal_add.setOnClickListener(new MyClickListener());
                pro_testUser_add.setOnClickListener(new MyClickListener());

                add_dialog = new AlertDialog.Builder(getActivity())
                        .setView(mview)
                        .show();

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

    private void click_1() {
        text_pro_project_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog(text_pro_project_1);

            }
        });


        text_pro_project_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDateDialog(text_pro_project_2);
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

    ArrayList<Integer> principa_list = new ArrayList<>();
    ArrayList<Integer> testUser_list = new ArrayList<>();
    boolean[] principa_checkedItems;
    boolean[] testUser_checkedItems;

    private class MyClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            array = getResources().getStringArray(R.array.pro_text_dialog);

            switch (view.getId()) {
                case R.id.pro_principal_add:
                    principa_checkedItems = new boolean[array.length];
                    for (int i = 0; i < principa_list.size(); i++) {  //記錄點過的項目
                        principa_checkedItems[principa_list.get(i)] = true;
                    }

                    dialog = new AlertDialog.Builder(getContext())
                            .setMultiChoiceItems(array, principa_checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                                    //  checkedItems[which] = isChecked;
                                    if (isChecked) {
                                        principa_list.add(which);
                                    } else {
                                        principa_list.remove(Integer.valueOf(which));
                                    }
                                }
                            })
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int which) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    for (int i = 0; i < principa_checkedItems.length; i++) {
                                        if (principa_checkedItems[i]) {
                                            stringBuilder.append(array[i] + "\t");
                                        }
                                    }
                                    pro_principal_add.setText(stringBuilder);
                                    // Toast.makeText(getActivity(), stringBuilder, Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton("取消", null)
                            .show();
                    break;
                case R.id.pro_testUser_add:
                    testUser_checkedItems = new boolean[array.length];
                    for (int i = 0; i < testUser_list.size(); i++) {  //記錄點過的項目
                        testUser_checkedItems[testUser_list.get(i)] = true;
                    }

                    new AlertDialog.Builder(getContext())
                            .setMultiChoiceItems(array, testUser_checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                                    if (isChecked) {
                                        testUser_list.add(which);
                                    } else {
                                        testUser_list.remove(Integer.valueOf(which));
                                    }
                                }
                            })
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int which) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    for (int i = 0; i < testUser_checkedItems.length; i++) {
                                        if (testUser_checkedItems[i]) {
                                            stringBuilder.append(array[i] + "\t");
                                        }
                                    }
                                    pro_testUser_add.setText(stringBuilder);
                                }
                            })
                            .setNegativeButton("取消", null)
                            .show();
                    break;
                case R.id.startTime_add:
                    showDateDialog(startTime_add);
                    break;
                case R.id.esfinishTime_add:
                    showDateDialog(esfinishTime_add);
                    break;
                case R.id.compleTime_add:
                    showDateDialog(compleTime_add);
                    break;
                case R.id.btn_yes: //送出資料 這邊要檢查欄位
                    add_dialog.dismiss();
                    break;
                case R.id.btn_no:
                    add_dialog.dismiss();
                    break;
            }
        }
    }

    private class MycheckBoxListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            switch (buttonView.getId()) {
                case R.id.cb_0:
                    if (cb_0.isChecked()) {
                        cb_1.setChecked(true);
                        cb_2.setChecked(true);
                        cb_3.setChecked(true);
                        cb_4.setChecked(true);
                        cb_5.setChecked(true);
                        cb_6.setChecked(true);
                    } else {
                        cb_1.setChecked(false);
                        cb_2.setChecked(false);
                        cb_3.setChecked(false);
                        cb_4.setChecked(false);
                        cb_5.setChecked(false);
                        cb_6.setChecked(false);
                    }
                    break;
                case R.id.cb_1:

                    break;
                case R.id.cb_2:

                    break;
                case R.id.cb_3:

                    break;
                case R.id.cb_4:

                    break;
                case R.id.cb_5:

                    break;
                case R.id.cb_6:

                    break;
            }

        }
    }

    private class MyRadioGroupListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
            if (!isSelect) {
                isSelect = true; //2個群組都註冊同樣監聽  只要有變動2個燈會觸發  所以要設一個狀態 只讓點擊的群組觸發
                switch (radioGroup.getId()) {
                    case R.id.rg0:
                        switch (checkedId) {
                            case R.id.rb0_1:
                                Toast.makeText(getContext(), rb0_1.getText(), Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.rb0_2:
                                Toast.makeText(getContext(), rb0_2.getText(), Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.rb0_3:
                                Toast.makeText(getContext(), rb0_3.getText(), Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.rb0_4:
                                Toast.makeText(getContext(), rb0_4.getText(), Toast.LENGTH_SHORT).show();
                                break;
                        }
                        break;
                    case R.id.rg1:

                        rg2.clearCheck();
                        switch (checkedId) {
                            case R.id.rb1:
                                Toast.makeText(getContext(), rb1.getText(), Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.rb2:
                                Toast.makeText(getContext(), rb2.getText(), Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.rb3:
                                Toast.makeText(getContext(), rb3.getText(), Toast.LENGTH_SHORT).show();
                                break;
                        }

                        break;
                    case R.id.rg2:

                        rg1.clearCheck();
                        switch (checkedId) {
                            case R.id.rb4:
                                Toast.makeText(getContext(), rb4.getText(), Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.rb5:
                                Toast.makeText(getContext(), rb5.getText(), Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.rb6:
                                Toast.makeText(getContext(), rb6.getText(), Toast.LENGTH_SHORT).show();
                                break;
                        }

                        break;
                }
                isSelect = false;

            }
        }
    }

    private void showDateDialog(final TextView view) {
        DatePickerDialog datedialog = new DatePickerDialog(getContext(), android.R.style.Theme_DeviceDefault_Dialog_Alert, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                view.setText(year + "-" + (month + 1) + "-" + day);
            }
        }, year, month, day);
        datedialog.show();
    }

}
