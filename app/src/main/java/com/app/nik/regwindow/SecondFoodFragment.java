package com.app.nik.regwindow;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


public class SecondFoodFragment extends ListFragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayAdapter adapter = new ArrayAdapter<String>(inflater.getContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.seconds));
        setListAdapter(adapter);
       return super.onCreateView(inflater,container,savedInstanceState);
    }

}
