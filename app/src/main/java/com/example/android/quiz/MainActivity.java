package com.example.android.quiz;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.quiz.R.id.checkBox1;
import static com.example.android.quiz.R.id.radioButton1;
import static com.example.android.quiz.R.id.radioButton3;
import static com.example.android.quiz.R.id.radioButton4;

public class MainActivity extends AppCompatActivity {

    CheckBox multiAnswer1, multiAnswer2, multiAnswer3, multiAnswer4;
    RadioButton choice1, choice2, choice3, choice4;
    RadioGroup radioGroup;
    Button start, next;
    TextView questionField;
    EditText textAnswerField;

    int CheckedRadio;
    int score = 0;
    int wrongAnswers = 0;
    int QuestionNumber = 0;
    boolean result ;

    private Questions mQuestions = new Questions();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //check boxes
        multiAnswer1 = (CheckBox) findViewById(checkBox1);
        multiAnswer2 = (CheckBox) findViewById(R.id.checkBox2);
        multiAnswer3 = (CheckBox) findViewById(R.id.checkBox3);
        multiAnswer4 = (CheckBox) findViewById(R.id.checkBox4);

        //radio buttons and group
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        choice1 = (RadioButton) findViewById(R.id.radioButton1);
        choice2 = (RadioButton) findViewById(R.id.radioButton2);
        choice3 = (RadioButton) findViewById(radioButton3);
        choice4 = (RadioButton) findViewById(radioButton4);

        //TextAnswer
        textAnswerField = (EditText) findViewById(R.id.textAnswer);

        //mainly shows the questions but can show some messages
        questionField = (TextView) findViewById(R.id.question);

        // START the Quiz, gets the NEXT question and   reSTART the Quiz a gain
        start = (Button) findViewById(R.id.start);
        next = (Button) findViewById(R.id.next);
    }

    // this method updates the questions and make the right way to answer appear
    public void updateQuestions (){

        questionField.setText(mQuestions.getQuestion(QuestionNumber));

        // for checkbox questions
        if (QuestionNumber ==0 || QuestionNumber == 1 ){

            //clear checked boxes
            multiAnswer1.setChecked(false);
            multiAnswer2.setChecked(false);
            multiAnswer3.setChecked(false);
            multiAnswer4.setChecked(false);

            // write the possible choices
            multiAnswer1.setText(mQuestions.getFirstChoice(QuestionNumber));
            multiAnswer2.setText(mQuestions.getSecondChoice(QuestionNumber));
            multiAnswer3.setText(mQuestions.getThirdChoice(QuestionNumber));
            multiAnswer4.setText(mQuestions.getForthChoice(QuestionNumber));

            // make the answers appear
            multiAnswer1.setVisibility(View.VISIBLE);
            multiAnswer2.setVisibility(View.VISIBLE);
            multiAnswer3.setVisibility(View.VISIBLE);
            multiAnswer4.setVisibility(View.VISIBLE);


        }

        // for radio button questions
        else if (QuestionNumber == 2 ){

            //clear checked boxes
            radioGroup.clearCheck();


            // write the possible choices
            choice1.setText(mQuestions.getFirstChoice(QuestionNumber));
            choice2.setText(mQuestions.getSecondChoice(QuestionNumber));
            choice3.setText(mQuestions.getThirdChoice(QuestionNumber));
            choice4.setText(mQuestions.getForthChoice(QuestionNumber));

            // make the answers appear
            radioGroup.setVisibility(View.VISIBLE);

        }
        else if (QuestionNumber == 3){
            choice1.setTextColor(Color.parseColor("#4CAF50"));
            choice2.setTextColor(Color.parseColor("#FFEB3B"));
            choice3.setTextColor(Color.parseColor("#D32F2F"));
            choice4.setTextColor(Color.parseColor("#2196F3"));

            radioGroup.clearCheck();


            choice1.setText(mQuestions.getFirstChoice(QuestionNumber));
            choice2.setText(mQuestions.getSecondChoice(QuestionNumber));
            choice3.setText(mQuestions.getThirdChoice(QuestionNumber));
            choice4.setText(mQuestions.getForthChoice(QuestionNumber));
        }
        // for written text questions
        else{
            textAnswerField.setVisibility(View.VISIBLE);
        }



    }
    // this method checks if the answer is correct
    public boolean CheckAnswer (){
        // For check boxes
        boolean checkBox1Value = multiAnswer1.isChecked();
        boolean checkBox2Value = multiAnswer2.isChecked();
        boolean checkBox3Value = multiAnswer3.isChecked();
        boolean checkBox4Value = multiAnswer4.isChecked();


        switch (QuestionNumber) {


            case 0:
                if (checkBox1Value && checkBox2Value && !checkBox3Value && !checkBox4Value)
                    result = true;
                else
                    result = false;
                break;


            case 1:
                if (!checkBox1Value && checkBox2Value && checkBox3Value && !checkBox4Value)
                    result = true;
                else
                    result = false;


                break;


            case 2:
                CheckedRadio = radioGroup.getCheckedRadioButtonId();
                if (CheckedRadio == radioButton4)
                    result = true;
                else
                    result = false;
                break;

            case 3:
                CheckedRadio = radioGroup.getCheckedRadioButtonId();
                if (CheckedRadio == radioButton1)
                    result = true;
                else
                    result = false;


                choice1.setTextColor(Color.parseColor("#000000"));
                choice2.setTextColor(Color.parseColor("#000000"));
                choice3.setTextColor(Color.parseColor("#000000"));
                choice4.setTextColor(Color.parseColor("#000000"));

                break;

            case 4:
                String TextAnswer = textAnswerField.getText().toString();
                if (TextAnswer.compareToIgnoreCase("10") == 0)
                    result = true;
                else
                    result = false;

                textAnswerField.setText("");

                break;

            case 5:
                 TextAnswer = textAnswerField.getText().toString();
                if (TextAnswer.compareToIgnoreCase("uncle") == 0)
                    result = true;
                else
                    result = false;


                textAnswerField.setText("");

                break;


        }
        return result;
    }


    // This method starts the Quiz and restart it
    public void Start (View view){

        updateQuestions();

        start.setVisibility(View.GONE);
        start.setText("Restart");
        next.setVisibility(View.VISIBLE);



    }


    //This method checks the answer,calculate the score and gives next question
    public void Next (View view){
        switch (QuestionNumber){
            case 0:
                if (CheckAnswer())
                    score += 10;
                else
                    wrongAnswers++;
                QuestionNumber++;
                updateQuestions();
                break;


            case 1:
                if (CheckAnswer())
                    score += 10;
                else
                    wrongAnswers++;

                QuestionNumber++;
                updateQuestions();


                multiAnswer1.setVisibility(View.GONE);
                multiAnswer2.setVisibility(View.GONE);
                multiAnswer3.setVisibility(View.GONE);
                multiAnswer4.setVisibility(View.GONE);

                break;


            case 2:

                if (CheckAnswer())
                    score += 10;
                else
                    wrongAnswers++;

                QuestionNumber++;
                updateQuestions();

                break;

            case 3:
                if (CheckAnswer())
                    score += 10;
                else
                    wrongAnswers++;

                QuestionNumber++;
                updateQuestions();


                radioGroup.setVisibility(View.GONE);
                break;


            case 4:
                if (CheckAnswer())
                    score += 10;
                else
                    wrongAnswers++;

                QuestionNumber++;
                updateQuestions();
                next.setText("Get the final score");

                break;

            case 5:
                if (CheckAnswer())
                    score += 10;
                else
                    wrongAnswers++;


                Toast.makeText(this, "score: " + score + " / wrong answers:" + wrongAnswers, Toast.LENGTH_LONG).show();


                //finish this Quiz (ready to restart)
                textAnswerField.setVisibility(View.GONE);
                questionField.setText("Do you want to start again?");
                QuestionNumber = 0;
                score = 0;
                wrongAnswers = 0;

                //restart
                next.setVisibility(View.GONE);
                next.setText("next");
                start.setVisibility(View.VISIBLE);

                break;



        }


    }

}
