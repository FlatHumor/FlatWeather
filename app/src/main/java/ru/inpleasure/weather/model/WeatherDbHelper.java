package ru.inpleasure.weather.model;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Field;

import ru.inpleasure.weather.model.dbo.Weather;

public class WeatherDbHelper extends SQLiteOpenHelper
{
    private static final String DB_NAME = "weather.db";
    
    public WeatherDbHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }
    
    // i have no idea, what reflective way of building create table script is not working
    // at this time o_0
    public void __onCreate(SQLiteDatabase database)
    {
        StringBuilder scriptBuilder = new StringBuilder();
        List<String> scriptParts = new ArrayList<>();
        scriptBuilder.append(String.format("create table %s (", Weather.class.getSimpleName()));
        for (Field field : Weather.class.getFields()) {
            if (field.isAnnotationPresent(DbField.class))
                scriptParts.add(field.getAnnotation(DbField.class).value());
        }
        String script = TextUtils.join(", ", scriptParts);
        scriptBuilder.append(script);
        scriptBuilder.append(");");
        database.execSQL(scriptBuilder.toString());
    }

    @Override
    public void onCreate(SQLiteDatabase database)
    {
        database.execSQL("create table Weather (" +
                "id integer primary key autoincrement," +
                "longitude real," +
                "latitude real," +
                "country text," +
                "sunrise integer," +
                "sunset integer," +
                "weatherId integer," +
                "weatherMain text," +
                "weatherDescription text," +
                "weatherIcon text," +
                "mainTemperature real," +
                "mainHumidity real," +
                "mainPressure real," +
                "mainMinTemperature real," +
                "mainMaxTemperature real," +
                "mainSeaLevel real," +
                "mainGroundLevel real," +
                "windSpeed real," +
                "windDegrees real," +
                "rain3h real," +
                "cloudsAll real," +
                "timestamp integer," +
                "systemId integer," +
                "cityName text," +
                "systemCode integer)");
    }



    @Override
    public void onUpgrade(SQLiteDatabase p1, int p2, int p3)
    {
        // TODO: Implement this method
    }
}
