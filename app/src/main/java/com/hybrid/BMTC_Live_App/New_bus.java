package com.hybrid.BMTC_Live_App;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class New_bus extends AppCompatActivity {
    TextInputLayout mbusno, mpass, msrc, mdest ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_bus);
        mbusno = (TextInputLayout) findViewById(R.id.bus_no);
        mpass = (TextInputLayout) findViewById(R.id.password);
        msrc = (TextInputLayout) findViewById(R.id.src);
        mdest = (TextInputLayout) findViewById(R.id.dest);

    }

    public void submit(View view){
        String busno = mbusno.getEditText().getText().toString();
        String pass = mpass.getEditText().getText().toString();
        String src = msrc.getEditText().getText().toString();
        String dest = mdest.getEditText().getText().toString();
        String method = "newbus";
        BackgroundTask back = new BackgroundTask(this);
        back.execute(method,busno,pass,src,dest);
    }

    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnected();
    }
}
