package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.Button;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class activity2 extends AppCompatActivity {

    CheckBox music,dance,play,fashion,food;
    RatingBar mr,dr,pr,far,fr;

    Button clear,submit;
    String m_r,d_r,p_r,fa_r,f_r;

    Boolean create,start,resume,restart,pause,stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        create= true;

        if (stop!= null){
            Toast.makeText(activity2.this, "State of activity Activity2 changed from Stop to Create", Toast.LENGTH_SHORT).show();
            Log.i("activity2","State of activity Main Activity changed from Stop to Create");
            stop = false;
        }


        music = (CheckBox) findViewById(R.id.music);
        dance = (CheckBox) findViewById(R.id.dance);
        play = (CheckBox) findViewById(R.id.play);
        fashion = (CheckBox) findViewById(R.id.fashion);
        food = (CheckBox) findViewById(R.id.food);

        mr = (RatingBar) findViewById(R.id.music_rating);
        dr = (RatingBar) findViewById(R.id.dance_rating);
        pr = (RatingBar) findViewById(R.id.play_rating);
        far = (RatingBar) findViewById(R.id.fashion_rating);
        fr = (RatingBar) findViewById(R.id.food_rating);

        mr.setNumStars(5);
        dr.setNumStars(5);
        pr.setNumStars(5);
        far.setNumStars(5);
        fr.setNumStars(5);




        clear = findViewById(R.id.clear_btn);
        submit = findViewById(R.id.submit_btn);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                boolean check = onCheckboxClicked();
                if(check){
                    Intent intent = getIntent();
                    String name = intent.getStringExtra("name");
                    String role = intent.getStringExtra("role");

                    Intent i = new Intent(activity2.this, activity3.class);
                    i.putExtra("name",name);
                    i.putExtra("role",role);
                    i.putExtra("music_rate",m_r);
                    i.putExtra("dance_rate",d_r);
                    i.putExtra("play_rate",p_r);
                    i.putExtra("fashion_rate",fa_r);
                    i.putExtra("food_rate",f_r);
                    Toast.makeText(activity2.this, "Entry Recorded", Toast.LENGTH_SHORT).show();
                    Log.i("activity2","Entry Recorded");
                    clear();
                    startActivity(i);
                }
                else{
                    Toast.makeText(activity2.this, "Invalid Entry", Toast.LENGTH_SHORT).show();
                    Log.i("activity2","Invalid Entry");
                }


            }
        });

    }

    public void clear(){
        mr.setRating(0F);
        dr.setRating(0F);
        pr.setRating(0F);
        far.setRating(0F);
        fr.setRating(0F);

        music.setChecked(false);
        dance.setChecked(false);
        play.setChecked(false);
        fashion.setChecked(false);
        food.setChecked(false);

        m_r = String.valueOf(mr.getRating());
        d_r = String.valueOf(dr.getRating());
        p_r = String.valueOf(pr.getRating());
        fa_r = String.valueOf(far.getRating());
        f_r = String.valueOf(fr.getRating());


    }
    public boolean onCheckboxClicked() {
        m_r = String.valueOf(mr.getRating());
        d_r = String.valueOf(dr.getRating());
        p_r = String.valueOf(pr.getRating());
        fa_r = String.valueOf(far.getRating());
        f_r = String.valueOf(fr.getRating());

        if(mr.getRating()!= 0 && !music.isChecked()){
            return false;
        }
        else if(dr.getRating()!= 0 && !dance.isChecked()){
            return false;
        }
        else if(pr.getRating()!= 0 && !play.isChecked()){
            return false;
        }
        else if(far.getRating()!= 0 && !fashion.isChecked()){
            return false;
        }
        else if(fr.getRating()!= 0 && !food.isChecked()){
            return false;
        }
        else if(music.isChecked() && mr.getRating()== 0){
            return false;
        }
        else if(dance.isChecked() && dr.getRating()== 0){
            return false;
        }
        else if(play.isChecked() && pr.getRating()== 0){
            return false;
        }
        else if(fashion.isChecked() && far.getRating()== 0){
            return false;
        }
        else if(food.isChecked() && fr.getRating()== 0){
            return false;
        }


        return true;





    }
    @Override
    protected void onStart() {
        super.onStart();

        start = true;


        if (create){
            Toast.makeText(activity2.this, "State of activity Activity2 changed from Create to Start", Toast.LENGTH_SHORT).show();
            Log.i("activity2","State of activity Main Activity changed from Create to Start");
            create = false;
        }
        else if(restart){
            Toast.makeText(activity2.this, "State of activity Activity2 changed from Restart to Start", Toast.LENGTH_SHORT).show();
            Log.i("activity2","State of activity Main Activity changed from Restart to Start");
            restart = false;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        resume = true;
        if (start){
            Toast.makeText(activity2.this, "State of activity Activity2 changed from Start to Resume", Toast.LENGTH_SHORT).show();
            Log.i("activity2","State of activity Main Activity changed from Start to Resume");
            start = false;
        }
        else if(pause){
            Toast.makeText(activity2.this, "State of activity Activity2 changed from Pause to Resume", Toast.LENGTH_SHORT).show();
            Log.i("activity2","State of activity Main Activity changed from Pause to Resume");
            pause = false;
        }
    }
    @Override
    protected void onRestart() {
        super.onRestart();

        restart = true;
        if (stop){
            Toast.makeText(activity2.this, "State of activity Activity2 changed from Stop to Restart", Toast.LENGTH_SHORT).show();
            Log.i("activity2","State of activity Main Activity changed from Stop to Restart");
            stop = false;
        }
        else if(pause){
            Toast.makeText(activity2.this, "State of activity Activity2 changed from Pause to Restart", Toast.LENGTH_SHORT).show();
            Log.i("activity2","State of activity Main Activity changed from Pause to Restart");
            pause = false;
        }

    }

    @Override
    protected void onPause() {
        super.onPause();

        pause = true;
        resume = false;
        Toast.makeText(activity2.this, "State of activity Activity2 changed from Resume to Pause", Toast.LENGTH_SHORT).show();
        Log.i("activity2","State of activity Main Activity changed from Resume to Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        stop= true;
        pause = false;
        Toast.makeText(activity2.this, "State of activity Activity2 changed from Pause to Stop", Toast.LENGTH_SHORT).show();
        Log.i("activity2","State of activity Main Activity changed from Pause to Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stop = false;

        Toast.makeText(activity2.this, "State of activity Activity2 changed from Stop to Destroy", Toast.LENGTH_SHORT).show();
        Log.i("activity2","State of activity Main Activity changed from Stop to Destroy");
    }


}




