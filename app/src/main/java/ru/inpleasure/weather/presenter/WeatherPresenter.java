package ru.inpleasure.weather.presenter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Bitmap;
import android.location.Location;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.View;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import ru.inpleasure.weather.Contract;
import ru.inpleasure.weather.Locator;
import ru.inpleasure.weather.api.WeatherApi;
import ru.inpleasure.weather.api.dto.WeatherDto;
import ru.inpleasure.weather.model.WeatherModel;
import ru.inpleasure.weather.model.dbo.Weather;
import ru.inpleasure.weather.draw.WeatherDrawer;

import java.util.List;
import android.graphics.drawable.*;


public class WeatherPresenter
    implements Contract.Presenter
{
    private Context context;
    private Contract.Model model;
    private Contract.View view;
    private Contract.Api api;
    private Contract.Drawer drawer;
    private Locator locator;
    private WeatherLoader weatherLoader;
    
    
    public WeatherPresenter(Contract.View view) {
        this.view = view;
        context = view.getContext();
        model = new WeatherModel(context);
        locator = new Locator(this);
        api = new WeatherApi(context);
        
    }

    @SuppressWarnings("null")
    private boolean isConnectedToInternet()
    {
        NetworkInfo nInfo = ((ConnectivityManager)context
            .getSystemService(Context.CONNECTIVITY_SERVICE))
            .getActiveNetworkInfo();
        return nInfo != null && nInfo.isConnectedOrConnecting();
    }
    
    @Override
    public Context getContext() {
        return context;
    }
    
    @Override
    public void onDestroy() {
        locator.stop();
        if (weatherLoader != null &&
            weatherLoader.getStatus() == AsyncTask.Status.RUNNING)
            weatherLoader.cancel(false);
        weatherLoader = null;
    }
    
    @Override
    public void onHistoryButtonClick() {
        
    }
    
    @Override
    public void onRefreshButtonClick() {
        if (weatherLoader == null) {
            weatherLoader = new WeatherLoader(view);
            weatherLoader.execute(locator.getLocation());
        }
        else if (weatherLoader.getStatus() != AsyncTask.Status.RUNNING)
            weatherLoader.execute(locator.getLocation());
    }
    
    @Override
    public void onLocationReceived(Location location) {
        if (isConnectedToInternet()) {
            weatherLoader = new WeatherLoader(view);
            weatherLoader.execute(location);
        }
    }

    @Override
    public void initialize() {
        view.showWeather(model.getLastWeather());
        locator.start();
    }
    
    @Override
    public void onLocationError() {
        locator.stop();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void draw() {
        List<Weather> weatherList = model.getWeather();
        if (weatherList == null)
            return;
        new BitmapDrawer(view).execute(weatherList);
    }


    @SuppressWarnings("all")
    class WeatherLoader extends AsyncTask <Location, Void, Weather>
    {
        private Contract.View view;

        private WeatherLoader(final Contract.View view) {
            this.view = view;
        }

        @Override
        protected Weather doInBackground(Location... locations)
        {
            WeatherDto weatherDto = api.getWeather(locations[0]);
            if (weatherDto == null) return null;
            return Weather.createFromDto(weatherDto);
        }

        @Override
        protected void onPostExecute(Weather weather)
        {
            if (weather == null || view == null) return;
            model.addWeather(weather);
            view.showWeather(weather);
        }
    }

    @SuppressWarnings("all")
    class BitmapDrawer extends AsyncTask<List<Weather>, Void, Bitmap>
    {
        private Contract.View view;
        private WeatherDrawer drawer;
        
        public BitmapDrawer(final Contract.View view) {
            this.view = view;
            drawer = new WeatherDrawer(view);
        }
        
        @Override
        protected Bitmap doInBackground(List<Weather>... w)
        {
            List<Weather> weatherList = w[0];
            return drawer.drawWeatherTwo(weatherList);
        }
        
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            View drawableView = view.getDrawableView();
            //drawableView.getLayoutParams().width = bitmap.getWidth();
            drawableView.getLayoutParams().height = bitmap.getHeight();
            ((ImageView)drawableView).setImageBitmap(bitmap);
            view.draw();
        }
    }
}
