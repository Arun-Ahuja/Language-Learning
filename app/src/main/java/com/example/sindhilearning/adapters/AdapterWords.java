package com.example.sindhilearning.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sindhilearning.R;
import com.example.sindhilearning.beans.SentenceBean;
import com.example.sindhilearning.beans.WordsBean;

import java.util.ArrayList;

/**
 * Created by aliraza on 05/20/2019.
 */

public class AdapterWords extends BaseAdapter{

    ArrayList<WordsBean> list;
    Context context;

    public AdapterWords(Context context,ArrayList<WordsBean> list) {
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
            convertView=View.inflate(parent.getContext(), R.layout.row_design_words,null);
        }

        TextView tv_sindhi=(TextView)convertView.findViewById(R.id.tv_sindhi);
        TextView tv_broken=(TextView)convertView.findViewById(R.id.broken_sindhi);
        TextView tv_eng=(TextView)convertView.findViewById(R.id.tv_english);
        ImageView iv=(ImageView)convertView.findViewById(R.id.iv);

        iv.setImageResource(list.get(position).getImage());
        tv_broken.setText(list.get(position).getBroken_sindhi()+"="+list.get(position).getSindhi());

        tv_broken.setTextColor(list.get(position).getColor());
//        tv_urdu.setText(list.get(position).getSentence_uru());

        tv_eng.setText(list.get(position).getEnglish());


        return convertView;
    }



}
