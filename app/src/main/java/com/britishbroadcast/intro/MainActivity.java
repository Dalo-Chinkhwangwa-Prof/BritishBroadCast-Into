package com.britishbroadcast.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    private TextView mainTextView;

    private long number = 0;
    private long secondNumber = 0;
    private Map<String, Integer> arithmeticMap = new HashMap<String, Integer>(){{
        put("+", 0);
        put("-", 1);
        put("/", 2);
        put("x", 3);
    }};
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTextView = findViewById(R.id.solution_textview);
        mainTextView.setText(number + "");

    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.one_button:
                concatNumber(1);
                break;
            case R.id.two_button:
                concatNumber(2);
                break;
            case R.id.three_button:
                concatNumber(3);
                break;
            case R.id.four_button:
                concatNumber(4);
                break;
            case R.id.five_button:
                concatNumber(5);
                break;
            case R.id.six_button:
                concatNumber(6);
                break;
            case R.id.seven_button:
                concatNumber(7);
                break;
            case R.id.eight_button:
                concatNumber(8);
                break;
            case R.id.nine_button:
                concatNumber(9);
                break;
            case R.id.zero_button:
                concatNumber(0);
                break;
            case R.id.addition_button:
                initCalculation("+");
                break;
            case R.id.subtraction_button:
                initCalculation("-");
                break;
            case R.id.division_button:
                initCalculation("/");
                break;
            case R.id.multiplication_button:
                initCalculation("x");
                break;
            case R.id.cancel_button:
                number = 0;
                mainTextView.setText("0");
                break;
            case R.id.equals_button:
                calculateValue();
                break;
        }
    }

    private void initCalculation(String s) {
        if(!operator.isEmpty())
            calculateValue();
        else {
            mainTextView.setText("0");
            secondNumber = number;
            number = 0;
        }
        operator = s;
    }

    private void calculateValue() {

        long solution = 0;
        switch (arithmeticMap.get(operator)){
            case 0://addition
                solution = number + secondNumber;
                break;
            case 1://subtraction
                solution = secondNumber - number;
                break;
            case 2://division
                solution = (secondNumber/number);
                break;
            case 3://multiplication
                solution = (secondNumber * number);
                break;
        }
        secondNumber = 0;
        number = 0;
        mainTextView.setText(String.valueOf(solution));
    }

    private void concatNumber(int add) {

        StringBuilder sBuilder = new StringBuilder();
        String value = sBuilder.append(number).append(add).toString();
        if (value.length() < 19)
            number = Long.parseLong(value);
        else//show a message using a toast
            Toast.makeText(this, "Number too big!", Toast.LENGTH_SHORT).show();
        mainTextView.setText(String.valueOf(number));
    }
}