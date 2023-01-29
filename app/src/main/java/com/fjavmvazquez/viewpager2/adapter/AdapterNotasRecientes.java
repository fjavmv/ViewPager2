package com.fjavmvazquez.viewpager2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.fjavmvazquez.viewpager2.R;
import com.fjavmvazquez.viewpager2.datamodel.DataModelNotas;

import java.util.ArrayList;

public class AdapterNotasRecientes extends RecyclerView.Adapter<AdapterNotasRecientes.ViewHolderDatosRecientes> {

    ArrayList<DataModelNotas> mDataModelNotas;


    public AdapterNotasRecientes(ArrayList<DataModelNotas> dataModelNotas) {
        this.mDataModelNotas = dataModelNotas;
    }

    @NonNull
    @Override
    public AdapterNotasRecientes.ViewHolderDatosRecientes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_recientes,null,false);
        return new AdapterNotasRecientes.ViewHolderDatosRecientes(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterNotasRecientes.ViewHolderDatosRecientes holder, int position) {
        //Establece la comunicación entre el adaptador y ViewHolderDatos
        //holder.asignarDatos(articulos.get(position));
        holder.asignarDatos(mDataModelNotas.get(position));
    }

    @Override
    public int getItemCount() {
        //retorna el tamaño de la lista
        return mDataModelNotas.size();
    }

    public class ViewHolderDatosRecientes extends RecyclerView.ViewHolder {
        TextView mTextViewTitulo;
        TextView mTextViewFecha;
        ImageView mImageViewCompartir;
        CardView mCardViewListener;

        public ViewHolderDatosRecientes(@NonNull View itemView) {
            super(itemView);
            inicializaComponentes(itemView);
            mCardViewListener.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),mTextViewTitulo.getText(),Toast.LENGTH_SHORT).show();
                }
            });

            mImageViewCompartir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),"Compartir",Toast.LENGTH_SHORT).show();
                }
            });


        }

        public void inicializaComponentes(View itemView){
            mTextViewTitulo = itemView.findViewById(R.id.txtTitulo);
            mImageViewCompartir = itemView.findViewById(R.id.imgCompartir);
            mTextViewFecha = itemView.findViewById(R.id.txtFecha);
            mCardViewListener = itemView.findViewById(R.id.cardViewListener);
        }

        public void asignarDatos(DataModelNotas dataModelNotas) {
            mTextViewTitulo.setText(dataModelNotas.getTitulo());
            mTextViewFecha.setText(dataModelNotas.getFecha());
        }
    }
}

