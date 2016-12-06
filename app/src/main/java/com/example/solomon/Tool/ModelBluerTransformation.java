package com.example.solomon.Tool;

import android.graphics.Bitmap;

import com.squareup.picasso.Transformation;

import net.qiujuer.genius.blur.StackBlur;

/**
 * Created by Solomon on 2016/11/15.
 */
public class ModelBluerTransformation implements Transformation {
    private int radius;

    public ModelBluerTransformation (int radius){
        this.radius=radius;

    }
    @Override
    public Bitmap transform(Bitmap source) {

        // Java
        Bitmap newBitmap = StackBlur.blur(source, (int) radius, false);

/*// Bitmap JNI Native
        Bitmap newBitmap1 = StackBlur.blurNatively(source, (int) radius, false);

// Pixels JNI Native
        Bitmap newBitmap2 = StackBlur.blurNativelyPixels(source, (int) radius, false);*/
        source.recycle();
        return newBitmap;
    }

    @Override
    public String key() {
        return "SS";
    }
}
