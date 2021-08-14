package com.example.uts_10118326_if8;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME ="catatanharian.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "catatanharian";
    public static final String COL_1 = "Tanggal";

    public static final String COL_2 = "Judul";

    public static final String COL_3 = "Kategori";

    public static final String COL_4 = "Isi";

    public Database(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table catatanharian(tanggal text primary key , judul text null, kategori text null, isi text null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);

        onCreate(db);

    }

    public boolean tambahData(String tanggal, String judul, String kategori, String isi) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1,tanggal);

        contentValues.put(COL_2,judul);

        contentValues.put(COL_3,kategori);

        contentValues.put(COL_4,isi);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1)

            return false;

        else

            return true;

    }

    public Cursor tampildata() {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor res = db.rawQuery("select * from catatanharian", null);

        return res;

    }

    public boolean updateData(String tanggal,String judul,String kategori,String isi) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1,tanggal);

        contentValues.put(COL_2,judul);

        contentValues.put(COL_3,kategori);

        contentValues.put(COL_4,isi);

        db.update(TABLE_NAME,contentValues,"TANGGAL = ?",new String[] {tanggal});

        return true;

    }

    public int deleteData (String tanggal) {

        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_NAME, "TANGGAL = ?", new String[] {tanggal});

    }
}

// tanggal pengerjaan : 6 juni 2021
// nim : 10118326
// nama : Syaiful Bahri
// kelas : IF-8