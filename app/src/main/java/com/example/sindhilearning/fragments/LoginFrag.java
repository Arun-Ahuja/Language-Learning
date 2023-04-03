package com.example.sindhilearning.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sindhilearning.R;

import org.w3c.dom.Text;


public class LoginFrag extends Fragment {

    TextView tv_guest,tv_signup;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_login, container, false);

        tv_guest=(TextView)view.findViewById(R.id.tv_guest);
        tv_signup=(TextView)view.findViewById(R.id.tv_signup);

        tv_guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             moveToAnOtherFrag(new DashBoardFrag());
            }
        });

        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToAnOtherFrag(new RegisterFrag());
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
}

    @Override
    public void onDetach() {
        super.onDetach();

    }
    public void moveToAnOtherFrag(Fragment fragment){

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout, fragment);
        fragmentTransaction.commit();

    }
}
