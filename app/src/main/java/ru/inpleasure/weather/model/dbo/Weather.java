package ru.inpleasure.weather.model.dbo;
 
public class Weather
{
   Integer id;
   Double longitute;
   Double latitude;
   String country;
   Long sunrise;
   Long sunset;
   Integer weatherId;
   String weatherMain;
   String weatherDescription;
   String weatherIcon;
   Double mainTemperature;
   Double mainHumidity;
   Double mainPressure;
   Double mainMinTemperature;
   Double mainMaxTemperature;
   Double windSpeed;
   Double windDegrees;
   Double rain3h;
   Double cloudsAll;
   Long timestamp;
   Long systemId;
   String cityName;
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
