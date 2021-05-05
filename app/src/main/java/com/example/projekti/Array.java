package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Array extends AppCompatActivity {

    private static final String TAG = "";
    public ArrayList<String> painoindeksi = new ArrayList<>();

    private static final String KEY = "avain";

    public static final String SHARED_PREFS = "sharedPrefs";

    private String paino;



    public Array(){
        paino = "0";
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array);


        //luodaan arrayadapter
        ListView lv = (ListView) findViewById(R.id.Painoindeksilista);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, painoindeksi);
        lv.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();

        for(int i = 0; painoindeksi.size()>i; i++){
            arrayAdapter.add(painoindeksi.get(i));
            Log.d(null, (painoindeksi.get(i)));
        }



    }





public String returnPaino(){
        return this.paino;
}
    public void muutaPaino (String value){
        this.paino = value;

        painoindeksi.add(paino);
        for(int i=0; painoindeksi.size() > i; i++){
            Log.d(null, Integer.toString(i));
        }



    }
    protected void onPause() {
        super.onPause();

       // saveData();

    }


 /*   public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        for(int i = 0; i < painoindeksi.size(); i++){
            editor.putString(KEY, painoindeksi[i]);
        }

        editor.apply();
    }

  */
}