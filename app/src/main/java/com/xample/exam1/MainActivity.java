package com.xample.exam1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button btn_inch;
    private Button btn_cm;
    private EditText txt_inch;
    private EditText txt_cm;
    private final DecimalFormat format = new DecimalFormat("##.#####");
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();

        btn_inch = super.findViewById(R.id.btn_toinch);
        btn_cm = super.findViewById(R.id.btn_tocm);
        txt_inch = super.findViewById(R.id.edtxt_inch);
        txt_cm = super.findViewById(R.id.edtxt_cm);


        btn_cm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(txt_inch.getText().length() == 0){
                    Toast toast = Toast.makeText(context, "Impossible, le champ des INCH est vide!", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    double toconvert = Double.parseDouble(txt_inch.getText().toString());
                    toconvert = toconvert*2.54; //Thanks google ;)
                    txt_cm.setText(format.format(toconvert));
                }

            }
        });

        btn_inch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(txt_cm.getText().length() == 0){
                    Toast toast = Toast.makeText(context, "Impossible, le champ des CM est vide!", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    double toconvert = Double.parseDouble(txt_cm.getText().toString());
                    toconvert = toconvert*0.393701; //Thanks google ;)
                    txt_inch.setText(format.format(toconvert));
                }

            }
        });
    }
}
