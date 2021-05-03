package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Verenpaine extends AppCompatActivity {

    TextView verenpaineKentta, verenpaineInfo;
    Button laskeBtn;
    EditText ylaArvo, alaArvo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verenpaine);

        //Elementtien haku XML-layoutista
        verenpaineKentta = findViewById(R.id.tvVerenpaine);
        verenpaineInfo = findViewById(R.id.tvVerenpaineInfo);
        laskeBtn = findViewById(R.id.laskeBtn);
        ylaArvo = findViewById(R.id.ylaArvo);
        alaArvo = findViewById(R.id.alaArvo);

        //Lisätietoja verenpaineen eri tasoille
        String matalaVp = ("Verenpaine on matala, jos se on alle 100/60 mmHg.");
        String ihanteellinenVp = ("Verenpaine on ihanteellinen, kun se on alle 120/80 mmHg");
        String normaaliVp = ("Verenpaine on normaali, kun se on alle 130/85 mmHg.");
        String tyydyttavaVp = ("Verenpaine on tyydyttävä, kun se on 130-139/ 85-89 mmHg välillä.");
        String korkeaVp = ("Verenpaine on koholla, kun se on yli 140/90 mmHg.");


        //Lisätään alla tehty toiminnallisuus napin sallimiselle
        ylaArvo.addTextChangedListener(onkoTyhja);
        alaArvo.addTextChangedListener(onkoTyhja);

        //Napin painallus hakee arvot tekstikentistä ja kertoo verenpaineen tason ehtojen mukaisesti
        laskeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int yla = Integer.parseInt(ylaArvo.getText().toString());
                int ala = Integer.parseInt(alaArvo.getText().toString());

                if (yla >= 140 && ala >= 90) {
                    verenpaineKentta.setText("Verenpaineesi on koholla.");
                    verenpaineInfo.setText(korkeaVp);
                } else if (yla >= 130 && yla <= 139 && ala >= 85 && ala <= 89) {
                    verenpaineKentta.setText("Verenpaineesi on tyydyttävä.");
                    verenpaineInfo.setText(tyydyttavaVp);
                } else if (yla <= 130 && ala <= 85 && ala >= 79) {
                    verenpaineKentta.setText("Verenpaineesi on normaali.");
                    verenpaineInfo.setText(normaaliVp);
                } else if (yla <= 120 && ala <= 80 && ala >= 60) {
                    verenpaineKentta.setText("Verenpaineesi on ihanteellinen.");
                    verenpaineInfo.setText(ihanteellinenVp);
                } else if (yla <= 100 && ala <= 60 && ala >= 40) {
                    verenpaineKentta.setText("Verenpaineesi on matala.");
                    verenpaineInfo.setText(matalaVp);
                } else if (yla >= 200 || ala >= 150) {
                    verenpaineKentta.setText("Yli rajojen.");
                    verenpaineInfo.setText("");
                } else if (yla <= 50 || ala <= 30) {
                    verenpaineKentta.setText("Alle rajojen.");
                    verenpaineInfo.setText("");
                }
            }
        });

    }

    //Sallii nappulan, jos tekstikenttä ei ole tyhjä
    private TextWatcher onkoTyhja = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            if (ylaArvo.toString().trim().equals("")) {
                laskeBtn.setEnabled(false);
            } else {
                laskeBtn.setEnabled(true);
            }
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


}

