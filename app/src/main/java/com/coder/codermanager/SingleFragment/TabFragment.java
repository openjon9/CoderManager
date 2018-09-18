package com.coder.codermanager.SingleFragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment extends Fragment {

    private Context context;
    private String text; //Fragment的显示内容

    public TabFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public TabFragment(Context context, String text) {
        this.context = context;
        this.text = text;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(context);
        textView.setText(text);
        textView.setTextSize(30);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

}
