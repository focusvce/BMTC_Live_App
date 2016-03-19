package com.hybrid.BMTC_Live_App;

import android.app.AlertDialog;

import android.content.Context;
import android.content.Intent;

import android.os.AsyncTask;

import android.util.Log;


import android.widget.TextView;
import android.widget.Toast;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class BackgroundTask extends AsyncTask<String, Void, String> {


    String SERVER_JUNK = "<!-- Hosting24 Analytics Code --><script type=\"text/javascript\" src=\"http://stats.hosting24.com/count.php\"></script><!-- End Of Analytics Code -->";

    AlertDialog alertDialog;

    String flag = "0";
    TextView bn, s, d, c, n;

    //SharedPreferences sharedPreferences;
    Context ctx;

    public BackgroundTask(Context ctx) {
        this.ctx = ctx;
    }

    public BackgroundTask(Context ctx, TextView bn, TextView s, TextView d, TextView c, TextView n) {
        this.bn = bn;
        this.s = s;
        this.c = c;
        this.s = s;
        this.d = d;
    }

    //ProgressDialog bar;

   /* public void setProgressBar(ProgressDialog bar) {
        this.bar = bar;
    }*/

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
       /* bar.setCancelable(true);
        bar.setIndeterminate(true);
        bar.setMessage("Loading ...");
        bar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        bar.setProgress(0);
        bar.setMax(100);
        bar.show();*/

        alertDialog = new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Error");

    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url = "http://192.168.1.8/bmtc/register(1).php";
        String login_url = "http://192.168.1.8/bmtc/login(1).php";
        String update_url ="http://192.168.1.8/bmtc/update.php";
        String method = params[0];
        if (method.equals("newbus")) {
            // bar.cancel();
            String bus_no = params[1];
            String bus_pass = params[2];
            String bus_src = params[3];
            String bus_dest = params[4];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                //to write we need a buffer writer variable
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("bus_no", "UTF-8") + "=" + URLEncoder.encode(bus_no, "UTF-8") + "&" +
                        URLEncoder.encode("bus_pass", "UTF-8") + "=" + URLEncoder.encode(bus_pass, "UTF-8") + "&" +
                        URLEncoder.encode("bus_src", "UTF-8") + "=" + URLEncoder.encode(bus_src, "UTF-8") + "&" +
                        URLEncoder.encode("bus_dest", "UTF-8") + "=" + URLEncoder.encode(bus_dest, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                inputStream.close();
                return "Registration Success";


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } else if (method.equals("login")) {

            final String bus_no = params[1];
            final String bus_pass = params[2];
            Log.e("ADARSH", "received " + bus_no + "  " + bus_pass);

            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("bus_no", "UTF-8") + "=" + URLEncoder.encode(bus_no, "UTF-8") + "&" +
                        URLEncoder.encode("bus_pass", "UTF-8") + "=" + URLEncoder.encode(bus_pass, "UTF-8");
                Log.e("ADARSH", data);
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                Log.e("ADARSH", response);


                return response;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (method.equals("update")) {

            String bus_no = params[1];
            String bus_src = params[2];
            String bus_dest = params[3];
            String bus_now = params[4];
            String bus_crowd = params[5];

            try {
                URL url = new URL(update_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                //to write we need a buffer writer variable
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("bus_no", "UTF-8") + "=" + URLEncoder.encode(bus_no, "UTF-8") + "&" +
                        URLEncoder.encode("bus_src", "UTF-8") + "=" + URLEncoder.encode(bus_src, "UTF-8") + "&" +
                        URLEncoder.encode("bus_dest", "UTF-8") + "=" + URLEncoder.encode(bus_dest, "UTF-8") + "&" +
                        URLEncoder.encode("bus_now", "UTF-8") + "=" + URLEncoder.encode(bus_now, "UTF-8") + "&" +
                        URLEncoder.encode("bus_crowd", "UTF-8") + "=" + URLEncoder.encode(bus_crowd, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                Log.e("ADARSH",response);
                return "Update successful";


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }


    @Override
    protected void onPostExecute(String result) {
        Log.e("TAG", "Result: " + result);


        if (result.equals("Registration Success")) {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        } else if (result.equals("Update successful")) {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
        } else if (result.equals("No info")) {
            alertDialog.setMessage("No such user available!");
            alertDialog.show();

        } else if (result.equals("Welcome")) {

            Toast.makeText(ctx, "Login Success", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(ctx, StatusFinal.class);
            ctx.startActivity(i);

        } else if (result.equals("search")) {
            Log.e("ADARSH", "search complete");
        }
    }


    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);

    }
}


