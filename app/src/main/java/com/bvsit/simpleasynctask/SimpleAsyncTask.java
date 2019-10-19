package com.bvsit.simpleasynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void,Void,String[]> {
    WeakReference<TextView> mTextView;

    public SimpleAsyncTask(WeakReference<TextView> tv) {
        this.mTextView = tv;
    }

    @Override
    protected String[] doInBackground(Void... voids) {
        Random r = new Random();
        int n = r.nextInt(11);
        int s = n * 200;
        return null;
    }
}
