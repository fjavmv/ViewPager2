package com.fjavmvazquez.viewpager2.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fjavmvazquez.viewpager2.R;

public class MiFragment extends Fragment {
    private TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View miVista = inflater.inflate(R.layout.fragment_mi, container, false);
        textView = miVista.findViewById(R.id.txtmi);
        return miVista;
    }
}

