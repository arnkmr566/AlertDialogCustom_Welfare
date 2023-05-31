package com.example.alertdialogcustom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    Button byDefaultToast, simpleToast, nestedToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);


        byDefaultToast = findViewById(R.id.button1);
        simpleToast = findViewById(R.id.button2);
        nestedToast = findViewById(R.id.button3);

        byDefaultToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ToastActivity.this, "By Default Toast", Toast.LENGTH_LONG).show();

            }
        });

        simpleToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

Toast toast = Toast.makeText(ToastActivity.this, "SimpleToast", Toast.LENGTH_LONG);
toast.setGravity(Gravity.CENTER , 0,0);
toast.show();
            }
        });

        nestedToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast = Toast.makeText(ToastActivity.this, "SimpleToast", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM | Gravity.RIGHT , 0,0);
                toast.show();
            }
        });




    }
}