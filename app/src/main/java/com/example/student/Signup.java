package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Signup extends AppCompatActivity {
    ArrayList<String> ar;
    Spinner sp;
    ArrayAdapter<String> ad;
    String stdob,stbldgr,stnam,stmob,stloc;
    EditText edbob,ednam,edmob,edloc;
    Db db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        edbob=findViewById(R.id.editTextTextPersonName4);
        ednam=findViewById(R.id.editTextTextPersonName);
        edmob=findViewById(R.id.editTextTextPersonName2);
        edloc=findViewById(R.id.editTextTextPersonName3);
        sp=findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                stbldgr=ar.get(position);
                Toast.makeText(Signup.this, ""+stbldgr, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ar=new ArrayList<>();
        ar.add("B.COM");
        ar.add("BCA");
        ar.add("B.VOC");
        ar.add("BBA");
        ar.add("BSC");
        edbob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dp=new DatePickerDialog(Signup.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        edbob.setText(year+"/"+(1+month)+"/"+dayOfMonth);
                    }
                }, 2023, 0, 6);
                dp.show();
            }
        });
        ad=new ArrayAdapter<>(Signup.this, android.R.layout.simple_spinner_dropdown_item,ar);
        sp.setAdapter(ad);
        db=new Db(Signup.this);
    }

    @SuppressLint("NotConstructor")
    public void Signup(View view) {
        stnam=ednam.getText().toString();
        stmob=edmob.getText().toString();
        stloc=edloc.getText().toString();
        stdob=edbob.getText().toString();
        db.Signup(stnam,stmob,stloc,stdob,stbldgr);
        Toast.makeText(this, stnam+"-"+stmob+"-"+stloc+"-"+stdob, Toast.LENGTH_SHORT).show();
    }
}