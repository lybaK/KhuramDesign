package com.wapexp.www.khuramdesign;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

/**
 * Created by ankit on 27/10/17.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private Context context;
    private List<User> list;

    public UserAdapter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_design_user, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User sos = list.get(position);
       // holder.sid.setText(sos.getsID());
        holder.sid.setText(sos.getUsername());
        holder.syaer.setText(sos.getEmail());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView sid, syaer;
        public ViewHolder(View itemView) {
            super(itemView);
            sid = itemView.findViewById(R.id.profile_name);
            syaer = itemView.findViewById(R.id.profile_email);

        }

    }

}