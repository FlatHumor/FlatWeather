package ru.inpleasure.weather.draw;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import ru.inpleasure.weather.Contract;
import ru.inpleasure.weather.model.dbo.Weather;
import ru.inpleasure.weather.api.dto.WeatherDto;

public class WeatherDrawer implements Contract.Drawer
{
    private static final int BAR_OFFSET = 70;
    private static final float DOT_OFFSET = 150f;
    private static final float SEPARATOR_OFFSET = DOT_OFFSET / 2f;
    private static final float DOT_LABEL_OFFSET = 30f;
    private static final int ICON_SIZE = 200;
    
    private Canvas canvas;
    private Contract.View view;
    private View drawableView;
    private float canvasWidth;
    private float canvasHeight;
    private float centerX;
    private float centerY;
    private Paint barPaint;
    private Paint dotPaint;
    private Paint dotLabelPaint;
    private Paint oxisPaint;
    private Paint pathPaint;
    private Path dotPath;

    public WeatherDrawer(Contract.View view)
    {
        this.view = view;
        drawableView = view.getDrawableView();
        barPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        barPaint.setColor(0xff2b7bba);
        barPaint.setStrokeWidth(20f);
        dotPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        dotPaint.setColor(Color.WHITE);
        dotPaint.setStrokeWidth(20f);
        dotPaint.setStrokeCap(Paint.Cap.ROUND);
        pathPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pathPaint.setColor(0xffffffff);
        pathPaint.setStrokeWidth(5f);
        pathPaint.setStyle(Paint.Style.STROKE);
        dotLabelPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        dotLabelPaint.setTypeface(Typeface.SANS_SERIF);
        dotLabelPaint.setColor(Color.WHITE);
        dotLabelPaint.setTextAlign(Paint.Align.CENTER);
        dotLabelPaint.setTextSize(20f);
        oxisPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        oxisPaint.set(pathPaint);
        oxisPaint.setStrokeWidth(1f);
        oxisPaint.setColor(0xaaffffff);
        dotPath = new Path();
    }
    
    public Bitmap drawDots(List<Weather> weatherList)
    {
        dotPath.reset();
        float xPosition = 20f;
        double firstValue = weatherList.get(0).getMainTemperature();
        int bitmapWidth = (int)(xPosition + DOT_OFFSET * weatherList.size());
        int bitmapHeight = (int)(view.getHeight() * 0.2);
        centerY = bitmapHeight / 2f;
        float scale = centerY / 50;
        Bitmap bitmap = Bitmap.createBitmap(bitmapWidth, bitmapHeight,
            Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        dotPath.moveTo(xPosition, (float)(centerY - firstValue * scale));
        canvas.drawLine(0f, centerY, bitmapWidth, centerY, oxisPaint);
        for (Weather weather : weatherList)
        {
            float scaledValue = (float)(centerY + weather.getMainTemperature() * scale);
            canvas.drawLine(xPosition + SEPARATOR_OFFSET, 0f,
                xPosition + SEPARATOR_OFFSET, bitmapHeight, oxisPaint);
            canvas.drawPoint(xPosition, (float)(bitmapHeight - scaledValue), dotPaint);
            canvas.drawBitmap(getIconBitmap(weather.getWeatherIcon()),
                xPosition - 100f, bitmapHeight - scaledValue - 100f, pathPaint);
            canvas.drawText(String.valueOf(weather.getMainTemperature()), xPosition,
                (float)(bitmapHeight - scaledValue), dotLabelPaint);
            canvas.drawText(weather.getMeasureTime(), xPosition, bitmapHeight, dotLabelPaint);
            dotPath.lineTo(xPosition, (float)(bitmapHeight - scaledValue));
            xPosition += DOT_OFFSET;
        }
        return bitmap;
    }
    
    private Bitmap getIconBitmap(String iconName)
    {
        int iconResource = WeatherDto.WEATHER_ICONS.get(iconName);
        Bitmap bitmap = BitmapFactory.decodeResource(
            view.getContext().getResources(), iconResource);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(
            bitmap, ICON_SIZE, ICON_SIZE, false);
        return scaledBitmap;
    }
}
