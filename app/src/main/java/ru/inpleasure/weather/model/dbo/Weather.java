package ru.inpleasure.weather.model.dbo;

import ru.inpleasure.weather.model.DbField;
 
public class Weather
{
    @DbField("id integer primary key autoincrement")
    Integer id;
    
    @DbField("longitude real")
    Double longitute;
    
    @DbField("latitude real")
    Double latitude;
    
    @DbField("country text")
    String country;
    
    @DbField("sunrise integer")
    Long sunrise;
    
    @DbField("sunset integer")
    Long sunset;
    
    @DbField("weatherId integer")
    Integer weatherId;
    
    @DbField("weatherMain text")
    String weatherMain;
    
    @DbField("weatherDescription text")
    String weatherDescription;
    
    @DbField("weatherIcon text")
    String weatherIcon;
    
    @DbField("mainTemperature real")
    Double mainTemperature;
    
    @DbField("mainHumidity real")
    Double mainHumidity;
    
    @DbField("mainPressure real")
    Double mainPressure;
    
    @DbField("mainMinTemperature real")
    Double mainMinTemperature;
    
    @DbField("mainMaxTemperature real")
    Double mainMaxTemperature;
    
    @DbField("windSpeed real")
    Double windSpeed;
    
    @DbField("windDegrees real")
    Double windDegrees;
    
    @DbField("rain3h real")
    Double rain3h;
    
    @DbField("cloudsAll real")
    Double cloudsAll;
    
    @DbField("timestamp integer")
    Long timestamp;
    
    @DbField("systemId integer")
    Long systemId;
    
    @DbField("cityName text")
    String cityName;
    
    @DbField("systemCode integer")
    Integer systemCode;
 
    public Integer getId() {
       return this.id;
    }
 
    public void setId(Integer value) {
       this.id = value;
    }
 
    public Double getLongitute() {
       return this.longitute;
    }
 
    public void setLongitute(Double value) {
       this.longitute = value;
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
 
    public Double getMainHumidity() {
       return this.mainHumidity;
    }
 
    public void setMainHumidity(Double value) {
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
 
    public Double getCloudsAll() {
       return this.cloudsAll;
    }
 
    public void setCloudsAll(Double value) {
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
}
