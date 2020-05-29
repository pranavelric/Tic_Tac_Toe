package com.example.tictaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String player1="",player2="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i =getIntent();
        player1=i.getStringExtra("playerr1");
        player2=i.getStringExtra("playerr2");
        System.out.println(player1+player2);
    }

    //Player reprasentation
    //0=x
    //1 =o
    //

    boolean gameActive =true;
    int activePlayer =0;
    int gameState[]={2,2,2,2,2,2,2,2,2};
    //state meaning 0=x,1=o,2=null
    int [][]winPos = {{0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
    };

    public void playerTap(View view){
        TextView    status ;

        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            gameReset(view);
        }
        if(gameState[tappedImage]==2){
            gameState[tappedImage]=activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer==0){
                img.setImageResource(R.drawable.x);
                activePlayer=1;
                status =(TextView)findViewById(R.id.status);
                   status.setText(player1+" O's turn :tap to play");

            }
            else{
                img.setImageResource(R.drawable.o);
                activePlayer=0;
                status =(TextView)findViewById(R.id.status);
                status.setText(player2+" X's turn :tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);

        }
//check if any
        String winner="";
      for(int [] winPos:winPos){
          if(gameState[winPos[0]]==gameState[winPos[1]]&&gameState[winPos[2]]==gameState[winPos[1]]&&gameState[winPos[0]]!=2){
              //someone won

              gameActive=false;
              if(gameState[winPos[0]]==0){
                  winner = player2+" X has won";
              }
              else{
                  winner = player1+" O has won";
              }
              status =(TextView)findViewById(R.id.status);
              status.setText(winner+" Click to start again");
              status.setOnClickListener(
                      new View.OnClickListener() {
                          @Override
                          public void onClick(View v) {
                              gameReset(v);
                          }
                      }
              );

          }

      }
      boolean draw = true;
      for(int i=0;i<gameState.length;i++)
      {
          if(gameState[i]==2){
              draw=false;
          break;
          }

      }
      if(draw==true&&winner==""){
          status =(TextView)findViewById(R.id.status);
          status.setText("DRAW: Click to start again ");
          status.setOnClickListener(
                  new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          gameReset(v);
                      }
                  }
          );


      }


    }

    public void gameReset(View view){
        gameActive=true;
        activePlayer = 0;
        for(int i=0;i<gameState.length;i++)
            gameState[i]=2;

        ((ImageView )findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView )findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView )findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView )findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView )findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView )findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView )findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView )findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView )findViewById(R.id.imageView8)).setImageResource(0);

    Intent j = new Intent(this.getApplicationContext(),Main2Activity.class);
    startActivity(j);

    }



}
