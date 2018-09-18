package com.coder.codermanager.SingleFragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.coder.codermanager.OutFragment.Fragment2;
import com.coder.codermanager.OutFragment.Fragment3;
import com.coder.codermanager.R;

import com.coder.codermanager.OutFragment.Fragment1;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener {


    private MainActivity context;
    private ArrayList<View> viewList;
    private ViewPager mViewPager;
    private ImageView img_cursor;
    private LinearLayout linear_page_1, linear_page_2, linear_page_3;
    private TabLayout tabLayout;
//    private Fragment1 fragment1 = new Fragment1();
//    private Fragment2 fragment2 = new Fragment2();
//    private Fragment3 fragment3 = new Fragment3();

    private List<Fragment> fragmentList;
    private List<String> titleList;
    private List<Integer> imgList;
    private MyFragmentPagerAdapter adapter;


    private ViewHolder holder;
    private List<Fragment> fragments = new ArrayList<>();
    private TabLayout tab_layout_sub;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        setTitle("後台管理系統");

        findview();
        //initEvent();
        initData();
        initView();


    }

    private void findview() {

//        tabLayout.addTab(tabLayout.newTab().setText(setImageSpan("首頁", R.drawable.ic_home)));
//        tabLayout.addTab(tabLayout.newTab().setText(setImageSpan("客戶管理", R.drawable.ic_tag_faces)));
//        tabLayout.addTab(tabLayout.newTab().setText(setImageSpan("專案管理", R.drawable.ic_folder_black)));

//
//        linear_page_1 = (LinearLayout) findViewById(R.id.linear_page_1);
//        linear_page_2 = (LinearLayout) findViewById(R.id.linear_page_2);
//        linear_page_3 = (LinearLayout) findViewById(R.id.linear_page_3);
//
//        img_cursor = (ImageView) findViewById(R.id.img_cursor);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tab_layout_sub = (TabLayout)findViewById(R.id.tab_layout_sub);
        mViewPager = (ViewPager) findViewById(R.id.pager);
    }

    private void initData() {

        fragmentList = new ArrayList<>();
        fragmentList.add(new Fragment1());
        fragmentList.add(new Fragment2());
        fragmentList.add(new Fragment3());

        titleList = new ArrayList<>();
        titleList.add("首頁");
        titleList.add("客戶管理");
        titleList.add("專案管理");

        imgList = new ArrayList<>();
        imgList.add(R.drawable.ic_home);
        imgList.add(R.drawable.ic_tag_faces);
        imgList.add(R.drawable.ic_folder_black);


//        View t1 = getLayoutInflater().inflate(R.layout.main_page_1, null);
//        View t2 = getLayoutInflater().inflate(R.layout.main_page_2, null);
//        View t3 = getLayoutInflater().inflate(R.layout.main_page_3, null);
//
//
//        viewList = new ArrayList<>();
//        viewList.add(t1);
//        viewList.add(t2);
//        viewList.add(t3);
    }

    private void initView() {
        //mViewPager.setAdapter(new mainPagerAdapter(viewList, context)); 這種是換layout的方式

//
//        //设置分割线
//        LinearLayout linearLayout = (LinearLayout) tabLayout.getChildAt(0);
//        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
//        linearLayout.setDividerDrawable(ContextCompat.getDrawable(this,
//                R.drawable.divider)); //设置分割线的样式
//        linearLayout.setDividerPadding(dip2px(10)); //设置分割线间隔

        adapter = new MyFragmentPagerAdapter(context, getSupportFragmentManager(), fragmentList, titleList, imgList);

        mViewPager.setAdapter(adapter); //這種是Fragment 的方式
     //   mViewPager.setCurrentItem(0);//起始頁面
        //  mViewPager.setOnPageChangeListener(new MyOnPageChangeListener());

        tabLayout.setupWithViewPager(mViewPager);//將 tabLayout 與 mViewPager 連接

        setTabView();

        mViewPager.addOnPageChangeListener(this);
       tabLayout.addOnTabSelectedListener(this);
    }

    private void setTabView() {
        holder = null;
        for (int i = 0; i < titleList.size(); i++) {
            //依次获取标签
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            //为每个标签设置布局
            tab.setCustomView(R.layout.tab_item);
            // Log.d("CustomView",tab.getCustomView()+"");
            holder = new ViewHolder(tab.getCustomView());
            //为标签填充数据
            holder.tvTabName.setText(titleList.get(i));
            holder.img.setImageDrawable(getDrawable(imgList.get(i)));

            //默认选择第一项
            if (i == 0) {
                holder.tvTabName.setSelected(true);
                holder.tvTabName.setTextAppearance( R.style.TabLayoutTextStyle);
            }else {
                holder.tvTabName.setSelected(false);
                holder.tvTabName.setTextAppearance( R.style.TabLayoutTextStyle2);
            }
        }
    }


    private void initEvent() {
        linear_page_1.setOnClickListener(new MyOnClickListener(0));
        linear_page_2.setOnClickListener(new MyOnClickListener(1));
        linear_page_3.setOnClickListener(new MyOnClickListener(2));

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /****
     *  PageChangeListener
     * ****/
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        tabLayout.getTabAt(position).select();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /***
     *  TabSelectedListener
     *
     *
     */

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        holder = new ViewHolder(tab.getCustomView());
        holder.tvTabName.setSelected(true);
        //选中后字体变大
        holder.tvTabName.setTextAppearance( R.style.TabLayoutTextStyle);
        //让Viewpager跟随TabLayout的标签切换
        mViewPager.setCurrentItem(tab.getPosition());


    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        holder = new ViewHolder(tab.getCustomView());
        holder.tvTabName.setSelected(false);
        //恢复为默认字体大小
        holder.tvTabName.setTextAppearance( R.style.TabLayoutTextStyle2);

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    class ViewHolder {
        TextView tvTabName;
        ImageView img;

        public ViewHolder(View tabView) {
            tvTabName = (TextView) tabView.findViewById(R.id.tv_tab_name);
            img=(ImageView)tabView.findViewById(R.id.img);
        }
    }

    //像素单位转换
    public int dip2px(int dip) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (dip * density + 0.5);
    }

    private class MyOnClickListener implements View.OnClickListener {

        private int index = 0;

        public MyOnClickListener(int index) {
            this.index = index;
        }

        @Override
        public void onClick(View view) {
            mViewPager.setCurrentItem(index);
        }
    }


}
