package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Verenpaine extends AppCompatActivity {

    TextView verenpaineKentta, verenpaineInfo;
    Button laskeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verenpaine);

        verenpaineKentta = findViewById(R.id.tvVerenpaine);
        verenpaineInfo = findViewById(R.id.tvVerenpaineInfo);
        laskeBtn = findViewById(R.id.laskeBtn);
        EditText ylaArvo = findViewById(R.id.ylaArvo);
        EditText alaArvo = findViewById(R.id.alaArvo);

        String normaaliVp = ("Verenpaine on normaali, kun se on alle 130/85 mmHg.");
        String tyydyttavaVp = ("Verenpaine on tyydyttävä, kun se on 130-139/ 85-89 mmHg välillä.");
        String korkeaVp = ("Verenpaine on koholla, kun se on yli 140/90 mmHg.");
        String tyhja = ("");

        laskeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int yla = Integer.parseInt(ylaArvo.getText().toString());
                int ala = Integer.parseInt(alaArvo.getText().toString());

                if (yla >= 139 && ala >= 89) {
                    verenpaineKentta.setText("Verenpaineesi on koholla.");
                    verenpaineInfo.setText(korkeaVp);
                } else if(yla >= 129 && yla <= 139 && ala >= 85 && ala <= 89) {
                    verenpaineKentta.setText("Verenpaineesi on tyydyttävä.");
                    verenpaineInfo.setText(tyydyttavaVp);
                } else if(yla <= 130 && ala <= 85) {
                    verenpaineKentta.setText("Verenpaineesi on normaali.");
                    verenpaineInfo.setText(normaaliVp);
                } else if (yla >= 159 || yla <= 99 || ala >= 119 || ala <= 69) {
                    verenpaineKentta.setText("Anna sopiva luku.");
                    verenpaineInfo.setText(tyhja);
                }
            }
        });

    }


}

