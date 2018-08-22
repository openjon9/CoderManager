package com.coder.codermanager.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coder.codermanager.Data.homeData;
import com.coder.codermanager.MainActivity;
import com.coder.codermanager.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rey on 2018/8/22.
 */

public class HomeListAdapter extends BaseAdapter {

    Context context;
    List<homeData> mList = new ArrayList<>();
    private int mSelect;

    public HomeListAdapter(MainActivity context, ArrayList<homeData> mlist) {

        this.context = context;
        this.mList = mlist;

    }

    @Override
    public int getCount() {
        return mList.size();
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
        if (convertView == null) {
            myTag = new MyTag();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.homeitem, null);
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

        return convertView;
    }

    private void addHeaderView(View v, Object data, Boolean isSelectable) {

        LayoutInflater inflater = LayoutInflater.from(context);


    }

    private class MyTag {

        TextView proName;
        TextView UnNumber;
        TextView timeOutNumber;
    }

}
