package com.example.laba1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox colorCheckBox = findViewById(R.id.checkBox);
        colorCheckBox.setOnClickListener(selectCheckBox);
        CheckBox boldCheckBox = findViewById(R.id.checkBox2);
        boldCheckBox.setOnClickListener(selectCheckBox);
        CheckBox italicCheckBox = findViewById(R.id.checkBox3);
        italicCheckBox.setOnClickListener(selectCheckBox);

    }

    public void onClick(View view)
    {
        TextView textView = findViewById(R.id.textView);
        Random random = new Random();
        int value = random.nextInt(100);
        textView.setText("Я насчитал " + value  + " ворон");
    }


View.OnClickListener selectCheckBox  = new View.OnClickListener() {

    @Override
    public void onClick(View view) {
        CheckBox colorCheckBox = findViewById(R.id.checkBox);
        CheckBox boldCheckBox = findViewById(R.id.checkBox2);
        CheckBox italicCheckBox = findViewById(R.id.checkBox3);
        TextView textView = findViewById(R.id.textView);

        if (colorCheckBox.isChecked()) {
            textView.setTextColor(Color.RED);
        }
        else {
            textView.setTextColor(Color.BLACK);
        }



        if (italicCheckBox.isChecked() && boldCheckBox.isChecked())
        {
            textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC));
        }
        else
        {
            if (boldCheckBox.isChecked()) {
                textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            }
            else if (italicCheckBox.isChecked())
            {
                textView.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
            }
            else
            {
                textView.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
            }
        }

    }
};

}