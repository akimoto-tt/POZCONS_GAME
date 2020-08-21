package com.example.pozcons_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;


    public void startGame(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}
