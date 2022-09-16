package com.example.car_emi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText t1,t2,t3,t4;
    Button btn;
    TextView E;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.emiCalcBtn);
        btn.setOnClickListener(this::onClick);
        t1 = findViewById(R.id.principalAmount);
        t2 = findViewById(R.id.interestRate);
        t3 = findViewById(R.id.downPayment);
        t4 = findViewById(R.id.loanTerm);
        E = findViewById(R.id.result);
    }
    public void onClick(View v) {
        double p, r, n, d, emi;
        p = Double.parseDouble(t1.getText().toString());
        d = Double.parseDouble(t3.getText().toString());
        p = p - d;
        r = Double.parseDouble(t2.getText().toString());
        r = r / (12 * 100);
        n = Double.parseDouble(t4.getText().toString());
        emi = p * (r * Math.pow((1 + r), n))/ (Math.pow((1 + r), n) - 1);
        E.setText(" "+emi);
    }
}