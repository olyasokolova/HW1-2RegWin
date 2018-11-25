package com.app.nik.regwindow.repositorii;

import android.content.Context;

import com.app.nik.regwindow.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Repository {
    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_DESC = "desc";
    public static final String EXTRA_PIC = "pic";
    private static ArrayList<String> titles = new ArrayList<>();
    private static ArrayList<String> descs = new ArrayList<>();
    private static ArrayList<Integer> pics = new ArrayList<>();
    public static String getTitle(int position, Context context){
        if(titles.size()==0)
            initializeTitles(context);
        return titles.get(position);
    }

    private static void initializeTitles(Context context) {
        titles= new ArrayList(Arrays.asList(context.getResources().getStringArray(R.array.firsts)));
    }

    public static String getDescs(int position, Context context){
        if(descs.size()==0)
            initializeDescs(context);
        return descs.get(position);
    }

    private static void initializeDescs(Context context) {
        descs= new ArrayList(Arrays.asList(context.getResources().getStringArray(R.array.seconds)));
    }

    public static int getPics(int position, Context context){
        if(pics.size()==0)
            initializePics(context);
        return pics.get(position);
    }

    private static void initializePics(Context context) {
        pics.add(R.drawable.pic1);
        pics.add(R.drawable.pic2);
        pics.add(R.drawable.pic3);
        pics.add(R.drawable.pic4);
    }


}
