package com.fjavmvazquez.viewpager2.model;

public class DbUtilitis {
    protected static final int DATABASE_VERSION = 1;
    protected static final String DATABASE_NAME = "notas_db";
    protected static  final String TABLE_NAME = "tb_notas";
    protected static  final String ID_NOTA = "(id_nota INTEGER PRIMARY KEY AUTOINCREMENT,";
    protected static  final String TITULO_NOTA = "titulo_nota TEXT NOT NULL,";
    protected static  final String FECHA_NOTA = "fecha_nota TEXT NOT NULL,";
    protected static  final String DESCRIPTION_NOTA = "description_nota TEXT NOT NULL,";
    protected static  final String CREATE_AT = "create_at DATE NOT NULL)";

}
