package com.example.simmproviders.p;
import android.provider.BaseColumns;

public interface Constants extends BaseColumns {
	
	public static final String AUTHORITY =
            "com.example.simmproviders.p";
    public static final String SIMPLE_AUTHORITY =
            "com.example.simmproviders.p";
    public static final String DEFAULT_SORT_ORDER = "especialidade";
    
    public static final String ESPECIALIDADE = "especialidade";
    public static final String TABLE_NAME_ESPECIALIDADE = "especialidade";
    public static final String ESPECIALIDADE_NAME = "especialidade";
    
	/**DATABASE*/
	public static final String DATABASE_NAME = "SimmDB.db";
	public static final int DATABASE_VERSION = 6;
	/**AREA/ESPECIALIDADE*/
	public static final String TABLE_NAME_AREA = "area";
	public static final String NAME_AREA = "nome_area";
	public static final String ID_AREA = "id_area";
	

	public static final String TAG_E = "Erro:TSD";
	public static final String TAG_A = "ColecaoArea";
	public static final String TAG_D = "ColecaoDoenca";
	public static final String TAG_AN = "Anamnese";
	public static final String TAG_EC = "Complementar";
	public static final String TAG_DI = "Diagnostico";
	public static final String TAG_TR = "Tratamento";
	

	
}