package ru.inpleasure.weather;

import android.os.Bundle;
import android.os.Looper;
import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.location.Location;


public class Locator implements LocationListener
{
    public static final long TIME_INTERVAL = 60 * 3600 * 1000;
    public static final float DISTANCE = 10000f;
    private LocationManager locationManager;
    private Contract.Presenter presenter;
    
    public Locator(Contract.Presenter presenter) {
        this.presenter = presenter;
        locationManager = (LocationManager)presenter.getContext()
            .getSystemService(Context.LOCATION_SERVICE);
    }
    
    @Override
    public void onLocationChanged(Location location) {
        presenter.onLocationReceived(location);
    }
    
    @Override
    public void onProviderEnabled(String provider) {
        
    }
    
    @Override
    public void onProviderDisabled(String provider) { }
    
    @Override
    public void onStatusChanged(String s, int i, Bundle b) { }
    
    public void start()
    {
        if (locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER) != null) {
            presenter.onLocationReceived(locationManager.
                getLastKnownLocation(LocationManager.NETWORK_PROVIDER));
        }
        if (!locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            presenter.onLocationError();
            return;
        }
        locationManager.requestLocationUpdates(
            LocationManager.NETWORK_PROVIDER, TIME_INTERVAL,
            DISTANCE, this);
    }
    
    public void stop() {
        locationManager.removeUpdates(this);
    }
    
    public Location getLocation() {
        return locationManager.getLastKnownLocation(
            LocationManager.NETWORK_PROVIDER);
    }
}
