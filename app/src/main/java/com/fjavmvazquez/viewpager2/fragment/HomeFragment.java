package com.fjavmvazquez.viewpager2.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fjavmvazquez.viewpager2.R;
import com.fjavmvazquez.viewpager2.adapter.AdapterHome;
import com.fjavmvazquez.viewpager2.datamodel.DataModelUtil;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class HomeFragment extends Fragment {

    private CompactCalendarView compactCalendar;
    private final SimpleDateFormat dateFormatMonth = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
    private RecyclerView recyclerView;
    private TextView textView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        compactCalendar = rootView.findViewById(R.id.calendar);
        recyclerView = rootView.findViewById(R.id.rviewGastos);
        textView =rootView.findViewById(R.id.txtHeader);
        //Adaptador de recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        AdapterHome adapterHome = new AdapterHome(DataModelUtil.llenarHome());
        recyclerView.setAdapter(adapterHome);

        compactCalendar.setUseThreeLetterAbbreviation(true);

        //Event ev1 = new Event(Color.BLUE, 1674928620000L, "uno");
        //EEE-MMM-dd-yyyy HH:mm:ss
        Event ev1 = new Event(Color.RED, fechaALong("30-01-2023"), "Pagar a coppel");

        compactCalendar.addEvent(ev1);

        //Event ev2 = new Event(Color.RED, 1674842220000L, "dos");
        Event ev2 = new Event(Color.rgb(26, 188, 156), fechaALong("31-01-2023"), "Presupuesto del usuario");
        compactCalendar.addEvent(ev2);


        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener(){
            @Override
            public void onDayClick(Date dateClicked) {

                if (dateFormatMonth.format(dateClicked).compareTo(milliADate(ev1.getTimeInMillis()))==0) {
                    Toast.makeText(getContext(), Objects.requireNonNull(ev1.getData()).toString(), Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(getContext(), "No contiene eventos", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                textView.setText(dateFormatMonth.format(firstDayOfNewMonth));
            }
        });

        return  rootView;
    }

    public String milliADate(Long milli){
        // Estableciendo formato
        DateFormat simple = new SimpleDateFormat("dd-MM-yyyy",Locale.getDefault());
        // Creando fecha de milliseconds
        // usando constructor de Date
        Date date = new Date(milli);
        return simple.format(date);
    }
    public Long fechaALong(String fecha){
        SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy",Locale.getDefault());
        Long timeInMillis = null;
        try {
            Date d = f.parse(fecha);
            assert d != null;
            timeInMillis = d.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeInMillis;
    }
}
