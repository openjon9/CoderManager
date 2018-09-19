package com.coder.codermanager.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.coder.codermanager.Activity.Pro.proTodoActivity;
import com.coder.codermanager.Data.homeHomeData;
import com.coder.codermanager.R;

import java.util.List;

/**
 * Created by Rey on 2018/9/7.
 */

public class homeHomeListAdapter extends RecyclerView.Adapter<homeHomeListAdapter.ViewHolder> {

    public static final int TYPE_HEADER = 0;  //说明是带有Header的
    public static final int TYPE_FOOTER = 1;  //说明是带有Footer的
    public static final int TYPE_NORMAL = 2;  //说明是不带有header和footer的


    private Context context;
    private List<homeHomeData> mData;
    private int itemCount = 3;
    private String TAG = "HomeList";

    private View mFooterView;
    private View mHeaderView;
    private int pos;

    public View getmFooterView() {
        return mFooterView;
    }

    public View getmHeaderView() {
        return mHeaderView;
    }

    public void setmFooterView(View mFooterView) {
        this.mFooterView = mFooterView;
        notifyItemInserted(getItemCount() - 1);//放最後面
    }


    public void setmHeaderView(View mHeaderView) {
        this.mHeaderView = mHeaderView;
        notifyItemInserted(0);//放最前面
    }


    public homeHomeListAdapter(Context context, List<homeHomeData> mData) {
        this.context = context;
        this.mData = mData;
    }

    //创建View，如果是HeaderView或者是FooterView，直接在Holder中返回
    @Override
    public int getItemViewType(int position) {

        if (mHeaderView == null && mFooterView == null) {
            return TYPE_NORMAL;
        }
        if (position == 0) {
            return TYPE_HEADER;
        }
//        if (position == getItemCount() - 1) {
//            return TYPE_FOOTER;
//        }

        return TYPE_NORMAL;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (mHeaderView != null && viewType == TYPE_HEADER) {
            return new ViewHolder(mHeaderView);
        }

        if (mFooterView != null && viewType == TYPE_FOOTER) {
            return new ViewHolder(mFooterView);
        }

        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_home_item_1, parent, false);
        return new homeHomeListAdapter.ViewHolder(mView); //layout設定給ViewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //  Log.d(TAG, getItemViewType(position) + "");
        pos = getRealPosition(holder);

        if (getItemViewType(position) == TYPE_NORMAL) {
            holder.timeOutNumber.setText(mData.get(pos).getTimeOutNumber());
            holder.UnNumber.setText(mData.get(pos).getUnNumber());
            holder.proName.setText(mData.get(pos).getProName());

//            if ( getItemCount() == itemCount) {
//
//            } else {
//                holder.line.setVisibility(View.VISIBLE);
//            }

//            if (holder instanceof ViewHolder) {
//                ((ViewHolder) holder).proName.setText(mData.get(position).getProName());
//                ((ViewHolder) holder).UnNumber.setText(mData.get(position).getUnNumber());
//                ((ViewHolder) holder).timeOutNumber.setText(mData.get(position).getTimeOutNumber());
//            }

            holder.linear_UnNumber.setOnClickListener(new View.OnClickListener() { //mHeaderView 沒有這個元件  所以沒辦法統一放Fragment 裡
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, proTodoActivity.class);
                    context.startActivity(intent);
                }
            });

        } else if (getItemViewType(position) == TYPE_HEADER) {
            //  ((ViewHolder) holder).UnDate.setText(mData.get(position).getUnDate());
            holder.UnDate.setText(mData.get(position).getUnDate());

        } else {
            return;
        }


    }

    public int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return mHeaderView == null ? position : position - 1;
    }

    //返回View中Item的个数，这个时候，总的个数应该是ListView中Item的个数加上HeaderView和FooterView
    @Override
    public int getItemCount() {

        return mData.size() + 1;

//        if (mHeaderView == null && mFooterView == null) {
//            if (mData.size() >= 1) {
//                return itemCount;
//            } else {
//                return mData.size();
//            }
//        } else if (mHeaderView == null && mFooterView != null) {
//            if (mData.size() >= 1) {
//                return itemCount;
//            } else {
//                return mData.size() + 1;
//            }
//        } else if (mHeaderView != null && mFooterView == null) {
//            if (mData.size() >= 1) {
//                return itemCount;
//            } else {
//                return mData.size() + 1;
//            }
//        } else {
//            if (mData.size() >= 1) {
//                return itemCount;
//            } else {
//                return mData.size() + 2;
//            }
//        }

    }

    @Override
    public void onViewRecycled(@NonNull ViewHolder holder) { //每次回收都會觸發
        super.onViewRecycled(holder);

    }

    /**
     * 点击后设置Item的数量
     *
     * @param number
     */
    public void addItemNum(int number) {
        itemCount = number;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {  //設定layout的元件

        TextView proName;
        TextView UnNumber;
        TextView timeOutNumber;

        TextView UnDate;

        LinearLayout linear_UnNumber;


        public ViewHolder(View itemView) {
            super(itemView);

            if (itemView == mHeaderView) {
                UnDate = (TextView) itemView.findViewById(R.id.UnDate);
            } else if (itemView == mFooterView) {
                return;
            } else {
                proName = (TextView) itemView.findViewById(R.id.proName);
                UnNumber = (TextView) itemView.findViewById(R.id.UnNumber);
                timeOutNumber = (TextView) itemView.findViewById(R.id.timeOutNumber);
                linear_UnNumber = (LinearLayout) itemView.findViewById(R.id.linear_UnNumber);

            }

        }
    }


}
