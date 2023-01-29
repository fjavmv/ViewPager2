package com.fjavmvazquez.viewpager2.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fjavmvazquez.viewpager2.R;
import com.fjavmvazquez.viewpager2.adapter.AdapterNotasRecientes;
import com.fjavmvazquez.viewpager2.datamodel.DataModelUtil;

public class NotasRecientesFragment extends Fragment {

    private RecyclerView mRecyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_recientes, container, false);

        mRecyclerView = rootView.findViewById(R.id.recyclerDatos);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        AdapterNotasRecientes adapterNotasRecientes = new AdapterNotasRecientes(DataModelUtil.llenarRecientes());
        mRecyclerView.setAdapter(adapterNotasRecientes);

        return rootView;
    }
}