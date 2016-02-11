package com.udacity.gradle.yaakovbuilditbigger.free;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.udacity.gradle.yaakovbuilditbigger.JokeAsyncTask;
import com.udacity.gradle.yaakovbuilditbigger.R;

import il.co.yshahak.jokeactivitylibrary.JokeActivity;

public class MainActivity extends AppCompatActivity implements JokeAsyncTask.JokesCallback{

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

    public void tellJoke(View view){
        new JokeAsyncTask().execute(this);
    }

    @Override
    public void onSuccess(String joke) {
        Intent jokeIntent = new Intent(MainActivity.this, JokeActivity.class);
        jokeIntent.putExtra(JokeActivity.EXTRA_JOKE, joke);
        startActivity(jokeIntent);
    }

    @Override
    public void onFailure() {

    }


}