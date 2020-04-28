package com.project.Year;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class InstructionsSliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public InstructionsSliderAdapter(Context context){
        this.context = context;
    }

    public int[] slide_images= {
            R.drawable.common_google_signin_btn_icon_light_focused,
            R.drawable.film,
            R.drawable.history,
            R.drawable.music,
            R.drawable.film
    };

    public String[] slide_headings = {
            "Instructions",
            "Select Category",
            "Analyze the Image",
            "Input Your Guess",
            "Incorrect Guess? - No Problem!"
    };

    public String[] slide_descs = {
            "The main objective of this game, is to try and score as many points as possible by guessing the year of a series of images, based on the category you have chosen.",
            "To begin a match, you need to first select a category. On the category select screen, simply select the category you would like to play from the various options, and your match wil begin.",
            "Analyze the Image. Built-in zoom features allow for a closer inspection of the image and possible clues."
                    + " Double Tap the image to Zoom In/Out and move around the image by swiping in the direction you wish to focus on.",
            "No Time Limit, No pressure. Take as long as you need to come up with an answer you would like to submit." +
                    " Simply enter your guess in the provided area, and receive instant feedback on the correct answer and what you scored. Information on the Image can be found by pressing the Info button",
            "Points are awarded for how CLOSE you can get to the correct Year. Simply being Incorrect/Correct will not effect your Score." +
                    " Take your time and form a accurate as possible guess to maximize points"
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
        View view = layoutInflater.inflate(R.layout.activity_instructions_slider_adapter, container, false);

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
