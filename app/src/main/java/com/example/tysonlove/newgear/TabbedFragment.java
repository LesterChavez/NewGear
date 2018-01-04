package com.example.tysonlove.newgear;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by TysonLove on 1/4/2018.
 */

public class TabbedFragment extends android.support.v4.app.Fragment {
    private static final String TAG = "TabbedFragment";
    private Button btnTest;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tabbed, container, false);
        btnTest = (Button) view.findViewById(R.id.btnTest);
        btnTest.setOnClickListener((View.OnClickListener) view);


        return view;

        }


    }

