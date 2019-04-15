package com.wapexp.www.khuramdesign;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment_Select_Zone extends Fragment {

    String zone[]={"Zone 1","Zone 2","Zone 3","Zone 4"};
    Button mSelect;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_select_zone, container, false);
         final Spinner mySpinner = (Spinner)view.findViewById(R.id.spinner);

         mSelect=view.findViewById(R.id.mark_btn);
         mySpinner.setAdapter(new MyAdapter(getActivity(), R.layout.custom_spinner, zone));

        mSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  String item=mySpinner.getSelectedItem().toString();
                  Toast.makeText(getActivity(), ""+item, Toast.LENGTH_SHORT).show();
                  Intent scan=new Intent(getActivity(),MainActivity.class);
                  startActivity(scan);
            }
        });
        return view;
    }

    public class MyAdapter extends ArrayAdapter<String> {


        public MyAdapter(Context context, int textViewResourceId, String[] objects) {
            super(context, textViewResourceId, objects);
        }

        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }

        public View getCustomView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater=getLayoutInflater();
            View row=inflater.inflate(R.layout.custom_spinner, parent, false);
            TextView label=(TextView)row.findViewById(R.id.textview);
            label.setText(zone[position]);

            return row;
        }
    }
}