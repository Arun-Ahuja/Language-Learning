package com.example.sindhilearning.classes;

import com.example.sindhilearning.R;
import com.example.sindhilearning.beans.RhymesBean;

import java.util.ArrayList;

/**
 * Created by aliraza on 05/13/2019.
 */

public class BAL {
    public static ArrayList<RhymesBean> list=new ArrayList<>();

    public BAL(){
        setUpRhymes();
    }

    private void setUpRhymes(){
        list=new ArrayList<>();

        list.add(new RhymesBean(1,"Jhoo Mati","جھو ماٽي", R.drawable.jhoomati,R.string.jhoomati,R.raw.jhoo_mati," Siya Pahuja","Jagdish Lalwani","Sahijram Tahilram Raghani"));
        list.add(new RhymesBean(2,"Jo Kheer Piye","جو کير پئ",R.drawable.jokheerpye,R.string.jokheerpiye,R.raw.jokheerpiye," Siya Pahuja","Jagdish Lalwani","Sahijram Tahilram Raghani"));
        list.add(new RhymesBean(3,"Muhnji Aman","منھنجي امان",R.drawable.mother_pic,R.string.muhnji_ammar,R.raw.muhnji_amad,"Siya Pahuja","Jagdish Lalwani"," Bherumal Meharchand Advani"));
        list.add(new RhymesBean(4,"Paiso Ladhum","پيسو لڌم",R.drawable.paiso_ladhum,R.string.paisoladhum,R.raw.paisoladhum," Siya Pahuja","Jagdish Lalwani","Sahijram Tahilram Raghani"));
        list.add(new RhymesBean(5,"Wah re Taara","وآھ ڙي تارا",R.drawable.wahretaara,R.string.wahretaara,R.raw.waahre_taara," Siya Pahuja","Jagdish Lalwani","Sahijram Tahilram Raghani"));

    }

}
