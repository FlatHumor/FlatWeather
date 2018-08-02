package ru.inpleasure.weather.model.dbo;

import ru.inpleasure.weather.model.DbField;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
 
public class Weather
{
    @DbField("id integer primary key autoincrement")
    private Integer id;
    
    @DbField("longitude real")
    private Double longitude;
    
    @DbField("latitude real")
    private Double latitude;
    
    @DbField("country text")
    private String country;
    
    @DbField("sunrise integer")
    private Long sunrise;
    
    @DbField("sunset integer")
    private Long sunset;
    
    @DbField("weatherId integer")
    private Integer weatherId;
    
    @DbField("weatherMain text")
    private String weatherMain;
    
    @DbField("weatherDescription text")
    private String weatherDescription;
    
    @DbField("weatherIcon text")
    private String weatherIcon;
    
    @DbField("mainTemperature real")
    private Double mainTemperature;
    
    @DbField("mainHumidity real")
    private Integer mainHumidity;
    
    @DbField("mainPressure real")
    private Double mainPressure;
    
    @DbField("mainMinTemperature real")
    private Double mainMinTemperature;
    
    @DbField("mainMaxTemperature real")
    private Double mainMaxTemperature;

    @DbField("mainSeaLevel real")
    private Double mainSeaLevel;

    @DbField("mainGroundLevel real")
    private Double mainGroundLevel;
    
    @DbField("windSpeed real")
    private Double windSpeed;
    
    @DbField("windDegrees real")
    private Double windDegrees;
    
    @DbField("rain3h real")
    private Double rain3h;
    
    @DbField("cloudsAll real")
    private Integer cloudsAll;
    
    @DbField("timestamp integer")
    private Long timestamp;
    
    @DbField("systemId integer")
    private Long systemId;
    
    @DbField("cityName text")
    private String cityName;
    
    @DbField("systemCode integer")
    private Integer systemCode;
 
    public Integer getId() {
       return this.id;
    }
 
    public void setId(Integer value) {
       this.id = value;
    }
 
    public Double getLongitude() {
       return this.longitude;
    }
 
    public void setLongitude(Double value) {
       this.longitude = value;
    }
 
    public Double getLatitude() {
       return this.latitude;
    }
 
    public void setLatitude(Double value) {
       this.latitude = value;
    }
 
    public String getCountry() {
       return this.country;
    }
 
    public void setCountry(String value) {
       this.country = value;
    }
 
    public Long getSunrise() {
       return this.sunrise;
    }
 
    public void setSunrise(Long value) {
       this.sunrise = value;
    }
 
    public Long getSunset() {
       return this.sunset;
    }
 
    public void setSunset(Long value) {
       this.sunset = value;
    }
 
    public Integer getWeatherId() {
       return this.weatherId;
    }
 
    public void setWeatherId(Integer value) {
       this.weatherId = value;
    }
 
    public String getWeatherMain() {
       return this.weatherMain;
    }
 
    public void setWeatherMain(String value) {
       this.weatherMain = value;
    }
 
    public String getWeatherDescription() {
       return this.weatherDescription;
    }
 
    public void setWeatherDescription(String value) {
       this.weatherDescription = value;
    }
 
    public String getWeatherIcon() {
       return this.weatherIcon;
    }

    public void setWeatherIcon(String value) {
       this.weatherIcon = value;
    }
 
    public Double getMainTemperature() {
       return this.mainTemperature;
    }
 
    public void setMainTemperature(Double value) {
       this.mainTemperature = value;
    }
 
    public Integer getMainHumidity() {
       return this.mainHumidity;
    }
 
    public void setMainHumidity(Integer value) {
       this.mainHumidity = value;
    }
 
    public Double getMainPressure() {
       return this.mainPressure;
    }
 
    public void setMainPressure(Double value) {
       this.mainPressure = value;
    }
 
    public Double getMainMinTemperature() {
       return this.mainMinTemperature;
    }
 
    public void setMainMinTemperature(Double value) {
       this.mainMinTemperature = value;
    }
 
    public Double getMainMaxTemperature() {
       return this.mainMaxTemperature;
    }
 
    public void setMainMaxTemperature(Double value) {
       this.mainMaxTemperature = value;
    }

    public Double getMainSeaLevel() {
        return mainSeaLevel;
    }

    public void setMainSeaLevel(Double mainSeaLevel) {
        this.mainSeaLevel = mainSeaLevel;
    }

    public Double getMainGroundLevel() {
        return mainGroundLevel;
    }

    public void setMainGroundLevel(Double mainGroundLevel) {
        this.mainGroundLevel = mainGroundLevel;
    }
 
    public Double getWindSpeed() {
       return this.windSpeed;
    }
 
    public void setWindSpeed(Double value) {
       this.windSpeed = value;
    }
 
    public Double getWindDegrees() {
       return this.windDegrees;
    }
 
    public void setWindDegrees(Double value) {
       this.windDegrees = value;
    }
 
    public Double getRain3h() {
       return this.rain3h;
    }
 
    public void setRain3h(Double value) {
       this.rain3h = value;
    }
 
    public Integer getCloudsAll() {
       return this.cloudsAll;
    }
 
    public void setCloudsAll(Integer value) {
       this.cloudsAll = value;
    }
 
    public Long getTimestamp() {
       return this.timestamp;
    }
 
    public void setTimestamp(Long value) {
       this.timestamp = value;
    }
 
    public Long getSystemId() {
       return this.systemId;
    }
 
    public void setSystemId(Long value) {
       this.systemId = value;
    }
 
    public String getCityName() {
       return this.cityName;
    }
 
    public void setCityName(String value) {
       this.cityName = value;
    }
 
    public Integer getSystemCode() {
       return this.systemCode;
    }
 
    public void setSystemCode(Integer value) {
       this.systemCode = value;
    }
    
    public String getSunriseString() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis(sunrise * 1000);
        return sdf.format(calendar.getTime());
    }
    
    public String getRoundedTemperature() {
        long roundedTemperature = Math.round(mainTemperature);
        return String.format("%s°", roundedTemperature);
    }
    
    public String getMeasureTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        calendar.setTimeInMillis(timestamp * 1000);
        return sdf.format(calendar.getTime());
    }
}
