package com.coder.codermanager.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.coder.codermanager.Data.homeHomeData;
import com.coder.codermanager.Activity.MainActivity;
import com.coder.codermanager.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rey on 2018/8/22.
 */

public class HomeListAdapter extends BaseAdapter {

    private ArrayList<String> mtitle;
    Context context;
    List<homeHomeData> mList = new ArrayList<>();
    private int mSelect;
    private int itemCount = 1;
    public static final int TYPE_TITLE = 0;
    public static final int TYPE_COMPANY = 1;
    private String TAG = "listAdapter";

    public HomeListAdapter(MainActivity context, ArrayList<homeHomeData> mlist, ArrayList<String> listTitle) {

        this.context = context;
        this.mList = mlist;
        this.mtitle = listTitle;
    }

    public HomeListAdapter(Context context, List<homeHomeData> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        // 这里是关键
        // 如果数据数量大于3，只显示3条数据。这里数量自己定义。
        // 否则，显示全部数量。
        if (mList.size() >= 1) {
            return itemCount;
        } else {
            return mList.size();
        }
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        MyTag myTag = null;
        TitleViewHolder titleHolder;

//        switch (getItemViewType(position)) {
//            case TYPE_TITLE:
//                if (convertView == null) {
//                    convertView = LayoutInflater.from(context).inflate(R.layout.list_title, null);
//                    titleHolder = new TitleViewHolder();
//                    titleHolder.title = (TextView) convertView.findViewById(R.id.title_list);
//                    convertView.setTag(titleHolder);
//                } else {
//                    titleHolder = (TitleViewHolder) convertView.getTag();
//                }
//
//                if (mtitle.get(position).equals("11")) {
//                    titleHolder.title.setText("Home");
//
//                } else if (mtitle.get(position).equals("22")) {
//                    titleHolder.title.setText("test");
//                }
//                Log.d(TAG,"123");
//                break;
//            case TYPE_COMPANY:
//
//                break;
//
//        }

        if (convertView == null) {
            myTag = new MyTag();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.home_home_item_1, null);
            myTag.proName = (TextView) convertView.findViewById(R.id.proName);
            myTag.UnNumber = (TextView) convertView.findViewById(R.id.UnNumber);
            myTag.timeOutNumber = (TextView) convertView.findViewById(R.id.timeOutNumber);

            convertView.setTag(myTag);
        } else {
            myTag = (MyTag) convertView.getTag();
        }

        myTag.proName.setText(mList.get(position).getProName());
        myTag.UnNumber.setText(mList.get(position).getUnNumber());
        myTag.timeOutNumber.setText(mList.get(position).getTimeOutNumber());
        Log.d(TAG, "456");

        return convertView;
    }

//    @Override
//    public int getItemViewType(int position) {
//        Log.d(TAG, "position:" + position);
//        if (position == 1) {
//            return TYPE_TITLE;
//        } else {
//            return TYPE_COMPANY;
//        }
//    }
//
//    @Override
//    public int getViewTypeCount() {
//        return 2;
//    }

    /**
     * 点击后设置Item的数量
     *
     * @param number
     */
    public void addItemNum(int number) {
        itemCount = number;
    }

    class TitleViewHolder {
        TextView title;
    }

    private class MyTag {

        TextView proName;
        TextView UnNumber;
        TextView timeOutNumber;
    }

}
