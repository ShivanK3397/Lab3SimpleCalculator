package com.example.lab3simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private enum Operator {none,add,minus,multiply,divide}
    private double data1 = 0,data2 = 0;

    private Operator optr = Operator.none;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void btnClick(View view){
        TextView etext = (TextView) findViewById(R.id.resultEdit);
        Button button = (Button) view;
        etext.setText(etext.getText()+button.getText().toString());
    }

    public void optrClick(View view){
        TextView etext = (TextView) findViewById(R.id.resultEdit);
        Button button = (Button) view;
        data1 = Double.parseDouble(etext.getText().toString());
        etext.setText("");

        if (button.getText().equals("+")){
            optr=Operator.add;
        }
        else if (button.getText().equals("-")){
            optr=Operator.minus;
        }
        else if (button.getText().equals("*")){
            optr = Operator.multiply;
        }
        else{
            optr=Operator.divide;
        }
    }

    public void dotClick(View view){
        TextView etext = (TextView) findViewById(R.id.resultEdit);
        etext.setText(etext.getText()+".");
    }

    public void clearClick(View view){
        TextView etext = (TextView) findViewById(R.id.resultEdit);
        etext.setText("");
     }

     public void btnResultClick(View view){
        if (optr!=Operator.none){
            TextView eText = (TextView) findViewById(R.id.resultEdit);
            data2 = Double.parseDouble(eText.getText().toString());
            double result = 0;
            if (optr==Operator.add){
                result=data1+data2;
            }
            else if (optr==Operator.minus){
                result= data1-data2;
            }
            else if (optr==Operator.multiply){
                result=data1*data2;
            }
            else{
                result=data1/data2;
            }

            optr=Operator.none;
            data1=result;
            if(result- (int)result!=0){
                eText.setText(String.valueOf(result));
            }
            else{
                eText.setText(String.valueOf((int)result));
            }


        }
     }
}