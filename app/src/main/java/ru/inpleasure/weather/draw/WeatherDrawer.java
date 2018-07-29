package ru.inpleasure.weather.draw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;

import ru.inpleasure.weather.Contract;

public class WeatherDrawer implements Contract.Drawer
{
    private Canvas canvas;
    private Contract.View view;

    public WeatherDrawer(Contract.View view) {
        this.view = view;
    }

    public void drawSomething()
    {
        Bitmap bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.RED);
        this.canvas = canvas;
    }

    @Override
    public Canvas getCanvas() {
        drawSomething();
        return canvas;
    }
}
