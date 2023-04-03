package com.example.sindhilearning.adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.sindhilearning.R;
import com.example.sindhilearning.beans.AlphabetQuizBean;
import com.example.sindhilearning.beans.LessionBean;
import com.example.sindhilearning.fragments.AlphabetFrag;
import com.example.sindhilearning.interfaces.RecyclerViewClickListener;

import java.util.ArrayList;

/**
 * Created by aliraza on 07/03/2019.
 */

public class AdapterAlphaQuiz extends RecyclerView.Adapter<AdapterAlphaQuiz.MyViewHolder> {
    String[]options;
    private RecyclerViewClickListener mListener;
    String[] colors={"#FF00FF","#9B870c","#800080","#006400","#0B0EED","#08F5DC"};


    public AdapterAlphaQuiz(RecyclerViewClickListener mListener,String[]options) {
        this.mListener = mListener;
        this.options=options;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
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
            mListener.onClick(v, getAdapterPosition());

//            if (option.equalsIgnoreCase(""+a.get(getAdapterPosition).getAnswer())){
//                AlphabetFrag.tv_ans.setText("Right");
//            }
//            else {
//                AlphabetFrag.tv_ans.setText("Wrong!");
//            }
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)


    // Create new views (invoked by the layout manager)
    @Override
    public AdapterAlphaQuiz.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        RelativeLayout v = (RelativeLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.row_design_lesson, parent, false);
        AdapterAlphaQuiz.MyViewHolder vh = new AdapterAlphaQuiz.MyViewHolder(v,mListener);


        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(AdapterAlphaQuiz.MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //holder.textView.setText(mDataset[position]);

        String option=options[position];
        holder.alphabet.setText(""+option);
        holder.alphabet.setTextColor(Color.parseColor(colors[position]));



        // holder.tv_sindh.setText(""+rhymesBeans.get(position).getName_sindhi());
        // holder.imageView.setImageResource(rhymesBeans.get(position).getImage());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return options.length;//mDataset.length;
    }

}
