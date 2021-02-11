package com.britishbroadcast.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mainTextView;

    private int number = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainTextView = findViewById(R.id.solution_textview);
        mainTextView.setText(number+"");

    }

    public void onClick(View view){

        switch (view.getId()){
            case R.id.one_button:
                if(number > 0)
                    number = Integer.parseInt(mainTextView.getText().toString() + 1);
                else
                    number = 1;
                mainTextView.setText(number+"");
                break;


        }


    }
}