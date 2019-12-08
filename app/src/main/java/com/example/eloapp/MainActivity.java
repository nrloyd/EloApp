package com.example.eloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private EditText elo1;
    private EditText elo2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeDisplayContent();
    }

    private void initializeDisplayContent() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        elo1 = findViewById(R.id.elo1);
        elo2 = findViewById(R.id.elo2);
        textView = findViewById(R.id.textView);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int elo1int = Integer.parseInt((elo1.getText().toString()));
                int elo2int = Integer.parseInt((elo2.getText().toString()));
                int result = Calculator.result(elo1int, elo2int, 0,
                        40.0, true, 0);

                elo1.setText(Integer.toString(elo1int + result));
                elo2.setText(Integer.toString(elo2int - result));
                textView.setText("Change in elo: " + Integer.toString(result));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int elo1int = Integer.parseInt((elo1.getText().toString()));
                int elo2int = Integer.parseInt((elo2.getText().toString()));
                int result = Calculator.result(elo1int, elo2int, 0,
                        40.0, false, 0);

                elo1.setText(Integer.toString(elo1int + result));
                elo2.setText(Integer.toString(elo2int - result));
                textView.setText("Change in elo: " + Integer.toString(result));
            }
        });
    }
}
