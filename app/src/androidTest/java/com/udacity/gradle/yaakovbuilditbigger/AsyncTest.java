package com.udacity.gradle.yaakovbuilditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class AsyncTest extends AndroidTestCase {
    private static String joke;

    public void testForGettingSomeResultFromServer() {

        JokeAsyncTask.JokesCallback jokesCallback = new JokeAsyncTask.JokesCallback() {
            @Override
            public void onSuccess(String testResult) {
                joke = testResult;
            }

            @Override
            public void onFailure() {

            }
        };

        new JokeAsyncTask().execute(jokesCallback);
        try {
            new CountDownLatch(1).await(10, TimeUnit.SECONDS);
            assertNotNull(joke);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}