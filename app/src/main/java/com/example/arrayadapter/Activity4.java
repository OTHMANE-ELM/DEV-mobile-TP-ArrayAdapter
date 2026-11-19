package com.example.arrayadapter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        setTitle("4. Récapitulatif");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Lecture de toutes les données reçues
        Intent recu = getIntent();
        String nom = recu.getStringExtra("nom");
        String prenom = recu.getStringExtra("prenom");
        String genre = recu.getStringExtra("genre");
        ArrayList<String> loisirs = recu.getStringArrayListExtra("loisirs");

        // Affichage
        ((TextView) findViewById(R.id.tvNom)).setText("Nom : " + nom);
        ((TextView) findViewById(R.id.tvPrenom)).setText("Prénom : " + prenom);
        ((TextView) findViewById(R.id.tvGenre)).setText("Genre : " + genre);

        StringBuilder sb = new StringBuilder("Loisirs sélectionnés :\n");
        for (String l : loisirs) {
            sb.append("  • ").append(l).append("\n");
        }
        ((TextView) findViewById(R.id.tvLoisirs)).setText(sb.toString());

        // Terminer : ferme toute l'application
        ((Button) findViewById(R.id.btnTerminer)).setOnClickListener(v -> finishAffinity());
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
