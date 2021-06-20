package com.example.adminbus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.adminbus.Busmodel.BusModelclass;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class addbusses extends AppCompatActivity {

    ProgressDialog progressDialog;

   // final int RESULT_INTENT=1;
   FirebaseDatabase rootnode;
    DatabaseReference reference;

    //dropdowns
    AutoCompleteTextView autoboard,autodestin,autoprice,autoBustype,autotime,autotimedestin;
    TextInputLayout busid,til_board,til_destin,til_price,til_bustype,til_timestart,til_timingdesin;
    //for dropdown
    ArrayList<String> locations;   //array list for location
    ArrayAdapter<String> arrayAdapter_locations;

    ArrayList<String> timeing; //array list for Start time
    ArrayAdapter<String> arrayAdapter_timeing;

  //  ArrayAdapter<String> arrayAdapter_timingarrive;//adapter  for arrive time

    ArrayList<String> bustype;          //array list for bus type
    ArrayAdapter<String> arrayAdapter_bustype;

    ArrayList<String> prices;       //array list for prices
    ArrayAdapter<String> arrayAdapter_prices;

    //ends

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbusses);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //for boading
        arrayAdapter_locations = new ArrayAdapter<>(getApplicationContext(),
                R.layout.dropdowitem,
                locations);
        autoboard.setAdapter(arrayAdapter_locations);


        //for destin
        arrayAdapter_locations = new ArrayAdapter<>(getApplicationContext(),
                R.layout.dropdowitem,
                locations);

        autodestin.setAdapter(arrayAdapter_locations);
        //time for start
        arrayAdapter_timeing = new ArrayAdapter<>(getApplicationContext(),
                R.layout.dropdowitem,
                timeing);
        autotime.setAdapter(arrayAdapter_timeing);

        //time of arrive

        arrayAdapter_timeing = new ArrayAdapter<>(getApplicationContext(),
                R.layout.dropdowitem,
                timeing);
        autotimedestin.setAdapter(arrayAdapter_timeing);

        //for bustype
        arrayAdapter_bustype = new ArrayAdapter<>(getApplicationContext(),
                R.layout.dropdowitem,
                bustype);
        autoBustype.setAdapter(arrayAdapter_bustype);
        //bus prices
        arrayAdapter_prices = new ArrayAdapter<>(getApplicationContext(),
                R.layout.dropdowitem,
                prices);
        autoprice.setAdapter(arrayAdapter_prices);

    }

    private void init(){
        busid = (TextInputLayout) findViewById(R.id.busid);
        til_board = (TextInputLayout) findViewById(R.id.til_board);
        til_destin = (TextInputLayout) findViewById(R.id.til_destin);
        til_timestart = (TextInputLayout) findViewById(R.id.til_timestart);
        til_timingdesin = (TextInputLayout) findViewById(R.id.til_timingdesin);
        til_price = (TextInputLayout) findViewById(R.id.til_price);
        til_bustype = (TextInputLayout) findViewById(R.id.til_bustype);
        autoboard= (AutoCompleteTextView) findViewById(R.id.autonboard);
        autodestin= (AutoCompleteTextView) findViewById(R.id.autondestin);
        autotime= (AutoCompleteTextView) findViewById(R.id.autotime);
        autotime= (AutoCompleteTextView) findViewById(R.id.autotime);
        autotimedestin= (AutoCompleteTextView) findViewById(R.id.autotimedestin);
        autoprice= (AutoCompleteTextView) findViewById(R.id.autoprice);
        autoBustype= (AutoCompleteTextView) findViewById(R.id.autoBustype);

        locations = new ArrayList<>();
        locations.add("Lahore");
        locations.add("Rawalpindi");
        locations.add("Peshawar");
        locations.add("Multan");
        locations.add("Hyderabad");
        locations.add("Faisalabad");
        locations.add("Quetta");
        locations.add("Sargodha");
        locations.add("Gujranwala");
        timeing = new ArrayList<>();
        timeing.add("00:00 AM");
        timeing.add("02:00 AM");
        timeing.add("03:00 AM");
        timeing.add("04:00 AM");
        timeing.add("06:00 AM");
        timeing.add("07:00 AM");
        timeing.add("09:00 AM");
        timeing.add("11:00 PM");
        timeing.add("13:00 PM");
        timeing.add("14:00 PM");
        timeing.add("16:00 PM");
        timeing.add("18:00 PM");
        timeing.add("19:00 PM");
        timeing.add("22:00 PM");
        timeing.add("24:00 PM");
        bustype = new ArrayList<>();
        bustype.add("Classic");
        bustype.add("Gold");
        bustype.add("Premium");
        prices= new ArrayList<>();
        prices.add("1000Rs.");
        prices.add("1500Rs.");
        prices.add("2000Rs.");
        prices.add("2500Rs.");
        prices.add("3000Rs.");
        prices.add("3500Rs.");
        prices.add("4000Rs.");


    }

    public void btnSave(View view) {
        progressDialog = new ProgressDialog(addbusses.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(
                android.R.color.transparent
        );

        String id=busid.getEditText().getText().toString();
        String location=til_board.getEditText().getText().toString();
        String destination=til_destin.getEditText().getText().toString();
        String timeStart=til_timestart.getEditText().getText().toString();
        String timearrive=til_timingdesin.getEditText().getText().toString();
        String price=til_price.getEditText().getText().toString();
        String condition=til_bustype.getEditText().getText().toString();
        String reservedseat=null;

        BusModelclass busModelclass = new BusModelclass(id,location,destination,timeStart,timearrive,price,condition,reservedseat);

        rootnode = FirebaseDatabase.getInstance(); //get root
        reference = rootnode.getReference().child("busses");
        reference.child(id)
                .setValue(busModelclass)
                .addOnCompleteListener(new OnCompleteListener<Void>() {

                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                     //   Toast.makeText(addbusses.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(addbusses.this,MainActivity.class);
                        setResult(RESULT_OK,intent);
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(addbusses.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

    }

    public void btnBack(View view) {
        Intent intent = new Intent(addbusses.this,MainActivity.class);
        setResult(RESULT_CANCELED,intent);
        finish();
    }

    public void movetolist(View view) {
        Intent intent = new Intent(addbusses.this,MainActivity.class);
        setResult(RESULT_CANCELED,intent);
        finish();

    }
}