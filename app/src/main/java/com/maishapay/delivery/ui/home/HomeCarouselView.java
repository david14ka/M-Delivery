package com.maishapay.delivery.ui.home;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.maishapay.delivery.R;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class HomeCarouselView {

    private Activity mActivity;
    private int[] sampleImages;

    HomeCarouselView(Context mContext) {
        this.mActivity = (Activity) mContext;
    }

    void show(int[] sampleImages, CarouselView carouselView){

        this.sampleImages = sampleImages;

        try {
             //carouselView = (CarouselView) mActivity.findViewById(R.id.carouselView);
            carouselView.setPageCount(sampleImages.length);

            carouselView.setImageListener(imageListener);
            carouselView.setImageClickListener(imageClickListener);

        }catch (Exception e){

            Log.e(TAG, "loadCarouselViewShow: ", e);
        }

    }

    private ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(sampleImages[position]);

        }
    };

    private ImageClickListener imageClickListener = new ImageClickListener() {
        @Override
        public void onClick(int position) {
            Toast.makeText(mActivity, "slide "+position, Toast.LENGTH_SHORT).show();
        }
    };
}
