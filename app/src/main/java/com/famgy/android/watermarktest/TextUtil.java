package com.famgy.android.watermarktest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by famgy on 11/1/17.
 */

/* 添加全屏斜着45度的文字 */
public class TextUtil {

    public static Bitmap drawCenterLable(Context context, Bitmap bmp, String text) {
        float scale = context.getResources().getDisplayMetrics().density;
        //创建一样大小的图片
        Bitmap newBmp = Bitmap.createBitmap(bmp.getWidth(), bmp.getHeight(), Bitmap.Config.ARGB_8888);
        //创建画布
        Canvas canvas = new Canvas(newBmp);
        canvas.drawBitmap(bmp, 0, 0, null);  //绘制原始图片
        canvas.save();
        canvas.rotate(45); //顺时针转45度
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.argb(50, 255, 255, 255)); //白色半透明
        paint.setTextSize(dp2px(context, 100));
        paint.setDither(true);
        paint.setFilterBitmap(true);
        Rect rectText = new Rect();  //得到text占用宽高， 单位：像素
        paint.getTextBounds(text, 0, text.length(), rectText);

        double beginX = (bmp.getWidth()/2 - rectText.width()/2)*0.5 ;  //45度角度值是1.414
        double beginY = (bmp.getHeight()/2 - rectText.width()/2)*0.5;
        canvas.drawText(text, (int)beginX, (int)beginY, paint);
        canvas.restore();
        return newBmp;
    }

    public static int dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}

