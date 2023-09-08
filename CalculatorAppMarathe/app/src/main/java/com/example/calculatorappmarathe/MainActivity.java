package com.example.calculatorappmarathe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    public String currentnum = "";

    public String view = "";

    TextView screen;
    public ArrayList<String> numArr = new ArrayList<String>();
    public ArrayList<String> operationArr = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = findViewById(R.id.calcScreen);

    }

    public void numSelected(View v){
        if(v.getId() == R.id.button0){
            currentnum += "0";
            view += "0";

        }
        else if (v.getId() == R.id.button1){
            currentnum += "1";
            view += "1";

        }
        else if (v.getId() == R.id.button2){
            currentnum += "2";
            view += "2";
        }
        else if(v.getId() == R.id.button3){
            currentnum += "3";
            view += "3";
        }
        else if(v.getId() == R.id.button4){
            currentnum += "4";
            view += "4";

        }
        else if(v.getId() == R.id.button5){
            currentnum += "5";
            view += "5";
        }
        else if(v.getId() == R.id.button6){
            currentnum += "6";
            view += "6";
        }
        else if(v.getId() == R.id.button7){
            currentnum += "7";
            view += "7";
        }
        else if(v.getId() == R.id.button8){
            currentnum += "8";
            view += "8";
        }
        else if(v.getId() == R.id.button9){
            currentnum += "9";
            view += "9";
        }
        else if(v.getId() == R.id.button_dot){
            currentnum += ".";
            view += ".";
        }
        else if(v.getId() == R.id.button_equals){
            numArr.add(currentnum);
            currentnum = "";
            calculate();

        }
        else if(v.getId() == R.id.button_divide){
            numArr.add(currentnum);
            currentnum = "";
            operationArr.add("/");
            view += " / ";
        }
        else if(v.getId() == R.id.button_multiply){
            numArr.add(currentnum);
            currentnum = "";
            operationArr.add("*");
            view += "*";
        }
        else if(v.getId() == R.id.button_add){
            numArr.add(currentnum);
            currentnum = "";
            operationArr.add("+");
            view += "+";
        }
        else if(v.getId() == R.id.button_subtract){
            numArr.add(currentnum);
            currentnum = "";
            operationArr.add("-");
            view += "-";
        }
        if(view.length() < 3){
            screen.setText(view);
        }
        else if(v.getId() != R.id.button_equals && view.substring(0, 3).equals("ERR")){
            view = view.substring(3);
            screen.setText(view);
        }
        else if(!view.substring(0,3).equals("ERR")){
            screen.setText(view);
        }



    }
    public void calculate(){
        if(numArr.size() - operationArr.size() == 1 && !numArr.contains("")){
            while(operationArr.contains("*") || operationArr.contains("/")){
                if(operationArr.contains("*")){
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
                if(operationArr.contains("+")){
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
            view = numArr.get(0);
        }
        else{
            view = "ERR";
            screen.setText(view);
        }


    }


}