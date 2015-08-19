/**
 * 
 */
package com.example.myapp.customView;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 带文字的Image view
 * @author lhy13592
 * 
 * 
 */
 public class ImageTextView extends View{
    private String mstr;
    private int msrc;
    
    //构造类
    public  ImageTextView(Context context) {
	super(context);
    }
    
    public ImageTextView(Context context,AttributeSet attrs){
	super(context, attrs);
	
	int textid = attrs.getAttributeResourceValue(null, "text", 0);
	int imgid = attrs.getAttributeResourceValue(null, "Src", 0);
	mstr = getResources().getText(textid).toString();
	msrc = imgid;
	
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        InputStream inputStream = getResources().openRawResource(msrc);
        Bitmap mBitmap = BitmapFactory.decodeStream(inputStream);
       
        int wt = mBitmap.getWidth();
        int ht = mBitmap.getHeight();
        canvas.drawBitmap(mBitmap, 0,0, paint);
        canvas.drawText(mstr, wt/4, 30, paint);
        
    }
    
}
