package com.example.solomon.Tool;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

import com.squareup.picasso.Transformation;


/**
 * https://www.zhihu.com/question/47496609
 * Created by Solomon on 2016/11/2.
 */
public class PRoundedCornersTransformation implements Transformation {
    public enum CornerType {
        ALL,
        TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT,
        TOP, BOTTOM, LEFT, RIGHT,
        OTHER_TOP_LEFT, OTHER_TOP_RIGHT, OTHER_BOTTOM_LEFT, TOHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT, DIAGONAL_FROM_TOP_RIGHT
    }

    private int mRadius;
    private int mDiameters;
    private int mMargin;
    private CornerType mCornerType;

    public PRoundedCornersTransformation(int radius, int margin) {
        this(radius, margin, CornerType.ALL);
    }

    public PRoundedCornersTransformation(int radius, int margin, CornerType cornerType) {
        mRadius = radius;
        mDiameters = radius * 2;
        mMargin = margin;
        mCornerType = cornerType;
    }

    @Override
    public Bitmap transform(Bitmap source) {

        int width = source.getWidth();
        int height = source.getHeight();

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        drawRoundRect(canvas, paint, width, height);

        source.recycle();
        return bitmap;
    }

    @Override
    public String key() {
        return "blur";
    }

    private void drawRoundRect(Canvas canvas, Paint paint, float width, float height) {
        float right = width - mMargin;
        float bottom = height - mMargin;
        //    float left=
        switch (mCornerType) {
            case ALL:
                canvas.drawRoundRect(new RectF(mMargin, mMargin, right, bottom), mRadius, mRadius, paint);
                break;
            case TOP_LEFT:
                drawRoundRect(canvas, paint, width, height);
                break;
            case TOP_RIGHT:
                drawRoundRect(canvas, paint, width, height);
                break;
            case BOTTOM_LEFT:
                drawRoundRect(canvas, paint, width, height);
                break;
            case BOTTOM_RIGHT:
                drawRoundRect(canvas, paint, width, height);
                break;
            case TOP:
                drawTopRoundRect(canvas, paint, width, height);
                break;
            case BOTTOM:
                drawBottomRoundRect(canvas, paint, width, height);
                break;

        }

    }

    private void drawBottomRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        canvas.drawRoundRect(new RectF(mMargin, bottom - mDiameters, right, bottom), mRadius, mRadius, paint);
        canvas.drawRect(new RectF(mMargin, mMargin, right, bottom - mRadius), paint);
    }

    private void drawTopRoundRect(Canvas canvas, Paint paint, float right, float bottom) {
        canvas.drawRoundRect(new RectF(mMargin, mMargin, right, bottom - mRadius), mRadius, mRadius, paint);
        canvas.drawRect(new RectF(mMargin, bottom - mDiameters, right, bottom), paint);
    }

}
