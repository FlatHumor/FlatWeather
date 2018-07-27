package ru.inpleasure.weather.presenter;

import android.content.Context;
import android.location.Location;
import ru.inpleasure.weather.Contract;
import ru.inpleasure.weather.Locator;


public class WeatherPresenter
    implements Contract.Presenter
{
    private Context context;
    private Contract.Model model;
    private Contract.View view;
    private Locator locator;
    
    
    public WeatherPresenter(Contract.View view) {
        this.view = view;
        context = view.getContext();
        locator = new Locator(this);
        
    }
    
    @Override
    public Context getContext() {
        return context;
    }
    
    @Override
    public void onDestroy() {
        locator.stop();
    }
    
    @Override
    public void onHistoryButtonClick() {
        
    }
    
    @Override
    public void onRefreshButtonClick() {
        view.showText("getting location...");
        locator.start();
    }
    
    @Override
    public void onLocationReceived(Location location) {
        if (location == null) {
            view.showText("location is unavailable");
            return;
        }
        double lat = location.getLatitude();
        double lon = location.getLongitude();
        String l = String.format("lon: %s, lat: %s", lon, lat);
        view.showText(l);
    }
    
    @Override
    public void onLocationError()
    {
        view.showText("Location Error");
        locator.stop();
    }
}
