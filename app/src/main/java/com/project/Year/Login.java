package com.project.Year;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
public class Login extends AppCompatActivity {
    EditText iEmailAddress, iUserPassword;
    Button bLoginBtn;
    TextView bCreateScreenBtn, bForgotTextLinkBtn;
    ProgressBar pProgressBar;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        //Elements that are shown on screen when intent is started
        setContentView( R.layout.activity_login );
        iEmailAddress = findViewById( R.id.inputEmailAddress );
        iUserPassword = findViewById( R.id.inputPassword );
        bLoginBtn = findViewById( R.id.btnRegisterPage );
        bCreateScreenBtn = findViewById( R.id.CreateBtn );
        fAuth = FirebaseAuth.getInstance();
        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainMenu.class));
            finish();
        }
        pProgressBar = findViewById( R.id.widgetProgressBar );
        bForgotTextLinkBtn = findViewById( R.id.forgotPassword );
        bLoginBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View view ) {
                String email = iEmailAddress.getText().toString().trim();
                String password = iUserPassword.getText().toString().trim();
                // "Email" field is empty
                if ( TextUtils.isEmpty( email ) ) {
                    iEmailAddress.setError( "Email is Required" );
                    return;
                }
                // "Password" field is empty
                if ( TextUtils.isEmpty( password ) ) {
                    iUserPassword.setError( "Email is Required" );
                    return;
                }
                // "Password" is not long enough to be considered secure
                if ( password.length() < 6 ) {
                    iUserPassword.setError( "Password must be 7 characters minimum" );
                    return;
                }
                pProgressBar.setVisibility( View.VISIBLE );
                //Authenticates user with the Email and Password provided
                fAuth.signInWithEmailAndPassword( email, password ).addOnCompleteListener( new OnCompleteListener < AuthResult > () {
                    @Override
                    public void onComplete( @NonNull Task < AuthResult > task ) {
                        if ( task.isSuccessful() ) {
                            Toast.makeText( Login.this, "Logged in Successfully", Toast.LENGTH_SHORT ).show();
                            startActivity( new Intent( getApplicationContext(), MainMenu.class ) );
                        } else {
                            Toast.makeText( Login.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT ).show();
                        }
                    }
                } );
            }
        } );
        // Return to the register page if you have not created a account yet.
        bCreateScreenBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View view ) {
                startActivity( new Intent( getApplicationContext(), Register.class ) );
            }
        } );
        //Button allows you to reset your password if you forget it
        bForgotTextLinkBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View view ) {
                final EditText resetMail = new EditText( view.getContext() );
                final AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder( view.getContext() );
                passwordResetDialog.setTitle( "Reset Password ?" );
                passwordResetDialog.setMessage( "Please enter your Email to be sent Password Reset link" );
                passwordResetDialog.setView( resetMail );
                passwordResetDialog.setPositiveButton( "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick( DialogInterface dialogInterface, int which ) {
                        String mail = resetMail.getText().toString();
                        fAuth.sendPasswordResetEmail( mail ).addOnSuccessListener( new OnSuccessListener < Void > () {
                            @Override
                            public void onSuccess( Void aVoid ) {
                                Toast.makeText( Login.this, "Reset link has been been sent to your requested Email Address.",
                                        Toast.LENGTH_SHORT ).show(); // successful password reset
                            }
                        } ).addOnFailureListener( new OnFailureListener() {
                            @Override
                            public void onFailure( @NonNull Exception e ) {
                                Toast.makeText( Login.this, "Error ! Reset Link has not been sent"
                                        + e.getMessage(), Toast.LENGTH_SHORT ).show(); // unsuccessful password reset
                            }
                        } );
                    }
                } );
                passwordResetDialog.setNegativeButton( "No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick( DialogInterface dialogInterface, int i ) {}
                } );
                passwordResetDialog.create().show();
            }
        } );
    }
}