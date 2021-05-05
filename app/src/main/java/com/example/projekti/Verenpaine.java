package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//Tekijä Sylvester Salo
public class Verenpaine extends AppCompatActivity {

    TextView verenpaineKentta, verenpaineInfo;
    Button laskeBtn;
    EditText ylaArvo, alaArvo;
    String matalaVpInfo, ihanteellinenVpInfo, normaaliVpInfo, tyydyttavaVpInfo, korkeaVpInfo,
            matalaVp, ihanteellinenVp, normaaliVp, tyydyttavaVp, korkeaVp, ylaRaja, alaRaja;

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

        //Verenpaineteksti
        matalaVp = getString(R.string.matala_vp);
        ihanteellinenVp = getString(R.string.ihanteellinen_vp);
        normaaliVp = getString(R.string.normaali_vp);
        tyydyttavaVp = getString(R.string.tyydyttava_vp);
        korkeaVp = getString(R.string.koholla_vp);

        //Lisätietoja verenpaineen eri tasoille
        matalaVpInfo = getString(R.string.matala_vp_info);
        ihanteellinenVpInfo = getString(R.string.ihanteellinen_vp_info);
        normaaliVpInfo = getString(R.string.normaali_vp_info);
        tyydyttavaVpInfo = getString(R.string.tyydyttava_vp_info);
        korkeaVpInfo = getString(R.string.koholla_vp_info);
        ylaRaja = getString(R.string.Ylä_raja);
        alaRaja = getString(R.string.Ala_raja);


        //Napin painallus hakee arvot tekstikentistä ja kertoo verenpaineen tason ehtojen mukaisesti
        laskeBtn.setOnClickListener(v -> {
            try {
                int yla = Integer.parseInt(ylaArvo.getText().toString());
                int ala = Integer.parseInt(alaArvo.getText().toString());

                if (yla >= 140 && yla <= 200 && ala >= 90 && ala <= 150) {
                    verenpaineKentta.setText(korkeaVp);
                    verenpaineInfo.setText(korkeaVpInfo);
                } else if (yla >= 130 && yla <= 139 && ala >= 85 && ala <= 89) {
                    verenpaineKentta.setText(tyydyttavaVp);
                    verenpaineInfo.setText(tyydyttavaVpInfo);
                } else if (yla <= 130 && yla >= 120 && ala <= 85 && ala >= 80) {
                    verenpaineKentta.setText(normaaliVp);
                    verenpaineInfo.setText(normaaliVpInfo);
                } else if (yla <= 120 && yla >= 100 && ala <= 80 && ala >= 60) {
                    verenpaineKentta.setText(ihanteellinenVp);
                    verenpaineInfo.setText(ihanteellinenVpInfo);
                } else if (yla <= 100 && yla >= 50 && ala <= 60 && ala >= 40) {
                    verenpaineKentta.setText(matalaVp);
                    verenpaineInfo.setText(matalaVpInfo);
                } else if (yla >= 200 || ala >= 150) {
                    verenpaineKentta.setText(ylaRaja);
                    verenpaineInfo.setText("");
                } else if (yla <= 50 || ala <= 30) {
                    verenpaineKentta.setText(alaRaja);
                    verenpaineInfo.setText("");
                }
            } catch (NumberFormatException exception) {
                Toast.makeText(getApplicationContext(), "Täytä kentät", Toast.LENGTH_SHORT).show();
            }
        });

    }


}

