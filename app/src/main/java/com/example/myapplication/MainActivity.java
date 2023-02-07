package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    EditText name, role;
    Button next;

    Boolean create,start,resume,restart,pause,stop;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create= true;

        if (stop!= null){
            Toast.makeText(MainActivity.this, "State of activity Main Activity changed from Stop to Create", Toast.LENGTH_SHORT).show();
            Log.i("MyActivity","State of activity Main Activity changed from Stop to Create");
            stop = false;
        }


        name = findViewById(R.id.Name);
        role = findViewById(R.id.Role);
        next = findViewById(R.id.next_button);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = String.valueOf(name.getText());
                String r = String.valueOf(role.getText());
                r = r.toLowerCase();
                if(n.length()!=0 && r.length()!=0 && (r.equals("participant")||r.equals("audience"))){
                    Intent i = new Intent(MainActivity.this, activity2.class);
                    i.putExtra("name",n);
                    i.putExtra("role",r);
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity.this, "Invalid Name or Role", Toast.LENGTH_SHORT).show();
                    Log.i("MyActivity","Invalid Name or Role");

                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        start = true;


        if (create){
            Toast.makeText(MainActivity.this, "State of activity Main Activity changed from Create to Start", Toast.LENGTH_SHORT).show();
            Log.i("MyActivity","State of activity Main Activity changed from Create to Start");
            create = false;
        }
        else if(restart){
            Toast.makeText(MainActivity.this, "State of activity Main Activity changed from Restart to Start", Toast.LENGTH_SHORT).show();
            Log.i("MyActivity","State of activity Main Activity changed from Restart to Start");
            restart = false;
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

        resume = true;
        if (start){
            Toast.makeText(MainActivity.this, "State of activity Main Activity changed from Start to Resume", Toast.LENGTH_SHORT).show();
            Log.i("MyActivity","State of activity Main Activity changed from Start to Resume");
            start = false;
        }
        else if(pause){
            Toast.makeText(MainActivity.this, "State of activity Main Activity changed from Pause to Resume", Toast.LENGTH_SHORT).show();
            Log.i("MyActivity","State of activity Main Activity changed from Pause to Resume");
            pause = false;
        }
    }
    @Override
    protected void onRestart() {
        super.onRestart();

        restart = true;
        if (stop){
            Toast.makeText(MainActivity.this, "State of activity Main Activity changed from Stop to Restart", Toast.LENGTH_SHORT).show();
            Log.i("MyActivity","State of activity Main Activity changed from Stop to Restart");
            stop = false;
        }
        else if(pause){
            Toast.makeText(MainActivity.this, "State of activity Main Activity changed from Pause to Restart", Toast.LENGTH_SHORT).show();
            Log.i("MyActivity","State of activity Main Activity changed from Pause to Restart");
            pause = false;
        }

    }

    @Override
    protected void onPause() {
        super.onPause();

        pause = true;
        resume = false;
        Toast.makeText(MainActivity.this, "State of activity Main Activity changed from Resume to Pause", Toast.LENGTH_SHORT).show();
        Log.i("MyActivity","State of activity Main Activity changed from Resume to Pause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        stop= true;
        pause = false;
        Toast.makeText(MainActivity.this, "State of activity Main Activity changed from Pause to Stop", Toast.LENGTH_SHORT).show();
        Log.i("MyActivity","State of activity Main Activity changed from Pause to Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stop = false;

        Toast.makeText(MainActivity.this, "State of activity Main Activity changed from Stop to Destroy", Toast.LENGTH_SHORT).show();
        Log.i("MyActivity","State of activity Main Activity changed from Stop to Destroy");
    }


}
