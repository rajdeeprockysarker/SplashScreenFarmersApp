package com.example.splashscreenfarmersapp.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.splashscreenfarmersapp.R;


public class SignupOTPFragment extends Fragment {

    Button btn_verifyOTP;
    EditText edt_otp_signup_phoneno;
    TextView txt_otp_signup_phoneno;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup_o_t_p, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btn_verifyOTP=(Button)getActivity().findViewById(R.id.btn_verifyOTP);
         edt_otp_signup_phoneno=(EditText)getActivity().findViewById(R.id.edt_otp_signup_phoneno);
         txt_otp_signup_phoneno=(TextView)getActivity().findViewById(R.id.txt_otp_signup_phoneno);
        txt_otp_signup_phoneno.setText("phone no. 123123123");
    }
}