package com.bvsit.simpleasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

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

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    MyTask myTask;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.textView1);
    }

    public void startTask(View view) {
        mTextView.setText(R.string.napping);
        myTask = new MyTask(mTextView);
        myTask.setListener(new MyTask.OnTaskCompleted() {
            @Override
            public void onTaskCompleted(String result) {
                mTextView.setText(result);
            }
        });
        myTask.execute();
    }
}
