package com.sh.mvvmpractise;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   public View_Model view_model;
    RecyclerView recyclerView;

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        view_model=new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(View_Model.class);


      //  view_model = new ViewModelProvider(this).get(View_Model.class);


        view_model.getAllUsers().observe(MainActivity.this, new Observer<UserPojo[]>() {
            @Override
            public void onChanged(UserPojo[] userPojos) {

             recyclerView.setAdapter(new User_Adapter(userPojos));
            }
        });

    }
}
