package com.app.nik.regwindow;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class FirstFoodFragment extends ListFragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ArrayAdapter adapter = new ArrayAdapter<String>(inflater.getContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.firsts));
        setListAdapter(adapter);

        return super.onCreateView(inflater,container,savedInstanceState);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        switch (position){
            case 0:
                Toast.makeText(this.getContext(),String.valueOf(position),Toast.LENGTH_LONG).show();
                break;
            case 1:
                Toast.makeText(this.getContext(),String.valueOf(position),Toast.LENGTH_LONG).show();
                break;
            case 2:
                Toast.makeText(this.getContext(),String.valueOf(position),Toast.LENGTH_LONG).show();
                break;
            case 3:
                Toast.makeText(this.getContext(),String.valueOf(position),Toast.LENGTH_LONG).show();
                break;
        }

    }
}
