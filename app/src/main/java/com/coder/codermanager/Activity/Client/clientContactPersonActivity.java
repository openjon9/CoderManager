package com.coder.codermanager.Activity.Client;

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

import com.coder.codermanager.Adapter.contactPersonListAdapter;
import com.coder.codermanager.Data.contactPersonData;
import com.coder.codermanager.Interface.windowSoftInputModeInterface;
import com.coder.codermanager.R;

import net.cachapa.expandablelayout.ExpandableLinearLayout;

import java.util.ArrayList;

public class clientContactPersonActivity extends AppCompatActivity implements windowSoftInputModeInterface {

    private clientContactPersonActivity context;
    private Spinner contact_person_select;
    private Spinner contact_person_company;
    private Spinner contact_person_time;
    private boolean isopen = false;
    private ImageView image_up;
    private ExpandableLinearLayout expandableLayout;
    private ArrayAdapter<String> contact_person_select_spinnerAdapter;
    private ArrayAdapter<String> contact_person_time_spinnerAdapter;
    private ArrayAdapter<String> contact_person_company_spinnerAdapter;
    private RecyclerView contact_person_recyclerview;
    private ArrayList<contactPersonData> myDataset;
    private contactPersonListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_contact_person);

        context = this;
        setTitle("聯絡人管理");
        findview();
        setRecyclerview();
        setSpinner();
        initEvent();
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

    private void setSpinner() {

        contact_person_select_spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.contact_person_select));
        contact_person_select_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        contact_person_select.setAdapter(contact_person_select_spinnerAdapter);

        contact_person_company_spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.contact_person_company));
        contact_person_company_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        contact_person_company.setAdapter(contact_person_company_spinnerAdapter);


        contact_person_time_spinnerAdapter = new ArrayAdapter<String>(context, R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.contact_person_time));
        contact_person_time_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
        contact_person_time.setAdapter(contact_person_time_spinnerAdapter);

    }

    private void setRecyclerview() {
        myDataset = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            myDataset.add(new contactPersonData(String.valueOf(i)));
        }

        mAdapter = new contactPersonListAdapter(context, myDataset);

        //方向一定要設才有效果
        final LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        contact_person_recyclerview.setLayoutManager(layoutManager);

        contact_person_recyclerview.setAdapter(mAdapter);
    }

    private void findview() {
        contact_person_select = (Spinner) findViewById(R.id.contact_person_select);
        contact_person_company = (Spinner) findViewById(R.id.contact_person_company);
        contact_person_time = (Spinner) findViewById(R.id.contact_person_time);
        image_up = (ImageView) findViewById(R.id.image_up);
        expandableLayout = (net.cachapa.expandablelayout.ExpandableLinearLayout) findViewById(R.id.expandableLayout);//伸縮
        contact_person_recyclerview = (RecyclerView) findViewById(R.id.contact_person_recyclerview);
    }

    @Override
    public void hideSoft(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
