package com.hybrid.BMTC_Live_App;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    TextInputLayout mBusno, mPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mBusno = (TextInputLayout)findViewById(R.id.bus_noLogin);
        mPass = (TextInputLayout)findViewById(R.id.passwordLogin);

    }

    public void loginFinal(View view){
        String bus_no = mBusno.getEditText().getText().toString();
        String bus_pass = mPass.getEditText().getText().toString();
        String method = "login";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,bus_no,bus_pass);
    }


}
