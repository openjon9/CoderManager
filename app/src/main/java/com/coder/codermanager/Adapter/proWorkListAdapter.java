package com.coder.codermanager.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.coder.codermanager.Data.proWorkData;
import com.coder.codermanager.R;

import java.util.List;

/**
 * Created by Rey on 2018/9/11.
 */

public class proWorkListAdapter extends RecyclerView.Adapter<proWorkListAdapter.ViewHolder> {


    private Context context;
    private List<proWorkData> mData;
    private AlertDialog mdialog;

    public proWorkListAdapter(Context context, List<proWorkData> mData) {
        this.context = context;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.proworkitem_1, parent, false);
        proWorkListAdapter.ViewHolder vh = new proWorkListAdapter.ViewHolder(mView); //layout設定給ViewHolder

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

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {


            @Override
            public boolean onLongClick(View view) {
                View mview = LayoutInflater.from(context).inflate(R.layout.prowork_dialog_1, null);
                EditText ed_name = (EditText) mview.findViewById(R.id.ed_name);
                EditText ed_time = (EditText) mview.findViewById(R.id.ed_time);
                EditText ed_write = (EditText) mview.findViewById(R.id.ed_write);
                Button btn_yes = (Button) mview.findViewById(R.id.btn_yes);
                Button btn_no = (Button) mview.findViewById(R.id.btn_no);


                mdialog = new AlertDialog.Builder(context)
                        .setView(mview)
                        // .setCancelable(false)
                        .show();

                btn_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mdialog.dismiss();
                    }
                });

                btn_no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mdialog.dismiss();
                    }
                });

                return true;
            }


//                View popupView = LayoutInflater.from(context).inflate(R.layout.workrecordpopview,null,false);
//                popupView.findViewById(R.id.text);
//
//                PopupWindow popupWindow = new PopupWindow(popupView,800,800,true);
//                popupWindow.setBackgroundDrawable(new ColorDrawable(0x4e000000));
//                popupWindow.showAtLocation(popupView,Gravity.CENTER,0,0);



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
