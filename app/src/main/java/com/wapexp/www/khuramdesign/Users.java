package com.wapexp.www.khuramdesign;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Users extends AppCompatActivity {
//
//    RecyclerView mRecycler;
//    public List<Custom_design> store_data_list;
private String url = "http://192.168.10.7/Android/test.php";
    private RecyclerView mRecyclerView;
    private List<User> mUploads;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        mRecyclerView = findViewById(R.id.recycler);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,1));


        mUploads = new ArrayList<>();

        mAdapter = new UserAdapter(Users.this, mUploads);

        mRecyclerView.setAdapter(mAdapter);

        getData();
//
//        mRecycler = findViewById(R.id.recycler);
//        mRecycler.setLayoutManager(new LinearLayoutManager(this));
//
//        store_data_list = new ArrayList<>();
//
//        Custom_design l1 = new Custom_design(R.drawable.profile_photo, "User Name", "useremail@gmail.com");
//        Custom_design l2 = new Custom_design(R.drawable.profile, "Khuram", "khuram@gmail.com");
//        Custom_design l3 = new Custom_design(R.drawable.profile_photo, "Olivia", "Olivia@gmail.com");
//        Custom_design l4 = new Custom_design(R.drawable.profile, "George", "George@gmail.com");
//        Custom_design l5 = new Custom_design(R.drawable.profile_photo, "Jack", "Jack@gmail.com");
//        Custom_design l6 = new Custom_design(R.drawable.profile, "Charlie", "Charlie@gmail.com");
//        Custom_design l7 = new Custom_design(R.drawable.profile_photo, "Harry", "Harry@gmail.com");
//
//        store_data_list.add(l1);
//        store_data_list.add(l2);
//        store_data_list.add(l3);
//        store_data_list.add(l4);
//        store_data_list.add(l5);
//        store_data_list.add(l6);
//        store_data_list.add(l7);

//
//        Custom_adapter_pages custom_adapter_pages = new Custom_adapter_pages(this, R.layout.custom_design_user, store_data_list);
//        mRecycler.setAdapter(custom_adapter_pages);
    }
    private void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        User sos = new User();
                        sos.setUsername(jsonObject.getString("username"));
                        sos.setEmail(jsonObject.getString("email"));


                        mUploads.add(sos);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }



                }
                mAdapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }
}
