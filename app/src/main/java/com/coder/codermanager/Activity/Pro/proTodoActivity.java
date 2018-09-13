package com.coder.codermanager.Activity.Pro;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.coder.codermanager.Adapter.proTodoListAdapter;
import com.coder.codermanager.Data.proTodoData;
import com.coder.codermanager.Interface.windowSoftInputModeInterface;
import com.coder.codermanager.R;

import net.cachapa.expandablelayout.ExpandableLinearLayout;

import java.util.ArrayList;

public class proTodoActivity extends AppCompatActivity implements windowSoftInputModeInterface {

    private proTodoActivity context;
    private Spinner pro_todo_selete;
    private ArrayAdapter<String> pro_todo_selete_spinnerAdapter;
    private Spinner pro_todo_project;
    private ArrayAdapter<String> pro_todo_project_spinnerAdapter;
    private Spinner pro_todo_type;
    private ArrayAdapter<String> pro_todo_type_spinnerAdapter;
    private Spinner pro_todo_priority;
    private ArrayAdapter<String> pro_todo_priority_spinnerAdapter;
    private ImageView image_up;
    private RecyclerView pro_todo_recyclerview;
    private ArrayList<proTodoData> myDataset;
    private proTodoListAdapter mAdapter;
    private ExpandableLinearLayout expandableLayout;
    private boolean isopen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_todo);

        context = this;
        setTitle("代辦事項管理");
        findview();
        setRecyclerview();
        setSpinner();
        initEvent();
    }

    private void setSpinner() {

        pro_todo_selete_spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.pro_todo_selete));
        pro_todo_selete_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        pro_todo_selete.setAdapter(pro_todo_selete_spinnerAdapter);


        pro_todo_project_spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.pro_todo_project));
        pro_todo_project_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        pro_todo_project.setAdapter(pro_todo_project_spinnerAdapter);

        pro_todo_type_spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.pro_todo_type));
        pro_todo_type_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        pro_todo_type.setAdapter(pro_todo_type_spinnerAdapter);

        pro_todo_priority_spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.pro_todo_priority));
        pro_todo_priority_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        pro_todo_priority.setAdapter(pro_todo_priority_spinnerAdapter);
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

    private void setRecyclerview() {

        myDataset = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            myDataset.add(new proTodoData(String.valueOf(i)));
        }

        mAdapter = new proTodoListAdapter(context, myDataset);

        //方向一定要設才有效果
        final LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        pro_todo_recyclerview.setLayoutManager(layoutManager);

        pro_todo_recyclerview.setAdapter(mAdapter);

     //   setHeaderView(pro_todo_recyclerview);
    }

//    private void setHeaderView(RecyclerView view) {
//        View header = LayoutInflater.from(this).inflate(R.layout.pro_todoitem2, view, false);
//        mAdapter.setmHeaderView(header);
//    }

    private void findview() {

        pro_todo_selete = (Spinner) findViewById(R.id.pro_todo_selete);
        pro_todo_project = (Spinner) findViewById(R.id.pro_todo_project);
        pro_todo_type = (Spinner) findViewById(R.id.pro_todo_type);
        pro_todo_priority = (Spinner) findViewById(R.id.pro_todo_priority);

        image_up = (ImageView) findViewById(R.id.image_up);
        pro_todo_recyclerview = (RecyclerView) findViewById(R.id.pro_todo_recyclerview);

        expandableLayout = (net.cachapa.expandablelayout.ExpandableLinearLayout) findViewById(R.id.expandableLayout);//伸縮
    }

    @Override
    public void hideSoft(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
