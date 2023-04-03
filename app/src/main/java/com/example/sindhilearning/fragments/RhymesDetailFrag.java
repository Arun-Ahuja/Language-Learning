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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sindhilearning.R;
import com.example.sindhilearning.classes.BAL;
import com.example.sindhilearning.classes.Util;


public class RhymesDetailFrag extends Fragment {

    private Button btn_play_rhyme;
    private TextView tv_english, tv_sindhi, tv_poet, tv_singer, tv_director;
    private ImageView iv_rhymes_detail;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_rhymes_detail, container, false);
        btn_play_rhyme=(Button) view.findViewById(R.id.btn_play_rhyme);
        tv_english=(TextView)view.findViewById(R.id.tv_english);
        tv_sindhi=(TextView)view.findViewById(R.id.tv_sindhi);
        iv_rhymes_detail=(ImageView) view.findViewById(R.id.iv_rhymes_detail);
        tv_poet=(TextView) view.findViewById(R.id.tv_poet);
        tv_singer=(TextView) view.findViewById(R.id.tv_singer);
        tv_director=(TextView) view.findViewById(R.id.tv_director);


        tv_sindhi.setText(""+ BAL.list.get(Util.rhyme_selected_position).getName_sindhi());
        tv_english.setText(""+ BAL.list.get(Util.rhyme_selected_position).getName_eng());

        tv_poet.setText(""+BAL.list.get(Util.rhyme_selected_position).getWriter());
        tv_singer.setText(""+BAL.list.get(Util.rhyme_selected_position).getSinger());
        tv_director.setText(""+BAL.list.get(Util.rhyme_selected_position).getMusic());

        iv_rhymes_detail.setImageResource(BAL.list.get(Util.rhyme_selected_position).getImage());
        //iv_rhymes_detail.setImageDrawable(getResources().getDrawable(R.drawable.jhoomati));


        btn_play_rhyme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToAnotherFrag(new RhymePlayScreenFrag(),"");
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

    private void moveToAnotherFrag(Fragment fragment, String backToStack){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.layout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
