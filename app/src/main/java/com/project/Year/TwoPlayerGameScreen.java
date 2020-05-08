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
import java.util.Random;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.github.chrisbanes.photoview.PhotoView;
import com.bumptech.glide.Glide;
public class TwoPlayerGameScreen extends AppCompatActivity {

    Button nextRound;
    EditText editText;
    EditText editText2;
    Button submitGuess;
    Button submitGuess2;
    Firebase mQuestionRef, mYearRef;
    int mQuestionNumber = 1;
    static int scoreOn = 0;
    int roundOn = 1;
    static int scoreOnPlayer2 = 0;
    static int ImageYear = 0;

    public void validate() {
        int n = editText.getText().toString().equals( "" ) ? 0 : Integer.parseInt( editText.getText().toString() );
        TextView textView2 = ( TextView ) findViewById( R.id.txt_YourGuess );
        TextView textView3 = ( TextView ) findViewById( R.id.txt_CorrectAnswer );
        TextView textView = findViewById( R.id.txt_displaycorrectyear );
        TextView YouScored = findViewById( R.id.txt_YouScored );
        if ( n == ImageYear ) {
            scoreOn = scoreOn + 100;
            YouScored.setText( "Player 1 Scored: " + 100 );
            Player2Question();
        }
        if ( !( n == ImageYear ) && n > 2020 || n < 1 ) {
            Toast.makeText( this, "Please enter a year between '1-2020'", Toast.LENGTH_SHORT ).show();
        } else if ( n == ImageYear + 9 || n == ImageYear - 9 ) {
            YouScored.setText( "Player 1 Scored: " + 10 );
            scoreOn = scoreOn + 10;
            Player2Question();
        } else if ( n == ImageYear + 8 || n == ImageYear - 8 ) {
            YouScored.setText( "Player 1 Scored: " + 20 );
            scoreOn = scoreOn + 20;
            Player2Question();
        } else if ( n == ImageYear + 7 || n == ImageYear - 7 ) {
            YouScored.setText( "Player 1 Scored: " + 30 );
            scoreOn = scoreOn + 30;
            Player2Question();
        } else if ( n == ImageYear + 6 || n == ImageYear - 6 ) {
            YouScored.setText( "Player 1 Scored: " + 40 );
            scoreOn = scoreOn + 40;
            Player2Question();
        } else if ( n == ImageYear + 5 || n == ImageYear - 5 ) {
            YouScored.setText( "Player 1 Scored: " + 50 );
            scoreOn = scoreOn + 50;
            Player2Question();
        } else if ( n == ImageYear + 4 || n == ImageYear - 4 ) {
            YouScored.setText( "Player 1 Scored: " + 60 );
            scoreOn = scoreOn + 60;
            Player2Question();
        } else if ( n == ImageYear + 3 || n == ImageYear - 3 ) {
            YouScored.setText( "Player 1 Scored: " + 70 );
            scoreOn = scoreOn + 70;
            Player2Question();
        } else if ( n == ImageYear + 2 || n == ImageYear - 2 ) {
            YouScored.setText( "Player 1 Scored: " + 80 );
            scoreOn = scoreOn + 80;
            Player2Question();
        } else if ( n == ImageYear + 1 || n == ImageYear - 1 ) {
            YouScored.setText( "Player 1 Scored: " + 90 );
            scoreOn = scoreOn + 90;
            Player2Question();
        } else if ( !( n == ImageYear ) ) {
            YouScored.setText( "Player 1 Scored: " + 0 );
            Player2Question();
        }
    }
    public void validate2() {
        int n2 = editText2.getText().toString().equals( "" ) ? 0 : Integer.parseInt( editText2.getText().toString() );
        TextView textView2 = ( TextView ) findViewById( R.id.txt_YourGuess );
        TextView textView3 = ( TextView ) findViewById( R.id.txt_CorrectAnswer );
        TextView textView = findViewById( R.id.txt_displaycorrectyear );
        TextView YouScored2 = findViewById( R.id.txt_YouScored2 );
        submitGuess2 = ( Button ) findViewById( R.id.submitGuess2 );
        submitGuess = ( Button ) findViewById( R.id.submitGuess );
        if ( n2 == ImageYear ) {
            roundOn = roundOn + 1;
            scoreOnPlayer2 = scoreOnPlayer2 + 100;
            YouScored2.setText( "  Player 2 Scored: " + 100 );
            TestAnswerStuff();
        }
        if ( !( n2 == ImageYear ) && n2 > 2020 || n2 < 1 ) {
            Toast.makeText( this, "Please enter a year between '1-2020'", Toast.LENGTH_SHORT ).show();
        } else if ( n2 == ImageYear + 9 || n2 == ImageYear - 9 ) {
            roundOn = roundOn + 1;
            YouScored2.setText( "  Player 2 Scored: " + 10 );
            scoreOnPlayer2 = scoreOnPlayer2 + 10;
            TestAnswerStuff();
        } else if ( n2 == ImageYear + 8 || n2 == ImageYear - 8 ) {
            roundOn = roundOn + 1;
            YouScored2.setText( "  Player 2 Scored: " + 20 );
            scoreOnPlayer2 = scoreOnPlayer2 + 20;
            TestAnswerStuff();
        } else if ( n2 == ImageYear + 7 || n2 == ImageYear - 7 ) {
            roundOn = roundOn + 1;
            YouScored2.setText( "  Player 2 Scored: " + 30 );
            scoreOnPlayer2 = scoreOnPlayer2 + 30;
            TestAnswerStuff();
        } else if ( n2 == ImageYear + 6 || n2 == ImageYear - 6 ) {
            roundOn = roundOn + 1;
            YouScored2.setText( "  Player 2 Scored: " + 40 );
            scoreOnPlayer2 = scoreOnPlayer2 + 40;
            TestAnswerStuff();
        } else if ( n2 == ImageYear + 5 || n2 == ImageYear - 5 ) {
            roundOn = roundOn + 1;
            YouScored2.setText( "  Player 2 Scored: " + 50 );
            scoreOnPlayer2 = scoreOnPlayer2 + 50;
            TestAnswerStuff();
        } else if ( n2 == ImageYear + 4 || n2 == ImageYear - 4 ) {
            roundOn = roundOn + 1;
            YouScored2.setText( "  Player 2 Scored: " + 60 );
            scoreOnPlayer2 = scoreOnPlayer2 + 60;
            TestAnswerStuff();
        } else if ( n2 == ImageYear + 3 || n2 == ImageYear - 3 ) {
            roundOn = roundOn + 1;
            YouScored2.setText( "  Player 2 Scored: " + 70 );
            scoreOnPlayer2 = scoreOnPlayer2 + 70;
            TestAnswerStuff();
        } else if ( n2 == ImageYear + 2 || n2 == ImageYear - 2 ) {
            roundOn = roundOn + 1;
            YouScored2.setText( "  Player 2 Scored: " + 80 );
            scoreOnPlayer2 = scoreOnPlayer2 + 80;
            TestAnswerStuff();
        } else if ( n2 == ImageYear + 1 || n2 == ImageYear - 1 ) {
            roundOn = roundOn + 1;
            YouScored2.setText( "  Player 2 Scored: " + 90 );
            scoreOnPlayer2 = scoreOnPlayer2 + 90;
            TestAnswerStuff();
        } else if ( !( n2 == ImageYear ) ) {
            roundOn = roundOn + 1;
            YouScored2.setText( "  Player 2 Scored: " + 0 );
            TestAnswerStuff();
        }
    }
    public void TestAnswerStuff() {
        int n = editText.getText().toString().equals( "" ) ? 0 : Integer.parseInt( editText.getText().toString() );
        int n2 = editText2.getText().toString().equals( "" ) ? 0 : Integer.parseInt( editText2.getText().toString() );
        TextView textView2 = ( TextView ) findViewById( R.id.txt_YourGuess );
        TextView textView3 = ( TextView ) findViewById( R.id.txt_CorrectAnswer );
        TextView textView = findViewById( R.id.txt_displaycorrectyear );
        TextView YouScored = findViewById( R.id.txt_YouScored );
        TextView YouScored2 = findViewById( R.id.txt_YouScored2 );
        TextView scoreView = ( TextView ) findViewById( R.id.txt_scoreOn );
        TextView scoreView2 = ( TextView ) findViewById( R.id.txt_scoreOn2 );
        textView2.setText( "Player 1:  " + n + "  Player 2:  " + n2 );
        YouScored.setVisibility( View.VISIBLE );
        YouScored2.setVisibility( View.VISIBLE );
        editText.setVisibility( View.GONE );
        editText2.setVisibility( View.GONE );
        textView2.setVisibility( View.VISIBLE );
        textView.setVisibility( View.VISIBLE );
        textView3.setVisibility( View.VISIBLE );
        submitGuess.setVisibility( View.GONE );
        submitGuess2.setVisibility( View.GONE );
        nextRound.setVisibility( View.VISIBLE );
        scoreView.setVisibility( View.VISIBLE );
        scoreView2.setVisibility( View.VISIBLE );
        TextView doubleView = ( TextView ) findViewById( R.id.txt_displaycorrectyear );
        doubleView.setText( " " + ImageYear );
    }
    public void Player2Question() {
        TextView textView2 = ( TextView ) findViewById( R.id.txt_YourGuess );
        TextView textView3 = ( TextView ) findViewById( R.id.txt_CorrectAnswer );
        TextView textView = findViewById( R.id.txt_displaycorrectyear );
        final PhotoView photoView = ( PhotoView ) findViewById( R.id.image );
        TextView YouScored = findViewById( R.id.txt_YouScored );
        TextView YouScored2 = findViewById( R.id.txt_YouScored2 );
        TextView scoreView = ( TextView ) findViewById( R.id.txt_scoreOn );
        TextView scoreView2 = ( TextView ) findViewById( R.id.txt_scoreOn2 );
        textView2.setText( "Player 2 Guess: " );
        scoreView.setVisibility( View.INVISIBLE );
        scoreView2.setVisibility( View.INVISIBLE );
        photoView.setVisibility( View.VISIBLE );
        textView2.setVisibility( View.VISIBLE );
        editText.setVisibility( View.GONE );
        editText2.setVisibility( View.VISIBLE );
        textView.setVisibility( View.INVISIBLE );
        textView3.setVisibility( View.INVISIBLE );
        nextRound.setVisibility( View.INVISIBLE );
        submitGuess.setVisibility( View.GONE );
        submitGuess2.setVisibility( View.VISIBLE );
        YouScored.setVisibility( View.GONE );
        YouScored2.setVisibility( View.GONE );
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
                System.out.println( list.remove( index ) );
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
        mQuestionRef = new Firebase( "https://retrieve-images-1c732.firebaseio.com/" + TwoPlayerCategoryScreen.mQuestionTopic + "/" + mQuestionNumber + "/image" );
        TextView textView2 = ( TextView ) findViewById( R.id.txt_YourGuess );
        TextView textView3 = ( TextView ) findViewById( R.id.txt_CorrectAnswer );
        TextView textView = findViewById( R.id.txt_displaycorrectyear );
        final PhotoView photoView = ( PhotoView ) findViewById( R.id.image );
        TextView YouScored = findViewById( R.id.txt_YouScored );
        TextView YouScored2 = findViewById( R.id.txt_YouScored2 );
        photoView.setVisibility( View.VISIBLE );
        textView2.setVisibility( View.VISIBLE );
        editText.setVisibility( View.VISIBLE );
        textView.setVisibility( View.INVISIBLE );
        textView3.setVisibility( View.INVISIBLE );
        nextRound.setVisibility( View.INVISIBLE );
        YouScored.setVisibility( View.GONE );
        YouScored2.setVisibility( View.GONE );
        mQuestionRef.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot ) {
                String image = dataSnapshot.getValue( String.class );
                Glide.with( getApplicationContext() ).load( image ).into( photoView );
            }
            @Override
            public void onCancelled( FirebaseError firebaseError ) {}
        } );
        mYearRef = new Firebase( "https://retrieve-images-1c732.firebaseio.com/" + TwoPlayerCategoryScreen.mQuestionTopic + "/" + mQuestionNumber + "/correctyear" );
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
        setContentView( R.layout.activity_two_player_game_screen );
        TextView doubleView = ( TextView ) findViewById( R.id.txt_displaycorrectyear );
        editText = ( EditText ) findViewById( R.id.numberEnteredEt );
        editText2 = ( EditText ) findViewById( R.id.numberEnteredEtPlayer2 );
        submitGuess = ( Button ) findViewById( R.id.submitGuess );
        submitGuess2 = ( Button ) findViewById( R.id.submitGuess2 );
        nextRound = ( Button ) findViewById( R.id.nextQuestion );

        final TextView textView2 = ( TextView ) findViewById( R.id.txt_YourGuess );
        TextView textView3 = ( TextView ) findViewById( R.id.txt_CorrectAnswer );
        TextView scoreView = ( TextView ) findViewById( R.id.txt_scoreOn );
        TextView scoreView2 = ( TextView ) findViewById( R.id.txt_scoreOn2 );
        TextView roundView = findViewById( R.id.txt_roundOn );
        final ImageView imageView = findViewById( R.id.image );

        RandomQuestion();
        UpdateQuestion();
        scoreOn = 0;
        scoreOnPlayer2 = 0;
        editText.getText().clear();
        editText2.getText().clear();

        scoreView.setVisibility( View.VISIBLE );
        roundView.setVisibility( View.VISIBLE );
        scoreView.setText( "Player 1 Score: " + scoreOn );
        scoreView2.setText( "Player 2 Score: " + scoreOnPlayer2 );
        roundView.setText( "Round: " + roundOn );
        submitGuess.setVisibility( View.VISIBLE );
        editText.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                validate();
                TextView scoreView = ( TextView ) findViewById( R.id.txt_scoreOn );
                scoreView.setText( "Player 1 Score: " + scoreOn );
            }
        } );
        editText2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                validate2();
                editText2.getText().clear();
                TextView scoreView2 = ( TextView ) findViewById( R.id.txt_scoreOn2 );
                scoreView2.setText( "Player 2 Score: " + scoreOnPlayer2 );
            }
        } );
        submitGuess.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View view ) {
                validate();
                TextView scoreView = ( TextView ) findViewById( R.id.txt_scoreOn );
                scoreView.setText( "Player 1 Score: " + scoreOn );
            }
        } );
        submitGuess2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View view ) {
                validate2();
                editText2.getText().clear();
                TextView scoreView2 = ( TextView ) findViewById( R.id.txt_scoreOn2 );
                scoreView2.setText( "Player 2 Score: " + scoreOnPlayer2 );
            }
        } );
        nextRound.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View view ) {
                if ( roundOn == 6 && TwoPlayerCategoryScreen.mQuestionTopic == "History" ) {
                    Intent intent = new Intent( getApplicationContext(), TwoPlayerResultScreen.class );
                    startActivity( intent );
                    submitGuess.setText( "Finish Game" );
                } else if ( roundOn == 6 && TwoPlayerCategoryScreen.mQuestionTopic == "IconicMoviePosters" ) {
                    Intent intent = new Intent( getApplicationContext(), TwoPlayerResultScreen.class );
                    startActivity( intent );
                    submitGuess.setText( "Finish Game" );
                } else if ( roundOn == 6 && TwoPlayerCategoryScreen.mQuestionTopic == "AlbumCovers" ) {
                    Intent intent = new Intent( getApplicationContext(), TwoPlayerResultScreen.class );
                    startActivity( intent );
                    submitGuess.setText( "Finish Game" );
                } else if ( roundOn == 6 && TwoPlayerCategoryScreen.mQuestionTopic == "HipHopAlbumCovers" ) {
                    Intent intent = new Intent( getApplicationContext(), TwoPlayerResultScreen.class );
                    startActivity( intent );
                    submitGuess.setText( "Finish Game" );
                } else if ( roundOn == 6 && TwoPlayerCategoryScreen.mQuestionTopic == "F1Podiums" ) {
                    Intent intent = new Intent( getApplicationContext(), TwoPlayerResultScreen.class );
                    startActivity( intent );
                    submitGuess.setText( "Finish Game" );
                } else if ( roundOn == 6 && TwoPlayerCategoryScreen.mQuestionTopic == "UefaChampionsLeague" ) {
                    Intent intent = new Intent( getApplicationContext(), TwoPlayerResultScreen.class );
                    startActivity( intent );
                    submitGuess.setText( "Finish Game" );
                } else if ( roundOn == 5 ) {
                    RandomQuestion();
                    UpdateQuestion();
                    editText.getText().clear();
                    editText2.getText().clear();
                    submitGuess.setVisibility( View.VISIBLE );
                    TextView roundView = findViewById( R.id.txt_roundOn );
                    roundView.setText( "Round: " + roundOn );
                    textView2.setText( "Player 1 Guess:" );
                    nextRound.setText( "Finish Game" );
                } else {
                    RandomQuestion();
                    UpdateQuestion();
                    editText.getText().clear();
                    editText2.getText().clear();
                    submitGuess.setVisibility( View.VISIBLE );
                    TextView roundView = findViewById( R.id.txt_roundOn );
                    roundView.setText( "Round: " + roundOn );
                    textView2.setText( "Player 1 Guess: " );
                }
            }
        } );
    }
}