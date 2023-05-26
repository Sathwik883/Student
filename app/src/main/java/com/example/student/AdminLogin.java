package com.example.student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdminLogin extends AppCompatActivity {
    ArrayList<String> br;
    ArrayAdapter<String> ad;
    Spinner sp;
    String stbldgr;
    Db db;
    TextView v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        sp=findViewById(R.id.spinner2);
        v=findViewById(R.id.textView);
        br=new ArrayList<>();
        br.add("B.COM");
        br.add("BCA");
        br.add("B.VOC");
        br.add("BBA");
        br.add("BSC");
        ad=new ArrayAdapter<>(AdminLogin.this, android.R.layout.simple_spinner_dropdown_item,br);
        sp.setAdapter(ad);
        db=new Db(AdminLogin.this);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                stbldgr=br.get(position);
                Toast.makeText(AdminLogin.this, ""+stbldgr, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void selbol(View view) {
        String res= Db.getda(stbldgr);
        v.setText(res);
    }
}