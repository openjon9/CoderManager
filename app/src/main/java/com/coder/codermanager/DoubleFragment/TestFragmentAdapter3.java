package com.coder.codermanager.DoubleFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Rey on 2018/9/18.
 */

public class TestFragmentAdapter3 extends FragmentStatePagerAdapter {

    public static final String TAB_TAG = "@dream@";

    private List<String> mTitles;

    public TestFragmentAdapter3(FragmentManager fm, List<String> mTitles) {
        super(fm);
        this.mTitles = mTitles;
    }

    public TestFragmentAdapter3(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        //初始化Fragment数据
        String[] title = mTitles.get(position).split(TAB_TAG);
        ContentFragment_3 fragment = new ContentFragment_3();
        fragment.setType(Integer.parseInt(title[1]));
        fragment.setTitle(title[0]);

        return fragment;
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position).split(TAB_TAG)[0];
    }
}
