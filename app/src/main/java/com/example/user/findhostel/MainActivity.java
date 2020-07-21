package com.example.user.findhostel;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    TextView signup;
    Button sigin;
    EditText email,password;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog=new ProgressDialog(this);
        firebaseAuth=FirebaseAuth.getInstance();
        signup=(TextView)findViewById(R.id.signup);
        sigin=(Button)findViewById(R.id.sigin);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Signu.class);
                startActivity(intent);
            }
        });
        sigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Login.....");
                progressDialog.show();
                firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                      if(task.isSuccessful())
                      {
                          progressDialog.dismiss();
                          if(email.getText().toString().equalsIgnoreCase("ashith@gmail.com"))
                          {
                              Intent intent2=new Intent(getApplicationContext(),AddHostel.class);
                              startActivity(intent2);
                          }
                          else {

                              Intent intent = new Intent(getApplicationContext(), Homepage.class);
                              startActivity(intent);
                          }
                      }
                      else
                      {
                          progressDialog.dismiss();
                          Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_LONG).show();
                      }
                    }
                });
            }
        });
    }
}
