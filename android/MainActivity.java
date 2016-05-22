package com.example.logan.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View v){
        EditText book = (EditText) findViewById(R.id.book);
        EditText verse = (EditText) findViewById(R.id.verse);
        EditText chapter = (EditText) findViewById(R.id.chapter); //Gets the text from the different boxes

        Intent i = new Intent(MainActivity.this, Main2Activity.class); //Creates an intent of the second activity

        i.putExtra("book", book.getText().toString());
        i.putExtra("verse",verse.getText().toString());
        i.putExtra("chapter", chapter.getText().toString());
        // Puts the text into the intent
        startActivity(i);
        // Starts the second activity
    }
}
