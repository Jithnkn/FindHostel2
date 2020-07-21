package com.example.user.findhostel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthSettings;

import java.util.ArrayList;

public class Homepage extends AppCompatActivity {

    ListView list;
    String[] place;
    ImageView femaleImage,maleImage;
    EditText searchbar;
    FirebaseAuth firebaseAuth;
    ArrayList<String> arrayList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        femaleImage=(ImageView) findViewById(R.id.femaleimage);
        maleImage=(ImageView)findViewById(R.id.maleimage);
        searchbar=(EditText) findViewById(R.id.searchbar);
        final Intent intent=getIntent();
        final String plce=intent.getStringExtra("place");
        searchbar.setText(plce);
            searchbar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1 = new Intent(getApplicationContext(), PlaceList.class);

                    startActivity(intent1);
                }
            });

        firebaseAuth=FirebaseAuth.getInstance();
        femaleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),FemaleHostelName.class);
                intent.putExtra("place",searchbar.getText().toString());
                startActivity(intent);
            }
        });
        maleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MaleHostelName.class);
                intent.putExtra("place",searchbar.getText().toString());
                startActivity(intent);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.signout)
        {
            firebaseAuth.signOut();
            Intent intent=new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"Signout",Toast.LENGTH_LONG).show();
        }
        return true;
    }
}
