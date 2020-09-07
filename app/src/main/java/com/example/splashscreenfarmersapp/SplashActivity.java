package com.example.splashscreenfarmersapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.splashscreenfarmersapp.view.LoginRegistrationActivity;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SplashActivity extends AppCompatActivity {

    String[] permissions = new String[] {
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
    };
    public static final int MULTIPLE_PERMISSIONS = 10; // code you want.
    RadioGroup radioGroup;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        radioGroup = (RadioGroup) findViewById(R.id.myRadioGroup);
        next=(Button)findViewById(R.id.next);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if(checkedId == R.id.rd_english) {
                    setLocale("en");
                } else if(checkedId == R.id.rd_hindi) {
                    setLocale("mr");
                } else {
                    setLocale("mr");
                }

                next.setText(R.string.next);
            }

        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inti=new Intent(SplashActivity.this, LoginRegistrationActivity.class);
                startActivity(inti);
                finish();
            }
        });


        if (checkPermissions()){
            // permissions granted.
            openLogin();
        } else {
            // show dialog informing them that we lack certain permissions
        }


    }

    public void openLogin(){
        if( CustomeShreadPreferance.getDefaultLanguage(getApplicationContext()).length()>0){
            radioGroup.setVisibility(View.GONE);
            next.setVisibility(View.GONE);
            new splashTime().execute();
        }
    }


    class splashTime extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Intent inti=new Intent(SplashActivity.this, LoginRegistrationActivity.class);
            startActivity(inti);
            finish();
        }
    }



    public void setLocale(String localeName) {

            Locale myLocale = new Locale(localeName);
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = myLocale;
            res.updateConfiguration(conf, dm);

        CustomeShreadPreferance.saveDefaultLanguage(getApplicationContext(),localeName);
    }

    public static void setLocaleEn (Context context){
        Locale locale = new Locale("en_US");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getApplicationContext().getResources().updateConfiguration(config, null);
    }



    private boolean checkPermissions() {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p:permissions) {
            result = ContextCompat.checkSelfPermission(this,p);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MULTIPLE_PERMISSIONS:{
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    // permissions granted.
                    openLogin();
                } else {
                    // no permissions granted.
                    openLogin();
                }
                return;
            }
        }
    }


}