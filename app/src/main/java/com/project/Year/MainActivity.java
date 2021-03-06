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
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button nextRound;
    EditText editText;
    Button submitGuess;
    Firebase mQuestionRef, mYearRef;
    int mQuestionNumber = 1;
    int scoreOn = 0;
    int roundOn = 1;
    static int ImageYear = 0;

    //method handles all operations for submitting a guess
    public void validate() {
        int n = editText.getText().toString().equals( "" ) ? 0 : Integer.parseInt( editText.getText().toString() );
        TextView textView2 = ( TextView ) findViewById( R.id.txt_YourGuess );
        TextView textView3 = ( TextView ) findViewById( R.id.txt_CorrectAnswer );
        TextView textView = findViewById( R.id.txt_displaycorrectyear );
        TextView YouScored = findViewById( R.id.txt_YouScored );
        if ( n == ImageYear ) {
            Toast.makeText( this, "Well done that is correct", Toast.LENGTH_SHORT ).show();
            roundOn = roundOn + 1;
            scoreOn = scoreOn + 100;
            YouScored.setText( "You Scored " + 100 );
            TestAnswerStuff();
        }
        if ( !( n == ImageYear ) && n > 2020 || n < 1 ) {
            Toast.makeText( this, "Please enter a year between '1-2020'", Toast.LENGTH_SHORT ).show();
        } else if ( n == ImageYear + 9 || n == ImageYear - 9 ) {
            roundOn = roundOn + 1;
            YouScored.setText( "You Scored " + 10 );
            scoreOn = scoreOn + 10;
            TestAnswerStuff();
        } else if ( n == ImageYear + 8 || n == ImageYear - 8 ) {
            roundOn = roundOn + 1;
            YouScored.setText( "You Scored " + 20 );
            scoreOn = scoreOn + 20;
            TestAnswerStuff();
        } else if ( n == ImageYear + 7 || n == ImageYear - 7 ) {
            roundOn = roundOn + 1;
            YouScored.setText( "You Scored " + 30 );
            scoreOn = scoreOn + 30;
            TestAnswerStuff();
        } else if ( n == ImageYear + 6 || n == ImageYear - 6 ) {
            roundOn = roundOn + 1;
            YouScored.setText( "You Scored " + 40 );
            scoreOn = scoreOn + 40;
            TestAnswerStuff();
        } else if ( n == ImageYear + 5 || n == ImageYear - 5 ) {
            roundOn = roundOn + 1;
            YouScored.setText( "You Scored " + 50 );
            scoreOn = scoreOn + 50;
            TestAnswerStuff();
        } else if ( n == ImageYear + 4 || n == ImageYear - 4 ) {
            roundOn = roundOn + 1;
            YouScored.setText( "You Scored " + 60 );
            scoreOn = scoreOn + 60;
            TestAnswerStuff();
        } else if ( n == ImageYear + 3 || n == ImageYear - 3 ) {
            roundOn = roundOn + 1;
            YouScored.setText( "You Scored " + 70 );
            scoreOn = scoreOn + 70;
            TestAnswerStuff();
        } else if ( n == ImageYear + 2 || n == ImageYear - 2 ) {
            roundOn = roundOn + 1;
            YouScored.setText( "You Scored " + 80 );
            scoreOn = scoreOn + 80;
            TestAnswerStuff();
        } else if ( n == ImageYear + 1 || n == ImageYear - 1 ) {
            roundOn = roundOn + 1;
            YouScored.setText( "You Scored " + 90 );
            scoreOn = scoreOn + 90;
            TestAnswerStuff();
        } else if ( !( n == ImageYear ) ) {
            roundOn = roundOn + 1;
            YouScored.setText( "You Scored " + 0 );
            TestAnswerStuff();
        }
    }
    public void TestAnswerStuff() {
        int n = editText.getText().toString().equals( "" ) ? 0 : Integer.parseInt( editText.getText().toString() );
        TextView textView2 = ( TextView ) findViewById( R.id.txt_YourGuess );
        TextView textView3 = ( TextView ) findViewById( R.id.txt_CorrectAnswer );
        TextView textView = findViewById( R.id.txt_displaycorrectyear );
        TextView YouScored = findViewById( R.id.txt_YouScored );
        textView2.setText( "Your Guess:  " + n );
        YouScored.setVisibility( View.VISIBLE );
        editText.setVisibility( View.GONE );
        textView2.setVisibility( View.VISIBLE );
        textView.setVisibility( View.VISIBLE );
        textView3.setVisibility( View.VISIBLE );
        submitGuess.setVisibility( View.INVISIBLE );
        nextRound.setVisibility( View.VISIBLE );
        TextView doubleView = ( TextView ) findViewById( R.id.txt_displaycorrectyear );
        doubleView.setText( " " + ImageYear );
    }
    public void RandomQuestion() {
        if ( roundOn == 1 ) {
            int size = 5;
            ArrayList < Integer > list = new ArrayList < Integer > ( size );
            for ( int i = 1; i <= size; i++ ) {
                list.add( i );
            }
            Random rand = new Random();
            if ( list.size() > 0 ) {
                int index = rand.nextInt( list.size() );
                System.out.println( "INDEX SELECTED =   " + list.remove( index ) );
                mQuestionNumber = index + 1;
            }
        }
        if ( roundOn == 2 ) {
            int size = 5;
            ArrayList < Integer > list = new ArrayList < Integer > ( size );
            for ( int i = 1; i <= size; i++ ) {
                list.add( i );
            }
            Random rand = new Random();
            if ( list.size() > 0 ) {
                int index = rand.nextInt( list.size() );
                System.out.println( list.remove( index ) );
                mQuestionNumber = index + 6;
                System.out.println( mQuestionNumber );
            }
        }
        if ( roundOn == 3 ) {
            int size = 5;
            ArrayList < Integer > list = new ArrayList < Integer > ( size );
            for ( int i = 1; i <= size; i++ ) {
                list.add( i );
            }
            Random rand = new Random();
            if ( list.size() > 0 ) {
                int index = rand.nextInt( list.size() );
                System.out.println( list.remove( index ) );
                mQuestionNumber = index + 11;
                System.out.println( mQuestionNumber );
            }
        }
        if ( roundOn == 4 ) {
            int size = 5;
            ArrayList < Integer > list = new ArrayList < Integer > ( size );
            for ( int i = 1; i <= size; i++ ) {
                list.add( i );
            }
            Random rand = new Random();
            if ( list.size() > 0 ) {
                int index = rand.nextInt( list.size() );
                mQuestionNumber = index + 16;
                System.out.println( list.remove( index ) );
                System.out.println( mQuestionNumber );
            }
        }
        if ( roundOn == 5 ) {
            int size = 5;
            ArrayList < Integer > list = new ArrayList < Integer > ( size );
            for ( int i = 1; i <= size; i++ ) {
                list.add( i );
            }
            Random rand = new Random();
            if ( list.size() > 0 ) {
                int index = rand.nextInt( list.size() );
                mQuestionNumber = index + 21;
                System.out.println( list.remove( index ) );
                System.out.println( mQuestionNumber );
            }
        }
    }
    public void UpdateQuestion() {
        mQuestionRef = new Firebase( "https://retrieve-images-1c732.firebaseio.com/" + CategorySelect.mQuestionTopic + "/" + mQuestionNumber + "/image" );
        TextView textView2 = ( TextView ) findViewById( R.id.txt_YourGuess );
        TextView textView3 = ( TextView ) findViewById( R.id.txt_CorrectAnswer );
        TextView textView = findViewById( R.id.txt_displaycorrectyear );
        final PhotoView photoView = ( PhotoView ) findViewById( R.id.image );
        TextView YouScored = findViewById( R.id.txt_YouScored );
        photoView.setVisibility( View.VISIBLE );
        textView2.setVisibility( View.VISIBLE );
        editText.setVisibility( View.VISIBLE );
        textView.setVisibility( View.INVISIBLE );
        textView3.setVisibility( View.INVISIBLE );
        nextRound.setVisibility( View.INVISIBLE );
        YouScored.setVisibility( View.GONE );
        mQuestionRef.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot ) {
                String image = dataSnapshot.getValue( String.class );
                Glide.with( getApplicationContext() ).load( image ).into( photoView );
            }
            @Override
            public void onCancelled( FirebaseError firebaseError ) {}
        } );
        mYearRef = new Firebase( "https://retrieve-images-1c732.firebaseio.com/" + CategorySelect.mQuestionTopic + "/" + mQuestionNumber + "/correctyear" );
        mYearRef.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot ) {
                int YearSet = dataSnapshot.getValue( int.class );
                ImageYear = YearSet;
            }
            @Override
            public void onCancelled( FirebaseError firebaseError ) {}
        } );
    }
    @Override
    protected void onCreate( Bundle savedInstanceState ) {

        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        TextView doubleView = ( TextView ) findViewById( R.id.txt_displaycorrectyear );
        TextView Title = ( TextView ) findViewById( R.id.txt_PageTitle );
        editText = ( EditText ) findViewById( R.id.numberEnteredEt );
        submitGuess = ( Button ) findViewById( R.id.submitGuess );
        nextRound = ( Button ) findViewById( R.id.nextQuestion );
        final TextView textView2 = ( TextView ) findViewById( R.id.txt_YourGuess );
        TextView textView3 = ( TextView ) findViewById( R.id.txt_CorrectAnswer );
        TextView scoreView = ( TextView ) findViewById( R.id.txt_scoreOn );
        TextView roundView = findViewById( R.id.txt_roundOn );
        final ImageView imageView = findViewById( R.id.image );

        RandomQuestion();
        UpdateQuestion();
        editText.getText().clear();
        scoreView.setVisibility( View.VISIBLE );
        roundView.setVisibility( View.VISIBLE );
        scoreView.setText( "" + scoreOn );
        roundView.setText( "" + roundOn );
        submitGuess.setVisibility( View.VISIBLE );

        if ( roundOn == 1 && CategorySelect.mQuestionTopic == "History" ) {
            Title.setText( "History" );
        } else if ( roundOn == 1 && CategorySelect.mQuestionTopic == "IconicMoviePosters" ) {
            Title.setText( "Film Posters" );
        } else if ( roundOn == 1 && CategorySelect.mQuestionTopic == "AlbumCovers" ) {
            Title.setText( "Iconic Albums" );
        } else if ( roundOn == 1 && CategorySelect.mQuestionTopic == "HipHopAlbumCovers" ) {
            Title.setText( "Hip Hop" );
        } else if ( roundOn == 1 && CategorySelect.mQuestionTopic == "F1Podiums" ) {
            Title.setText( "Formula 1" );
        } else if ( roundOn == 1 && CategorySelect.mQuestionTopic == "UefaChampionsLeague" ) {
            Title.setText( "UEFA CL" );
        }
        editText.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                validate();
                editText.getText().clear();
                TextView scoreView = ( TextView ) findViewById( R.id.txt_scoreOn );
                scoreView.setText( "" + scoreOn );
            }
        } );
        submitGuess.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View view ) {
                validate();
                editText.getText().clear();
                TextView scoreView = ( TextView ) findViewById( R.id.txt_scoreOn );
                scoreView.setText( "" + scoreOn );
            }
        } );
        nextRound.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View view ) {
                if ( roundOn == 6 && CategorySelect.mQuestionTopic == "History" ) {
                    Intent intent = new Intent( getApplicationContext(), result.class );
                    intent.putExtra( "HISTORY_SCORE", scoreOn );
                    startActivity( intent );
                    submitGuess.setText( "Finish Game" );
                } else if ( roundOn == 6 && CategorySelect.mQuestionTopic == "IconicMoviePosters" ) {
                    Intent intent = new Intent( getApplicationContext(), result.class );
                    intent.putExtra( "FILM_SCORE", scoreOn );
                    startActivity( intent );
                    submitGuess.setText( "Finish Game" );
                } else if ( roundOn == 6 && CategorySelect.mQuestionTopic == "AlbumCovers" ) {
                    Intent intent = new Intent( getApplicationContext(), result.class );
                    intent.putExtra( "ALBUMS_SCORE", scoreOn );
                    startActivity( intent );
                    submitGuess.setText( "Finish Game" );
                } else if ( roundOn == 6 && CategorySelect.mQuestionTopic == "HipHopAlbumCovers" ) {
                    Intent intent = new Intent( getApplicationContext(), result.class );
                    intent.putExtra( "HIPHOP_SCORE", scoreOn );
                    startActivity( intent );
                    submitGuess.setText( "Finish Game" );
                } else if ( roundOn == 6 && CategorySelect.mQuestionTopic == "F1Podiums" ) {
                    Intent intent = new Intent( getApplicationContext(), result.class );
                    intent.putExtra( "F1PODIUMS_SCORE", scoreOn );
                    startActivity( intent );
                    submitGuess.setText( "Finish Game" );
                } else if ( roundOn == 6 && CategorySelect.mQuestionTopic == "UefaChampionsLeague" ) {
                    Intent intent = new Intent( getApplicationContext(), result.class );
                    intent.putExtra( "UEFACL_SCORE", scoreOn );
                    startActivity( intent );
                    submitGuess.setText( "Finish Game" );
                } else if ( roundOn == 5 ) {
                    RandomQuestion();
                    UpdateQuestion();
                    editText.getText().clear();
                    submitGuess.setVisibility( View.VISIBLE );
                    TextView roundView = findViewById( R.id.txt_roundOn );
                    roundView.setText( "" + roundOn );
                    textView2.setText( "Your Guess:" );
                    nextRound.setText( "Finish Game" );
                } else {
                    RandomQuestion();
                    UpdateQuestion();
                    editText.getText().clear();
                    submitGuess.setVisibility( View.VISIBLE );
                    TextView roundView = findViewById( R.id.txt_roundOn );
                    roundView.setText( "" + roundOn );
                    textView2.setText( "Your Guess:" );
                }
            }
        } );
    }
}