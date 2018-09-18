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
import com.coder.codermanager.Activity.Pro.proProjectActivity;
import com.coder.codermanager.Data.clientData;
import com.coder.codermanager.R;

import java.util.List;

/**
 * Created by Rey on 2018/9/13.
 */

public class clentListAdapter extends RecyclerView.Adapter<clentListAdapter.ViewHolder> {

    private Context context;
    private List<clientData> mData;

    public clentListAdapter(Context context, List<clientData> mData) {
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
        holder.client_id.setText(mData.get(position).getId());
        holder.client_name.setText(mData.get(position).getName());
        holder.client_proNumber.setText(mData.get(position).getProNumber());
        holder.client_iogo.setImageResource(R.drawable.ic_android);


        if (mData.size() - 1 == position) {
            holder.line.setVisibility(View.GONE);
        } else {
            holder.line.setVisibility(View.VISIBLE);
        }

        holder.client_proNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(context,proProjectActivity.class); //帶入單一客戶的傳案數量 到專案頁面
                context.startActivity(intent);
               // Toast.makeText(context, "123", Toast.LENGTH_SHORT).show();
            }
        });


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
        private TextView client_name;
        private ImageView client_iogo;
        private TextView client_id;

        private TextView client_proNumber;

        public ViewHolder(View itemView) {
            super(itemView);



            client_id = (TextView) itemView.findViewById(R.id.client_id);
            client_name = (TextView) itemView.findViewById(R.id.client_name);
            client_iogo = (ImageView) itemView.findViewById(R.id.client_iogo);
            client_proNumber = (TextView) itemView.findViewById(R.id.client_proNumber);


            line = (TextView) itemView.findViewById(R.id.line);


        }
    }

}
