package com.fjavmvazquez.viewpager2.datamodel;

import com.fjavmvazquez.viewpager2.R;
import com.fjavmvazquez.viewpager2.datamodel.DataModelNotas;

import java.util.ArrayList;

public class DataModelUtil {
   private static ArrayList<DataModelNotas> sMDataModelNotasArrayList;

 public static ArrayList<DataModelNotas> llenar(){
        sMDataModelNotasArrayList = new ArrayList<>();
       sMDataModelNotasArrayList.add(new DataModelNotas(R.drawable.cumple,"Mi cumpleaños","Notas de como estuvo tu cumpleaños etc.....","11/12/2020"));
       sMDataModelNotasArrayList.add(new DataModelNotas(R.drawable.viaje,"Mi Viaje","A un mes de mi viaje por x lugar ................",
               "10/10/2022"));
       sMDataModelNotasArrayList.add(new DataModelNotas(R.drawable.recuerdos,"Buenos recuerdos","Hace unos días encontre unas fotografias que traen buenos recuerdos.......","10/12/2011"));
       sMDataModelNotasArrayList.add(new DataModelNotas(R.drawable.juegos,"Mi jeugo favorito", "Disfruto de jugar este juego desde que estaba en secundaria.............................","27/11/2022"));
 return sMDataModelNotasArrayList;
 }

    public static ArrayList<DataModelNotas> llenarRecientes(){
        sMDataModelNotasArrayList = new ArrayList<>();
        sMDataModelNotasArrayList.add(new DataModelNotas("Hola","11/12/2020"));
        sMDataModelNotasArrayList.add(new DataModelNotas("Saludos", "10/10/2022"));
        sMDataModelNotasArrayList.add(new DataModelNotas("Prueba","10/12/2011"));
        sMDataModelNotasArrayList.add(new DataModelNotas("Mi jeugo favorito","27/11/2022"));
        sMDataModelNotasArrayList.add(new DataModelNotas("Mi cumpleaños","11/12/2020"));
        sMDataModelNotasArrayList.add(new DataModelNotas("Mi Viaje", "10/10/2022"));

        return sMDataModelNotasArrayList;
    }




}
