package com.example.sindhilearning.adapters;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sindhilearning.R;
import com.example.sindhilearning.beans.LessionBean;
import com.example.sindhilearning.beans.RhymesBean;
import com.example.sindhilearning.interfaces.RecyclerViewClickListener;

import java.util.ArrayList;

/**
 * Created by aliraza on 06/03/2019.
 */

public class AdapterLessonAlpha extends RecyclerView.Adapter<AdapterLessonAlpha.MyViewHolder> {
    private ArrayList<LessionBean> lessionBeans;
    private RecyclerViewClickListener mListener;
    public MediaPlayer mPlayer;
    Context context;

    String[] colors={"#006400","#0B0EED","#08F5DC","#FF00FF","#9B870c","#800080"};



    public AdapterLessonAlpha(Context context, RecyclerViewClickListener mListener,ArrayList<LessionBean> list) {
        this.mListener = mListener;
        lessionBeans=list;
        this.context=context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public RelativeLayout relativeLayout;
        public TextView alphabet;


        private RecyclerViewClickListener mListener;

        public MyViewHolder(RelativeLayout v, RecyclerViewClickListener listener) {
            super(v);
            relativeLayout = v;

            alphabet=(TextView)v.findViewById(R.id.alphabet);




            mListener = listener;
            v.setOnClickListener(this);
            alphabet.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mListener.onClick(v, getPosition());





        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)


    // Create new views (invoked by the layout manager)
    @Override
    public AdapterLessonAlpha.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        RelativeLayout v = (RelativeLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.row_design_lesson, parent, false);
        AdapterLessonAlpha.MyViewHolder vh = new AdapterLessonAlpha.MyViewHolder(v,mListener);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(AdapterLessonAlpha.MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //holder.textView.setText(mDataset[position]);

        holder.alphabet.setText(""+lessionBeans.get(position).getLetter());
        holder.alphabet.setTextColor(Color.parseColor(colors[position]));

       // holder.tv_sindh.setText(""+rhymesBeans.get(position).getName_sindhi());
       // holder.imageView.setImageResource(rhymesBeans.get(position).getImage());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return lessionBeans.size();//mDataset.length;
    }

}