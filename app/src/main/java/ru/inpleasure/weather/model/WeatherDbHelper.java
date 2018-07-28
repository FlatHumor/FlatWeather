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
import ru.inpleasure.weather.log.NicroLog;

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
        StringBuilder scriptBuilder = new StringBuilder();
        List<String> scriptParts = new ArrayList<>();
        scriptBuilder.append(String.format("create table %s (", Weather.class.getSimpleName()));
        for (Field field : Weather.class.getFields()) {
            if (field.isAnnotationPresent(DbField.class))
                scriptParts.add(field.getAnnotation(DbField.class).value());
        }
        String script = TextUtils.join(", ", scriptParts);
        scriptBuilder.append(script);
        scriptBuilder.append(")");
        database.execSQL(scriptBuilder.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase p1, int p2, int p3)
    {
        // TODO: Implement this method
    }
}
