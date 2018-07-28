package ru.inpleasure.weather.api;

import ru.inpleasure.weather.Contract;
import ru.inpleasure.weather.api.dto.WeatherDto;

public class WatherApi
    implements Contract.Api
{
    public static final String BASE_API = "https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&appid=%s";
    
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
    
    public WeatherDto getWeather() {
        return null;
    }
}
