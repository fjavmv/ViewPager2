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

public class NuevaNotaAdapter extends RecyclerView.Adapter<NuevaNotaAdapter.ViewHolderDatos> {
    ArrayList<DataModelNotas> mDataModelNotas;
    public NuevaNotaAdapter(ArrayList<DataModelNotas> dataModelNotas){
        this.mDataModelNotas = dataModelNotas;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_item_custom,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        //Establece la comunicación entre el adaptador y ViewHolderDatos
        //holder.asignarDatos(articulos.get(position));
        holder.asignarDatos(mDataModelNotas.get(position));
    }

    @Override
    public int getItemCount() {
        //retorna el tamaño de la lista
        return mDataModelNotas.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView mTextViewTitulo;
        TextView mTextViewDescripcion;
        TextView mTextViewFecha;
        ImageView mImageViewFondo;
        ImageView mImageViewFavorito;
        ImageView mImageViewCompartir;
        CardView mCardViewListener;

        public ViewHolderDatos(@NonNull View itemView) {
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

            mImageViewFavorito.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),"Favoritos",Toast.LENGTH_SHORT).show();
                }
            });

        }

        public void inicializaComponentes(View itemView){
            mTextViewTitulo = itemView.findViewById(R.id.txtTitulo);
            mImageViewFondo = itemView.findViewById(R.id.imgvFondo);
            mImageViewFavorito = itemView.findViewById(R.id.imgvFavorito);
            mImageViewCompartir = itemView.findViewById(R.id.imgCompartir);
            mTextViewDescripcion = itemView.findViewById(R.id.txtContenido);
            mTextViewFecha = itemView.findViewById(R.id.txtFecha);
            mCardViewListener = itemView.findViewById(R.id.cardViewListener);
        }

        public void asignarDatos(DataModelNotas dataModelNotas) {
            mImageViewFondo.setImageResource(dataModelNotas.getIdFoto());
            mTextViewTitulo.setText(dataModelNotas.getTitulo());
            mTextViewDescripcion.setText(dataModelNotas.getDescripcion());
            mTextViewFecha.setText(dataModelNotas.getFecha());
        }
    }
}
