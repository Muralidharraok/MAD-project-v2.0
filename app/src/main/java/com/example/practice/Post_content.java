package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Post_content extends AppCompatActivity  {
    EditText title,desc;
    Button post;
   // StorageReference storageReference;
     DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_content);
        title = findViewById(R.id.posttitle);
        desc = findViewById(R.id.notice);
        post = findViewById(R.id.post);
    //    storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Notice");
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                posting();
            }
        });
    }

    public void posting() {
        String posttile = title.getText().toString().trim();
        String postdesc = desc.getText().toString().trim();
        if(!TextUtils.isEmpty(posttile) && !TextUtils.isEmpty(postdesc))
        {
            DatabaseReference newpost =databaseReference.push();
            newpost.child("Title").setValue(posttile);
            newpost.child("Desc").setValue(postdesc);
          //  newpost.child("uid").setValue(FirebaseAuth.get)
            Toast.makeText(getApplicationContext(),"posted",Toast.LENGTH_SHORT).show();
        }
        finish();
    }
}
