package com.persistence;

import android.provider.BaseColumns;

public interface Constants extends BaseColumns {
	
	public static final String DATABASE_NAME = "SimmDB.db";
	public static final int DATABASE_VERSION = 3;
	public static final String TABLE_NAME_AREA = "area";
	public static final String NAME_AREA = "nome_area";
	public static final String ID_AREA = "id_area";
	
	public static final String TABLE_NAME_DOENCA = "doenca";
	public static final String NAME_DOENCA = "nome_doenca";
	public static final String AREA_ID = "area_id";
	
	public static final String TAG_E = "Erro:TSD";
	public static final String TAG_A = "ColecaoArea";
	public static final String TAG_D = "ColecaoDoenca";
	
}