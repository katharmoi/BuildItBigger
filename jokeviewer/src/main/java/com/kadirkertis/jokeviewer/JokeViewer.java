package com.kadirkertis.jokeviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeViewer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_viewer);

        String joke = getIntent().getStringExtra("JOKE");
        TextView tv = (TextView) findViewById(R.id.joke_text);
        tv.setText(joke);
    }
}
