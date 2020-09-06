package com.example.splashscreenfarmersapp.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.splashscreenfarmersapp.R;

public class ForgetPasswordFragment extends Fragment {
    ImageView btn_forgetpassword_back;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forget_password, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btn_forgetpassword_back=(ImageView)getActivity().findViewById(R.id.btn_forgetpassword_back);

        btn_forgetpassword_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((LoginRegistrationActivity)getActivity()).replacFragment(0);
            }
        });

    }
}