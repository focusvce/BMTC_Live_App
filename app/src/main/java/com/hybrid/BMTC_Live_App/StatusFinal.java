package com.hybrid.BMTC_Live_App;

import android.speech.tts.TextToSpeech;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StatusFinal extends AppCompatActivity {


    EditText bn,s,d,c,n;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_final);
        bn= (EditText) findViewById(R.id.ETbusno);
        s= (EditText) findViewById(R.id.Src);
        d= (EditText) findViewById(R.id.Dest);
        n= (EditText) findViewById(R.id.Present);
        c= (EditText) findViewById(R.id.Crowd);
        b= (Button) findViewById(R.id.btn_choice3);

    }
    public void update(View view){
        String bus_no = bn.getText().toString();
        String bus_src = s.getText().toString();
        String bus_dest = d.getText().toString();
        String bus_now = n.getText().toString();
        String bus_crowd = c.getText().toString();
        String method = "update";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method, bus_no, bus_src,bus_dest,bus_now,bus_crowd);
    }
}
