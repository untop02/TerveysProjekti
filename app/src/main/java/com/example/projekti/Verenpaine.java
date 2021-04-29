package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Verenpaine extends AppCompatActivity {

    int ylaArvo;
    int alaArvo;
    TextView verenpaineKentta;
    Button laskeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verenpaine);

        verenpaineKentta = findViewById(R.id.tvVerenpaine);
        laskeBtn = findViewById(R.id.laskeBtn);

        laskeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                laskeVerenpaine();
            }
        });

    }

    public void laskeVerenpaine() {
        if (ylaArvo >= 140 && alaArvo >= 90) {
            verenpaineKentta.setText("Verenpaineesi on koholla.");
        } else {
            verenpaineKentta.setText("Verenpaineesi on normaali.");
        }
    }

}