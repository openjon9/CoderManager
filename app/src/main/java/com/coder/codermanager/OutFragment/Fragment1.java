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

import com.coder.codermanager.Activity.Home.homeHomeActivity;
import com.coder.codermanager.Activity.Home.homePMActivity;
import com.coder.codermanager.Activity.Home.homePendingTestActivity;
import com.coder.codermanager.Activity.Home.homeTodoActivity;
import com.coder.codermanager.R;
import com.coder.codermanager.DoubleFragment.TestFragmentAdapter_1;

import java.util.Arrays;


/*************
 *
 *    Fragment 生命週期   產生階段（未出現在畫面上） onAttach --> onCreate --> onCreateView --> onActivityCreated
 *                                      準備階段（出現在畫面上）      onStart -->  onResume  -->
 *                                     暫停階段                                       onPause  -->  onStop
 *                                     Fragment已不在畫面中                onDestroyView
 *                                    Fragment要被清除之前                 onDestroy
 *                                   當初被加入的Activity卸載時        onDetach
 */

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {


    private View view;
    private Button btn_bome, btn_todo, btn_PM, btn_tested;

    private View viewContent;
    private TabLayout tab_essence;
    private ViewPager vp_essence;

    public Fragment1() {
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

        viewContent = inflater.inflate(R.layout.fragment_fragment1, container, false);
//        btn_bome = (Button) view.findViewById(R.id.btn_bome);
//        btn_todo = (Button) view.findViewById(R.id.btn_todo);
//        btn_PM = (Button) view.findViewById(R.id.btn_PM);
//        btn_tested = (Button) view.findViewById(R.id.btn_tested);
//
//        btn_bome.setOnClickListener(new MyOnClickListener());
//        btn_todo.setOnClickListener(new MyOnClickListener());
//        btn_PM.setOnClickListener(new MyOnClickListener());
//        btn_tested.setOnClickListener(new MyOnClickListener());

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
        String[] titles = getResources().getStringArray(R.array.home_tab);

        //创建一个viewpager的adapter
        TestFragmentAdapter_1 adapter = new TestFragmentAdapter_1(getChildFragmentManager(), Arrays.asList(titles)); //getChildFragmentManager()  雙層以上需要用這個方法  否則內外部切換內層會出現空白
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
                case R.id.btn_bome: //首頁資訊
                    intent = new Intent(getContext(), homeHomeActivity.class);
                    getActivity().startActivity(intent);
                    break;
                case R.id.btn_todo: //代辦事項
                    intent = new Intent(getContext(), homeTodoActivity.class);
                    getActivity().startActivity(intent);
                    break;
                case R.id.btn_PM://PM管理事項
                    intent = new Intent(getContext(), homePMActivity.class);
                    getActivity().startActivity(intent);
                    break;
                case R.id.btn_tested: //待測試事項
                    intent = new Intent(getContext(), homePendingTestActivity.class);
                    getActivity().startActivity(intent);
                    break;
            }

        }
    }
}
