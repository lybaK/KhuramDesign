package com.wapexp.www.khuramdesign;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Custom_adapter_pages extends RecyclerView.Adapter<Custom_adapter_pages.Custom_View> {

    public Context context;
    int res;
    List<Custom_design> list;


    public Custom_adapter_pages(Context context, int res, List<Custom_design> list){
        this.context=context;
        this.res=res;
        this.list=list;
    }

    @Override
    public Custom_View onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(this.context);
        View view=layoutInflater.inflate(res,null,false);

        return new Custom_View(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Custom_View holder, int position) {

        final Custom_design list1=list.get(position);
        ImageView profile_imageview=holder.profile_Image;
        TextView profile_name=holder.profile_Name;
        TextView profile_follow=holder.profile_Follower;
        LinearLayout linearLayout=holder.linearLayout;


        profile_imageview.setImageDrawable(context.getResources().getDrawable(list1.getProfile_image()));
        profile_name.setText(list1.getProfile_name());
        profile_follow.setText(list1.getProfile_follower());


        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "User", Toast.LENGTH_SHORT).show();

            }
        });



    }

    @Override
    public int getItemCount() {
        return 7;
    }


    class Custom_View extends RecyclerView.ViewHolder{

        ImageView profile_Image;
        TextView profile_Name;
        TextView profile_Follower;
        LinearLayout linearLayout;


        public Custom_View(View itemView) {
            super(itemView);

            profile_Image=itemView.findViewById(R.id.profile_image);
            profile_Name=itemView.findViewById(R.id.profile_name);
            profile_Follower=itemView.findViewById(R.id.profile_email);
            linearLayout=itemView.findViewById(R.id.lin);

        }
    }


}
