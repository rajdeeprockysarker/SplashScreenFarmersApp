package com.example.splashscreenfarmersapp.view;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.splashscreenfarmersapp.R;
import com.example.splashscreenfarmersapp.viewmodel.LoginLiveData;
import com.example.splashscreenfarmersapp.viewmodel.SignupLiveData;

public class SignupFragment extends Fragment {


    EditText edt_full_name, edt_mobileno, edt_password, edt_confirm_password;
    Button btn_reciveotp;
    ImageView btn_signup_back;
    ProgressDialog dialog ;
    private LoginLiveData mLoginLiveData;


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
        edt_full_name = (EditText) getActivity().findViewById(R.id.edt_full_name);
        edt_mobileno = (EditText) getActivity().findViewById(R.id.edt_mobileno);
        edt_password = (EditText) getActivity().findViewById(R.id.edt_password);
        edt_confirm_password = (EditText) getActivity().findViewById(R.id.edt_confirm_password);
        btn_reciveotp = (Button) getActivity().findViewById(R.id.btn_reciveotp);
        btn_signup_back = (ImageView) getActivity().findViewById(R.id.btn_signup_back);
        dialog = ProgressDialog.show(getActivity(), getResources().getString(
                R.string.loading
        ), getResources().getString(R.string.please_wait), true);

        dialog.dismiss();

        mLoginLiveData=new ViewModelProvider(getActivity()).get(LoginLiveData.class);

        mLoginLiveData.registrationCheckForMobile.observe(this, new Observer() {
            @Override
            public void onChanged(Object o) {
                Log.v("",""+((MutableLiveData) o).getValue());

                if((Integer) ((MutableLiveData) o).getValue()==0){
                    mLoginLiveData.initiateRegistrationForUser(1);
                }
                else{
                    if((Integer) ((MutableLiveData) o).getValue()==1)
                        Toast.makeText(getContext(), "User exists", Toast.LENGTH_LONG).show();
                    if((Integer) ((MutableLiveData) o).getValue()==2)
                        Toast.makeText(getContext(), "Network error", Toast.LENGTH_LONG).show();

                }
            }
        });
        mLoginLiveData.registrationCheck.observe(this, new Observer() {
            @Override
            public void onChanged(Object o) {
                Log.v("",""+((MutableLiveData) o).getValue());
//                if((Integer)((MutableLiveData) o).getValue()==10) {
//                    Toast.makeText(getContext(), "Success", Toast.LENGTH_LONG).show();
//                }
//                else
//                {
//                    Toast.makeText(getContext(),"Failed",Toast.LENGTH_LONG).show();
//                }
                dialog.dismiss();
            }
        });




        btn_signup_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((LoginRegistrationActivity) getActivity()).replacFragment(0);
            }
        });

        btn_reciveotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickReciveOTP();
            }
        });
    }

    public void onClickReciveOTP() {
        boolean flag = true;
        if (edt_full_name.getText().toString().trim().isEmpty()) {
            edt_full_name.setError("Must insert field");
            flag = false;
        }
        if (edt_mobileno.getText().toString().trim().isEmpty()) {
            edt_mobileno.setError("Must insert field");
            flag = false;
        }
        if (edt_password.getText().toString().trim().isEmpty()) {
            edt_password.setError("Must insert field");
            flag = false;
        }
        if (edt_confirm_password.getText().toString().trim().isEmpty()) {
            edt_confirm_password.setError("Must insert field");
            flag = false;
        }
        if (edt_password.getText().toString().trim().length() < 6) {
            edt_password.setError("Must be morethan 5 charecter");
            flag = false;
        }
        if (edt_confirm_password.getText().toString().trim().length() < 6) {
            edt_confirm_password.setError("Must be morethan 5 charecter");
            flag = false;
        }

        if (flag) {
            ((LoginRegistrationActivity) getActivity()).replacFragment(3);
        }

        dialog.show();
        mLoginLiveData.setUserIdForEditUserAgainstMobileNo(6);

    }
}