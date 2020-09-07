package com.example.splashscreenfarmersapp.viewmodel;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.example.splashscreenfarmersapp.model.User;
import com.example.splashscreenfarmersapp.retrofit.POSTCardService;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginLiveData extends AndroidViewModel {


    private MutableLiveData<Integer> checkMobileNoFirstRegistration = new MutableLiveData<>();
    private MutableLiveData<Integer> initiateRegistration = new MutableLiveData<>();
    public LiveData registrationCheckForMobile = Transformations.map(checkMobileNoFirstRegistration, new Function() {
        @Override
        public Object apply(Object user) {

            return checkMobileNoFirstRegistration;
        }
    });

    public LiveData registrationCheck = Transformations.map(initiateRegistration, new Function() {
        @Override
        public Object apply(Object user) {

            return initiateRegistration;
        }
    });

    public LoginLiveData(@NonNull Application application) {
        super(application);
    }

    public void setUserIdForEditUserAgainstMobileNo(int id) {

        if (checkMobileNoFirstRegistration == null) {
            checkMobileNoFirstRegistration = new MutableLiveData<>();
        }
        new SignupMobileNoCheck().execute();


    }

    public void initiateRegistrationForUser(int id) {

        if (initiateRegistration == null) {
            initiateRegistration = new MutableLiveData<>();
        }

        new Signup().execute();


    }


    public class SignupMobileNoCheck extends AsyncTask<Void, Void, Void> {
        POSTCardService postCardService;
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(2000);

                if (this.postCardService == null) {
                    this.postCardService = new POSTCardService();
                }

                postCardService
                        .getAPI()
                        .checkMobileNo("987654321")
                        .enqueue(new Callback<List<User>>() {
                            @Override
                            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                                Log.v("post","Val");
                              if(response.body().size()>0){
                                  checkMobileNoFirstRegistration.postValue(1);
                              }
                              if(response.body().size()==0){
                                  checkMobileNoFirstRegistration.postValue(0);
                              }
                            }

                            @Override
                            public void onFailure(Call<List<User>> call, Throwable t) {
                                Log.v("post","Val");
                                checkMobileNoFirstRegistration.postValue(2);
                            }
                        });

                Log.v("","");


            }
            catch (Exception e){

            }

            return null;
        }
    }
    public class Signup extends AsyncTask<Void, Void, Void> {
        POSTCardService postCardService;
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(2000);

                if (this.postCardService == null) {
                    this.postCardService = new POSTCardService();
                }

                postCardService
                        .getAPI()
                        .createuser("123")
                        .enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                Log.v("post","Val");
                                initiateRegistration.postValue(0);
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Log.v("post","Val");
                                initiateRegistration.postValue(1);
                            }
                        });

                Log.v("","");


            }
            catch (Exception e){

            }

            return null;
        }
    }

}
