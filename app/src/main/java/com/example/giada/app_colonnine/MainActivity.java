package com.example.giada.app_colonnine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.ClipData;
        import android.content.Intent;
        import android.support.annotation.NonNull;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    // Costanti
    private final static String EXTRA_COLONNINE = "colonnine";
    private final static String TAG = "AppColonnine";

    // Widget
    private ListView listaColonnine;


    // Adapter
    private ColonninaAdapter adapter;


    // Autenticazione Firebase
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getResources().getStringArray(R.array.supporti);


        // Autenticazione Firebase
        mAuth = FirebaseAuth.getInstance();

        // Comportamento differenziato
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null) {
            // Utente non autenticato, voglio impedire l'accesso
            Intent intent = new Intent(this, login.class);
            startActivity(intent);
        } else {
            // Utente autenticato.
            // Nessuna operazione richiesta
        }





    Colonnina c = new Colonnina();
        c.setIndirizzogenerico("viale Europa");
        c.setGestore("Enel");
    }
        //c.setSupporto(TipoSupporto.values());




}