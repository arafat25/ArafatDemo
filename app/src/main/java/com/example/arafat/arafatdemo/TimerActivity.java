package com.example.arafat.arafatdemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.arafat.arafatdemo.R.id.time;

public class TimerActivity extends BaseActivity {

    private int time;
    @BindView(R.id.timer_et)
    EditText editText;

    @BindView(R.id.timer_bt)
    Button timerButton;

    Handler mHandler = new Handler();

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            time--;
            if(time>0){
                editText.setText(String.valueOf(time));
                mHandler.postDelayed(this,1000);
                //mHandler.post(this); *Have to post runnable only once
            }
        }
    };

     View.OnClickListener start = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            time = Integer.valueOf(editText.getText().toString());
            timerButton.setText("Stop");
            timerButton.setOnClickListener(stop);
            editText.setEnabled(false);
            mHandler.postDelayed(runnable, 1000); //runnable posted here

        }


    };

     View.OnClickListener stop = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            timerButton.setText("Reset");
            timerButton.setOnClickListener(reset);
            mHandler.removeCallbacks(runnable);
        }
    };


     View.OnClickListener reset = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            timerButton.setText("Start");
            timerButton.setOnClickListener(start);
            editText.setEnabled(true);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        ButterKnife.bind(this);

        timerButton.setOnClickListener(start);


    }

}

