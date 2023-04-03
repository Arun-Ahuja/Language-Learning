package com.example.sindhilearning.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sindhilearning.R;
import com.example.sindhilearning.beans.RhymesBean;
import com.example.sindhilearning.interfaces.RecyclerViewClickListener;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RhymesAdapter extends RecyclerView.Adapter<RhymesAdapter.MyViewHolder> {
    private ArrayList<RhymesBean> rhymesBeans;
    private RecyclerViewClickListener mListener;


    public RhymesAdapter(RecyclerViewClickListener mListener,ArrayList<RhymesBean> list) {
        this.mListener = mListener;
        rhymesBeans=list;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public CardView textView;
        public TextView tv_english;
        public TextView tv_sindh;
        public ImageView imageView;

        private RecyclerViewClickListener mListener;

        public MyViewHolder(CardView v, RecyclerViewClickListener listener) {
            super(v);
            textView = v;
            tv_english=(TextView)v.findViewById(R.id.tv_english);
            tv_sindh=(TextView)v.findViewById(R.id.tv_sindhi);
            imageView=(ImageView)v.findViewById(R.id.iv_rhymes);

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
    public RhymesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.row_design_rhymes, parent, false);
        MyViewHolder vh = new MyViewHolder(v,mListener);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //holder.textView.setText(mDataset[position]);

        holder.tv_english.setText(""+rhymesBeans.get(position).getName_eng());
        holder.tv_sindh.setText(""+rhymesBeans.get(position).getName_sindhi());
        holder.imageView.setImageResource(rhymesBeans.get(position).getImage());


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return rhymesBeans.size();//mDataset.length;
    }
}
