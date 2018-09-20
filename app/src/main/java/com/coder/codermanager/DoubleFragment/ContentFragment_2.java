package com.coder.codermanager.DoubleFragment;


import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.coder.codermanager.Adapter.clentListAdapter;
import com.coder.codermanager.Adapter.contactPersonListAdapter;
import com.coder.codermanager.Data.clientData;
import com.coder.codermanager.Data.contactPersonData;
import com.coder.codermanager.Date.MyDate;
import com.coder.codermanager.Interface.windowSoftInputModeInterface;
import com.coder.codermanager.R;

import net.cachapa.expandablelayout.ExpandableLinearLayout;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment_2 extends Fragment implements windowSoftInputModeInterface {


    private int year;
    private int month;
    private int day;
    private int mType;
    private String mTitle;
    private View viewContent;
    private int recyclerview;
    private TextView text_client_client_1, text_client_client_2;
    private Spinner client_select, client_time;
    private ImageView image_up;
    private ExpandableLinearLayout expandableLayout;
    private RecyclerView client_recyclerview;
    private ArrayList<clientData> myDataset_client;
    private clentListAdapter client_Adapter;
    private ArrayAdapter<String> client_select_spinnerAdapter;
    private ArrayAdapter<String> client_time_spinnerAdapter;
    private boolean isopen = false;

    private TextView text_client_contact_person_1, text_client_contact_person_2;
    private Spinner contact_person_select, contact_person_company, contact_person_time;
    private RecyclerView contact_person_recyclerview;
    private ArrayList<contactPersonData> myDataset_contactPersonData;
    private contactPersonListAdapter contact_person_Adapter;
    private ArrayAdapter<String> contact_person_select_spinnerAdapter;
    private ArrayAdapter<String> contact_person_company_spinnerAdapter;
    private ArrayAdapter<String> contact_person_time_spinnerAdapter;
    private ImageView client_person_add;
    private ImageView client_client_add;

    public ContentFragment_2() {
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
                viewContent = inflater.inflate(R.layout.activity_client_client, container, false);
                findview(mType, viewContent);
                initData(mType);
                setRecyclerview(mType);
                setSpinner(mType);
                initEvent(mType);
                break;
            case 1:
                viewContent = inflater.inflate(R.layout.activity_client_contact_person, container, false);
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
                text_client_client_1 = (TextView) viewContent.findViewById(R.id.text_client_client_1);
                text_client_client_2 = (TextView) viewContent.findViewById(R.id.text_client_client_2);

                client_select = (Spinner) viewContent.findViewById(R.id.client_select);
                client_time = (Spinner) viewContent.findViewById(R.id.client_time);

                image_up = (ImageView) viewContent.findViewById(R.id.image_up);
                client_client_add = (ImageView) viewContent.findViewById(R.id.client_client_add);
                expandableLayout = (net.cachapa.expandablelayout.ExpandableLinearLayout) viewContent.findViewById(R.id.expandableLayout);//伸縮
                client_recyclerview = (RecyclerView) viewContent.findViewById(R.id.client_recyclerview);
                break;
            case 1:
                text_client_contact_person_1 = (TextView) viewContent.findViewById(R.id.text_client_contact_person_1);
                text_client_contact_person_2 = (TextView) viewContent.findViewById(R.id.text_client_contact_person_2);

                contact_person_select = (Spinner) viewContent.findViewById(R.id.contact_person_select);
                contact_person_company = (Spinner) viewContent.findViewById(R.id.contact_person_company);
                contact_person_time = (Spinner) viewContent.findViewById(R.id.contact_person_time);
                image_up = (ImageView) viewContent.findViewById(R.id.image_up);
                expandableLayout = (net.cachapa.expandablelayout.ExpandableLinearLayout) viewContent.findViewById(R.id.expandableLayout);//伸縮
                contact_person_recyclerview = (RecyclerView) viewContent.findViewById(R.id.contact_person_recyclerview);

                client_person_add = (ImageView) viewContent.findViewById(R.id.client_person_add);
                break;
        }
    }

    private void initData(int mType) {
        switch (mType) {
            case 0:
                myDataset_client = new ArrayList<>();
                for (int i = 0; i < 100; i++) {
                    myDataset_client.add(new clientData(String.valueOf(i), String.valueOf(i)));
                }
                break;
            case 1:
                myDataset_contactPersonData = new ArrayList<>();
                for (int i = 0; i < 100; i++) {
                    myDataset_contactPersonData.add(new contactPersonData(String.valueOf(i)));
                }
                break;
        }
    }

    private void setRecyclerview(int mType) {
        LinearLayoutManager layoutManager;
        switch (mType) {
            case 0:
                client_Adapter = new clentListAdapter(getContext(), myDataset_client);

                //方向一定要設才有效果
                layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                client_recyclerview.setLayoutManager(layoutManager);

                client_recyclerview.setAdapter(client_Adapter);
                break;
            case 1:
                contact_person_Adapter = new contactPersonListAdapter(getContext(), myDataset_contactPersonData);

                //方向一定要設才有效果
                layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                contact_person_recyclerview.setLayoutManager(layoutManager);

                contact_person_recyclerview.setAdapter(contact_person_Adapter);
                break;
        }
    }

    private void setSpinner(int mType) {
        switch (mType) {
            case 0:
                client_select_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.client_select));
                client_select_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
                client_select.setAdapter(client_select_spinnerAdapter);


                client_time_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.client_time));
                client_time_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
                client_time.setAdapter(client_time_spinnerAdapter);
                break;
            case 1:
                contact_person_select_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.contact_person_select));
                contact_person_select_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
                contact_person_select.setAdapter(contact_person_select_spinnerAdapter);

                contact_person_company_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.contact_person_company));
                contact_person_company_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
                contact_person_company.setAdapter(contact_person_company_spinnerAdapter);


                contact_person_time_spinnerAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.contact_person_time));
                contact_person_time_spinnerAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
                contact_person_time.setAdapter(contact_person_time_spinnerAdapter);
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
        }
    }

    private void click_2() {

        client_person_add.setOnClickListener(new View.OnClickListener() {
            public AlertDialog dialog;

            @Override
            public void onClick(View view) {
                View mview = LayoutInflater.from(getContext()).inflate(R.layout.add_client_person, null);
                Spinner add_client_person_select = (Spinner) mview.findViewById(R.id.add_client_person_select);
                ImageView add_img = (ImageView) mview.findViewById(R.id.add_img);
                Button btn_yes = (Button) mview.findViewById(R.id.btn_yes);
                Button btn_no = (Button) mview.findViewById(R.id.btn_no);
                EditText ed_account = (EditText) mview.findViewById(R.id.ed_account);
                EditText ed_name = (EditText) mview.findViewById(R.id.ed_name);
                EditText ed_job = (EditText) mview.findViewById(R.id.ed_job); //職稱
                EditText ed_phone = (EditText) mview.findViewById(R.id.ed_phone); //連絡電話
                EditText ed_mobliephone = (EditText) mview.findViewById(R.id.ed_mobliephone); //手機
                EditText ed_email = (EditText) mview.findViewById(R.id.ed_email);

                ArrayAdapter<String> add_client_person_selectAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_layout, R.id.text_spinner, getResources().getStringArray(R.array.add_client_person_select));
                add_client_person_selectAdapter.setDropDownViewResource(R.layout.spinner_down_layout);
                add_client_person_select.setAdapter(add_client_person_selectAdapter);


                btn_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                btn_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog = new AlertDialog.Builder(getContext())
                        .setView(mview)
                        .show();

            }
        });

        text_client_contact_person_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datedialog = new DatePickerDialog(getContext(), android.R.style.Theme_DeviceDefault_Dialog_Alert, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        text_client_contact_person_1.setText(year + "-" + (month + 1) + "-" + day);
                    }
                }, year, month, day);
                datedialog.show();
            }
        });

        text_client_contact_person_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datedialog = new DatePickerDialog(getContext(), android.R.style.Theme_DeviceDefault_Dialog_Alert, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        text_client_contact_person_2.setText(year + "-" + (month + 1) + "-" + day);
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

    private void click_1() {
        text_client_client_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datedialog = new DatePickerDialog(getContext(), android.R.style.Theme_DeviceDefault_Dialog_Alert, new DatePickerDialog.OnDateSetListener() {
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

                DatePickerDialog datedialog = new DatePickerDialog(getContext(), android.R.style.Theme_DeviceDefault_Dialog_Alert, new DatePickerDialog.OnDateSetListener() {
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

        client_client_add.setOnClickListener(new View.OnClickListener() {
            public AlertDialog dialog;

            @Override
            public void onClick(View view) {

                View mview = LayoutInflater.from(getContext()).inflate(R.layout.add_client_client, null);
                ImageView add_img = (ImageView) mview.findViewById(R.id.add_img);
                EditText ed_name = (EditText) mview.findViewById(R.id.ed_name);
                EditText ed_Invoice = (EditText) mview.findViewById(R.id.ed_Invoice);
                EditText ed_TongBian = (EditText) mview.findViewById(R.id.ed_TongBian);
                EditText ed_phone = (EditText) mview.findViewById(R.id.ed_phone);
                EditText ed_address = (EditText) mview.findViewById(R.id.ed_address);
                EditText ed_Uri = (EditText) mview.findViewById(R.id.ed_Uri);

                Button btn_yes = (Button) mview.findViewById(R.id.btn_yes);
                Button btn_no = (Button) mview.findViewById(R.id.btn_no);


                btn_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                btn_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog = new AlertDialog.Builder(getContext())
                        .setView(mview)
                        .show();

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
