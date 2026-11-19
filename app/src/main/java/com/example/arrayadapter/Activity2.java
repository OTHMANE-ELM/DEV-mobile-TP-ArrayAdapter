package com.example.arrayadapter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    private ListView lvGenre;
    private final String[] genres = {"Femme", "Homme"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        setTitle("2. Votre genre");

        Intent recu = getIntent();
        String nom = recu.getStringExtra("nom");
        String prenom = recu.getStringExtra("prenom");

        lvGenre = findViewById(R.id.lvGenre);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_single_choice,
                genres);
        lvGenre.setAdapter(adapter);
        lvGenre.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lvGenre.setItemChecked(0, true);

        ((Button) findViewById(R.id.btnPrecedent)).setOnClickListener(v -> finish());

        ((Button) findViewById(R.id.btnSuivant)).setOnClickListener(v -> {
            String genre = genres[lvGenre.getCheckedItemPosition()];
            Intent intent = new Intent(this, Activity3.class);
            intent.putExtra("nom", nom);
            intent.putExtra("prenom", prenom);
            intent.putExtra("genre", genre);
            startActivity(intent);
        });
    }
}