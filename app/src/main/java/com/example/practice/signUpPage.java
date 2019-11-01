package com.example.practice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class signUpPage extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    Button createuser, backto;
    EditText name, usn, contact, email, branch, writeper;
    String emailID, passwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        createuser = findViewById(R.id.createusers);
        backto = findViewById(R.id.backto);
        name =findViewById(R.id.name);
        usn =findViewById(R.id.usn);
        email =findViewById(R.id.email);
        contact =findViewById(R.id.contactno);
        branch =findViewById(R.id.branch);
        writeper =findViewById(R.id.writeper);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        backto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(signUpPage.this,home.class));
                finish();
            }
        });
        createuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                create();
            }
        });
    }
    public void create()
    {
        emailID = email.getText().toString();
        passwd = usn.getText().toString();
        firebaseAuth.createUserWithEmailAndPassword(emailID,passwd).addOnCompleteListener(signUpPage.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    FirebaseUser currentUser = firebaseAuth.getCurrentUser();
                    Toast.makeText(getApplicationContext(),"user is added to Auth",Toast.LENGTH_SHORT).show();
                    Map<String,Object> newUser= new HashMap<>();
                    newUser.put("Name",name.getText().toString().trim());
                    newUser.put("USN",usn.getText().toString().trim());
                    newUser.put("Email",email.getText().toString().trim());
                    newUser.put("Contact",contact.getText().toString().trim());
                    newUser.put("Branch",branch.getText().toString().trim());
                    newUser.put("WritePer",writeper.getText().toString().trim());
                    firebaseFirestore.collection("users").document(currentUser.getUid()).set(newUser).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplicationContext(),"user is added to database",Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(),"user not added to database",Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"user not added to Auth",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
