package com.coder.codermanager.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coder.codermanager.Activity.Home.homePmClickActivity;
import com.coder.codermanager.Data.homeTodoData;
import com.coder.codermanager.R;
import com.coder.codermanager.homeTodoClickActivity;

import java.util.List;

/**
 * Created by Rey on 2018/9/14.
 */

public class homeTodoListAdapter extends RecyclerView.Adapter<homeTodoListAdapter.ViewHolder> {


    private Context context;
    private List<homeTodoData> mData;

    public homeTodoListAdapter(Context context, List<homeTodoData> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.home_todo_item_1, parent, false);
        return new homeTodoListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.home_todo_id.setText(mData.get(position).getId());
        holder.home_todo_priority.setText(mData.get(position).getPriority());
        holder.home_todo_status.setText(mData.get(position).getStatus());
        holder.home_todo_project.setText(mData.get(position).getProject());
        holder.home_todo_title.setText(mData.get(position).getTitle());

        if (mData.size() - 1 == position) {
            holder.line.setVisibility(View.GONE);
        } else {
            holder.line.setVisibility(View.VISIBLE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, homeTodoClickActivity.class);
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
        private TextView home_todo_id;
        private TextView home_todo_priority;
        private TextView home_todo_status;
        private TextView home_todo_project;
        private TextView home_todo_title;

        public ViewHolder(View itemView) {
            super(itemView);


            home_todo_id = (TextView) itemView.findViewById(R.id.home_todo_id);
            home_todo_priority = (TextView) itemView.findViewById(R.id.home_todo_priority);
            home_todo_status = (TextView) itemView.findViewById(R.id.home_todo_status);
            home_todo_project = (TextView) itemView.findViewById(R.id.home_todo_project);
            home_todo_title = (TextView) itemView.findViewById(R.id.home_todo_title);

            line = (TextView) itemView.findViewById(R.id.line);
        }
    }
}
