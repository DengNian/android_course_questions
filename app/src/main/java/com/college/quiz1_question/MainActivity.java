package com.college.quiz1_question;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int mCounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //counterView is the TextView that displays the value of the counter
        TextView counterView = findViewById(R.id.counterId);

        //TODO
        // Your code goes here

        Button btn_reset=findViewById(R.id.buttonResetId);
        Button btn_increment=findViewById(R.id.buttonIncId);
        Button btn_decrement=findViewById(R.id.buttonDecId);
        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter=0;
                counterView.setText(String.valueOf(mCounter));//update TextView
            }
        });

        btn_increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter +=1;
                counterView.setText(String.valueOf(mCounter));
            }
        });

        btn_decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCounter >0){
                    mCounter -=1;
                    counterView.setText(String.valueOf(mCounter));
                }
            }
        });


    }
}