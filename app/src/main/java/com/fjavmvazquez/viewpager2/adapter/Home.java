package com.fjavmvazquez.viewpager2.adapter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fjavmvazquez.viewpager2.R;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;

public class Home extends Fragment {
    private CompactCalendarView compactCalendarView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        compactCalendarView = view.findViewById(R.id.compactcalendar_view);



        return view;
    }
}