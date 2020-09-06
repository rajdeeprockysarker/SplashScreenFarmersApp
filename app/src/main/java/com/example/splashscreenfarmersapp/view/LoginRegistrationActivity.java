package com.example.splashscreenfarmersapp.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.splashscreenfarmersapp.R;

public class LoginRegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginregistration);
        LoadLoginFragment();


    }

    public void LoadLoginFragment(){

        LoginFragment newFragment = new LoginFragment();
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fram_loginregistation, newFragment);
        transaction.commit();
    }

    public void LoadSignupFragment(){

        SignupFragment newFragment = new SignupFragment();
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fram_loginregistation, newFragment);

        transaction.commit();
    }

    public void LoadForgetPasswordFragment(){

        ForgetPasswordFragment newFragment = new ForgetPasswordFragment();
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fram_loginregistation, newFragment);

        transaction.commit();
    }

    public void LoadVirifyOTPFragment(){

        SignupOTPFragment newFragment = new SignupOTPFragment();
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fram_loginregistation, newFragment);

        transaction.commit();
    }


    public void replacFragment(int flag){

        switch (flag){
            case 0:
                LoadLoginFragment();
                break;
            case 1:
                LoadSignupFragment();
                break;
            case 2:
                LoadForgetPasswordFragment();
                break;
            case 3:
                LoadVirifyOTPFragment();
                break;
        }

    }

    @Override
    public void onBackPressed() {
       // super.onBackPressed();
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fram_loginregistation);
        if(fragment instanceof SignupFragment){
            replacFragment(0);
            return;
        }
        else if(fragment instanceof ForgetPasswordFragment){
            replacFragment(0);
            return;
        }
        else if(fragment instanceof SignupOTPFragment){
            replacFragment(0);
            return;
        }
        else{
            finish();
        }
    }
}