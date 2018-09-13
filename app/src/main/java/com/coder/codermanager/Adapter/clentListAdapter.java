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

import com.coder.codermanager.Activity.Client.clientClientClickActivity;
import com.coder.codermanager.Data.clentData;
import com.coder.codermanager.R;

import java.util.List;

/**
 * Created by Rey on 2018/9/13.
 */

public class clentListAdapter extends RecyclerView.Adapter<clentListAdapter.ViewHolder> {

    private Context context;
    private List<clentData> mData;

    public clentListAdapter(Context context, List<clentData> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.clent_item_1, parent, false);
        clentListAdapter.ViewHolder vh = new clentListAdapter.ViewHolder(mView); //layout設定給ViewHolder

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.clent_id.setText(mData.get(position).getId());
        holder.clent_name.setText(mData.get(position).getName());
        holder.clent_proNumber.setText(mData.get(position).getProNumber());
        holder.clent_iogo.setImageResource(R.drawable.ic_android);


        if (mData.size() - 1 == position) {
            holder.line.setVisibility(View.GONE);
        } else {
            holder.line.setVisibility(View.VISIBLE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, clientClientClickActivity.class);
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
        private TextView clent_name;
        private ImageView clent_iogo;
        private TextView clent_id;

        private TextView clent_proNumber;

        public ViewHolder(View itemView) {
            super(itemView);



            clent_id = (TextView) itemView.findViewById(R.id.clent_id);
            clent_name = (TextView) itemView.findViewById(R.id.clent_name);
            clent_iogo = (ImageView) itemView.findViewById(R.id.clent_iogo);
            clent_proNumber = (TextView) itemView.findViewById(R.id.clent_proNumber);


            line = (TextView) itemView.findViewById(R.id.line);


        }
    }

}
