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

import com.coder.codermanager.Data.contactPersonData;
import com.coder.codermanager.R;
import com.coder.codermanager.Activity.Client.clientContactPersonClickActivity;

import java.util.List;

/**
 * Created by Rey on 2018/9/13.
 */

public class contactPersonListAdapter extends RecyclerView.Adapter<contactPersonListAdapter.ViewHolder> {

    private Context context;
    private List<contactPersonData> mData;

    public contactPersonListAdapter(Context context, List<contactPersonData> mData) {
        this.context = context;
        this.mData = mData;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_person_item_1, parent, false);
        contactPersonListAdapter.ViewHolder vh = new contactPersonListAdapter.ViewHolder(mView); //layout設定給ViewHolder

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.contact_person_id.setText(mData.get(position).getId());
        holder.contact_person_name.setText(mData.get(position).getName());
        holder.contact_person_company.setText(mData.get(position).getCompany());
        holder.contact_person_account.setText(mData.get(position).getAccount());
        holder.contact_person_logo.setImageResource(R.drawable.ic_android);


        if (mData.size() - 1 == position) {
            holder.line.setVisibility(View.GONE);
        } else {
            holder.line.setVisibility(View.VISIBLE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, clientContactPersonClickActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView contact_person_id;
        private TextView line;
        private TextView contact_person_company;
        private TextView contact_person_account;
        private TextView contact_person_name;

        private ImageView contact_person_logo;

        public ViewHolder(View itemView) {
            super(itemView);

            contact_person_id = (TextView) itemView.findViewById(R.id.contact_person_id);
            contact_person_company = (TextView) itemView.findViewById(R.id.contact_person_company);
            contact_person_name = (TextView) itemView.findViewById(R.id.contact_person_name);
            contact_person_account = (TextView) itemView.findViewById(R.id.contact_person_account);
            contact_person_logo = (ImageView) itemView.findViewById(R.id.contact_person_logo);

            line = (TextView) itemView.findViewById(R.id.line);


        }
    }

}
