/**
 * 
 */
package org.jug.montpellier.jugdroid.ui;

import org.jug.montpellier.jugdroid.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * A button which can draw a circle on the bottom-right to indicate how many new
 * information are available.<br/>
 * This button is useful in a Dashboard (see Android UI Pattern) as it provides
 * a dynamic dashboard instead of a static one.
 * 
 * @author etaix
 */
public class NewInfoButton extends Button {

	// The circle bitmap
	private Bitmap circle = null;
	private Paint paint;
	// The provider which returns the number of new informations available
	private NewInfoProvider provider = null;

	public NewInfoButton(Context context) {
		super(context);
		init();
	}

	public NewInfoButton(Context context, AttributeSet attrSet) {
		super(context, attrSet);
		init();
	}

	public NewInfoButton(Context context, AttributeSet attrSet, int defStyle) {
		super(context, attrSet, defStyle);
		init();
	}

	/**
	 * Init objects which are required to draw. It avoids to allocate an
	 * instance for each draw
	 */
	private void init() {
		circle = BitmapFactory.decodeResource(getResources(), R.drawable.circle);
		paint = new Paint();
		paint.setColor(Color.WHITE);
		paint.setTextSize(25.0f);
		paint.setFakeBoldText(true);
		paint.setStyle(Style.FILL_AND_STROKE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.TextView#onDraw(android.graphics.Canvas)
	 */
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		// If the provider has been set (otherwise don't draw the circle)
		if (provider != null) {
			int count = provider.getNewInfoCount();
			// If not equal to zero, otherwise don't draw the circle
			if (count != 0) {
				String text = (count < 10) ? ""+count : "9+"; 
				// Calculate the text bounds
				Rect bounds = new Rect();
				bounds.right = (int) paint.measureText(text);
				bounds.bottom = (int) (paint.descent() - paint.ascent());
				// Calculate default position for news indicator
				int left = (getWidth() / 2);
				int top = circle.getHeight() / 4;
				// Modifiy position according to the image size
				Drawable[] drawables = getCompoundDrawables();
				if (drawables != null && drawables.length >= 1) {
					Rect imgBounds = drawables[1].getBounds();
					left = left - (imgBounds.right / 2);
				}
				// Draw
				canvas.drawBitmap(circle, left, top, paint);
				canvas.drawText(text, left + (circle.getWidth() / 2) - (bounds.right / 2), top + bounds.bottom, paint);
			}
		}
	}

	/**
	 * Set the implementation of the NewInfoProvider
	 * @param providerP
	 */
	public void setInfoProvider(NewInfoProvider providerP) {
		provider = providerP;
	}
}
