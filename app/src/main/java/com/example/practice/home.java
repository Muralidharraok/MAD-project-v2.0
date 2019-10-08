package com.example.practice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class home extends AppCompatActivity {
   DatabaseReference databaseReference;
    RecyclerView postlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        postlist = findViewById(R.id.postlist);
        postlist.setHasFixedSize(true);
        postlist.setLayoutManager(new LinearLayoutManager(this));
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Notice");
    }

//    @Override
   // protected void onStart() {
 //       super.onStart();
       // FirebaseRecyclerOptions<postdisplay,postViewHolder> firebaseRecyclerOptions
   //     FirebaseRecyclerAdapter<postdisplay,postViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<postdisplay, postViewHolder>(
       //           postdisplay.class,
//                R.layout.post_list,
//                postViewHolder.class,
//                databaseReference
//        ) {
//            @Override
//            protected void onBindViewHolder(@NonNull postViewHolder postViewHolder, int i, @NonNull postdisplay postdisplay) {
//
//            }
//
//            @NonNull
//            @Override
//            public postViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                return null;
//            }
//        };
      //  FirebaseRecyclerOptions<> options = new FirebaseRecyclerOptions.Bluider<>
        //FirebaseRecyclerAdapter<postdisplay,postViewHolder> firebaseRecycleAdapter = new FirebaseRecyclerAdapter<postdisplay,postViewHolder>(
//                postdisplay.class,
//                R.layout.post_list,
//                postViewHolder.class,
//                databaseReference
//        )
//        {
//            @Override
//            protected void pop
//        }
   // }
//    public  class MyAdapter extends RecyclerView.Adapter<postViewHolder>
//    {
//        Context c;
//        ArrayList<postdisplay> models;
//        @NonNull
//        @Override
//        public postViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            return null;
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull postViewHolder holder, int position) {
//
//        }
//
//        @Override
//        public int getItemCount() {
//            return 0;
//        }
//    }
//    public static class postViewHolder extends RecyclerView.ViewHolder
//    {
//        TextView post_title, post_desc;
//       // View mView;
//        public postViewHolder(@NonNull View itemView) {
//            super(itemView);
//          //  mView = itemView;
//            this.post_title = itemView.findViewById(R.id.title);
//            this.post_desc = itemView.findViewById(R.id.description);

      //  }
//        public void setTile(String title)
//        {
//            TextView post_title = (TextView) mView.findViewById(R.id.title);
//            post_title.setText(title);
//        }
//        public void setDesc(String desc)
//        {
//            TextView post_desc = (TextView) mView.findViewById(R.id.description);
//            post_desc.setText(desc);
//        }
  //  }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.m, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.f1:
                FirebaseAuth.getInstance().signOut();
                finish();
                return true;
            case R.id.f2:
                startActivity(new Intent(home.this,Post_content.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}
