package ru.inpleasure.weather.presenter;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.Process;
import android.os.HandlerThread;

import ru.inpleasure.weather.Contract;
import ru.inpleasure.weather.Locator;


public class WeatherPresenter
    implements Contract.Presenter
{
    private static final String THREAD_ARG = "PRESENTER_THREAD";
    private Context context;
    private Looper looper;
    private HandlerThread thread;
    private Contract.Model model;
    private Contract.View view;
    private Locator locator;
    
    
    public WeatherPresenter(Context context) {
        this.context = context;
        locator = new Locator(this);
        thread = new HandlerThread(THREAD_ARG,
            Process.THREAD_PRIORITY_BACKGROUND);
        
    }
    
    @Override
    public Looper getLooper() {
        thread.start();
        return thread.getLooper();
    }
    
    @Override
    public Context getContext() {
        return context;
    }
    
    @Override
    public void onDestroy() {
        if (thread.isAlive())
            thread.stop();
    }
    
    @Override
    public void onHistoryButtonClick() {
        
    }
    
    @Override
    public void onRefreshButtonClick() {
        
    }
    
    @Override
    public void onLocationReceived(Location location) {
        
    }
}
