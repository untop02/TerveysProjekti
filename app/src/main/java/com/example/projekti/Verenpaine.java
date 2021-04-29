package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Verenpaine extends AppCompatActivity {


    TextView verenpaineKentta;
    Button laskeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verenpaine);

        verenpaineKentta = findViewById(R.id.tvVerenpaine);
        laskeBtn = findViewById(R.id.laskeBtn);
        EditText ylaArvo = findViewById(R.id.ylaArvo);
        EditText alaArvo = findViewById(R.id.alaArvo);


        laskeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int yla = Integer.parseInt(ylaArvo.getText().toString());
                int ala = Integer.parseInt(alaArvo.getText().toString());

                if (yla >= 140 && ala > 90) {
                    verenpaineKentta.setText("Verenpaineesi on koholla.");
                } else {
                    verenpaineKentta.setText("Verenpaineesi on nomaali");
                }
            }
        });

    }


}

