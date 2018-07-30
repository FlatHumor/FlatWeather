package ru.inpleasure.weather.draw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;

import ru.inpleasure.weather.Contract;

public class WeatherDrawer implements Contract.Drawer
{
    private static final int BAR_OFFSET = 70;
    private static final float DOT_OFFSET = 70;
    private static final float DOT_LABEL_OFFSET = 50;
    
    private Canvas canvas;
    private Contract.View view;
    private float canvasWidth;
    private float canvasHeight;
    private float centerX;
    private float centerY;
    private Paint barPaint;
    private Paint dotPaint;
    private Paint dotLabelPaint;
    private Paint pathPaint;
    private Path dotPath;

    public WeatherDrawer(Contract.View view) {
        this.view = view;
        canvas = view.getCanvas();
        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();
        centerX = canvasWidth / 2;
        centerY = canvasHeight / 2;
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
        dotPath = new Path();
    }
    
    public void drawDots(double[] values)
    {
        dotPath.reset();
        float xPosition = DOT_OFFSET;
        dotPath.moveTo(xPosition, (float)(canvasHeight-values[0]*3));
        for (double value : values)
        {
            canvas.drawPoint(
                xPosition,
                (float)(canvasHeight - value * 3),
                dotPaint);
            canvas.drawText(String.valueOf(value), xPosition,
                (float)(canvasHeight - value * 3 - DOT_LABEL_OFFSET),
                dotLabelPaint);
            dotPath.lineTo(xPosition, (float)(canvasHeight - value * 3));
            xPosition += DOT_OFFSET;
        }
        canvas.drawPath(dotPath, pathPaint);
        view.draw();
    }
}
