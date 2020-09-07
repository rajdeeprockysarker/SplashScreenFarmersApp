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
import androidx.lifecycle.ViewModel;

import com.example.splashscreenfarmersapp.retrofit.GetNetworkConnection;
import com.example.splashscreenfarmersapp.retrofit.POSTCardService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupLiveData extends AndroidViewModel {


    private MutableLiveData<Integer> userId = new MutableLiveData<>();
    public LiveData userList = Transformations.map(userId, new Function() {
        @Override
        public Object apply(Object user) {

            return userId;
        }
    });

    public SignupLiveData(@NonNull Application application) {
        super(application);
    }

    public void setUserIdForEditUser(int id) {

        if (userId == null) {
            userId = new MutableLiveData<>();
        }
        new SignupConnection().execute();


    }


    public class SignupConnection extends AsyncTask<Void, Void, Void> {
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
                                userId.postValue(10);
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Log.v("post","Val");
                                userId.postValue(9);
                            }
                        });


            }
            catch (Exception e){

            }

            return null;
        }
    }


}
