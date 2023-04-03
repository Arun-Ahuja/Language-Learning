package com.example.sindhilearning.fragments;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sindhilearning.R;
import com.example.sindhilearning.adapters.AdapterWords;
import com.example.sindhilearning.beans.WordsBean;
import com.example.sindhilearning.classes.Util;

import java.util.ArrayList;


public class WordsDetail extends Fragment {

    private ListView lv_words;
    private ArrayList<WordsBean> list;
    private MediaPlayer mPlayer;
    private TextView title;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_words_detail, container, false);
        title = (TextView) view.findViewById(R.id.title);

        lv_words = (ListView) view.findViewById(R.id.lv_words);
        if (Util.words_index == 1) {
            setUpCompterWords();
            title.setText("Compter Words");
        } else if (Util.words_index == 2) {
            setUpMathWords();
            title.setText("Mathmatics Words");

        } else if (Util.words_index == 3) {
            setUpScienceWords();
            title.setText("Science Words");
        } else if (Util.words_index == 4) {
            setUpAnimalWords();
            title.setText("Animal Words");
        } else if (Util.words_index == 5) {
            setUpNatureWords();
            title.setText("Nature Words");
        }


        lv_words.setAdapter(new AdapterWords(getActivity(), list));
        lv_words.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "" + list.get(position).getSindhi(), Toast.LENGTH_SHORT).show();
                mPlayer = MediaPlayer.create(getActivity(), list.get(position).getSound());
                if (!mPlayer.isPlaying()) {
                    mPlayer.start();
                }
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

    private void setUpCompterWords() {
        list = new ArrayList<>();
        list.add(new WordsBean("ڪ+ي+ب+و+ر+ڊ", "ڪيبورڊ ", "Keyboard", Color.parseColor("#006400"), R.drawable.keyboard, R.raw.keyboard));
        list.add(new WordsBean("ٻا+ڦ  و+ا+ر+ا   ڊ+و+ا+ئ+ي+س", "ٻاڦ وارا ڊوائيس", "Output devices", Color.parseColor("#006400"), R.drawable.power_supply, R.raw.power_supply));
        list.add(new WordsBean("ا+ن +پ+ٽ  ڊ+و+ا+ئ+ي+س+ز", "ان پٽ ڊوائيسز ", "Input Devices", Color.parseColor("#0B0EED"), R.drawable.input, R.raw.inpute_decices));
        list.add(new WordsBean("ڪ+م+پ+ي+و+ٽ+ر  ج+و  م+ر+ڪ+ز+ي+  ع+م+ل  ڪ+ا+ر", "ڪمپيوٽر جو مرڪزي عمل ڪار", "CPU", Color.parseColor("#9B870c"), R.drawable.cpu, R.raw.cpu));
        list.add(new WordsBean("م+ا+ئ+ع  ک+ر+س+ٽ+ل  ڊ+س+پ+ل+ي", "مائع کرسٽل ڊسپلي", "USB", Color.parseColor("#F53911"), R.drawable.usb, R.raw.usb));
    }


    private void setUpMathWords() {
        list = new ArrayList<>();
        list.add(new WordsBean("ض+ر+ب", "ضرب", "multiplication ", Color.parseColor("#006400"), R.drawable.multy, R.raw.multiplication));
        list.add(new WordsBean("و+ن+ڊ", "ونڊ", "Divisionon", Color.parseColor("#006400"), R.drawable.divid, R.raw.divide));
        list.add(new WordsBean("ج+و+ڙ", "جوڙ", "Addition", Color.parseColor("#0B0EED"), R.drawable.add, R.raw.addition));
        list.add(new WordsBean("ڪ+ٽ", "ڪٽ", "Subtraction", Color.parseColor("#9B870c"), R.drawable.sub, R.raw.subtraction));
        list.add(new WordsBean("ب+ر+ا+ب+ر", "برابر", "Equals to", Color.parseColor("#F53911"), R.drawable.equal, R.raw.equals_to));
    }

    private void setUpScienceWords() {
        list = new ArrayList<>();
        list.add(new WordsBean("ر+ت ج+ي ک+و+ٽ", "رت جي کوٽ", "Anemia", Color.parseColor("#006400"), R.drawable.anemia, R.raw.anaemia));
        list.add(new WordsBean("ل+ا+ک+ڙ+و", "لاکڙو", "Chicken-pox", Color.parseColor("#006400"), R.drawable.chickenpox, R.raw.chicken_px));
        list.add(new WordsBean("پ+ي+ٽ ج+و س+و+ر", "پيٽ جو سور", "chronic pain ", Color.parseColor("#0B0EED"), R.drawable.pain, R.raw.cronic_pain));
        list.add(new WordsBean("خ+ا+ر+ش", "خارش", "Itch", Color.parseColor("#9B870c"), R.drawable.itch, R.raw.itch));
        list.add(new WordsBean("ڪ+ن+گ+ھ", "ڪنگھ", "cough", Color.parseColor("#F53911"), R.drawable.cough, R.raw.cought));
    }


    private void setUpAnimalWords() {
        list = new ArrayList<>();
        list.add(new WordsBean("چ+م+ڙ+و", "چمڙو", "bat", Color.parseColor("#006400"), R.drawable.bat, R.raw.bat));
        list.add(new WordsBean("ڪ+ت+ي", "ڪتي", "bitch", Color.parseColor("#006400"), R.drawable.bith, R.raw.bitch));
        list.add(new WordsBean("م+ي+ن+ه+ن", "مينهن", "buffalo", Color.parseColor("#0B0EED"), R.drawable.buffalo, R.raw.buffalo));
        list.add(new WordsBean("اُ+ٺ", "اُٺ", "camel", Color.parseColor("#9B870c"), R.drawable.camel, R.raw.camel));
        list.add(new WordsBean("ٻ+ل+ي", "ٻلي", "cat", Color.parseColor("#F53911"), R.drawable.cat, R.raw.cat));
    }

    private void setUpNatureWords() {
        list = new ArrayList<>();
        list.add(new WordsBean("و+ا+ھُ", "واھُ", "Canal", Color.parseColor("#006400"), R.drawable.canal, R.raw.canal));
        list.add(new WordsBean("ڪ+ڪ+رُ", "ڪڪرُ", "Cloud", Color.parseColor("#006400"), R.drawable.clouds, R.raw.cloudes));
        list.add(new WordsBean("ا+وُ+ن+د+ھ", "اوُندھ", "darkness", Color.parseColor("#0B0EED"), R.drawable.darkness, R.raw.darkness));
        list.add(new WordsBean("ڌ+ر+ت+ي", "ڌرتي", "earth", Color.parseColor("#9B870c"), R.drawable.earth, R.raw.earth));
        list.add(new WordsBean("چ+ن+ڊ گ+ر+ھ+ڻ", "چنڊ گرھڻ", "eclipse of the moon", Color.parseColor("#F53911"), R.drawable.eclips, R.raw.moon_eclips));
    }
}
