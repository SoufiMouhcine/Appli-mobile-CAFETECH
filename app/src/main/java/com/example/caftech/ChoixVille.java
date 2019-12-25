package com.example.caftech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChoixVille extends AppCompatActivity {
    Button media;
    Button rabat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_ville);

        media=(Button)findViewById(R.id.bt_media);
        rabat=(Button)findViewById(R.id.bt_rabat);

        media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cafeMedia=new Intent(ChoixVille.this,CafeMedia.class);
                startActivity(cafeMedia);
            }
        });
    }
}
