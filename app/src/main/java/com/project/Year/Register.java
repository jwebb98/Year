package com.project.Year;
import android.content.Intent;
import android.support.annotation.NonNull;
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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
public class Register extends AppCompatActivity {
    EditText iUsername, iEmailAddress, iUserPassword;
    Button bRegisterAccount;
    TextView bLoginScreen;
    ProgressBar pProgressBar;
    FirebaseAuth fAuth;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register); //Define the Items that will show on screen when this intent is started.
        iUsername = findViewById( R.id.inputName);
        iEmailAddress = findViewById( R.id.inputEmailAddress);
        iUserPassword = findViewById( R.id.inputPassword);
        bRegisterAccount = findViewById( R.id.btnRegisterNewAccount);
        bLoginScreen = findViewById( R.id.btnRegisterPage);
        pProgressBar = findViewById( R.id.widgetProgressBar);
        fAuth = FirebaseAuth.getInstance(); //Enables the sign in features to make use of Firebase authentication
        //Checks if user is Signed in on current device
        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainMenu.class));
            finish();
        }
        bRegisterAccount.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                String EmailAddress = iEmailAddress.getText().toString().trim();
                String UserPassword = iUserPassword.getText().toString().trim();
                // "Email" field is empty
                if (TextUtils.isEmpty(EmailAddress)) {
                    iEmailAddress.setError("A Email Address is Required");
                    return;
                } // "Password" field is empty
                if (TextUtils.isEmpty(UserPassword)) {
                    iUserPassword.setError("A Password is Required");
                    return;
                } // "Password" is not long enough to be considered secure
                if (UserPassword.length() < 6) {
                    iUserPassword.setError("Password must be 7 characters minimum");
                    return;
                }
                pProgressBar.setVisibility(View.VISIBLE);
                //Creates user account with details provided, Ensures completeness with backend
                fAuth.createUserWithEmailAndPassword(EmailAddress, UserPassword).addOnCompleteListener(new OnCompleteListener < AuthResult > () {
                    @Override public void onComplete(@NonNull Task < AuthResult > task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Register.this, "User Account Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainMenu.class));
                        } else {
                            Toast.makeText(Register.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        // Lets the user go on the login screen as they have already created a account
        bLoginScreen.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });
    }
}