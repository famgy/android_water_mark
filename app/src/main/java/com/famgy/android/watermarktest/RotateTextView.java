package com.famgy.android.watermarktest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Created by Administrator on 2014/9/9.
 */
public class RotateTextView extends android.support.v7.widget.AppCompatTextView {

	private static final int DEFAULT_DEGREES = 0;

	private int mDegrees;

	public RotateTextView(Context context) {
		super(context, null);
	}

	public RotateTextView(Context context, AttributeSet attrs) {
		super(context, attrs, android.R.attr.textViewStyle);

		this.setGravity(Gravity.CENTER);

		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.RotateTextView);

		mDegrees = a.getDimensionPixelSize(R.styleable.RotateTextView_degree,
				DEFAULT_DEGREES);
		a.recycle();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.save();
		//canvas.rotate(45); //顺时针转45度
		canvas.translate(getCompoundPaddingRight(), getExtendedPaddingTop());
		canvas.rotate(mDegrees, this.getWidth() / 2f, this.getHeight() / 2f);
		super.onDraw(canvas);
		canvas.restore();
	}
}
