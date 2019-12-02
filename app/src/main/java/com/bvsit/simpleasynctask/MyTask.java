package com.bvsit.simpleasynctask;

import android.os.AsyncTask;

import java.util.Random;

public class MyTask extends AsyncTask<Void,Void,String> {

    public interface OnTaskCompletedListener{
        void onTaskCompleted(String s);
    }

    private OnTaskCompletedListener listener;

    public MyTask(OnTaskCompletedListener listener){
        this.listener=listener;
    }


    @Override
    protected String doInBackground(Void... voids) {
        // Generate a random number between 0 and 10
        Random r = new Random();
        int n = r.nextInt(11);

        // Make the task take long enough that we have
        // time to rotate the phone while it is running
        int s = n * 200;

        // Sleep for the random amount of time
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Return a String result
        return "Awake at last after sleeping for " + s + " milliseconds!";
    }

    @Override
    protected void onPostExecute(String s) {
        //super.onPostExecute(s);
        listener.onTaskCompleted(s);
    }
}
