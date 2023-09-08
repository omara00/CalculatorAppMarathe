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
        if(v.getId() == R.id.button0){
            currentnum += "0";
        }
        else if (v.getId() == R.id.button1){
            currentnum += "1";
        }
        else if (v.getId() == R.id.button2){
            currentnum += "2";
        }
        else if(v.getId() == R.id.button3){
            currentnum += "3";
        }
        else if(v.getId() == R.id.button4){
            currentnum += "4";
        }
        else if(v.getId() == R.id.button5){
            currentnum += "5";
        }
        else if(v.getId() == R.id.button6){
            currentnum += "6";
        }
        else if(v.getId() == R.id.button7){
            currentnum += "7";
        }
        else if(v.getId() == R.id.button8){
            currentnum += "8";
        }
        else if(v.getId() == R.id.button9){
            currentnum += "9";
        }
        else if(v.getId() == R.id.button_dot){
            currentnum += ".";
        }
        else if(v.getId() == R.id.button_equals){
            numArr.add(currentnum);
            currentnum = "";
            calculate();

        }
        else if(v.getId() == R.id.button_divide){
            numArr.add(currentnum);
            currentnum = "";
            operationArr.add("/")
        }
        else if(v.getId() == R.id.button_multiply){
            numArr.add(currentnum);
            currentnum = "";
            operationArr.add("*");
        }
        else if(v.getId() == R.id.button_add){
            numArr.add(currentnum);
            currentnum = "";
            operationArr.add("+");
        }
        else if(v.getId() == R.id.button_subtract){
            numArr.add(currentnum);
            currentnum = "";
            operationArr.add("-");
        }



    }
    public void calculate(){
        while(operationArr.indexOf("*") != -1 || operationArr.indexOf("/") != -1){
            if(operationArr.indexOf("*") != -1){
                int index = operationArr.indexOf("*");
                double value = Double.parseDouble(numArr.get(index)) * Double.parseDouble(numArr.get(index+1));
                numArr.set(index, value + "");
                numArr.remove(index + 1);
                operationArr.remove(index);
            }
            else{
                int index = operationArr.indexOf("/");
                double value = Double.parseDouble(numArr.get(index)) / Double.parseDouble(numArr.get(index+1));
                numArr.set(index, value + "");
                numArr.remove(index + 1);
                operationArr.remove(index);
            }
        }
        while(operationArr.size() > 0){
            if(operationArr.indexOf("+") != -1){
                int index = operationArr.indexOf("+");
                double value = Double.parseDouble(numArr.get(index)) + Double.parseDouble(numArr.get(index+1));
                numArr.set(index, value + "");
                numArr.remove(index + 1);
                operationArr.remove(index);
            }
            else{
                int index = operationArr.indexOf("-");
                double value = Double.parseDouble(numArr.get(index)) - Double.parseDouble(numArr.get(index+1));
                numArr.set(index, value + "");
                numArr.remove(index + 1);
                operationArr.remove(index);
            }
        }
        return numArr.get(0);
    }

}