package com.hybrid.BMTC_Live_App;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }



    public void new_bus(View view){
        startActivity(new Intent(this, New_bus.class));
    }

    public void login(View view){
        startActivity(new Intent(this, Login.class));
    }

    public void user(View view){
        startActivity(new Intent(this,User_activity.class));
    }


}
