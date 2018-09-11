package com.coder.codermanager.Adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


import com.coder.codermanager.Data.workRecordData;
import com.coder.codermanager.R;

import java.util.List;

/**
 * Created by Rey on 2018/9/11.
 */

public class workRecordListAdapter extends RecyclerView.Adapter<workRecordListAdapter.ViewHolder> {


    private Context context;
    private List<workRecordData> mData;

    public workRecordListAdapter(Context context, List<workRecordData> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.workrecorditem, parent, false);
        workRecordListAdapter.ViewHolder vh = new workRecordListAdapter.ViewHolder(mView); //layout設定給ViewHolder

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text_name.setText(mData.get(position).getName());
        holder.text_time.setText(mData.get(position).getTime());
        holder.text_project.setText(mData.get(position).getProject());
        holder.text_projectItem.setText(mData.get(position).getProjectItem());
        holder.text_Remarks.setText(mData.get(position).getRemarks());


        if (mData.size() - 1 == position) {
            holder.line.setVisibility(View.GONE);
        } else {
            holder.line.setVisibility(View.VISIBLE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





//                View popupView = LayoutInflater.from(context).inflate(R.layout.workrecordpopview,null,false);
//                popupView.findViewById(R.id.text);
//
//                PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.MATCH_PARENT  , ViewGroup.LayoutParams.WRAP_CONTENT , true);
//                popupWindow.setBackgroundDrawable(new ColorDrawable(0x4e000000));
//
//                popupWindow.showAsDropDown(popupView);


            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView text_name;
        private TextView text_time;
        private TextView text_project;
        private TextView text_projectItem;
        private TextView text_Remarks;
        private TextView line;

        public ViewHolder(View itemView) {
            super(itemView);

            text_name = (TextView) itemView.findViewById(R.id.text_name);
            text_time = (TextView) itemView.findViewById(R.id.text_time);
            text_project = (TextView) itemView.findViewById(R.id.text_project);
            text_projectItem = (TextView) itemView.findViewById(R.id.text_projectItem);
            text_Remarks = (TextView) itemView.findViewById(R.id.text_Remarks);

            line = (TextView) itemView.findViewById(R.id.line);
        }
    }


}
