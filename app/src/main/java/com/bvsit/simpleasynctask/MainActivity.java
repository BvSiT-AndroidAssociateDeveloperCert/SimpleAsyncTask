package com.bvsit.simpleasynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView1);

    }

    public void startTask(View view) {
        tv.setText(R.string.napping);
        MyTask myTask = new MyTask(new MyTask.OnTaskCompletedListener() {
            @Override
            public void onTaskCompleted(String s) {
                tv.setText(s);
            }
        });
        myTask.execute();
    }

}
