package ru.inpleasure.weather;

import android.os.Looper;
import android.location.Location;
import android.content.Context;

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
        Weather getWeather();
        void addWeather();
    }
    
    interface Presenter
    {
        void onRefreshButtonClick();
        void onHistoryButtonClick();
        void onLocationReceived(Location location);
        void onLocationError();
        Context getContext();
        void onDestroy();
    }
    
    interface View
    {
        Context getContext();
        void showWeatherIcon();
        void showText(String text);
    }
}
