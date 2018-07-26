package ru.inpleasure.weather.model;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;

public class WeatherDbHelper extends SQLiteOpenHelper
{
    private static final String DB_NAME = "weather.db";
    private Context context;
    
    public WeatherDbHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }
    
    @Override
    public void onCreate(SQLiteDatabase database)
    {
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase p1, int p2, int p3)
    {
        // TODO: Implement this method
    }
}
