package com.example.splashscreenfarmersapp.retrofit;

import android.os.AsyncTask;
import android.util.Log;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetNetworkConnection extends AsyncTask<Void, Void, Void> {
    POSTCardService postCardService;
    GetCardService getCardService;


    public GetNetworkConnection() {

    }

    @Override
    protected Void doInBackground(Void... voids) {

        ///////////////////// GET ////////////////////////////
//        final Message msg = new Message();
//
//
//        if (this.getCardService == null) {
//            this.getCardService = new GetCardService();
//        }
//
//        getCardService
//                .getAPI()
//                .get(1230000)
//                .enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                        Log.v("post","Val");
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//                        Log.v("post","Val");
//                    }
//                });
        //////////////////// GET END///////////////////////////////



        /////////////////// POST /////////////////////////

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
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.v("post","Val");
                    }
                });

        /////////////////// POST END /////////////////////////


        return null;
    }

}