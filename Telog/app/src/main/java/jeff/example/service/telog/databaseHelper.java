package jeff.example.service.telog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;


public class databaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "TELOG";
    public static final String TABLE_NAME = "TELOGNEW";
    public static final String QUANTITYA = "QUANTITYA";
    public static final String QUANTITYB = "QUANTITYB";
    public static final String QUANTITYC = "QUANTITYC";
    public static final String QUANTITYD = "QUANTITYD";
    public static final String QUANTITYE = "QUANTITYE";
    public static final String DATES = "DATES";

    public databaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //3.1 Category table create query

        db.execSQL("create table " + TABLE_NAME + "(QUANTITYA TEXT, QUANTITYB TEXT, QUANTITYC TEXT, QUANTITYD TEXT, QUANTITYE TEXT, DATES TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
//5. Method to insert data into table

    /**
     * Inserting new label into table
     */
    public boolean insertData(String QA, String QB, String QC, String QD, String QE, String DT) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(QUANTITYA,QA );//column name, column value
        values.put(QUANTITYB,QB);//column name, column value
        values.put(QUANTITYC,QC);//column name, column value
        values.put(QUANTITYD,QD);//column name, column value
        values.put(QUANTITYE,QE);//column name, column value
        values.put(DATES,DT);//column name, column value

        long result = db.insert(TABLE_NAME,null, values);
        if (result == -1)
            return false;
        else
            return true;

    }

    public Cursor getAllData(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res =  db.rawQuery("select * from "+ TABLE_NAME,null);
        return res;

    }


}