package com.example.user.findhostel;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Signu extends AppCompatActivity {

    TextView signIn;
    EditText password,email,username;
    Button sigin;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signu);
        progressDialog=new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference=FirebaseDatabase.getInstance().getReference().child("users");
        signIn=(TextView)findViewById(R.id.signIn);
        password=(EditText) findViewById(R.id.password);
        email=(EditText)findViewById(R.id.email);
        username=(EditText)findViewById(R.id.username);
        sigin=(Button)findViewById(R.id.sigin);
                signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
                sigin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        progressDialog.setMessage("Registering...");
                        progressDialog.show();
                    firebaseAuth.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                       if(task.isSuccessful())
                       {
                           progressDialog.dismiss();
                           Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                           startActivity(intent);
                       }
                       else
                       {
                           progressDialog.dismiss();
                           Toast.makeText(getApplicationContext(), "fail", Toast.LENGTH_SHORT).show();
                       }
                        }
                    });
                    }
                });
    }
}
