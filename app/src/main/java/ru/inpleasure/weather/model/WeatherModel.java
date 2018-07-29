package ru.inpleasure.weather.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ru.inpleasure.weather.Contract;
import ru.inpleasure.weather.model.dbo.Weather;

public class WeatherModel implements Contract.Model
{
    private Context context;

    public WeatherModel(Context context) {
        this.context = context;
    }

    @Override
    public List<Weather> getWeather() {
        WeatherDbHelper helper = new WeatherDbHelper(context);
        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor cursor;
        try {
            cursor = database.query(Weather.class.getSimpleName(),
                    null, null, null, null, null, null);
        }
        catch (Exception e) {
            return null;
        }
        if (cursor == null) return null;
        if (!cursor.moveToFirst()) return null;
        List<Weather> weatherList = new ArrayList<>(cursor.getCount());
        do {
            Weather weather = new Weather();
            weather.setId(cursor.getInt(cursor.getColumnIndex("id")));
            weather.setLongitude(cursor.getDouble(cursor.getColumnIndex("longitude")));
            weather.setLatitude(cursor.getDouble(cursor.getColumnIndex("latitude")));
            weather.setCountry(cursor.getString(cursor.getColumnIndex("country")));
            weather.setSunrise(cursor.getLong(cursor.getColumnIndex("sunrise")));
            weather.setSunset(cursor.getLong(cursor.getColumnIndex("sunset")));
            weather.setWeatherId(cursor.getInt(cursor.getColumnIndex("weatherId")));
            weather.setWeatherMain(cursor.getString(cursor.getColumnIndex("weatherMain")));
            weather.setWeatherDescription(cursor.getString(cursor.getColumnIndex("weatherDescription")));
            weather.setWeatherIcon(cursor.getString(cursor.getColumnIndex("weatherIcon")));
            weather.setMainTemperature(cursor.getDouble(cursor.getColumnIndex("mainTemperature")));
            weather.setMainHumidity(cursor.getInt(cursor.getColumnIndex("mainHumidity")));
            weather.setMainPressure(cursor.getDouble(cursor.getColumnIndex("mainPressure")));
            weather.setMainMinTemperature(cursor.getDouble(cursor.getColumnIndex("mainMinTemperature")));
            weather.setMainMaxTemperature(cursor.getDouble(cursor.getColumnIndex("mainMaxTemperature")));
            weather.setMainSeaLevel(cursor.getDouble(cursor.getColumnIndex("mainSeaLevel")));
            weather.setMainGroundLevel(cursor.getDouble(cursor.getColumnIndex("mainGroundLevel")));
            weather.setWindSpeed(cursor.getDouble(cursor.getColumnIndex("windSpeed")));
            weather.setWindDegrees(cursor.getDouble(cursor.getColumnIndex("windDegrees")));
            weather.setRain3h(cursor.getDouble(cursor.getColumnIndex("rain3h")));
            weather.setCloudsAll(cursor.getInt(cursor.getColumnIndex("cloudsAll")));
            weather.setTimestamp(cursor.getLong(cursor.getColumnIndex("timestamp")));
            weather.setSystemId(cursor.getLong(cursor.getColumnIndex("systemId")));
            weather.setCityName(cursor.getString(cursor.getColumnIndex("cityName")));
            weather.setSystemCode(cursor.getInt(cursor.getColumnIndex("systemCode")));
            weatherList.add(weather);
        }
        while (cursor.moveToNext());
        database.close();
        cursor.close();
        helper.close();
        return weatherList;
    }

    @Override
    public void addWeather(Weather weather) {
        ContentValues cv = new ContentValues();
        cv.put("longitude", weather.getLongitude());
        cv.put("latitude", weather.getLatitude());
        cv.put("country", weather.getCountry());
        cv.put("sunrise", weather.getSunrise());
        cv.put("sunset", weather.getSunset());
        cv.put("weatherId", weather.getWeatherId());
        cv.put("weatherMain", weather.getWeatherMain());
        cv.put("weatherDescription", weather.getWeatherDescription());
        cv.put("weatherIcon", weather.getWeatherIcon());
        cv.put("mainTemperature", weather.getMainTemperature());
        cv.put("mainHumidity", weather.getMainHumidity());
        cv.put("mainPressure", weather.getMainPressure());
        cv.put("mainMinTemperature", weather.getMainMinTemperature());
        cv.put("mainMaxTemperature", weather.getMainMaxTemperature());
        cv.put("mainSeaLevel", weather.getMainSeaLevel());
        cv.put("mainGroundLevel", weather.getMainGroundLevel());
        cv.put("windSpeed", weather.getWindSpeed());
        cv.put("windDegrees", weather.getWindDegrees());
        cv.put("rain3h", weather.getRain3h());
        cv.put("cloudsAll", weather.getCloudsAll());
        cv.put("timestamp", weather.getTimestamp());
        cv.put("systemId", weather.getSystemId());
        cv.put("cityName", weather.getCityName());
        cv.put("systemCode", weather.getSystemCode());
        WeatherDbHelper helper = new WeatherDbHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();
        database.insert(Weather.class.getSimpleName(), null, cv);
        database.close();
        helper.close();
    }
}
