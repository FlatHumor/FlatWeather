package ru.inpleasure.weather.api;

import android.content.Context;
import android.location.Location;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ru.inpleasure.weather.Contract;
import ru.inpleasure.weather.api.dto.WeatherDto;

public class WeatherApi
    implements Contract.Api
{
    public static final String BASE_API = "https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s";
    private Context context;

    public WeatherApi(Context context) {
        this.context = context;
    }
    
    private String getResponse(String url)
    {
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Response response = httpClient.newCall(request).execute();
            return response.body().string();
        }
        catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public WeatherDto getWeather(Location location) {
        double latitude = roundBySecondSign(location.getLatitude());
        double longitude = roundBySecondSign(location.getLongitude());

    }

    private static double roundBySecondSign(double value)
    {
        double precision = 100.0d;
        double multiplicatedValue = value * precision;
        int roundedValue = (int) Math.round(multiplicatedValue);
        return (double) roundedValue / precision;
    }
}
