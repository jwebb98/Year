package com.project.Year;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    public int[] slide_images= {
          R.drawable.category100,
          R.drawable.cinema100,
          R.drawable.history160,
          R.drawable.music180,
          R.drawable.sports160
    };

    public String[] slide_headings = {
            "Category Select","Film", "History", "Music", "Sports"
    };

    public String[] slide_descs = {
      "test","random stuff 1 hopefully working FILM", "random stuff 2 hopefully working HISTORY", "random stuff 3 hopefully working MUSIC", "random stuff 4 hopefully working Film"
    };

   // public String[] slide_buttons = {
    //        "Film Posters", "Historical Events", "Iconic Album Covers", "UEFA CL Teams"
   // };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (ConstraintLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);
        //Button slideButton = (Button) view.findViewById(R.id.slide_button);


        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);
        //slideButton.setText(slide_buttons[position]);



        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object){
        container.removeView((ConstraintLayout)object);
    }


}
