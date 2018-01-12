package com.example.giada.app_colonnine;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class login_activity1 extends AppCompatActivity {
    // Costanti
    private final static String TAG = "Login";
    // Widget
    private EditText mUsername;
    private EditText mPassword;
    private Button btnLogin;
    private ProgressBar mProgress;

    // Firebase
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Imposto gli attributi relativi ai widget
        mUsername = (EditText)findViewById(R.id.editUsername);
        mPassword = (EditText)findViewById(R.id.editPassw);
        btnLogin = (Button)findViewById(R.id.Button);
        mProgress = (ProgressBar)findViewById(R.id.progressBar);

        // Impostazione Firebase
        mAuth = FirebaseAuth.getInstance();

        // Imposto il listener per il pulsante
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUsername.getText().toString();
                String password = mPassword.getText().toString();
                if (username.isEmpty())
                    mUsername.setError(getString(R.string.obbligatorio));
                else if (password.isEmpty())
                    mPassword.setError(getString(R.string.obbligatorio));
                else
                    effettuaLogin(username, password);
            }
        });
    }

    /**
     * Funzione che prova ed effettuare il login
     * @param username indirizzo di email
     * @param password password
     */
    private void effettuaLogin(String username, String password) {

        mProgress.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        mProgress.setVisibility(View.INVISIBLE);
                        Log.d(TAG, "Task completato: successo = " + task.isSuccessful());
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(login_activity1.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(login_activity1.this, R.string.errore_login, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}











