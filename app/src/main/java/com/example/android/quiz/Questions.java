package com.example.android.quiz;


public class Questions {

    public String mQuestion[] = {
            "which of these are bears?",
            "Which of these are the effect of smoking?",
            "Whats the currency of Saudi Arabia?",
            "What is the color of a red traffic light ?",
            "10 Fishes in a Tank: 1 died 3 swam away 2 drown, how many left in the tank?",
            "What do you call your mothers brother?"
    };

    private String mChoices[][] = {
            {"Panda", "Grizzly", "Baboon", "Beaver"},
            {"cuts suicide risk", "Poor vision", "Immune system", " lower cancer risk"},
            {"ALL", "SDG", "QAR", "SAR"},
            {"Red", "Blue", "Yellow", "Green"}
    };



    public String getQuestion (int n){
        return mQuestion [n];
    }



    public String getFirstChoice (int n){
        return mChoices [n][0];
    }

    public String getSecondChoice (int n){
        return mChoices [n][1];
    }

    public String getThirdChoice(int n){
        return mChoices [n][2];
    }

    public String getForthChoice (int n){
        return mChoices [n][3];
    }


}
