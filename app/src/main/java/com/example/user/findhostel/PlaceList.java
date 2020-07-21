package com.example.user.findhostel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class PlaceList extends AppCompatActivity {
 ListView placeList;
    String[] placelt;
    SearchView searchView;
    ArrayList<String> hostel=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_list);
        searchView=(SearchView)findViewById(R.id.idsearch);
        placeList=(ListView)findViewById(R.id.placeList);
        final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,hostel);
        placeList.setAdapter(arrayAdapter);
        placelt=new String[]{
                "Kannur","Taliparamba","Payyanur","Thalassery"
        };
        for(int i=0;i<placelt.length;i++)
        {
            hostel.add(placelt[i]);
        }
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                String text = newText;
                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });
        placeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),Homepage.class);
                String place=(String) placeList.getItemAtPosition(position);
                intent.putExtra("place",place);
                startActivity(intent);
            }
        });
    }
}
