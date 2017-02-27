package com.example.arafat.arafatdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityA extends AppCompatActivity {



        private Button btaa;
        private Button btab;
        private Button btac;
        private Button btad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        initialView();
        initialListener();
    }

    private void initialView(){
        btaa = (Button) findViewById(R.id.btaa);
        btab = (Button) findViewById(R.id.btab);
        btac = (Button) findViewById(R.id.btac);
        btad = (Button) findViewById(R.id.btad);
    }

    private void initialListener(){
        btaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ActivityA.class);
                startActivity(intent);
            }
        });
        btab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ActivityB.class);
                startActivity(intent);
            }
        });
        btac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ActivityC.class);
                startActivity(intent);
            }
        });
        btad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ActivityD.class);
                startActivity(intent);
            }
        });

    }

}

