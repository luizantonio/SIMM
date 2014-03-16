package com.example.simmproviders.p;

import static android.provider.BaseColumns._ID;
import static com.example.simmproviders.p.Constants.TABLE_NAME_ESPECIALIDADE;
import static com.example.simmproviders.p.Constants.DATABASE_NAME;
import static com.example.simmproviders.p.Constants.DATABASE_VERSION;
import static com.example.simmproviders.p.Constants.NAME_AREA;
import static com.example.simmproviders.p.Constants.TABLE_NAME_AREA;
import static com.example.simmproviders.p.Constants.TAG_A;
import static com.example.simmproviders.p.Constants.TAG_AN;
import static com.example.simmproviders.p.Constants.TAG_D;
import static com.example.simmproviders.p.Constants.TAG_DI;
import static com.example.simmproviders.p.Constants.TAG_TR;
import java.util.HashMap;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.BaseColumns;
import android.text.TextUtils;
import android.util.Log;

public class SIMMProvider extends ContentProvider {
	// uri references all ESPECIALIDADES
    static final String PROVIDER_NAME="com.example.simmproviders.p";
    public static final String URL="content://" + PROVIDER_NAME + "/especialidades";
    public static final Uri CONTENT_URI=Uri.parse(URL);

    public static final String ESPECIALIDADE_NAME = "especialidade";
	private static final int ESPECIALIDADES = 1;
	private static final int ESPECIALIDADE_ID = 2;
	
	private static final UriMatcher sUriMatcher;
	private SQLiteDatabase db;
	private static HashMap<String, String> sEspecialidadesProjectionMap;
	    static {
	    	sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	    	   sUriMatcher.addURI(com.example.simmproviders.p.Constants.AUTHORITY, "especialidades", ESPECIALIDADES);
	    	   sUriMatcher.addURI(com.example.simmproviders.p.Constants.AUTHORITY, "especialidades/#", ESPECIALIDADE_ID);
	        // example projection map, not actually used in this application
	    	sEspecialidadesProjectionMap = new HashMap<String, String>();
	    	sEspecialidadesProjectionMap.put(BaseColumns._ID, BaseColumns._ID);
	    	sEspecialidadesProjectionMap.put(Constants.ESPECIALIDADE, Constants.ESPECIALIDADE_NAME);	
	}

	private static class DataBaseHelper extends SQLiteOpenHelper{

		/** Create a helper object for the Events database */
		public DataBaseHelper(Context ctx) {
		    super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
		}
		
		private final String IDENTIFICADOR = "identificador";
		
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME_ESPECIALIDADE + " ( " + _ID
				    + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
					+ IDENTIFICADOR + " INTEGER, "
					+ ESPECIALIDADE_NAME + " TEXT NOT NULL);");
			
			
			
		}
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w(TAG_A, oldVersion + " to " + newVersion
			          + ", which will destroy all old data");
			db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME_ESPECIALIDADE);	
			
			onCreate(db);
		}
	}

	    	
	
	@Override
	public boolean onCreate() {
		Context context=getContext();
        DataBaseHelper dbHelper=new DataBaseHelper(context);
        /*
           Create a write able database which will trigger its 
           creation if it doesn't already exist.
         */
        db=dbHelper.getWritableDatabase();
        return (db==null)?false:true;
	}

	 @Override
	 public String getType(Uri uri) {
	        switch (sUriMatcher.match(uri)) {
	            case ESPECIALIDADES:
	                return "vnd.android.cursor.dir/vnd.example.simmproviders";//"vnd.android.cursor.dir/vnd.example.especialidades";

	            case ESPECIALIDADE_ID:
	                return "vnd.android.cursor.item/vnd.example.simmproviders";//"vnd.android.cursor.item/vnd.example.especialidades";

	            default:
	                throw new IllegalArgumentException("Unknown especialidade type: " +
	                        uri);
	        }
	    }
	    @Override
	    public Cursor query(Uri uri, String[] projection, String where,
	                        String[] whereArgs, String sortOrder)
	    {
	        // If no sort order is specified use the default
	        String orderBy;
	        if (TextUtils.isEmpty(sortOrder)) {
	            orderBy = Constants.DEFAULT_SORT_ORDER;
	        } else {
	            orderBy = sortOrder;
	        }
	        int match = sUriMatcher.match(uri);
	        Cursor c;
	        switch (match) {
	            case ESPECIALIDADES:
	                // query the database for all especialidades
	                c = db.query(Constants.TABLE_NAME_ESPECIALIDADE, projection,
	                        where, whereArgs,
	                        null, null, orderBy);
	                c.setNotificationUri(getContext().getContentResolver(), CONTENT_URI);
	                break;
	            case ESPECIALIDADE_ID:
	                // query the database for a specific especialidades
	                long especialidadeID = ContentUris.parseId(uri);
	                c = db.query(Constants.TABLE_NAME_ESPECIALIDADE, projection,
	                        BaseColumns._ID + " = " + especialidadeID +
	                                (!TextUtils.isEmpty(where) ?
	                                        " AND (" + where + ')' : ""),
	                        whereArgs, null, null, orderBy);
	                c.setNotificationUri(getContext().getContentResolver(),CONTENT_URI);
	                break;
	            default:
	                throw new IllegalArgumentException("unsupported uri: " + uri);
	        }
	        return c;
	    }

	    @Override
	    public Uri insert(Uri uri, ContentValues initialValues) {
	        // Validate the requested uri
	        if (sUriMatcher.match(uri) != ESPECIALIDADES) {
	            throw new IllegalArgumentException("Unknown URI " + uri);
	        }
	        ContentValues values;
	        if (initialValues != null) {
	            values = new ContentValues(initialValues);
	        } else {
	            values = new ContentValues();
	        }
	        verifyValues(values);
	        // insert the initialValues into a new database row
	       
	        long rowId = db.insert(Constants.TABLE_NAME_ESPECIALIDADE, ESPECIALIDADE_NAME, values);
	        if (rowId > 0) {
	            Uri especialidadeURi = ContentUris.withAppendedId(CONTENT_URI, rowId);
	            getContext().getContentResolver().notifyChange(especialidadeURi, null);
	            return especialidadeURi;
	        }
	        throw new SQLException("Failed to insert row into " + uri);
	    }
	    private void verifyValues(ContentValues values) {
	        // Make sure that the fields are all set
	        if (!values.containsKey(ESPECIALIDADE_NAME)) {
	            Resources r = Resources.getSystem();
	            values.put(ESPECIALIDADE_NAME,
	                    r.getString(android.R.string.untitled));
	        }
	       
	    }

	    @Override
	    public int delete(Uri uri, String where, String[] whereArgs) {
	        int match = sUriMatcher.match(uri);
	        int affected;
	        switch (match) {
	            case ESPECIALIDADES:
	                affected = db.delete(Constants.TABLE_NAME_ESPECIALIDADE,
	                        (!TextUtils.isEmpty(where) ?
	                                " AND (" + where + ')' : ""),
	                        whereArgs);
	                break;
	            case ESPECIALIDADE_ID:
	                long especialidadeId = ContentUris.parseId(uri);
	                affected = db.delete(Constants.TABLE_NAME_ESPECIALIDADE,
	                        BaseColumns._ID + "=" + especialidadeId
	                                + (!TextUtils.isEmpty(where) ?
	                                " AND (" + where + ')' : ""),
	                        whereArgs);
	                break;
	            default:
	                throw new IllegalArgumentException("unknown especialidade element: " +
	                        uri);
	        }
	        getContext().getContentResolver().notifyChange(uri, null);
	        return affected;
	    }

	    @Override
	    public int update(Uri uri, ContentValues values, String where,
	                      String[] whereArgs)
	    {
	        int affected;
	        switch (sUriMatcher.match(uri)) {
	            case ESPECIALIDADES:
	                affected = db.update(Constants.TABLE_NAME_ESPECIALIDADE, values,
	                        where, whereArgs);
	                break;
	            case ESPECIALIDADE_ID:
	                String especialidadeId = uri.getPathSegments().get(1);
	                affected = db.update(Constants.TABLE_NAME_ESPECIALIDADE, values,
	                        BaseColumns._ID + "=" + especialidadeId 
	                                + (!TextUtils.isEmpty(where) ?
	                                " AND (" + where + ')' : ""),
	                        whereArgs);
	                break;
	            default:
	                throw new IllegalArgumentException("Unknown URI " + uri);
	        }
	        getContext().getContentResolver().notifyChange(uri, null);
	        return affected;
	    }   
}


