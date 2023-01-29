package com.fjavmvazquez.viewpager2.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.fjavmvazquez.viewpager2.R;

import java.util.Calendar;

public class NuevaNotaFragment extends Fragment implements DatePickerDialog.OnDateSetListener {

     private EditText mEditTextTitulo;
     private EditText mEditTextFecha; // campo a enlazar con el DatePicker
     private EditText mEditTextContenido;
     //private Spinner mSpinnerTipoNota;
     private Button mButtonGuardar;
     private Button mButtonCancelar;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_nueva_nota, container, false);

        mEditTextTitulo = rootView.findViewById(R.id.edt_titulo);
        mEditTextFecha = rootView.findViewById(R.id.edt_fecha);
        //mSpinnerTipoNota = rootView.findViewById(R.id.tipo_mensaje);
        mEditTextContenido = rootView.findViewById(R.id.edt_contenido);
        mButtonGuardar = rootView.findViewById(R.id.btn_guardar);
        mButtonCancelar = rootView.findViewById(R.id.btn_cancelar);

        mEditTextFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarCalendario();
            }
        });


        return rootView;
    }

    private void mostrarCalendario(){
        DatePickerDialog  datePickerDialog = new DatePickerDialog(getContext(),R.style.DatePickerStyle, this, Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        String date = month + "/" + dayOfMonth + "/" + year;
        mEditTextFecha.setText(date);
    }
}