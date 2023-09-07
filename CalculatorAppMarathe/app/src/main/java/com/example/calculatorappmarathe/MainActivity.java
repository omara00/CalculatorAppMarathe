package com.example.calculatorappmarathe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    public String currentnum = "";
    public ArrayList<String> numArr = new ArrayList<String>();
    public ArrayList<String> operationArr = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void numSelected(View v){
        String selected = "";
        if(v.getId() == R.id.button0){
            selected = "0";
        }
        else if (v.getId() == R.id.button1){
            selected = "1";
        }
        else if (v.getId() == R.id.button2){
            selected = "2";
        }
        else if(v.getId() == R.id.button3){
            selected = "3";
        }
        else if(v.getId() == R.id.button4){
            selected = "4";
        }
        else if(v.getId() == R.id.button5){
            selected = "5";
        }
        else if(v.getId() == R.id.button6){
            selected = "6";
        }
        else if(v.getId() == R.id.button7){
            selected = "7";
        }
        else if(v.getId() == R.id.button8){
            selected = "8";
        }
        else if(v.getId() == R.id.button9){
            selected = "9";
        }
        else if(v.getId() == R.id.button_dot){
            selected = ".";
        }
        else if(v.getId() == R.id.button_equals){
            selected = "=";
        }
        else if(v.getId() == R.id.button_divide){
            selected = "/";
        }
        else if(v.getId() == R.id.button_multiply){
            selected = "*";
        }
        else if(v.getId() == R.id.button_add){
            selected = "+";
        }
        else if(v.getId() == R.id.button_subtract){
            selected = "-";
        }



    }

}