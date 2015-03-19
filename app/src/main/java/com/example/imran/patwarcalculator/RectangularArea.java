package com.example.imran.patwarcalculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.imran.myapplication.R;

import static android.text.TextUtils.isEmpty;

public class RectangularArea extends ActionBarActivity {

    private EditText first;
    private EditText second;
    private TextView answer;
    private EditText firstInch;
    private EditText secondInch;
    double a = 0;
    double b = 0;
    double aInch = 0;
    double bInch = 0;
    private double c = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rectangular_area);
        first = (EditText) findViewById(R.id.firstNumber);
        second = (EditText) findViewById(R.id.secondNumber);
        firstInch = (EditText) findViewById(R.id.firstNumberInches);
        secondInch = (EditText) findViewById(R.id.secondNumberInches);
         answer = (TextView) findViewById(R.id.product);
        Button calculate= (Button) findViewById(R.id.calculateButton);

        Button resetButton = (Button) findViewById(R.id.resetButton);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first.setText("");
                second.setText("");
                answer.setText("");
                firstInch.setText("0");
                secondInch.setText("0");
            }
        });


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isEmpty(first.getText().toString())){
                    first.setError("Please enter length!");
                }
                else {
                    if (isEmpty(second.getText().toString())) {
                        second.setError("Please enter Width!");
                    } else area();
                }
            }
        });

    }
    private void area(){

        aInch = Double.parseDouble(firstInch.getText().toString());
        bInch = Double.parseDouble(secondInch.getText().toString());

        a = Double.parseDouble(first.getText().toString())+aInch/12;
        b = Double.parseDouble(second.getText().toString())+bInch/12;

        c = (a * b)/272.25;
        int marlaInteger = (int)c;
        double marlaDecimal = (c-(int)c);
        double sarsai = marlaDecimal*9;
        int sarsaiInteger = (int)sarsai;
        double sarsaiDecimal = sarsai - (int)sarsai;
        double karam = sarsaiDecimal*3;
        int karamInteger = (int)karam;
        answer.setText("" + Integer.toString(marlaInteger) + " Marla " + Integer.toString(sarsaiInteger) + " Sarsai " + Integer.toString(karamInteger) + " karam");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
