package com.example.user.findhostel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class  AddHostel extends AppCompatActivity {
    EditText hostelName,place,gender;
    Button submit;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_hostel);
        hostelName=(EditText)findViewById(R.id.hostelName);
        place=(EditText)findViewById(R.id.place);
        submit=(Button)findViewById(R.id.submit);
        gender=(EditText)findViewById(R.id.gender);
        firebaseDatabase=FirebaseDatabase.getInstance();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference=firebaseDatabase.getReference(place.getText().toString());
                final String userkey=databaseReference.push().getKey();
                final HostelAdapter hostelAdapter=new HostelAdapter(hostelName.getText().toString(),gender.getText().toString());
                databaseReference.child(userkey).setValue(hostelAdapter);
                Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_LONG).show();


            }
        });



    }
}
