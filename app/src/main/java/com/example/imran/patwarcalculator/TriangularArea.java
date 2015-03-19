package com.example.imran.patwarcalculator;

import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.imran.myapplication.R;

import static android.text.TextUtils.isEmpty;


public class TriangularArea extends ActionBarActivity {
    private EditText first;
    private EditText second;
    private EditText third;
    private TextView answer;
    private TextView counter;
    private EditText sideAInch;
    private EditText sideBInch;
    private EditText sideCInch;
    private double a = 0;
    private double b = 0;
    private double c = 0;
    private double aInch = 0;
    private double bInch = 0;
    private double cInch = 0;
    private double d = 0;
    private double s = 0;
    private int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.triangular_area);
        first = (EditText) findViewById(R.id.sidea);
        second = (EditText) findViewById(R.id.sideb);
        third = (EditText) findViewById(R.id.sidec);
        sideAInch = (EditText) findViewById(R.id.sideainches);
        sideBInch = (EditText) findViewById(R.id.sidebinches);
        sideCInch = (EditText) findViewById(R.id.sidecinches);

        answer = (TextView) findViewById(R.id.triResult);
        counter = (TextView) findViewById(R.id.counter);
        Button calculate= (Button) findViewById(R.id.triButton);
        ImageButton addTriangle= (ImageButton) findViewById(R.id.plus);
        Button resetButton = (Button) findViewById(R.id.resetButton);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               reset();
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(d==0){
                   answer.setText("Please first click on add button to calculate area.");
                }
                else
                marlas(d);
            }
            });

        addTriangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty(first.getText().toString())) {
                    first.setError("Please enter length of side A!");
                } else {
                    if (isEmpty(second.getText().toString())) {
                        second.setError("Please enter length of side B!");
                    } else {
                        if (isEmpty(third.getText().toString())) {
                            third.setError("Please enter length of side C!");
                        } else {
                            d+= area();
                            count += 1;
                            first.setText("");
                            second.setText("");
                            third.setText("");
                            sideAInch.setText("0");
                            sideBInch.setText("0");
                            sideCInch.setText("0");
                            counter.setText("Number of Triangles: " + count);
                        }
                    }
                }
            }


        });
    }


    private double area() {
        aInch = Double.parseDouble(sideAInch.getText().toString());
        bInch = Double.parseDouble(sideBInch.getText().toString());
        cInch = Double.parseDouble(sideCInch.getText().toString());
        a = Double.parseDouble(first.getText().toString()+aInch/12);
        b = Double.parseDouble(second.getText().toString()+bInch/12);
        c = Double.parseDouble(third.getText().toString()+cInch/12);
        s = (a + b + c) / 2;
        return d = Math.sqrt(s * (s - a) * (s - b) * (s - c)) / 272.25;
    }
    private void marlas(double d) {
        int marlaInteger = (int)d;
        double marlaDecimal = (d-(int)d);
        double sarsai = marlaDecimal*9;
        int sarsaiInteger = (int)sarsai;
        double sarsaiDecimal = sarsai - (int)sarsai;
        double karam = sarsaiDecimal*3;
        int karamInteger = (int)karam;
        answer.setText("" + Integer.toString(marlaInteger) + " Marla " + Integer.toString(sarsaiInteger) + " Sarsai " + Integer.toString(karamInteger) + " karam");
    }
    private void reset() {
        first.setText("");
        second.setText("");
        third.setText("");
        answer.setText("");
        sideAInch.setText("0");
        sideBInch.setText("0");
        sideCInch.setText("0");
        d=0;
        count = 0;
        counter.setText("Number of Triangles: " + count);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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
