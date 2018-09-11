package com.coder.codermanager.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.coder.codermanager.Data.ProData;
import com.coder.codermanager.ProToActivity;
import com.coder.codermanager.R;

import java.util.List;

/**
 * Created by Rey on 2018/9/6.
 */

public class ProjectListAdapter extends RecyclerView.Adapter<ProjectListAdapter.ViewHolder> {

    private Context context;
    private List<ProData> mData;

    @NonNull
    @Override
    public ProjectListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {   //取得layout

        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.projectitem, parent, false);
        ViewHolder vh = new ViewHolder(mView); //layout設定給ViewHolder

        return vh;
    }

    public ProjectListAdapter(Context context, List<ProData> mData) {
        this.mData = mData;
        this.context = context;
    }

    private String TAG = "HomeList";

    @Override
    public void onBindViewHolder(@NonNull ProjectListAdapter.ViewHolder holder, final int position) { //設定元件裡的事件
        holder.text_id.setText(mData.get(position).getID());
        holder.text_name.setText(mData.get(position).getName());
        holder.text_client.setText(mData.get(position).getClient());
        holder.img.setImageResource(R.drawable.ic_android);


        if (mData.size() - 1 == position) {
            holder.line.setVisibility(View.GONE);
        } else {
            holder.line.setVisibility(View.VISIBLE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(context, position + "", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ProToActivity.class);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {  //設定layout的元件

        private TextView text_id;
        private TextView text_name;
        private TextView text_client;
        private ImageView img;

        TextView line;

        public ViewHolder(View itemView) {
            super(itemView);

            text_id = (TextView) itemView.findViewById(R.id.text_id);
            text_name = (TextView) itemView.findViewById(R.id.text_name);
            text_client = (TextView) itemView.findViewById(R.id.text_client);
            img = (ImageView) itemView.findViewById(R.id.img);

            line = (TextView) itemView.findViewById(R.id.line);
        }
    }


}
