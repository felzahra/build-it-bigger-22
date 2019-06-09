package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertFalse;



@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);


    EndpointsAsyncTask.TaskCompleteListener listener = new EndpointsAsyncTask.TaskCompleteListener() {
        @Override
        public void onTaskComplete(String result) {
        }
    };

    @Test
    public void testAsyncTask() throws InterruptedException, ExecutionException {
        // on the MainActivity execute the AsyncTask

        //EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();

        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(listener);


        endpointsAsyncTask.execute(activityTestRule.getActivity());
        String randomJoke="";
        try {
            // the String returned in the onPostExecute is being retrieved
             randomJoke = endpointsAsyncTask.get();
        }catch (Exception e) {
            assertNull(e);
        }
        assertNotNull(randomJoke);

       assertTrue(randomJoke, randomJoke!= null);



    }
}
