package com.project.Year;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.github.chrisbanes.photoview.PhotoView;
import com.google.firebase.FirebaseApp;
import com.bumptech.glide.Glide;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity  {

    ImageView imageView;
    Button History;
    Button nextRound;
    TextView textView;
    EditText editText;
    TextView textView3;
    Button submitGuess;
    ImageView image;
    PhotoView photoView;
    TextView scoreView;
    TextView roundView;
    Firebase mQuestionRef,mYearRef;
    int mQuestionNumber = 1;



    int scoreOn = 0;
    int roundOn =1;
    Integer[] colm = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    final List<Integer> ints = new ArrayList<Integer>(Arrays.asList(colm));
    static int randomIndex = 0;
    static int ImageYear = 0;
    String[] Historyarray;




    //method handles all operations for submitting a guess
    public void validate(){
        int n = editText.getText().toString().equals("") ? 0 :Integer.parseInt(editText.getText().toString());
        TextView textView2 =  (TextView) findViewById(R.id.txt_YourGuess);
        TextView textView3 = (TextView) findViewById(R.id.txt_CorrectAnswer);
        TextView textView = findViewById(R.id.txt_displaycorrectyear);

        if (n == ImageYear) {
            Toast.makeText(this,"Well done that is correct", Toast.LENGTH_SHORT).show();
            roundOn = roundOn + 1;
            scoreOn = scoreOn + 1;
            textView2.setVisibility(View.INVISIBLE);
            editText.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.VISIBLE);
            textView3.setVisibility(View.VISIBLE);
            submitGuess.setVisibility(View.INVISIBLE);
            nextRound.setVisibility(View.VISIBLE);
            TextView doubleView = (TextView) findViewById(R.id.txt_displaycorrectyear);
            doubleView.setText("" + ImageYear);
            if (randomIndex ==11 || randomIndex==17 || randomIndex==27 || randomIndex==30) {
                roundOn = roundOn - 1;
                Intent myIntent = new Intent(MainActivity.this, MainMenu.class);
                startActivity(myIntent);
                finish();
            }
        }
         if (!(n == ImageYear ) && n > 2020 || n < 1) {
            Toast.makeText(this,"Please enter a year between '1-2020'", Toast.LENGTH_SHORT).show();
        }
       else if (!(n == ImageYear )) {
            Toast.makeText(this,"Incorrect, correct answer was:  " + ImageYear, Toast.LENGTH_SHORT).show();
             roundOn = roundOn + 1;
             textView2.setVisibility(View.INVISIBLE);
             editText.setVisibility(View.INVISIBLE);
             textView.setVisibility(View.VISIBLE);
            textView3.setVisibility(View.VISIBLE);
             submitGuess.setVisibility(View.INVISIBLE);
             nextRound.setVisibility(View.VISIBLE);
             TextView doubleView = (TextView) findViewById(R.id.txt_displaycorrectyear);
             doubleView.setText("" + ImageYear);
             if (roundOn == 6) {
                 roundOn = roundOn - 1;
                 Intent myIntent = new Intent(MainActivity.this, MainMenu.class);
                 startActivity(myIntent);
                 finish();
             }
        }
    }


    public void RandomQuestion(){
      if(roundOn==1){
          int size = 5;  ArrayList<Integer> list = new ArrayList<Integer>(size);
          for(int i = 1; i <= size; i++) { list.add(i); }
          Random rand = new Random();
          if(list.size() > 0) { int index = rand.nextInt(list.size());
          System.out.println("INDEX SELECTED =   " + list.remove(index));
          mQuestionNumber = index+1;
          System.out.println("QUESTION NUMBER SELECTED" + mQuestionNumber);} }

      if(roundOn==2){
        int size = 5;  ArrayList<Integer> list = new ArrayList<Integer>(size);
        for(int i = 1; i <= size; i++) { list.add(i); }
        Random rand = new Random();
        if(list.size() > 0) { int index = rand.nextInt(list.size()); System.out.println("INDEX SELECTED =   " + list.remove(index)); mQuestionNumber = index+6;
        System.out.println(mQuestionNumber);} }

      if(roundOn==3){
        int size = 2;  ArrayList<Integer> list = new ArrayList<Integer>(size);
        for(int i = 1; i <= size; i++) { list.add(i); }
        Random rand = new Random();
        if(list.size() > 0) { int index = rand.nextInt(list.size());System.out.println("INDEX SELECTED =   " + list.remove(index)); mQuestionNumber = index+11;
            System.out.println(mQuestionNumber);}

      }if(roundOn==4){
        int size = 5;  ArrayList<Integer> list = new ArrayList<Integer>(size);
        for(int i = 1; i <= size; i++) { list.add(i); }
        Random rand = new Random();
        if(list.size() > 0) { int index = rand.nextInt(list.size());mQuestionNumber = index+16; System.out.println("INDEX SELECTED =   " + list.remove(index));  System.out.println(mQuestionNumber);}

      }if(roundOn==5){
        int size = 5;  ArrayList<Integer> list = new ArrayList<Integer>(size);
        for(int i = 1; i <= size; i++) { list.add(i); }
        Random rand = new Random();
        if(list.size() > 0) { int index = rand.nextInt(list.size());mQuestionNumber = index+21; System.out.println("INDEX SELECTED =   " + list.remove(index)); System.out.println(mQuestionNumber);}
      }}


    public void UpdateQuestion(){
        if (roundOn == 6) {
            Intent myIntent = new Intent(MainActivity.this, MainMenu.class);
            startActivity(myIntent);
            finish();
        }
        mQuestionRef = new Firebase("https://retrieve-images-1c732.firebaseio.com/" + MainMenu.mQuestionTopic + "/" + mQuestionNumber +"/image");
        TextView textView2 =  (TextView) findViewById(R.id.txt_YourGuess);
        TextView textView3 = (TextView) findViewById(R.id.txt_CorrectAnswer);
        TextView textView = findViewById(R.id.txt_displaycorrectyear);
        final PhotoView photoView = (PhotoView)findViewById(R.id.image);
        photoView.setVisibility(View.VISIBLE);
        textView2.setVisibility(View.VISIBLE);
        editText.setVisibility(View.VISIBLE);
        textView.setVisibility(View.INVISIBLE);
        textView3.setVisibility(View.INVISIBLE);
        nextRound.setVisibility(View.INVISIBLE);
        mQuestionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String image = dataSnapshot.getValue(String.class);
                //Glide.with(getApplicationContext()).load(image).into(imageView);
                 Glide.with(getApplicationContext()).load(image).into(photoView);




            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mYearRef = new Firebase("https://retrieve-images-1c732.firebaseio.com/" + MainMenu.mQuestionTopic + "/" + mQuestionNumber +"/correctyear");
        mYearRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int YearSet = dataSnapshot.getValue(int.class);
                ImageYear = YearSet;
                //DisplayImageYear(ImageYear);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        //mQuestionNumber++;
    }

    //method selects image from array and displays it
    public void ImageSelect(){
        //mQuestionRef = new Firebase ("https://retrieve-images-1c732.firebaseio.com/0/question");
        Historyarray = getResources().getStringArray(R.array.historyArray);
        // randomnum = rand.nextInt(RandomImage.length);
        int numberOfElements = Historyarray.length;
        TextView textView2 =  (TextView) findViewById(R.id.txt_YourGuess);
        TextView textView3 = (TextView) findViewById(R.id.txt_CorrectAnswer);
        TextView textView = findViewById(R.id.txt_displaycorrectyear);

        for (int i = 1; (i < 2) && (ints.size() > 0); i++) {
            String randomStr = Historyarray[new Random().nextInt(Historyarray.length)];
            imageView = findViewById(R.id.image);
            imageView.setVisibility(View.VISIBLE);
            String url = randomStr;
            //Glide.with(getApplicationContext()).load(url).into(imageView);
            System.out.println("Index in array:   " + randomIndex);
            textView2.setVisibility(View.VISIBLE);
            editText.setVisibility(View.VISIBLE);
            textView.setVisibility(View.INVISIBLE);
            textView3.setVisibility(View.INVISIBLE);
            nextRound.setVisibility(View.INVISIBLE);
        }
        //randomIndex++;
        //ImageYearCheck cls2 = new ImageYearCheck();
        //cls2.checkIndex();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView doubleView = (TextView) findViewById(R.id.txt_displaycorrectyear);
        editText = (EditText) findViewById(R.id.numberEnteredEt);
        submitGuess = (Button) findViewById(R.id.submitGuess);
        nextRound = (Button) findViewById(R.id.nextQuestion);
        TextView textView2 =  (TextView) findViewById(R.id.txt_YourGuess);
        TextView textView3 = (TextView) findViewById(R.id.txt_CorrectAnswer);
        TextView scoreView = (TextView) findViewById(R.id.txt_scoreOn);
        TextView roundView = findViewById(R.id.txt_roundOn);
        final ImageView imageView = findViewById(R.id.image);

        RandomQuestion();
        UpdateQuestion();


        editText.getText().clear();
        scoreView.setVisibility(View.VISIBLE);
        roundView.setVisibility(View.VISIBLE);
        scoreView.setText("Score: " + scoreOn);
        roundView.setText("Round: " + roundOn);
        submitGuess.setVisibility(View.VISIBLE);

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
                editText.getText().clear();
            }
        });

        submitGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
                editText.getText().clear();
                TextView scoreView = (TextView) findViewById(R.id.txt_scoreOn);
                scoreView.setText("Score: " + scoreOn);
            }
        });


        nextRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RandomQuestion();
                UpdateQuestion();
                editText.getText().clear();
                submitGuess.setVisibility(View.VISIBLE);
                TextView roundView = findViewById(R.id.txt_roundOn);
                roundView.setText("Round: " + roundOn);
            }
        });




    }
}