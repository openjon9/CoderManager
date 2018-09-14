package com.coder.codermanager.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coder.codermanager.Data.homePendingTestData;
import com.coder.codermanager.R;
import com.coder.codermanager.Activity.Home.homePendingTestClickActivity;


import java.util.List;

/**
 * Created by Rey on 2018/9/14.
 */

public class homePendingTestListAdapter extends RecyclerView.Adapter<homePendingTestListAdapter.ViewHolder> {


    private Context context;
    private List<homePendingTestData> mData;

    public homePendingTestListAdapter(Context context, List<homePendingTestData> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.home_pending_test_item_1, parent, false);

        return new homePendingTestListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.home_pending_test_id.setText(mData.get(position).getId());
        holder.home_pending_test_priority.setText(mData.get(position).getPriority());
        holder.home_pending_test_status.setText(mData.get(position).getStatus());
        holder.home_pending_test_project.setText(mData.get(position).getProject());
        holder.home_pending_test_title.setText(mData.get(position).getTitle());

        if (mData.size() - 1 == position) {
            holder.line.setVisibility(View.GONE);
        } else {
            holder.line.setVisibility(View.VISIBLE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, homePendingTestClickActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView line;
        private TextView home_pending_test_id;
        private TextView home_pending_test_priority;
        private TextView home_pending_test_status;
        private TextView home_pending_test_project;
        private TextView home_pending_test_title;

        public ViewHolder(View itemView) {
            super(itemView);

            home_pending_test_id = (TextView) itemView.findViewById(R.id.home_pending_test_id);
            home_pending_test_priority = (TextView) itemView.findViewById(R.id.home_pending_test_priority);
            home_pending_test_status = (TextView) itemView.findViewById(R.id.home_pending_test_status);
            home_pending_test_project = (TextView) itemView.findViewById(R.id.home_pending_test_project);
            home_pending_test_title = (TextView) itemView.findViewById(R.id.home_pending_test_title);

            line = (TextView) itemView.findViewById(R.id.line);

        }
    }
}
