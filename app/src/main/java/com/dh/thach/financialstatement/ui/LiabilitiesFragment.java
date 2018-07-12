package com.dh.thach.financialstatement.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dh.thach.financialstatement.R;


public class LiabilitiesFragment extends Fragment {

    public LiabilitiesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_liabilities,container,false);
        TextView tv = view.findViewById(R.id.tv_textTile);
        tv.setText("Liabilities");
        return view;
    }
}
