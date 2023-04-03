package com.example.sindhilearning.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sindhilearning.R;
import com.example.sindhilearning.beans.ConsonentBean;
import com.example.sindhilearning.interfaces.RecyclerViewClickListener;

import java.util.ArrayList;

/**
 * Created by aliraza on 05/19/2019.
 */

public class AdapterConsonant extends RecyclerView.Adapter<AdapterConsonant.MyViewHolder> {
    private ArrayList<ConsonentBean> rhymesBeans;
    private RecyclerViewClickListener mListener;


    public AdapterConsonant(RecyclerViewClickListener mListener, ArrayList<ConsonentBean> list) {
        this.mListener = mListener;
        rhymesBeans = list;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public CardView textView;
        public TextView tv_consonent;


        private RecyclerViewClickListener mListener;

        public MyViewHolder(CardView v, RecyclerViewClickListener listener) {
            super(v);
            textView = v;
            tv_consonent = (TextView) v.findViewById(R.id.tv_consonent);


            mListener = listener;
            v.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mListener.onClick(v, getAdapterPosition());
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)


    // Create new views (invoked by the layout manager)
    @Override
    public AdapterConsonant.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.row_design_consonant, parent, false);
        AdapterConsonant.MyViewHolder vh = new AdapterConsonant.MyViewHolder(v, mListener);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(AdapterConsonant.MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //holder.textView.setText(mDataset[position]);


        holder.tv_consonent.setText(""+rhymesBeans.get(position).getConsonent());
        holder.tv_consonent.setTextColor(rhymesBeans.get(position).getColor());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return rhymesBeans.size();//mDataset.length;
    }

}
