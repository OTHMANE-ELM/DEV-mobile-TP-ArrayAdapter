package com.example.arrayadapter;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arrayadapter.R;

import java.util.ArrayList;

public class Activity3 extends AppCompatActivity {

    private ListView lvLoisirs;
    private final String[] loisirs =
            {"Sport", "Lecture", "Musique", "Voyage", "Cinéma", "Jeux vidéo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        setTitle("3. Vos loisirs");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent recu = getIntent();
        String nom = recu.getStringExtra("nom");
        String prenom = recu.getStringExtra("prenom");
        String genre = recu.getStringExtra("genre");

        lvLoisirs = findViewById(R.id.lvLoisirs);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_multiple_choice, // cases à cocher
                loisirs);
        lvLoisirs.setAdapter(adapter);
        lvLoisirs.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);   // plusieurs choix

        ((Button) findViewById(R.id.btnPrecedent)).setOnClickListener(v -> finish());

        ((Button) findViewById(R.id.btnSuivant)).setOnClickListener(v -> {
            // Récupérer toutes les cases cochées
            SparseBooleanArray coches = lvLoisirs.getCheckedItemPositions();
            ArrayList<String> selection = new ArrayList<>();
            for (int i = 0; i < loisirs.length; i++) {
                if (coches.get(i)) {            // true si la ligne i est cochée
                    selection.add(loisirs[i]);
                }
            }

            Intent intent = new Intent(this, Activity4.class);
            intent.putExtra("nom", nom);
            intent.putExtra("prenom", prenom);
            intent.putExtra("genre", genre);
            intent.putStringArrayListExtra("loisirs", selection); // une liste dans l'Intent
            startActivity(intent);
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}