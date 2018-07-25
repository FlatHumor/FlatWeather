package ru.inpleasure.weather;

import android.os.Bundle;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.location.Location;

public class Locator implements LocationListener
{
    private LocationManager locationManager;
    
    public Locator() {
        
    }
    
    @Override
    public void onLocationChanged(Location location)
    {
        
    }
    
    @Override
    public void onProviderEnabled(String provider) { }
    
    @Override
    public void onProviderDisabled(String provider) { }
    
    @Override
    public void onStatusChanged(String s, int i, Bundle b) { }
}
