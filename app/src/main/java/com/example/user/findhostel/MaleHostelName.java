
package com.example.user.findhostel;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MaleHostelName extends AppCompatActivity {
    ListView list;
    String[] hostelnamekannur,hostelnametpba;
    ArrayList<String> hostel=new ArrayList<>();

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_male_hostel_name);
        Intent intent=getIntent();

        list=(ListView)findViewById(R.id.malehostel) ;

        String s=intent.getStringExtra("place");
       // Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();

        final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,hostel);
        list.setAdapter(arrayAdapter);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference(""+s);
        databaseReference.addChildEventListener(new ChildEventListener() {
       @Override
       public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
      HostelAdapter hostelAdapter=dataSnapshot.getValue(HostelAdapter.class);
      String se=String.valueOf(hostelAdapter.getGender());
            if(se.equalsIgnoreCase("male")) {
                hostel.add("" + hostelAdapter.nameOfhostel);
                Toast.makeText(getApplicationContext(), "" + hostelAdapter.nameOfhostel, Toast.LENGTH_SHORT).show();
            }

      }

       @Override
       public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

       }

       @Override
       public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

       }

       @Override
       public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

       }

       @Override
       public void onCancelled(@NonNull DatabaseError databaseError) {

       }
   });

     /*   if(s.equalsIgnoreCase("kannur")) {
            for (int i = 0; i < hostelnamekannur.length; i++) {
                hostel.add(hostelnamekannur[i]);
            }
        }
        else if(s.equalsIgnoreCase("thaliparamba"))
        {
            for(int i=0;i<hostelnametpba.length;i++)
            {
                hostel.add(hostelnametpba[i]);
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Inavalid",Toast.LENGTH_LONG).show();
            Intent intent1=new Intent(getApplicationContext(),Homepage.class);
            startActivity(intent1);



        }*/

    }
}
