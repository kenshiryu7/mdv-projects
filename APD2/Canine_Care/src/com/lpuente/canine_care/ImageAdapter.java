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
   
    public Integer[] mThumbIds = {
    		R.drawable.choco, R.drawable.coco2, R.drawable.coco3, R.drawable.coco4,
    		
    		R.drawable.onions, R.drawable.onion2, R.drawable.onion3, R.drawable.onion4,
    		
    		R.drawable.grapes, R.drawable.grape2, R.drawable.grape3, R.drawable.grape4,
    		
    		R.drawable.coffee, R.drawable.coffee2, R.drawable.coffee3, R.drawable.coffee4,
    		
    		R.drawable.mnuts, R.drawable.mnuts2, R.drawable.mnuts3, R.drawable.mnuts4,
    		
    		R.drawable.azalea, R.drawable.azalea2, R.drawable.azalea3, R.drawable.azalea4,
    		
    		R.drawable.crocus, R.drawable.crocus2, R.drawable.crocus3, R.drawable.crocus4,
    		
    		R.drawable.foxglove, R.drawable.fox2, R.drawable.fox3, R.drawable.fox4,
    		
    		R.drawable.juniper, R.drawable.junip2, R.drawable.junip3, R.drawable.junip4,
    		
    		R.drawable.mistletoe, R.drawable.mtoe2, R.drawable.mtoe3, R.drawable.mtoe4,
    		
    		R.drawable.afreeze, R.drawable.eth2, R.drawable.eth3, R.drawable.eth4,
    		
    		R.drawable.ratpoison, R.drawable.rat2, R.drawable.rat3, R.drawable.rat4,
    		
    		R.drawable.snailbait, R.drawable.snail2, R.drawable.snail3, R.drawable.snail4};
    
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
