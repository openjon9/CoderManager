package com.coder.codermanager.OutFragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.coder.codermanager.Activity.Client.clientClientActivity;
import com.coder.codermanager.Activity.Client.clientContactPersonActivity;
import com.coder.codermanager.DoubleFragment.TestFragmentAdapter2;
import com.coder.codermanager.R;

import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {


    private View viewContent;
    private Button btn_Customer,btn_Contact;
    private TabLayout tab_essence;
    private ViewPager vp_essence;

    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewContent = inflater.inflate(R.layout.fragment_fragment2, container, false);
//        btn_Customer = (Button)view.findViewById(R.id.btn_Customer);
//        btn_Contact = (Button) view.findViewById(R.id.btn_Contact);
//
//        btn_Customer.setOnClickListener(new MyOnClickListener());
//        btn_Contact.setOnClickListener(new MyOnClickListener());
        initConentView(viewContent);
        initData();
        return viewContent;
    }

    public void initConentView(View viewContent) {
        this.tab_essence = (TabLayout) viewContent.findViewById(R.id.tab_essence);
        this.vp_essence = (ViewPager) viewContent.findViewById(R.id.vp_essence);
    }
    public void initData() {
        //获取标签数据
        String[] titles = getResources().getStringArray(R.array.client_tab);

        //创建一个viewpager的adapter
        TestFragmentAdapter2 adapter = new TestFragmentAdapter2(getChildFragmentManager(), Arrays.asList(titles)); //getChildFragmentManager()  雙層以上需要用這個方法  否則內外部切換內層會出現空白
        this.vp_essence.setAdapter(adapter);

        //将TabLayout和ViewPager关联起来
        this.tab_essence.setupWithViewPager(this.vp_essence);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private class MyOnClickListener implements View.OnClickListener {

        Intent intent;

        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.btn_Customer: //客戶管理
                    intent = new Intent(getContext(), clientClientActivity.class);
                    getActivity().startActivity(intent);
                    break;
                case R.id.btn_Contact: //聯絡人管理
                    intent = new Intent(getContext(), clientContactPersonActivity.class);
                    getActivity().startActivity(intent);
                    break;

            }

        }
    }
}
