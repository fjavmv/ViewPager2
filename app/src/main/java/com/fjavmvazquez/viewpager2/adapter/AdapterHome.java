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
import com.fjavmvazquez.viewpager2.datamodel.DataModelHome;

import java.util.ArrayList;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolderDatosHome> {

    ArrayList<DataModelHome> mDataModelHome;
    DataModelHome home;
    public AdapterHome(ArrayList<DataModelHome> dataModelHOme){
        mDataModelHome = dataModelHOme;
    }



    @NonNull
    @Override
    public AdapterHome.ViewHolderDatosHome onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_presupuesto,null,false);
        return  new AdapterHome.ViewHolderDatosHome(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHome.ViewHolderDatosHome holder, int position) {
        //Establece la comunicación entre el adaptador y ViewHolderDatosHome
        holder.asignarDatos(mDataModelHome.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataModelHome.size();
    }

    public class ViewHolderDatosHome extends RecyclerView.ViewHolder {
        TextView mTextViewTitulo;
        TextView mTextViewMonto;
        ImageView mImageViewELiminar;
        CardView mCardViewListener;

        public ViewHolderDatosHome(@NonNull View itemView) {
            super(itemView);
            inicializaComponentes(itemView);

            mCardViewListener.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   // Context context = view.getContext();
                   // Intent intent = new Intent(view.getContext(), MainActivity.class);
                   // context.startActivity(intent);
                    Toast.makeText(view.getContext(),"hhhdhdhdhd",Toast.LENGTH_SHORT).show();
                }
            });

        }

        public void inicializaComponentes(View itemView){
            mTextViewTitulo = itemView.findViewById(R.id.txtTituloHome);
            mImageViewELiminar = itemView.findViewById(R.id.imgEliminar);
            mTextViewMonto = itemView.findViewById(R.id.txtMonto);
            mCardViewListener = itemView.findViewById(R.id.cardViewListenerHome);
        }

        public void asignarDatos(DataModelHome dataModelHOme) {
            mTextViewTitulo.setText(dataModelHOme.getTitulo());
            mTextViewMonto.setText(String.valueOf(dataModelHOme.getMonto()));
        }

    }



}
