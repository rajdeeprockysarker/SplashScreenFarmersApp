package com.example.splashscreenfarmersapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.splashscreenfarmersapp.view.LoginRegistrationActivity;

import java.util.Locale;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final Button next;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.myRadioGroup);
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

}