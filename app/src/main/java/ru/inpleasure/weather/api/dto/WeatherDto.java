package ru.inpleasure.weather.api.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ru.inpleasure.weather.R;

public class WeatherDto
{
    public static final Map<String, Integer> WEATHER_ICONS;

    static {
        WEATHER_ICONS = new HashMap<>();
        WEATHER_ICONS.put("01d", R.drawable.sunny);
        WEATHER_ICONS.put("01n", R.drawable.sunny);
        WEATHER_ICONS.put("02d", R.drawable.mostly_cloudy);
        WEATHER_ICONS.put("02n", R.drawable.mostly_cloudy);
        WEATHER_ICONS.put("03d", R.drawable.cloudy);
        WEATHER_ICONS.put("03n", R.drawable.cloudy);
        WEATHER_ICONS.put("04d", R.drawable.cloudy);
        WEATHER_ICONS.put("04n", R.drawable.cloudy);
        WEATHER_ICONS.put("09d", R.drawable.drizzle);
        WEATHER_ICONS.put("09n", R.drawable.drizzle);
        WEATHER_ICONS.put("10d", R.drawable.slight_drizzle);
        WEATHER_ICONS.put("10n", R.drawable.slight_drizzle);
        WEATHER_ICONS.put("11d", R.drawable.thunderstorms);
        WEATHER_ICONS.put("11n", R.drawable.thunderstorms);
        WEATHER_ICONS.put("13d", R.drawable.snow);
        WEATHER_ICONS.put("13n", R.drawable.snow);
        WEATHER_ICONS.put("50d", R.drawable.haze);
        WEATHER_ICONS.put("50n", R.drawable.haze);
    }

    @SerializedName("coord")
    @Expose
    private Coord coord;
    @SerializedName("sys")
    @Expose
    private Sys sys;
    @SerializedName("weather")
    @Expose
    private List<Weather> weather = null;
    @SerializedName("main")
    @Expose
    private Main main;
    @SerializedName("wind")
    @Expose
    private Wind wind;
    @SerializedName("rain")
    @Expose
    private Rain rain;
    @SerializedName("clouds")
    @Expose
    private Clouds clouds;
    @SerializedName("dt")
    @Expose
    private Long dt;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cod")
    @Expose
    private Integer cod;

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public class Wind
    {
        @SerializedName("speed")
        @Expose
        private Double speed;
        @SerializedName("deg")
        @Expose
        private Double deg;

        public Double getSpeed() {
            return speed;
        }

        public void setSpeed(Double speed) {
            this.speed = speed;
        }

        public Double getDeg() {
            return deg;
        }

        public void setDeg(Double deg) {
            this.deg = deg;
        }
    }

    public class Clouds
    {
        @SerializedName("all")
        @Expose
        private Integer all;

        public Integer getAll() {
            return all;
        }

        public void setAll(Integer all) {
            this.all = all;
        }

    }

    public class Coord
    {
        @SerializedName("lon")
        @Expose
        private Double lon;
        @SerializedName("lat")
        @Expose
        private Double lat;

        public Double getLon() {
            return lon;
        }

        public void setLon(Double lon) {
            this.lon = lon;
        }

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

    }

    public class Main 
    {
        @SerializedName("temp")
        @Expose
        private Double temp;
        @SerializedName("humidity")
        @Expose
        private Integer humidity;
        @SerializedName("pressure")
        @Expose
        private Double pressure;
        @SerializedName("temp_min")
        @Expose
        private Double tempMin;
        @SerializedName("temp_max")
        @Expose
        private Double tempMax;
        @SerializedName("sea_level")
        @Expose
        private Double seaLevel;
        @SerializedName("grnd_level")
        @Expose
        private Double grndLevel;

        public Double getTemp() {
            return temp;
        }

        public void setTemp(Double temp) {
            this.temp = temp;
        }

        public Integer getHumidity() {
            return humidity;
        }

        public void setHumidity(Integer humidity) {
            this.humidity = humidity;
        }

        public Double getPressure() {
            return pressure;
        }

        public void setPressure(Double pressure) {
            this.pressure = pressure;
        }

        public Double getTempMin() {
            return tempMin;
        }

        public void setTempMin(Double tempMin) {
            this.tempMin = tempMin;
        }

        public Double getTempMax() {
            return tempMax;
        }

        public void setTempMax(Double tempMax) {
            this.tempMax = tempMax;
        }

        public Double getSeaLevel() {
            return seaLevel;
        }

        public void setSeaLevel(Double seaLevel) {
            this.seaLevel = seaLevel;
        }

        public Double getGrndLevel() {
            return grndLevel;
        }

        public void setGrndLevel(Double grndLevel) {
            this.grndLevel = grndLevel;
        }
    }

    public class Rain 
    {
        @SerializedName("3h")
        @Expose
        private Double _3h;

        public Double get3h() {
            return _3h;
        }

        public void set3h(Double _3h) {
            this._3h = _3h;
        }

    }

    public class Sys
    {
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("sunrise")
        @Expose
        private Long sunrise;
        @SerializedName("sunset")
        @Expose
        private Long sunset;
        @SerializedName("message")
        @Expose
        private Double message;

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public Long getSunrise() {
            return sunrise;
        }

        public void setSunrise(Long sunrise) {
            this.sunrise = sunrise;
        }

        public Long getSunset() {
            return sunset;
        }

        public void setSunset(Long sunset) {
            this.sunset = sunset;
        }

        public Double getMessage() {
            return message;
        }

        public void setMessage(Double message) {
            this.message = message;
        }

    }

    public class Weather
    {
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("main")
        @Expose
        private String main;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("icon")
        @Expose
        private String icon;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
