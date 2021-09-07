package com.example.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button ans, again;
    TextView showAns;
    EditText getVal;
    RadioButton c2f, f2c;
    Double x;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ans= findViewById(R.id.ans);
        again= findViewById(R.id.again);
        showAns= findViewById(R.id.showAns);
        getVal= findViewById(R.id.getVal);
        c2f= findViewById(R.id.c2f);
        f2c= findViewById(R.id.f2c);


        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getVal.getText().toString().isEmpty()){
                    showAns.setText("Please input Temperature");
                }
                else {
                   x= Double.parseDouble(String.valueOf(getVal.getText()));
                   if (c2f.isChecked()){
                       x = (x*9)/5+32;  //this is Equation..
                       x= Double.parseDouble(new DecimalFormat("##.###").format(x));
                       showAns.setText(String.valueOf(x) + "  Degree Fahrenheit");
                   }
                   else if(f2c.isChecked()){
                       x = (x-32)*5/9;
                       x= Double.parseDouble(new DecimalFormat("##.###").format(x));
                       showAns.setText(String.valueOf(x) + "  Degree Celsius");
                   }
                   else {
                       showAns.setText("Please select an option");
                   }
                }


            }
        });
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAns.setText("Answer");
                getVal.setText("");
                c2f.setChecked(false);
                f2c.setChecked(false);
            }
        });


    }

}
