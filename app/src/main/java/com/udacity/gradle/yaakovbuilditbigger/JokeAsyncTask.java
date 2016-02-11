package com.udacity.gradle.yaakovbuilditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

import il.co.yshahak.backend.myApi.MyApi;

/**
 * Created by B.E.L on 28/01/2016.
 */
public class JokeAsyncTask extends AsyncTask<JokeAsyncTask.JokesCallback, Void, String> {
    private static MyApi myApiService = null;
    private JokesCallback jokesCallback;

    @Override
    protected String doInBackground(JokesCallback... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://mystical-studio-121015.appspot.com/_ah/api/");
            myApiService = builder.build();
        }
        jokesCallback = params[0];

        try {
            return myApiService.setJoke().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        jokesCallback.onSuccess(result);
    }

    public interface JokesCallback{
        void onSuccess(String joke);
        void onFailure();
    }
}