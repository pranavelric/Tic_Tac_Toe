package com.example.tictaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {




    public void start(View view){
        EditText player1 = (EditText)findViewById(R.id.player1);
        EditText player2 = (EditText)findViewById(R.id.player2);
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
       //System.out.println("fdlskfjdkajflkdajflkf"+player1.getText()+" "+player2.getText());

        i.putExtra("playerr1",player1.getText().toString());
        i.putExtra("playerr2",player2.getText().toString());

        player1.setText("");
        player2.setText("");
        view.getContext().startActivity(i);
        //tartActivity(i);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}
