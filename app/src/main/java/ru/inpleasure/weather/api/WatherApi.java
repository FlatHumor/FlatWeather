package ru.inpleasure.weather.api;

import ru.inpleasure.weather.Contract;
import ru.inpleasure.weather.api.dto.WeatherDto;

public class WatherApi
    implements Contract.Api
{
    public static final String BASE_API = "https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s";
    
    public WeatherDto getWeather() {
        return null;
    }
}
