package com.bvsit.simpleasynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

/**
 * BvS
 * This demonstrates that it is still possible (though cumbersome) to use an interface in the AsyncTask:
 * In this case the TextView is not directly set in the AsyncTask by using a WeakReference
 * as is shown in the official solution
 * Essential in all cases is to use onPostExecute() to pass the result,
 * NOT directly in doInBackground()
 * Also in MainActivity instantiate a new MyTask every time the button is clicked,
 * NOT in onCreate()
 *
 */

public class MyTask extends AsyncTask<Void,Void,String> {

    public interface OnTaskCompleted{
        void onTaskCompleted(String result);
    }

    private OnTaskCompleted listener;

    public void setListener(OnTaskCompleted listener){
        this.listener=listener;
    }

    WeakReference<TextView> tv;

    MyTask(TextView tv){
        this.tv = new WeakReference<> (tv);
    }

    @Override
    protected String doInBackground(Void... voids) {
        int r=new Random().nextInt(11);
        long msec=r*200;
        try{
            Thread.sleep(msec);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        String result = "Slept for "+ msec + " mseconds";
        //listener.onTaskCompleted(result);
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        listener.onTaskCompleted(s);
        //tv.get().setText(s);
    }

}
