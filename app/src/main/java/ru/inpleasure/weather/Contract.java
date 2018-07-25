package ru.inpleasure.weather;

import ru.inpleasure.weather.model.dbo.Weather;
import ru.inpleasure.weather.api.dto.WeatherDto;

public interface Contract
{
    interface Api
    {
        WeatherDto getWeather();
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
        void onDestroy();
    }
    
    interface View
    {
        void showWeatherIcon();
    }
}
