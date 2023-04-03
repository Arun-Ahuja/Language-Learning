package com.example.sindhilearning.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sindhilearning.R;
import com.example.sindhilearning.beans.OptionsBean;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by aliraza on 05/15/2019.
 */

public class AdaperSentenceGameOptions extends BaseAdapter {


    ArrayList<OptionsBean> optionsBeans;
    Context context;
    public int answer=-1;
    public int pos=-1;

    public AdaperSentenceGameOptions(ArrayList<OptionsBean> optionsBeans, Context context) {
        this.optionsBeans = optionsBeans;
        this.context = context;
    }

    @Override
    public int getCount() {
        return optionsBeans.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView=View.inflate(parent.getContext(), R.layout.custom_item_for_option,null);
        }
        TextView txt_sindhi=(TextView)convertView.findViewById(R.id.txt_sindhi);
        txt_sindhi.setText(""+optionsBeans.get(position).getOption());
        LinearLayout ll=(LinearLayout)convertView.findViewById(R.id.ll);

        if (answer==1 && pos==position){
            ll.setBackgroundResource(R.drawable.rounded_corner_yellow_button_selected);
        }else if(answer==0 && pos==position){
            ll.setBackgroundColor(Color.WHITE);
        }
        else {
            ll.setBackgroundResource(R.drawable.sentence_game_option_selector);
        }

        return convertView;

    }
}
