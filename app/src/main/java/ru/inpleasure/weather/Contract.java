package ru.inpleasure.weather;

import android.graphics.Canvas;
import android.graphics.Bitmap;
import android.os.Looper;
import android.location.Location;
import android.content.Context;

import java.util.List;

import ru.inpleasure.weather.model.dbo.Weather;
import ru.inpleasure.weather.api.dto.WeatherDto;

public interface Contract
{
    interface Api
    {
        WeatherDto getWeather(Location location);
    }
    
    interface LocationService
    {
        Location getLocation();
        String getLatitude();
        String getLongitude();
    }
    
    interface Model
    {
        List<Weather> getWeather();
        Weather getLastWeather();
        void addWeather(Weather weather);
    }
    
    interface Presenter
    {
        void onRefreshButtonClick();
        void initialize();
        void onHistoryButtonClick();
        void draw();
        void onLocationReceived(Location location);
        void onLocationError();
        Context getContext();
        void onDestroy();
    }
    
    interface View
    {
        Context getContext();
        void showWeather(Weather weather);
        android.view.View getDrawableView();
        int getWidth();
        int getHeight();
        void draw();
        Canvas getCanvas();
    }

    interface Drawer
    {
        Bitmap drawDots(List<Weather> weatherList);
        Bitmap drawWeatherTwo(List<Weather> weatherList);
    }
}
