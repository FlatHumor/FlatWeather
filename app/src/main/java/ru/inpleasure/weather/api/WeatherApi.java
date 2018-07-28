package ru.inpleasure.weather.api;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ru.inpleasure.weather.Contract;
import ru.inpleasure.weather.MainActivity;
import ru.inpleasure.weather.api.dto.WeatherDto;

public class WeatherApi
    implements Contract.Api
{
    public static final String BASE_API = "https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s";
    public static final String TOKEN = "aadad65a84e4aa420d4e60577e58b3dc";
    private Context context;
    private SharedPreferences preferences;

    public WeatherApi(Context context) {
        this.context = context;
        preferences = context.getSharedPreferences(
                MainActivity.PREFERENCE_FILE, 0);
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
            return null;
        }
    }

    @Override
    public WeatherDto getWeather(Location location) {
        double latitude = roundBySecondSign(location.getLatitude());
        double longitude = roundBySecondSign(location.getLongitude());
        String token = preferences.getString(
                MainActivity.PREFERENCE_KEY_TOKEN, null);
        String weatherUrl = String.format(BASE_API, latitude, longitude, TOKEN);
        Log.d("__WEATHER_URL__", weatherUrl);
        String response = getResponse(weatherUrl);
        if (response == null)
            return null;
        return new Gson().fromJson(response, WeatherDto.class);
    }

    private static double roundBySecondSign(double value)
    {
        double precision = 100.0d;
        double multiplicatedValue = value * precision;
        int roundedValue = (int) Math.round(multiplicatedValue);
        return (double) roundedValue / precision;
    }
}
