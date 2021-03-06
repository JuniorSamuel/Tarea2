package com.example.tarea2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private TextView labelResult;
    private TextView labelError;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.inputNumber);
        result = (TextView) findViewById(R.id.result);
        labelResult = (TextView) findViewById(R.id.labelResult);
        labelError = (TextView) findViewById(R.id.labelError);
        Button btn = (Button) findViewById(R.id.button);

        input.setOnEditorActionListener((textView, i, keyEvent) -> {
            if(i == EditorInfo.IME_ACTION_DONE){
                search();
            }
            return false;
        });

        btn.setOnClickListener(view -> search());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);

        return super.onOptionsItemSelected(item);
    }

    public void search(){
        labelError.setVisibility(View.INVISIBLE);

        String textPunto = input.getText().toString();
        if(!textPunto.equals("")){
            getLiteral(textPunto);
        } else {
            setError("Debes ingresar un valor");
        }
        input.setText("");
    }


    private void getLiteral(String textPunto){

        float punto = Float.parseFloat(textPunto);

        if( punto > 100 || punto < 0) {
            setError("El valor deber ser mayor a 0 y menor de 100");
        }else if (punto >= 90 ){
            setLiteral(R.string.literal_A, R.color.green_800, R.string.labelResult_A);

        }else if(punto >= 80){
            setLiteral(R.string.literal_B, R.color.yellow_800, R.string.labelResult_B);

        }else if(punto >= 70){
            setLiteral(R.string.literal_C, R.color.orange_800, R.string.labelResult_C);
        }else{
            setLiteral(R.string.literal_F, R.color.red_900, R.string.labelResult_F);
        }
    }

    private void setLiteral(int text, int color, int textResult){
        result.setText(text);
        result.setTextColor(getColor(color));
        result.setVisibility(View.VISIBLE);

        labelResult.setText(textResult);
        labelResult.setVisibility(View.VISIBLE);
        labelError.setVisibility(View.INVISIBLE);

    }

    private void setError(String text){
        labelError.setText(text);
        labelError.setVisibility(View.VISIBLE);
        labelResult.setVisibility(View.INVISIBLE);
        result.setVisibility(View.INVISIBLE);
    }
}