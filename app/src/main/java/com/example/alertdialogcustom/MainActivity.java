package com.example.alertdialogcustom;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.alertdialogcustom.databinding.ActivityMainBinding;
import com.example.alertdialogcustom.databinding.SampleDialogBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnShowCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //   View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.sample_dialog,null);

                //   Button btnCancel = view.findViewById(R.id.btnCancel);
                //   Button btnDelete = view.findViewById(R.id.btnDelete);

                SampleDialogBinding dialogBinding = SampleDialogBinding.inflate(getLayoutInflater());

                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                        .setView(dialogBinding.getRoot())
                        .setCancelable(false)
                        .create();
                //       .setView(view).create();    // find view by id

                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.getWindow().setWindowAnimations(R.style.DialogAnimation);

                dialogBinding.btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "Cancelled", Toast.LENGTH_SHORT).show();
                    }
                });

                dialogBinding.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "Removed", Toast.LENGTH_SHORT).show();
                    }
                });


                dialog.show();

            }
        });



        binding.btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                 AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                         .setIcon(R.drawable.warning)
                         .setTitle("Delete Message")
                         .setMessage("Are you sure, You want to delete this message ")
                         .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialog, int which) {
                                 Toast.makeText(MainActivity.this, "Yes clicked", Toast.LENGTH_SHORT).show();
                             }
                         }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialog, int which) {
                                 Toast.makeText(MainActivity.this, "No Clicked", Toast.LENGTH_SHORT).show();
                             }
                         }).setNeutralButton("Mybe", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialog, int which) {
                                 Toast.makeText(MainActivity.this, "Cancel Clicked", Toast.LENGTH_SHORT).show();
                             }
                         })
                         .create();
                 dialog.show();
            }
        });
    }
}