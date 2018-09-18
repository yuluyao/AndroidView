package com.yuluyao.exv.pie;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.yuluyao.exv.pie.PieData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuluyao on 2018/1/19.
 */

public class PieView extends View {

    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    private float redius = 240;

    private int[] colos = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69,
            0xFF808080, 0xFFE6B800, 0xFF7CFC00};
    private RectF mRect = new RectF();
    private float mStartAngle = 0;

    private List<PieData> mData = new ArrayList<>();


    public PieView(Context context) {
        this(context, null, 0);
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
        initData();
    }

    private void initData() {
        mData.add(new PieData("hello", 99, 40));
        mData.add(new PieData("hello", 99, 40));
        mData.add(new PieData("hello", 99, 40));
        mData.add(new PieData("hello", 99, 40));
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.GRAY);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
        mRect.set(-redius, -redius, redius, redius);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(mWidth / 2, mHeight / 2);
        canvas.drawCircle(0, 0, 240, mPaint);

        for (int i = 0; i < mData.size(); i++) {
            float angle = mData.get(i).getAngle();
            mPaint.setColor(colos[i]);
            canvas.drawArc(mRect, mStartAngle, angle, true, mPaint);
            mStartAngle += angle;
        }

    }

    private int mLastX;
    private int mLastY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;
                float translationX = getTranslationX() + deltaX;
                float translationY = getTranslationY() + deltaY;
                setTranslationX(translationX);
                setTranslationY(translationY);
                break;
            case MotionEvent.ACTION_UP:
                setTranslationX(0);
                setTranslationY(0);
                break;
        }
        mLastX = x;
        mLastY = y;
        return true;
    }
}
