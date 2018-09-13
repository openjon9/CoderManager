package com.coder.codermanager.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.coder.codermanager.Data.proTodoData;
import com.coder.codermanager.R;
import com.coder.codermanager.Activity.Pro.proTodoClickActivity;

import java.util.List;

/**
 * Created by Rey on 2018/9/12.
 */

public class proTodoListAdapter extends RecyclerView.Adapter<proTodoListAdapter.ViewHolder> {


    private Context context;
    private List<proTodoData> mData;
    private View mHeaderView;
    private View mFooterView;
    private int itemCount = 1;

    public static final int TYPE_HEADER = 0;  //说明是带有Header的
    public static final int TYPE_FOOTER = 1;  //说明是带有Footer的
    public static final int TYPE_NORMAL = 2;  //说明是不带有header和footer的


    public proTodoListAdapter(Context context, List<proTodoData> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (mHeaderView != null && viewType == TYPE_HEADER) {
            return new proTodoListAdapter.ViewHolder(mHeaderView);
        }

        if (mFooterView != null && viewType == TYPE_FOOTER) {
            return new proTodoListAdapter.ViewHolder(mFooterView);
        }

        View mView = LayoutInflater.from(context).inflate(R.layout.pro_todo_item_1, parent, false);
        proTodoListAdapter.ViewHolder vh = new proTodoListAdapter.ViewHolder(mView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        if (getItemViewType(position) == TYPE_NORMAL) {

            holder.protodo_id.setText(mData.get(position).getId());
            holder.protodo_priority.setText(mData.get(position).getPriority());
            holder.protodo_status.setText(mData.get(position).getStatus());
            holder.protodo_project.setText(mData.get(position).getProject());
            holder.protodo_title.setText(mData.get(position).getTitle());

            if (mData.size() - 1 == position) {
                holder.line.setVisibility(View.GONE);
            } else {
                holder.line.setVisibility(View.VISIBLE);
            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent  = new Intent(context, proTodoClickActivity.class);
                    context.startActivity(intent);
                }
            });
        }

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Toast.makeText(context, "123", Toast.LENGTH_SHORT).show();

                return true;
            }
        });


    }

    @Override
    public int getItemViewType(int position) {
        if (mHeaderView == null && mFooterView == null) {
            return TYPE_NORMAL;
        }
        if (position == 0) {
            return TYPE_HEADER;
        }
        if (position == getItemCount() - 1) {
            return TYPE_FOOTER;
        }

        return TYPE_NORMAL;
    }

    @Override
    public int getItemCount() {
        if (mHeaderView == null && mFooterView == null) {

            return mData.size();

        } else if (mHeaderView == null && mFooterView != null) {

            return mData.size() + 1;

        } else if (mHeaderView != null && mFooterView == null) {

            return mData.size() + 1;

        } else {

            return mData.size() + 2;

        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView line;
        private TextView protodo_id;
        private TextView protodo_priority;
        private TextView protodo_status;
        private TextView protodo_project;
        private TextView protodo_title;

        public ViewHolder(View itemView) {
            super(itemView);

            if (itemView == mHeaderView) {
                return;
            } else if (itemView == mFooterView) {
                return;
            } else {
                protodo_id = (TextView) itemView.findViewById(R.id.protodo_id);
                protodo_priority = (TextView) itemView.findViewById(R.id.protodo_priority);
                protodo_status = (TextView) itemView.findViewById(R.id.protodo_status);
                protodo_project = (TextView) itemView.findViewById(R.id.protodo_project);
                protodo_title = (TextView) itemView.findViewById(R.id.protodo_title);

                line = (TextView) itemView.findViewById(R.id.line);
            }

        }
    }

    /**
     * 点击后设置Item的数量
     *
     * @param number
     */
    public void addItemNum(int number) {
        itemCount = number;
    }

    public View getmFooterView() {
        return mFooterView;
    }

    public View getmHeaderView() {
        return mHeaderView;
    }

    public void setmHeaderView(View mHeaderView) {
        this.mHeaderView = mHeaderView;
        notifyItemInserted(0);//放最前面
    }

    public void setmFooterView(View mFooterView) {
        this.mFooterView = mFooterView;
        notifyItemInserted(getItemCount() - 1);//放最後面
    }
}
