package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PainoIndeksi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paino_indeksi);

        Button b = (Button) findViewById(R.id.laske);
        EditText paino = (EditText) findViewById(R.id.Paino);
        EditText pituus = (EditText) findViewById(R.id.Pituus);
        TextView tv = (TextView) findViewById(R.id.textView);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    int w = Integer.parseInt(paino.getText().toString());
                    double h = Double.parseDouble(pituus.getText().toString())/100;

                    double bmi = w/(h*h);
                    double roundDbl = Math.round(bmi*100.0)/100.0;
                    String stringBmi = Double.toString(roundDbl);
                    if(bmi<18.5){
                        tv.setText("Paino indeksisi on "+stringBmi +" tämä määritellään alipainoiseksi.");

                    }
                    if(bmi>=18.5 && bmi <= 24.9){
                        tv.setText("Paino indeksisi on "+stringBmi +" tämä on terve painoindeksi.");

                    }
                    if(bmi > 25){
                        tv.setText("Paino indeksisi on "+stringBmi +" tämä määritellään ylipainoiseksi.");

                    }
                }catch (NumberFormatException exception) {
                    Toast.makeText(getApplicationContext(), "Täytä kentät", Toast.LENGTH_SHORT).show();
                }




            }
        });
    }

}