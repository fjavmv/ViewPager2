package com.fjavmvazquez.viewpager2.adapter;

import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class AdapterFragment  extends FragmentStateAdapter {
    private ArrayList<Fragment> mFragmentArrayList;
    public AdapterFragment(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, ArrayList<Fragment> fragmentArrayList) {
        super(fragmentManager, lifecycle);
        mFragmentArrayList = fragmentArrayList;
    }

   /* public AdapterFragment(@NonNull FragmentActivity fragmentActivity, ArrayList<Fragment> fragment) {
       super(fragmentActivity);
        mFragmentArrayList = fragment;
    }*/

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return mFragmentArrayList.get(position) ;
    }

    @Override
    public int getItemCount() {
        return mFragmentArrayList.size();
    }


}
