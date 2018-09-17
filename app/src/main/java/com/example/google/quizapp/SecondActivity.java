package com.example.google.quizapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private TextView question ;
    private RadioGroup answers;
    private Button nextBtn;
    private Button backBtn;
    private TextView score;
    private  int counter =0;
    private int scoreCounter =0;

    public static String QUESTIONONE = "What is 1+1";
    public static String ANSWERONEQ1 = "8";
    public static String ANSWERTWOQ1 = "1";
    public static String ANSWERTHREEQ1 = "3";
    public static String ANSWERFOURQ1 = "2";

    public static String QUESTIONTWO = "What's plus sign";
    public static String ANSWERONEQ2 = "+";
    public static String ANSWERTWOQ2 = "%";
    public static String ANSWERTHREEQ2 = "-";
    public static String ANSWERFOURQ2 = "/";


    public static String QUESTIONTHREE = "What's my name";
    public static String ANSWERONEQ3 = "Ali";
    public static String ANSWERTWOQ3 = "Abdusalam";
    public static String ANSWERTHREEQ3 = "Khaild";
    public static String ANSWERFOURQ3 = "Mohammed";


    public static String QUESTIONFOUR = "QU is refer to";
    public static String ANSWERONEQ4 = "Quails U ";
    public static String ANSWERTWOQ4 = "Quick using ";
    public static String ANSWERTHREEQ4 = "Qatar University";
    public static String ANSWERFOURQ4 = "Quail Unit";

    public static String SCORE ="Score";







    private RadioButton radioButton1 , radioButton2, radioButton3, radioButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //sending data into LAST ACTIVITY



        //score counter
        score=findViewById(R.id.conuter_score_TV);



        //question and answers declaration
        final String d[]= {QUESTIONONE,QUESTIONTWO,QUESTIONTHREE,QUESTIONFOUR};
        final String answerArray1[]={ANSWERONEQ1,ANSWERONEQ2,ANSWERONEQ3,ANSWERONEQ4};
        final String answerArray2[]={ANSWERTWOQ1,ANSWERTWOQ2,ANSWERTWOQ3,ANSWERTWOQ4};
        final String answerArray3[]={ANSWERTHREEQ1,ANSWERTHREEQ2,ANSWERTHREEQ3,ANSWERTHREEQ4};
        final String answerArray4[]={ANSWERFOURQ1,ANSWERFOURQ2,ANSWERFOURQ3,ANSWERFOURQ4};


        //Text view for question
        question = (TextView) findViewById(R.id.question_TV);
        question.setText(d[0]);


        //Radio group of answers and its listener
        answers=findViewById(R.id.raido_group);


        //concted var radio with btn in xml
        radioButton1 = findViewById(R.id.frist_Rbtn);
        radioButton2 = findViewById(R.id.secnd_Rbtn);
        radioButton3 = findViewById(R.id.thrid_Rbtn);
        radioButton4 = findViewById(R.id.four_Rbtn);

        // to show the value initial
        radioButton1.setText(answerArray1[0]);
        radioButton2.setText(answerArray2[0]);
        radioButton3.setText(answerArray3[0]);
        radioButton4.setText(answerArray4[0]);

        //score
        score=findViewById(R.id.conuter_score_TV);
        score.setText(scoreCounter+"");




       //next button
        nextBtn = findViewById(R.id.next_btn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backBtn.setVisibility(View.VISIBLE);


                radioButton1.setChecked(false);
                radioButton2.setChecked(false);
                radioButton3.setChecked(false);
                radioButton4.setChecked(false);

                int selectedId = answers.getCheckedRadioButtonId();
                switch (counter){
                    case 0:
                        if (selectedId==radioButton4.getId()) {
                            Toast.makeText(getApplicationContext(), "Good Job", Toast.LENGTH_SHORT).show();
                            scoreCounter++;
                            score.setText(scoreCounter+"");

                        }
                        else
                            Toast.makeText(getApplicationContext(),"Wrong Answer",Toast.LENGTH_SHORT).show();
                        ;break;
                    case 1:if (selectedId==radioButton1.getId()) {
                        Toast.makeText(getApplicationContext(), "Good Job", Toast.LENGTH_SHORT).show();
                        scoreCounter++;

                    }
                    else
                        Toast.makeText(getApplicationContext(),"Wrong Answer",Toast.LENGTH_SHORT).show();
                        ;break;
                    case 2:if (selectedId==radioButton2.getId()) {
                        Toast.makeText(getApplicationContext(), "Good Job", Toast.LENGTH_SHORT).show();
                        scoreCounter++;
                    }
                    else
                        Toast.makeText(getApplicationContext(),"Wrong Answer",Toast.LENGTH_SHORT).show();
                        ;break;
                    case 3:if (selectedId==radioButton3.getId()) {
                        Toast.makeText(getApplicationContext(), "Good Job", Toast.LENGTH_SHORT).show();
                        scoreCounter++;
                    }
                    else
                        Toast.makeText(getApplicationContext(),"Wrong Answer",Toast.LENGTH_SHORT).show();
                        ;break;


                }

                counter++;
                //arrays length
                if (counter<d.length) {
                    radioButton1.setText(answerArray1[counter]);
                    radioButton2.setText(answerArray2[counter]);
                    radioButton3.setText(answerArray3[counter]);
                    radioButton4.setText(answerArray4[counter]);
                    question.setText(d[counter]);
                }
                if (counter  >=4){
                    radioButton1.setEnabled(false);
                    radioButton2.setEnabled(false);
                    radioButton3.setEnabled(false);
                    radioButton4.setEnabled(false);
                }

                score.setText(scoreCounter+"");
                if (counter  >=4){
                    backBtn.setVisibility(View.INVISIBLE);
                    nextBtn.setText("Finish Quiz");



                }


                if (counter  == 5) {
                 Intent intent1 = new Intent(SecondActivity.this, LastActivity.class);

                 Bundle bundle=new Bundle();
                 bundle.putInt(SCORE,scoreCounter);
                 intent1.putExtras(bundle);
                 startActivity(intent1);
            }
            }
        });



        backBtn = findViewById(R.id.back_btn);
        backBtn.setVisibility(View.INVISIBLE);



        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter  ==1)
                    backBtn.setVisibility(View.INVISIBLE);
                    scoreCounter--;

                    counter--;

                    if (counter >= 0) {
                        question.setText(d[counter]);
                        radioButton1.setText(answerArray1[counter]);
                        radioButton2.setText(answerArray2[counter]);
                        radioButton3.setText(answerArray3[counter]);
                        radioButton4.setText(answerArray4[counter]);

                    }
                    if (counter < 0) {
                        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                        startActivity(intent);
                    }

                }

        });






    }


}
