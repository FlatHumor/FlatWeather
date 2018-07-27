package ru.inpleasure.weather;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.view.Window;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.graphics.Color;
import ru.inpleasure.weather.model.*;
import ru.inpleasure.weather.presenter.*;

public class MainActivity extends Activity
    implements Contract.View
{
    private TextView textView;
    private Button button;
    private Contract.Presenter presenter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.requestFeature(Window.FEATURE_NO_TITLE);
        window.setStatusBarColor(Color.rgb(64,61,56));
        setContentView(R.layout.main);
        textView = findViewById(R.id.activity_main_tv);
        button = findViewById(R.id.test_button);
        presenter = new WeatherPresenter(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                presenter.onRefreshButtonClick();
            }
        });
    }
    
    @Override
    public Context getContext() {
        return this;
    }
    
    @Override
    public void showWeatherIcon() {
        
    }
    
    @Override
    public void showText(String text) {
        textView.setText(text);
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
