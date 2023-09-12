package com.example.calculatorappmarathe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    public String currentnum = "";

    public String view = "";

    //stores the last change made, either a number or an operation
    public boolean numIsLastChanged = true;

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
            numIsLastChanged = true;

        }
        else if (v.getId() == R.id.button1){
            currentnum += "1";
            view += "1";
            numIsLastChanged = true;


        }
        else if (v.getId() == R.id.button2){
            currentnum += "2";
            view += "2";
            numIsLastChanged = true;

        }
        else if(v.getId() == R.id.button3){
            currentnum += "3";
            view += "3";
            numIsLastChanged = true;

        }
        else if(v.getId() == R.id.button4){
            currentnum += "4";
            view += "4";
            numIsLastChanged = true;


        }
        else if(v.getId() == R.id.button5){
            currentnum += "5";
            view += "5";
            numIsLastChanged = true;

        }
        else if(v.getId() == R.id.button6){
            currentnum += "6";
            view += "6";
            numIsLastChanged = true;

        }
        else if(v.getId() == R.id.button7){
            currentnum += "7";
            view += "7";
            numIsLastChanged = true;

        }
        else if(v.getId() == R.id.button8){
            currentnum += "8";
            view += "8";
            numIsLastChanged = true;

        }
        else if(v.getId() == R.id.button9){
            currentnum += "9";
            view += "9";
            numIsLastChanged = true;

        }
        else if(v.getId() == R.id.button_dot){
            currentnum += ".";
            view += ".";
            numIsLastChanged = true;
        }
        else if(v.getId() == R.id.button_equals){
            numArr.add(currentnum);
            currentnum = "";
            calculate();
            numIsLastChanged = true;


        }
        else if(v.getId() == R.id.button_divide){
            numArr.add(currentnum);
            currentnum = "";
            operationArr.add("/");
            view += " / ";
            numIsLastChanged = false;

        }
        else if(v.getId() == R.id.button_multiply){
            numArr.add(currentnum);
            currentnum = "";
            operationArr.add("*");
            view += " * ";
            numIsLastChanged = false;

        }
        else if(v.getId() == R.id.button_add){
            numArr.add(currentnum);
            currentnum = "";
            operationArr.add("+");
            view += " + ";
            numIsLastChanged = false;

        }
        else if(v.getId() == R.id.button_subtract){
            numArr.add(currentnum);
            currentnum = "";
            operationArr.add("-");
            view += " - ";
            numIsLastChanged = false;

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
        //catch error statements
        boolean two_decimals = false;
        for(String s: numArr){
            int decimals = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '.'){
                    decimals++;
                }
            }
            if(decimals > 1){
                two_decimals = true;
            }
        }
        if(numArr.size() - operationArr.size() == 1 && !numArr.contains("") && !two_decimals){
            while(operationArr.size() > 0) {
                int index;
                if (operationArr.contains("*")) {
                    index = operationArr.indexOf("*");
                    double value = Double.parseDouble(numArr.get(index)) * Double.parseDouble(numArr.get(index + 1));
                    numArr.set(index, value + "");
                } else if (operationArr.contains("/")) {
                    index = operationArr.indexOf("/");
                    double value = Double.parseDouble(numArr.get(index)) / Double.parseDouble(numArr.get(index + 1));
                    numArr.set(index, value + "");
                } else if (operationArr.contains("+")) {
                    index = operationArr.indexOf("+");
                    double value = Double.parseDouble(numArr.get(index)) + Double.parseDouble(numArr.get(index + 1));
                    numArr.set(index, value + "");
                } else {
                    index = operationArr.indexOf("-");
                    double value = Double.parseDouble(numArr.get(index)) - Double.parseDouble(numArr.get(index + 1));
                    numArr.set(index, value + "");
                }
                numArr.remove(index + 1);
                operationArr.remove(index);
            }
            Log.i("omkar", numArr.get(0));
            if(numArr.get(0).equals("Infinity")){
                view = "ERR";
                screen.setText(view);
                numArr.remove(0);
            }
            else {
                currentnum = "" + numArr.get(0);
                view = numArr.get(0);
                numArr.remove(0);
            }

        }
        else{
            view = "ERR";
            screen.setText(view);
            numArr.clear();
            operationArr.clear();
            currentnum = "";
        }


    }
    //clears all data
    public void clear(View V){
        view = "";
        screen.setText(view);
        numArr.clear();
        operationArr.clear();
        currentnum = "";
    }
    //deletes the last character added

    public void delete(View v){
        if(view.length() > 0){
            view = view.substring(0, view.length()-1);
            screen.setText(view);
        }
        if(numIsLastChanged && currentnum.length() == 1){
            currentnum = "";
        }
        else if(numIsLastChanged && currentnum.length() != 0){
            currentnum = currentnum.substring(0, currentnum.length()-1);
        }
        else if(!numIsLastChanged){
            operationArr.remove(operationArr.size()-1);
            numArr.remove(numArr.size()-1);
            currentnum = numArr.get(numArr.size()-1);
        }
    }


}