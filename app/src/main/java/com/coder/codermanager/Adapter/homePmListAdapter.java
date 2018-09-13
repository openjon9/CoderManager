package com.coder.codermanager.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coder.codermanager.Data.homePmListData;
import com.coder.codermanager.R;
import com.coder.codermanager.Activity.Home.homePmClickActivity;

import java.util.List;

/**
 * Created by Rey on 2018/9/13.
 */

public class homePmListAdapter extends RecyclerView.Adapter<homePmListAdapter.ViewHolder> {

    private Context context;
    private List<homePmListData> mData;

    public homePmListAdapter(Context context, List<homePmListData> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(context).inflate(R.layout.home_pm_item_1, parent, false);
        homePmListAdapter.ViewHolder vh = new homePmListAdapter.ViewHolder(mView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.home_pm_id.setText(mData.get(position).getId());
        holder.home_pm_priority.setText(mData.get(position).getPriority());
        holder.home_pm_status.setText(mData.get(position).getStatus());
        holder.home_pm_project.setText(mData.get(position).getProject());
        holder.home_pm_title.setText(mData.get(position).getTitle());

        if (mData.size() - 1 == position) {
            holder.line.setVisibility(View.GONE);
        } else {
            holder.line.setVisibility(View.VISIBLE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, homePmClickActivity.class);
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
        private TextView home_pm_id;
        private TextView home_pm_priority;
        private TextView home_pm_status;
        private TextView home_pm_project;
        private TextView home_pm_title;

        public ViewHolder(View itemView) {
            super(itemView);

            home_pm_id = (TextView) itemView.findViewById(R.id.home_pm_id);
            home_pm_priority = (TextView) itemView.findViewById(R.id.home_pm_priority);
            home_pm_status = (TextView) itemView.findViewById(R.id.home_pm_status);
            home_pm_project = (TextView) itemView.findViewById(R.id.home_pm_project);
            home_pm_title = (TextView) itemView.findViewById(R.id.home_pm_title);

            line = (TextView) itemView.findViewById(R.id.line);
        }
    }
}
