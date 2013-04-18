package com.lpuente.canine_care;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

 // Keep all Images in array
    //Right now all images in ONE array.
    //Prefer to have seperate arrays for only the proper images selected. Chocolate leads to chocolate IMGs for
    //example rather than opening ALL images. Will see if I can figure this out in TIME.
   
    public Integer[] mThumbIds = {R.drawable.choco, R.drawable.coco2, R.drawable.coco3, R.drawable.coco4};
    
 // Constructor
    public ImageAdapter(Context c){
        mContext = c;
    }
    
    
    
 //Methods from BaseAdapter   
    @Override
    public int getCount() {
        return mThumbIds.length;
    }
 
    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }
 
    @Override
    public long getItemId(int position) {
        return 0;
    }
 
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
        return imageView;
    }

}
