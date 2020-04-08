package com.project.Year;

import android.content.Intent;

public class ImageYearCheck extends MainActivity {

//This method attaches a year to each image
    public void checkIndex() {
        if (randomIndex==1 || randomIndex==19|| randomIndex==28)  {
            ImageYear = 1974; System.out.println("This image is from:  " + ImageYear);

        }
        else  if (randomIndex==2 || randomIndex==15|| randomIndex==20){
            ImageYear = 2007; System.out.println("This image is from:  " + ImageYear);
        }
        else  if (randomIndex==3 || randomIndex==12|| randomIndex==22){
            ImageYear = 1945; System.out.println("This image is from:  " + ImageYear);
        }
        else  if (randomIndex==4){
            ImageYear = 1933; System.out.println("This image is from:  " + ImageYear);
        }
        else  if (randomIndex==5 || randomIndex==14|| randomIndex==32){
            ImageYear = 1974; System.out.println("This image is from:  " + ImageYear);
        }
        else  if (randomIndex==13 || randomIndex==18|| randomIndex==31){
            ImageYear = 1912; System.out.println("This image is from:  " + ImageYear);
        }
        else  if (randomIndex==16){
            ImageYear = 2008; System.out.println("This image is from:  " + ImageYear);
        }
        else  if (randomIndex==21 || randomIndex==30){
            ImageYear = 1981; System.out.println("This image is from:  " + ImageYear);
        }
        else  if (randomIndex==29 || randomIndex==33){
            ImageYear = 1989; System.out.println("This image is from:  " + ImageYear);

        }
        if (randomIndex==5){
            randomIndex = 11;

        }
        if (randomIndex==16){
            randomIndex = 17;
        }

        if (randomIndex==22){
            randomIndex = 27;
        }
        if (randomIndex==33){
            randomIndex = 1;
        }

        if (randomIndex==100){
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory( Intent.CATEGORY_HOME );
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
        }

    }

}
