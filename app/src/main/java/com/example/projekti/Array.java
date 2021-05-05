package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class Array extends AppCompatActivity {

    private static final String TAG = "";
    ArrayList<Integer> painoindeksi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array);

        painoindeksi = new ArrayList<>();

        painoindeksi.add(19);
        painoindeksi.add(52);
        painoindeksi.add(12);
        painoindeksi.add(77);

        for (int i = 0; i < painoindeksi.size(); i++){
            Log.d(TAG, "onCreate: name " + painoindeksi.get(i));
        }
    }
}