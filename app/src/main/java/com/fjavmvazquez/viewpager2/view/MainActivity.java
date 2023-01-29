package com.fjavmvazquez.viewpager2.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.fjavmvazquez.viewpager2.fragment.MiFragment;
import com.fjavmvazquez.viewpager2.fragment.NotasFragment;
import com.fjavmvazquez.viewpager2.fragment.NuevaNotaFragment;
import com.fjavmvazquez.viewpager2.R;
import com.fjavmvazquez.viewpager2.fragment.NotasRecientesFragment;
import com.fjavmvazquez.viewpager2.util.ZoomOutPageTransformer;
import com.fjavmvazquez.viewpager2.adapter.AdapterFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    //Control pager, permite manejar la animación y permite deslizar de manera horizontal
    //Para pazar a la siguiente ventana
    private ViewPager2 mViewPager2;
    //Page adapter, este provee las paginas que se mostraran en el control pager
    private FragmentStateAdapter mPageAdapter;
    private TabLayout mTabLayout;
    private final int ICON = R.drawable.ic_action_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager2 = findViewById(R.id.pager);
        mTabLayout = findViewById(R.id.tab_layout);
        //Creamos las intancias de pager y el adaptador
        mPageAdapter = new AdapterFragment(getSupportFragmentManager(),getLifecycle(),loadFragment());
        mViewPager2.setAdapter(mPageAdapter);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(mTabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy(){
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Notas recientes");
                        break;
                    case 1:
                        tab.setIcon(ICON);
                        break;
                    case 2:
                        tab.setText("Notas");
                        break;
                    default:
                        break;
                }
            }
        });
        tabLayoutMediator.attach();
        mViewPager2.setPageTransformer(new ZoomOutPageTransformer());
    }

    @Override
    public void onBackPressed() {

        if(mViewPager2.getCurrentItem() == 0){
            super.onBackPressed();
        }
        else {
            mViewPager2.setCurrentItem(mViewPager2.getCurrentItem() - 1);
        }
    }

    private ArrayList<Fragment> loadFragment(){
        ArrayList<Fragment> mListAdapter = new ArrayList<>();
        mListAdapter.add(new NotasRecientesFragment());
        mListAdapter.add(new NuevaNotaFragment());
        mListAdapter.add(new NotasFragment());
        mListAdapter.add(new MiFragment());
        return mListAdapter;
    }


}