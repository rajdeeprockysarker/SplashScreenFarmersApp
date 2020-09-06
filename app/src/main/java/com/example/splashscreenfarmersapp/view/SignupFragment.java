package com.example.splashscreenfarmersapp.view;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.splashscreenfarmersapp.R;

public class SignupFragment extends Fragment{


    EditText edt_full_name,edt_mobileno,edt_password,edt_confirm_password;
    Button btn_reciveotp;
    ImageView btn_signup_back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false);
    }

    @SuppressLint("WrongViewCast")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        edt_full_name=(EditText)getActivity().findViewById(R.id.edt_full_name);
        edt_mobileno=(EditText)getActivity().findViewById(R.id.edt_mobileno);
        edt_password=(EditText)getActivity().findViewById(R.id.edt_password);
        edt_confirm_password=(EditText)getActivity().findViewById(R.id.edt_confirm_password);
        btn_reciveotp=(Button)getActivity().findViewById(R.id.btn_reciveotp);
        btn_signup_back=(ImageView)getActivity().findViewById(R.id.btn_signup_back);

        btn_signup_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((LoginRegistrationActivity)getActivity()).replacFragment(0);
            }
        });

        btn_reciveotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickReciveOTP();
            }
        });
    }

    public void onClickReciveOTP(){
        boolean flag = true;
        if(edt_full_name.getText().toString().trim().isEmpty()) {
            edt_full_name.setError("Must insert field");flag = false;
        }
        if(edt_mobileno.getText().toString().trim().isEmpty()) {
            edt_mobileno.setError("Must insert field");flag = false;
        }
        if(edt_password.getText().toString().trim().isEmpty()) {
            edt_password.setError("Must insert field");flag = false;
        }
        if(edt_confirm_password.getText().toString().trim().isEmpty()) {
            edt_confirm_password.setError("Must insert field");flag = false;
        }
        if(edt_password.getText().toString().trim().length()<6){
            edt_password.setError("Must be morethan 5 charecter");flag = false;
        }
        if(edt_confirm_password.getText().toString().trim().length()<6){
            edt_confirm_password.setError("Must be morethan 5 charecter");flag = false;
        }

        if(flag){
            ((LoginRegistrationActivity)getActivity()).replacFragment(3);
        }

    }
}