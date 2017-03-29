package com.jorgesys.chronometer;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Chronometer myChronometer;
    private Button start, restart, changeFormat, restartFormat;
    private boolean isRunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myChronometer = (Chronometer) findViewById(R.id.myChronometer);
        start = (Button) findViewById(R.id.startButton);
        restart = (Button) findViewById(R.id.restartButton);
        changeFormat = (Button) findViewById(R.id.setFormat);
        restartFormat = (Button) findViewById(R.id.clearFormat);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isRunning) {
                    myChronometer.start();
                    start.setText("Stop");
                    isRunning = true;
                }else{
                    myChronometer.stop();
                    start.setText("Start");
                    isRunning = false;
                }
            }
        });



        /*stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myChronometer.stop();
            }
        });*/

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChronometer.setBase(SystemClock.elapsedRealtime());
            }
        });

        changeFormat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChronometer.setFormat("Time: %s");
            }
        });

        restartFormat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChronometer.setFormat(null);
            }
        });


        myChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
                    @Override
                    public void onChronometerTick(Chronometer chronometer) {
                        if( chronometer.getText().toString().equalsIgnoreCase("00:12")) {
                            Toast.makeText(getApplicationContext(), "time reached 00:12", Toast.LENGTH_SHORT).show();
                            //myChronometer.stop();
                        }

                    }
                });

    }



}
