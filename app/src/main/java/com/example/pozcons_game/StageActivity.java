package com.example.pozcons_game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.Button;


//それぞれのidを設定**/
        Button button1=(Button)findViewById(R.id.button1);
                Button button2=(Button)findViewById(R.id.button2);
                //ボタンが押されたらonClickが動作するよう設定**/
                button1.setOnClickListener(this);
                button2.setOnClickListener(this);
                }

//ボタンが押された時の処理**/
public void onClick(View v){
        switch(v.getId()){

        case R.id.button1:
public void startGame(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        break;

        case R.id.button2:
public void startGame(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity2.class));
        }
        break;

}
