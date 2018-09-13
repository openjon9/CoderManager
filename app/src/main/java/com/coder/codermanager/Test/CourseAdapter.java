package com.coder.codermanager.Test;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coder.codermanager.R;

import java.util.List;

/**
 * Created by Rey on 2018/9/13.
 */

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.SimpleViewHolder> {

    private  Context mContext;
    private  List<Nugget> mData;
    private static RecyclerView horizontalList;

    public CourseAdapter(Context mContext, List<Nugget> data) {
        this.mContext = mContext;
        this.mData = data;
    }

    @NonNull
    @Override
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.testitem,parent,false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleViewHolder holder, int position) {
        holder.course_item_name_tv.setText(mData.get(position).getId());
        holder.horizontalAdapter.setData(mData.get(position).getTags()); // List of Strings
        holder.horizontalAdapter.setRowIndex(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder{

        private HorizontalAdapter horizontalAdapter;
        private  TextView course_item_name_tv;


        public SimpleViewHolder(View itemView) {
            super(itemView);

            Context context = itemView.getContext();
            course_item_name_tv = (TextView) itemView.findViewById(R.id.course_item_name_tv);
            horizontalList = (RecyclerView) itemView.findViewById(R.id.horizontal_list);

            LinearLayoutManager layout = new LinearLayoutManager(context);
            layout.setOrientation(LinearLayoutManager.HORIZONTAL);
            horizontalList.setLayoutManager(layout);

            horizontalAdapter = new HorizontalAdapter(context);
            horizontalList.setAdapter(horizontalAdapter);

        }
    }
}
