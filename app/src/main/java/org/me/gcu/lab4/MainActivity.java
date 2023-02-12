package org.me.gcu.lab4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText email;
    RadioButton radio_one, radio_two, yesRadio, noRadio;
    CheckBox checkBox, checkBox2, checkBox3, checkBox4;
    Button submit;
    TextView t1, t2, t3, t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(this);
        email = (EditText)findViewById(R.id.email);
        radio_one = (RadioButton)findViewById(R.id.radio_one);
        radio_two = (RadioButton)findViewById(R.id.radio_two);
        yesRadio = (RadioButton)findViewById(R.id.yesRadio);
        noRadio = (RadioButton)findViewById(R.id.noRadio);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        checkBox2 = (CheckBox)findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox)findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox)findViewById(R.id.checkBox4);
        t1 = (TextView)findViewById(R.id.t1);
        t2 = (TextView)findViewById(R.id.t2);
        t3 = (TextView)findViewById(R.id.t3);
        t4 = (TextView)findViewById(R.id.t4);
        noRadio.setChecked(true);
    }

    @Override
    public void onClick(View v) {

        String emailValue = String.valueOf(email.getText());
        String crustValue = "";
        RadioButton[] crusts = {radio_one, radio_two};
        String toppingsChoice = "";
        CheckBox[] toppings = {checkBox, checkBox2, checkBox3, checkBox4};
        String cheeseChoice = "";
        RadioButton[] cheeses = {yesRadio, noRadio};

        for (RadioButton ch: cheeses) {
            if (ch.isChecked()){
                cheeseChoice = String.valueOf(ch.getText());
            }
        }

        for (RadioButton c: crusts) {
            if (c.isChecked()){
                crustValue = String.valueOf(c.getText());
            }
        }

        for (CheckBox t: toppings) {
            if (t.isChecked()){
                toppingsChoice += String.valueOf(t.getText());
                toppingsChoice += ", ";
            } else{
                int x = 1;
                x++;
                if (x == toppings.length){
                    toppingsChoice += "No toppings were selected";
                }
            }
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setMessage("Here's your order \n\n Email: " + emailValue + "\n Crust: " + crustValue + "\n Toppings: " + toppingsChoice + "\n Extra Cheese?: " + cheeseChoice);

        builder.setTitle("Order Details");

        builder.setCancelable(true);

        builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
            MainActivity.this.finish();
        });

        builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
            dialog.cancel();
        });

        AlertDialog alert = builder.create();
        alert.show();
    }




}