package com.sh.mvvmpractise;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Model_UserRepository {
    private Application application;
    private UserPojo[] userPojos;
    private MutableLiveData<UserPojo[]> mutableLiveData;

    private String url="https://api.github.com/users";

    public Model_UserRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<UserPojo[]> getUserData(){
        if(mutableLiveData==null){
            mutableLiveData=new MutableLiveData<>();
        }

RequestQueue queue= Volley.newRequestQueue(application);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        GsonBuilder gsonBuilder =new GsonBuilder();
                        Gson gson=gsonBuilder.create();
                        userPojos=gson.fromJson(response,UserPojo[].class);
                        mutableLiveData.postValue(userPojos);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
return mutableLiveData;
    }
}
