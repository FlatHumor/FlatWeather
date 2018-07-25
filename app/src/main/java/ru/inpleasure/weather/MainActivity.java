package ru.inpleasure.weather;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.graphics.Color;

public class MainActivity extends Activity
    implements Contract.View
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.requestFeature(Window.FEATURE_NO_TITLE);
        window.setStatusBarColor(Color.rgb(64,61,56));
        setContentView(R.layout.main);
    }
    
    @Override
    public void showWeatherIcon() { }
}
