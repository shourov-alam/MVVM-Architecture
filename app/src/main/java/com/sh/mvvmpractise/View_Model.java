package com.sh.mvvmpractise;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


public class View_Model extends AndroidViewModel {

   public Model_UserRepository userRepository;


    public View_Model(@NonNull Application application) {
        super(application);
        userRepository=new Model_UserRepository(application);
    }

    public LiveData<UserPojo[]> getAllUsers(){

        return userRepository.getUserData();
    }
}
