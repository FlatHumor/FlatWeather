package ru.inpleasure.weather.draw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ImageView;

import ru.inpleasure.weather.Contract;

public class WeatherDrawer implements Contract.Drawer
{
    private static final int BAR_OFFSET = 70;
    private static final float DOT_OFFSET = 70;
    private static final float DOT_LABEL_OFFSET = 30;
    
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
        dotPath = new Path();
    }
    
    public void drawDots(double[] values)
    {
        dotPath.reset();
        float xPosition = 20f;
        int bitmapWidth = (int)(xPosition + DOT_OFFSET * values.length);
        int bitmapHeight = (int)(view.getHeight() * 0.2);
        centerY = bitmapHeight / 2f;
        float scale = centerY / 50;
        Bitmap bitmap = Bitmap.createBitmap(bitmapWidth, bitmapHeight,
            Bitmap.Config.ARGB_8888);
        drawableView.getLayoutParams().width = bitmapWidth;
        drawableView.getLayoutParams().height = bitmapHeight;
        ((ImageView)drawableView).setImageBitmap(bitmap);
        Canvas canvas = new Canvas(bitmap);
        dotPath.moveTo(xPosition, (float)(centerY - values[0] * scale));
        canvas.drawLine(0f, centerY, bitmapWidth, centerY, pathPaint);
        for (double value : values)
        {
            float scaledValue = (float)(centerY + value * scale);
            canvas.drawPoint(
                xPosition,
                (float)(bitmapHeight - scaledValue),
                dotPaint);
            canvas.drawText(String.valueOf(value), xPosition,
                (float)(bitmapHeight - scaledValue - DOT_LABEL_OFFSET),
                dotLabelPaint);
            dotPath.lineTo(xPosition, (float)(bitmapHeight - scaledValue));
            xPosition += DOT_OFFSET;
        }
        canvas.drawPath(dotPath, pathPaint);
        view.draw();
    }
}
