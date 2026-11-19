package com.example.arrayadapter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arrayadapter.Activity2;
import com.example.arrayadapter.R;

public class Activity1 extends AppCompatActivity {

    private EditText etNom, etPrenom;
    private Button btnSuivant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        setTitle("1. Vos informations");

        etNom = findViewById(R.id.etNom);
        etPrenom = findViewById(R.id.etPrenom);
        btnSuivant = findViewById(R.id.btnSuivant);

        btnSuivant.setOnClickListener(v -> {
            String nom = etNom.getText().toString().trim();
            String prenom = etPrenom.getText().toString().trim();

            if (nom.isEmpty()) { etNom.setError("Nom obligatoire"); return; }
            if (prenom.isEmpty()) { etPrenom.setError("Prénom obligatoire"); return; }

            Intent intent = new Intent(Activity1.this, Activity2.class);
            intent.putExtra("nom", nom);
            intent.putExtra("prenom", prenom);
            startActivity(intent);
        });
    }
}