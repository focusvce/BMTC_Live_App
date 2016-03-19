package com.hybrid.BMTC_Live_App;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by adarsh on 17/3/16.
 */
public class VolleySingle {
    private static VolleySingle sInstance = null;
    private RequestQueue requestQueue;

    private VolleySingle(){
        requestQueue = Volley.newRequestQueue(MyApplication.getAppContext());
    }
    public static VolleySingle getsInstance(){
        if(sInstance==null){
            sInstance =  new VolleySingle();
        }
        return sInstance;
    }
    public RequestQueue getRequestQueue(){
            return requestQueue;
    }
}
