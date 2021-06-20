package com.example.adminbus;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final int ADD_BUS=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ADD_BUS && resultCode == RESULT_OK) {

            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
            }
        else{
                Toast.makeText(this, "Process Canceled", Toast.LENGTH_SHORT).show();
            }

    }

    public void Addbuss(View view) {
        Intent intent = new Intent(MainActivity.this,addbusses.class);
        startActivityForResult(intent,ADD_BUS);


    }

}