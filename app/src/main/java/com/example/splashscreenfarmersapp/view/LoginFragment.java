package com.example.splashscreenfarmersapp.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.splashscreenfarmersapp.R;
import com.example.splashscreenfarmersapp.retrofit.GetNetworkConnection;


public class LoginFragment extends Fragment {



    TextView txt_signup,txt_forget_password;
    Button btn_login;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        txt_signup=(TextView) getActivity().findViewById(R.id.txt_signup);
        btn_login=(Button) getActivity().findViewById(R.id.btn_login);
        txt_forget_password=(TextView) getActivity().findViewById(R.id.txt_forget_password);
        txt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("","");
                ((LoginRegistrationActivity)getActivity()).replacFragment(1);
            }
        });
        txt_forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("","");
                ((LoginRegistrationActivity)getActivity()).replacFragment(2);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GetNetworkConnection().execute();
            }
        });
    }
}