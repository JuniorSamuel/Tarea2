package com.example.tarea2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private TextView labelResul;
    private TextView labelError;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.inputNumber);
        result = (TextView) findViewById(R.id.result);
        labelResul = (TextView) findViewById(R.id.labelResul);
        labelError = (TextView) findViewById(R.id.labelError);
    }

    public void Calcular(View view){
        labelError.setVisibility(View.INVISIBLE);

        String textPunto = input.getText().toString();
        if(!textPunto.equals("")){
            obtenerLiteral(textPunto);
        } else {
            setError("Debes ingresar un valor");
        }
    }


    private void obtenerLiteral(String textPunto){

        float punto = Float.parseFloat(textPunto);

        if( punto > 100 || punto < 0) {
            setError("El valor deber ser mayor a 0 y menor de 100");
        }else if (punto >= 90 ){
            setLiteral("A");
        }else if(punto >= 80){
            setLiteral("B");
        }else if(punto >= 70){
            setLiteral("C");
        }else{
            setLiteral("F");
        }
    }

    private void setLiteral(String text){
        result.setText(text);
        labelResul.setVisibility(View.VISIBLE);
        result.setVisibility(View.VISIBLE);
        labelError.setVisibility(View.INVISIBLE);
    }

    private void setError(String text){
        labelError.setText(text);
        labelError.setVisibility(View.VISIBLE);
        labelResul.setVisibility(View.INVISIBLE);
        result.setVisibility(View.INVISIBLE);
    }
}