package com.vogella.android.recyclerview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by adol on 4/6/16.
 */
public class SImageView extends ImageView {
    public boolean off30;
    public boolean off40;
    public SImageView(Context context)
    {
        super(context);
        // TODO Auto-generated constructor stub
        setBackgroundColor(0xFFFFFF);
    }

    /**
     * @param context
     * @param attrs
     */
    public SImageView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        System.out.println("Painting content");
        Paint paint  = new Paint(Paint.LINEAR_TEXT_FLAG);
        paint.setColor(0x0);
        paint.setTextSize(12.0F);
        System.out.println("Drawing text");
        canvas.drawText("Hello World in custom view", 100, 100, paint);
    }

}
