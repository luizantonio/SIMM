package com.persistence;

import static android.provider.BaseColumns._ID;
import static com.persistence.Constants.AREA_ID;
import static com.persistence.Constants.DATABASE_NAME;
import static com.persistence.Constants.DATABASE_VERSION;
import static com.persistence.Constants.NAME_DOENCA;
import static com.persistence.Constants.TABLE_NAME_AREA;
import static com.persistence.Constants.ID_AREA;
import static com.persistence.Constants.NAME_AREA;
import static com.persistence.Constants.TABLE_NAME_DOENCA;
import static com.persistence.Constants.TAG_A;
import static com.persistence.Constants.TAG_D;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper{

	/** Create a helper object for the Events database */
	public DataBaseHelper(Context ctx) {
	    super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME_AREA + " ( " + _ID
			    + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME_AREA
			    + " TEXT NOT NULL);");
		db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME_DOENCA + " ( " + _ID
			    + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME_DOENCA
			    + " TEXT NOT NULL, "+ AREA_ID + " INTEGER, FOREIGN KEY( "+ AREA_ID +") REFERENCES area("+_ID +"));");
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(TAG_A, oldVersion + " to " + newVersion
		          + ", which will destroy all old data");
		db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME_AREA);
		
		Log.w(TAG_D, oldVersion + " to " + newVersion
		          + ", which will destroy all old data");
		db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME_DOENCA);
		onCreate(db);
	}
}
