package com.example.google.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LastActivity extends AppCompatActivity {
    private TextView scoreTV;
    private ImageView winerImageViwe;
    private ImageView loserImageViwe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        Bundle bundle = getIntent().getExtras();
        int score= (int) bundle.get(SecondActivity.SCORE);

        scoreTV=findViewById(R.id.score_btn);
        scoreTV.setText(score+"/4");
        winerImageViwe=findViewById(R.id.winer_IV);
        loserImageViwe=findViewById(R.id.loser_IV);
        if (score>2)
             loserImageViwe.setVisibility(View.INVISIBLE);
        else
            winerImageViwe.setVisibility(View.INVISIBLE);


    }
}