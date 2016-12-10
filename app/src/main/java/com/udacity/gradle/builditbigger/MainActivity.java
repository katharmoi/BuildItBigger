package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.JokeProvider;
import com.kadirkertis.jokeviewer.JokeViewer;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
//        Part 1&2
//        Intent intent = new Intent(this, JokeViewer.class);
//        intent.putExtra("JOKE",JokeProvider.makeMeLough());
//        startActivity(intent);
//        Toast.makeText(this, funnyBoy.makeMeLough(), Toast.LENGTH_SHORT).show();

        //Part 3

        GetJokeTask task = new GetJokeTask(new GetJokeTask.OnJokeReceivedListener() {
            @Override
            public void onJokeReceived(String result) {
                Intent intent = new Intent(MainActivity.this,JokeViewer.class);
                intent.putExtra("JOKE",result);
                startActivity(intent);
            }
        });
    }


}
