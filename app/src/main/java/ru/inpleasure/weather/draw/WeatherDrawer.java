package ru.inpleasure.weather.draw;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.View;

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
    private Paint axisPaint;
    private Paint pathPaint;
    private Paint maxTempPaint;
    private Paint minTempPaint;
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
        axisPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        axisPaint.set(pathPaint);
        axisPaint.setStrokeWidth(1f);
        axisPaint.setColor(0xaaffffff);
        minTempPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        minTempPaint.setTypeface(Typeface.SANS_SERIF);
        minTempPaint.setTextAlign(Paint.Align.CENTER);
        minTempPaint.setTextSize(30f);
        minTempPaint.setColor(0xff2b7bba);
        maxTempPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        maxTempPaint.setTypeface(Typeface.SANS_SERIF);
        maxTempPaint.setTextAlign(Paint.Align.CENTER);
        maxTempPaint.setTextSize(40f);
        maxTempPaint.setColor(0xffff7d00);
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
        canvas.drawLine(0f, centerY, bitmapWidth, centerY, axisPaint);
        for (Weather weather : weatherList)
        {
            float scaledValue = (float)(centerY + weather.getMainTemperature() * scale);
            canvas.drawLine(xPosition + SEPARATOR_OFFSET, 0f,
                xPosition + SEPARATOR_OFFSET, bitmapHeight, axisPaint);
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

    public Bitmap drawWeatherTwo(List<Weather> weatherList)
    {
        final int BLOCK_COUNT = 7;
        final int WIDTH = view.getWidth();
        final int HEIGHT = Math.round(view.getHeight() * 0.2f);
        final float CENTER_Y = HEIGHT / 2f;
        final float PADDING = 10f;
        float blockWidth = WIDTH / BLOCK_COUNT;
        int iconSize = Math.round(blockWidth * 0.7f);
        float xPosition = PADDING;
        Bitmap bitmap = Bitmap.createBitmap(WIDTH, HEIGHT, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.WHITE);
        Rect timeTextRect = new Rect();
        Rect minTempRect = new Rect();
        minTempPaint.getTextBounds("00", 0, 2, minTempRect);
        dotLabelPaint.getTextBounds("00:00", 0, 4, timeTextRect);
        float timeYPosition = PADDING + timeTextRect.height();
        float minTempYPosition = HEIGHT - PADDING;
        float maxTempYPosition = HEIGHT - PADDING - minTempRect.height() - PADDING;
        float iconYPosition = CENTER_Y - iconSize / 2f;
        for (int i = weatherList.size() - 1; i >= 0; i--)
        {
            Weather weather = weatherList.get(i);

            float blockCenter = xPosition + blockWidth * 0.5f;
            canvas.drawText(weather.getMeasureTime(), blockCenter, timeYPosition, dotLabelPaint);

            String iconName = weather.getWeatherIcon();
            Bitmap iconBitmap = getScaledIcon(iconName, iconSize);
            float iconX = blockCenter - iconSize / 2f;
            canvas.drawBitmap(iconBitmap, iconX, iconYPosition, pathPaint);

            canvas.drawText(Weather.formatTemperature(weather.getMainMinTemperature()),
                    blockCenter, minTempYPosition, minTempPaint);
            canvas.drawText(Weather.formatTemperature(weather.getMainMaxTemperature()),
                    blockCenter, maxTempYPosition, maxTempPaint);
            xPosition += blockWidth;
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

    private Bitmap getScaledIcon(String iconName, int scaledSize)
    {
        int iconResource = WeatherDto.WEATHER_ICONS.get(iconName);
        Bitmap bitmap = BitmapFactory.decodeResource(
                view.getContext().getResources(), iconResource);
        return Bitmap.createScaledBitmap(bitmap, scaledSize, scaledSize, false);
    }
}
