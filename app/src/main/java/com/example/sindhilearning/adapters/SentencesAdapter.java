package com.example.sindhilearning.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sindhilearning.R;
import com.example.sindhilearning.beans.SentenceBean;

import java.util.ArrayList;

/**
 * Created by aliraza on 05/08/2019.
 */

public class SentencesAdapter extends BaseAdapter {


    ArrayList<SentenceBean> list;
    Context context;

    public SentencesAdapter(Context context,ArrayList<SentenceBean> list) {
        this.list = list;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView=View.inflate(parent.getContext(), R.layout.row_desing_sentences,null);
        }

        TextView tv_sindhi=(TextView)convertView.findViewById(R.id.tv_sindhi);
        TextView tv_urdu=(TextView)convertView.findViewById(R.id.tv_urdu);
        TextView tv_eng=(TextView)convertView.findViewById(R.id.tv_english);

        tv_sindhi.setText(list.get(position).getSentence_sindhi());
        tv_sindhi.setTextColor(list.get(position).getColor());
        tv_urdu.setText(list.get(position).getSentence_uru());
        tv_eng.setText(list.get(position).getSentence_english());


        return convertView;
    }
}
