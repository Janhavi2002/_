package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class activity3 extends AppCompatActivity {

    TextView Name_box,Role_box,T1,T2,T3,T4,T5;

    Boolean create,start,resume,restart,pause,stop;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        create= true;

        if (stop!= null){
            Toast.makeText(activity3.this, "State of activity Activity3 changed from Stop to Create", Toast.LENGTH_SHORT).show();
            Log.i("activity3","State of activity Main Activity changed from Stop to Create");
            stop = false;
        }

        Name_box = findViewById(R.id.name_box);
        Role_box = findViewById(R.id.role_box);
        T1 = findViewById(R.id.t1);
        T2 = findViewById(R.id.t2);
        T3 = findViewById(R.id.t3);
        T4 = findViewById(R.id.t4);
        T5 = findViewById(R.id.t5);


        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String role = intent.getStringExtra("role");
        String r1 = intent.getStringExtra("music_rate");
        String r2 = intent.getStringExtra("dance_rate");
        String r3 = intent.getStringExtra("play_rate");
        String r4 = intent.getStringExtra("fashion_rate");
        String r5 = intent.getStringExtra("food_rate");

        Name_box.setText(name);
        Role_box.setText(role);
        if (r1.equals("0.0")){
            T1.setText("Music event not attended");
        }
        else{
            T1.setText("Music rating is "+ r1);
        }
        if (r2.equals("0.0")){
            T2.setText("Dance event not attended");
        }
        else{
            T2.setText("Dance rating is "+ r2);
        }
        if (r3.equals("0.0")){
            T3.setText("Play event not attended");
        }
        else{
            T3.setText("Play rating is "+ r3);
        }
        if (r4.equals("0.0")){
            T4.setText("Fashion event not attended");
        }
        else{
            T4.setText("Fashion rating is "+ r4);
        }
        if (r5.equals("0.0")){
            T5.setText("Food event not attended");
        }
        else{
            T5.setText("Food rating is "+ r5);

        }

    }
    @Override
    protected void onStart() {
        super.onStart();

        start = true;


        if (create){
            Toast.makeText(activity3.this, "State of activity Activity2 changed from Create to Start", Toast.LENGTH_SHORT).show();
            Log.i("activity3","State of activity Main Activity changed from Create to Start");
            create = false;
        }
        else if(restart){
            Toast.makeText(activity3.this, "State of activity Activity2 changed from Restart to Start", Toast.LENGTH_SHORT).show();
            Log.i("activity3","State of activity Main Activity changed from Restart to Start");
            restart = false;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        resume = true;
        if (start){
            Toast.makeText(activity3.this, "State of activity Activity2 changed from Start to Resume", Toast.LENGTH_SHORT).show();
            Log.i("activity3","State of activity Main Activity changed from Start to Resume");
            start = false;
        }
        else if(pause){
            Toast.makeText(activity3.this, "State of activity Activity2 changed from Pause to Resume", Toast.LENGTH_SHORT).show();
            Log.i("activity3","State of activity Main Activity changed from Pause to Resume");
            pause = false;
        }
    }
    @Override
    protected void onRestart() {
        super.onRestart();

        restart = true;
        if (stop){
            Toast.makeText(activity3.this, "State of activity Activity2 changed from Stop to Restart", Toast.LENGTH_SHORT).show();
            Log.i("activity3","State of activity Main Activity changed from Stop to Restart");
            stop = false;
        }
        else if(pause){
            Toast.makeText(activity3.this, "State of activity Activity2 changed from Pause to Restart", Toast.LENGTH_SHORT).show();
            Log.i("activity3","State of activity Main Activity changed from Pause to Restart");
            pause = false;
        }

    }

    @Override
    protected void onPause() {
        super.onPause();

        pause = true;
        resume = false;
        Toast.makeText(activity3.this, "State of activity Activity2 changed from Resume to Pause", Toast.LENGTH_SHORT).show();
        Log.i("activity3","State of activity Main Activity changed from Resume to Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        stop= true;
        pause = false;
        Toast.makeText(activity3.this, "State of activity Activity2 changed from Pause to Stop", Toast.LENGTH_SHORT).show();
        Log.i("activity3","State of activity Main Activity changed from Pause to Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stop = false;

        Toast.makeText(activity3.this, "State of activity Activity2 changed from Stop to Destroy", Toast.LENGTH_SHORT).show();
        Log.i("activity3","State of activity Main Activity changed from Stop to Destroy");
    }


}




