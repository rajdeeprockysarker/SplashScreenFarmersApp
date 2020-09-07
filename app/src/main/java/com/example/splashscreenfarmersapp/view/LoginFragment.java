package com.example.splashscreenfarmersapp.view;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.splashscreenfarmersapp.R;
import com.example.splashscreenfarmersapp.retrofit.GetNetworkConnection;
import com.example.splashscreenfarmersapp.viewmodel.LoginLiveData;
import com.example.splashscreenfarmersapp.viewmodel.SignupLiveData;


public class LoginFragment extends Fragment {


    TextView txt_signup, txt_forget_password;
    Button btn_login;
    ProgressDialog dialog;
    EditText edt_username, edt_password;


    private LoginLiveData mLoginLiveData;

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
        txt_signup = (TextView) getActivity().findViewById(R.id.txt_signup);
        btn_login = (Button) getActivity().findViewById(R.id.btn_login);
        txt_forget_password = (TextView) getActivity().findViewById(R.id.txt_forget_password);
        edt_username = (EditText) getActivity().findViewById(R.id.edt_username);
        edt_password = (EditText) getActivity().findViewById(R.id.edt_password);

        mLoginLiveData = new ViewModelProvider(getActivity()).get(LoginLiveData.class);
        dialog = ProgressDialog.show(getActivity(), getResources().getString(
                R.string.loading
        ), getResources().getString(R.string.please_wait), true);

        dialog.dismiss();
        mLoginLiveData.userList.observe(this, new Observer() {
            @Override
            public void onChanged(Object o) {
                Log.v("", "" + ((MutableLiveData) o).getValue());
                if ((Integer) ((MutableLiveData) o).getValue() == 10) {
                    Toast.makeText(getContext(), "Success", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), "Failed", Toast.LENGTH_LONG).show();
                }
                dialog.dismiss();
            }
        });

        txt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("", "");
                ((LoginRegistrationActivity) getActivity()).replacFragment(1);
            }
        });
        txt_forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("", "");
                ((LoginRegistrationActivity) getActivity()).replacFragment(2);
            }
        });
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckLogin();
            }
        });
    }

    private void CheckLogin() {
        if (edt_username.getText().toString().trim().length() > 0 &&
                edt_password.getText().toString().trim().length() > 0) {
            dialog.show();
            mLoginLiveData.setUserIdForEditUser(10);
        }
        if(edt_username.getText().toString().trim().isEmpty()){
            edt_username.setError("Please insert your username");
        }
        if(edt_password.getText().toString().trim().isEmpty()){
            edt_password.setError("Please insert your password");
        }
    }


}