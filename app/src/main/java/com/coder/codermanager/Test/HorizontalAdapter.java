package com.coder.codermanager.Test;

import android.content.Context;
import android.support.annotation.NonNull;
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

public class HorizontalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private List<String> mDataList;
    private int mRowIndex = -1;

    public HorizontalAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<String> data) {
            mDataList = data;
            notifyDataSetChanged();

    }
    public void setRowIndex(int index) {
        mRowIndex = index;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.test_h_item,parent,false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder rawHolder, int position) {
        ItemViewHolder holder = (ItemViewHolder) rawHolder;
        holder.horizontal_item_text.setText(mDataList.get(position));
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    private class ItemViewHolder extends RecyclerView.ViewHolder{

        private  TextView horizontal_item_text;

        public ItemViewHolder(View itemView) {
            super(itemView);
            horizontal_item_text = (TextView) itemView.findViewById(R.id.horizontal_item_text);
        }
    }

}
