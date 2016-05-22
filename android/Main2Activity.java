package com.example.logan.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void display() {
        TextView displayScript = (TextView) findViewById(R.id.displayScript);
        Intent ni = getIntent();
        String script = ni.getExtras().getString("book")+ " " + ni.getExtras().getString("chapter")+ ":" + ni.getExtras().getString("verse");

        displayScript.setText(script);

    }
}
