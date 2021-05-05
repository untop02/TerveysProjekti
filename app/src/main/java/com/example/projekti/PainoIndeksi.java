package com.example.projekti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PainoIndeksi extends AppCompatActivity {


    private static final String KEY = "painoAvain";

    public static final String SHARED_PREFS = "sharedPrefs";

    int w;
    double h;
    String stringBmi = "";
    TextView tv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paino_indeksi);

        Button b = (Button) findViewById(R.id.laske);
        EditText paino = (EditText) findViewById(R.id.Paino);
        EditText pituus = (EditText) findViewById(R.id.Pituus);
         tv = (TextView) findViewById(R.id.textView);


            //Kuuntelija laske napille
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //yritetään laskea
                try{
                    w = Integer.parseInt(paino.getText().toString());
                    h = Double.parseDouble(pituus.getText().toString())/100;

                    double bmi = w/(h*h);
                    double roundDbl = Math.round(bmi*100.0)/100.0;
                    stringBmi = Double.toString(roundDbl);

                    //if lausekkeet eri painoindeksiarvoille.
                    if(bmi<18.5){
                        //painoindeksiluokan textView vaihtuu painoindeksiarvon perusteella, jos painoindeksi on alhainen tulostetaan alipainoinen, jos korkea ylipainoinen, jne...
                        tv.setText("Paino indeksisi on "+stringBmi +" tämä määritellään alipainoiseksi.");

                    }
                    if(bmi>=18.5 && bmi <= 24.9){
                        tv.setText("Paino indeksisi on "+stringBmi +" tämä on terve painoindeksi.");

                    }
                    if(bmi > 25){
                        tv.setText("Paino indeksisi on "+stringBmi +" tämä määritellään ylipainoiseksi.");

                    }
                    //jos yritys epäonnistuu "toastataan" käyttäjälle teksti jossa lukee "Täytä kentät".
                    //laskuyritys epäonnistuu jos kentät eivät ole täynnä.
                }catch (NumberFormatException exception) {
                    Toast.makeText(getApplicationContext(), "Täytä kentät", Toast.LENGTH_SHORT).show();
                }




            }

        });

    }


    //sovelluksen käynnistyessä käydään nämä läpi.
    @Override
    protected void onStart()
    {
        super.onStart();
        //kutsutaan loadData metodi.
        loadData();
        //kirjoitetaan logiin onStartin kutsumisesta.
        Log.d(null, "onStart() kutsuttu");
    }

    //sovelluksesta poislähtiestä suoritetaan onPause.
    @Override
    protected void onPause() {
        super.onPause();

        //suoritetaan saveData eli tallennusmetodi.
        saveData();

    }
    //saveData eli tallennusmetodi hakee painoindeksiluokan textviewin sisällön ja tallentaa tämän sharedPrefssiin.
   public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY, tv.getText().toString());
        editor.apply();
    }

    //loadData eli latausmetodi lataa tiedot textViewiin sharedPrefsistä.
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String text = sharedPreferences.getString(KEY, "");
        TextView tv = findViewById(R.id.textView);
        tv.setText(text);
    }

}