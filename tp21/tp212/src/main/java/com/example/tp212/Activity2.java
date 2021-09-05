package com.example.tp212;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    EditText txtInput;
    TextView txtOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        txtInput = findViewById(R.id.txtInput);
        String text = getIntent().getStringExtra("Message");

        txtOutput = findViewById(R.id.txtOutput);

        txtOutput.setText(text);
    }
}