package com.example.lux.calculatrice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private String solvingLine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        solvingLine = "0";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button)v;
                EditText promptField = (EditText)findViewById(R.id.promptField);
                if (!(b.getText().equals("=")))
                {
                    if(b.getText().equals("-"))
                        solvingLine += "+"+b.getText().toString();
                    else
                        solvingLine += b.getText().toString();

                    promptField.setText(promptField.getText()+b.getText().toString());
                }
                else
                {
                    String[] arrayCalc = solvingLine.split("\\+");
                    int total = 0;
                    for (String element : arrayCalc)
                    {
                        Log.d("DEBUG", element);
                        total += Integer.parseInt(element);
                        Log.d("DEBUG", "total : "+total);
                    }
                    promptField.setText(""+total);
                }
            }
        };

        //Faire une boucle for pour eviter la répetition
        //getResources().getIdentifier("button")
        findViewById(R.id.key_0).setOnClickListener(clickListener);
        findViewById(R.id.key_1).setOnClickListener(clickListener);
        findViewById(R.id.key_2).setOnClickListener(clickListener);
        findViewById(R.id.key_3).setOnClickListener(clickListener);
        findViewById(R.id.key_4).setOnClickListener(clickListener);
        findViewById(R.id.key_5).setOnClickListener(clickListener);
        findViewById(R.id.key_6).setOnClickListener(clickListener);
        findViewById(R.id.key_7).setOnClickListener(clickListener);
        findViewById(R.id.key_8).setOnClickListener(clickListener);
        findViewById(R.id.key_9).setOnClickListener(clickListener);
        findViewById(R.id.key_plus).setOnClickListener(clickListener);
        findViewById(R.id.key_minus).setOnClickListener(clickListener);
        findViewById(R.id.key_equal).setOnClickListener(clickListener);
    }
}
