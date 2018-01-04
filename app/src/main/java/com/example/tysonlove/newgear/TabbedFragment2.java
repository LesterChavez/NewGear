package com.example.tysonlove.newgear;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by TysonLove on 1/4/2018.
 */

public class TabbedFragment2 extends android.support.v4.app.Fragment {
    private static final String TAG = "TabbedFragment2";
    private Button btnTest2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabbed2, container, false);
        btnTest2 = (Button) view.findViewById(R.id.btnTest);
        btnTest2.setOnClickListener((View.OnClickListener) view);


        return view;

        };


    }

