package com.example.bijay.myapp_names;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by Bijay on 12-05-2016.
 */
public class ActSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final int database_version = 1;
    private static final String database_name = "dbNames";
    private static final String table_name = "tbNames";
    private static final String name_id = "id";
    private static final String name_fname = "fname";
    private static final String name_lname = "lname";

    private static final String [] columns = {name_id,name_fname,name_lname};

    public ActSQLiteOpenHelper(Context context){super(context, database_name, null, database_version);}

    @Override
    public void onCreate(SQLiteDatabase db){

        String create_names_table = "CREATE TABLE " + table_name + " ( " + name_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + name_fname +" TEXT, " + name_lname +  " TEXT )";
        db.execSQL(create_names_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void createName(Name name){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(name_fname,name.getFname());
        values.put(name_lname,name.getLname());

        db.insert(table_name,null,values);
        db.close();
    }

    public List<Name> getAllNames(){
        List<Name> names = new LinkedList<Name>();

        String query = "Select * from " + table_name;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Name name = null;
        if (cursor.moveToFirst()){
            do {
                name = new Name();
                name.setId(Integer.parseInt(cursor.getString(0)));
                name.setFname(cursor.getString(1));
                name.setLname(cursor.getString(2));
                names.add(name);
            } while (cursor.moveToNext());
        }
        db.close();
        return names;
    }
}