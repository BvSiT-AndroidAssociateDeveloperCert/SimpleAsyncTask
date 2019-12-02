package com.bvsit.simpleasynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void,Integer,String> {
    WeakReference<TextView> mTextView;

    public SimpleAsyncTask(TextView tv) {
        this.mTextView = new WeakReference<>(tv);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        //super.onProgressUpdate(values);
        mTextView.get().setText("Napping for "+ values[0] + " ms");
    }

    @Override
    protected String doInBackground(Void... voids) {

        // Generate a random number between 0 and 10
        Random r = new Random();
        int n = r.nextInt(11);

        // Make the task take long enough that we have
        // time to rotate the phone while it is running
        int s = n * 200;

        publishProgress(n * 200);

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
        super.onPostExecute(s);
        mTextView.get().setText(s);
    }
}
