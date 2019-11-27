package com.example.b2blearning;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity{
    Beer[] BeerArray = new Beer[]{
            new Beer("Brahma", "350 mL", "R$ 3,00" ),
            new Beer("Antarctica", "350 mL", "R$ 3,50" ),
            new Beer("Skol", "350 mL", "R$ 3,00" ),
            new Beer("Original", "600 mL", "R$7,00" ),
            new Beer("Serrana", "355 mL", "R$ 1,79" ),
            new Beer("Bohemia", "350 mL", "R$ 4,00" ),
            new Beer("Serra Malte", "600 mL", "R$ 7,00" ),
            new Beer("Corona", "310 mL", "R$ 6,00"),
            new Beer("Stella Artois", "275", "3,50"),
            new Beer("Budweiser", "330 mL", "R$ 4,00"),
            new Beer("Beck's", "330 mL", "R$ 5,00" )
    };

    String [] myStringArray = new String[] {
      "Brahma",
      "Antarctica",
      "Skol",
      "Original",
      "Serrana",
      "Bohemia",
      "Serra Malte",
      "Corona",
      "Stella Artois",
      "Budweiser",
      "Beck's",
      "Goose Island",
      "Hoegaarden",
      "Leffe",
      "Franziskaner",
      "Patagonia",
      "Quilmes",
      "Norteña"
    };

    private TextView welcome;
    private ListView products;
    private ListAdapter mListAdapter;
    private EditText quantity;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("User_Name");
        welcome = (TextView) findViewById(R.id.homeWelcome);
        welcome.setText("Welcome, " + name );
        products = (ListView) findViewById(R.id.prodList);
        mListAdapter = new ListAdapter(getApplicationContext(), R.layout.home_list,BeerArray);
        quantity = findViewById(R.id.quantEdit);

        if(products != null){
            products.setAdapter(mListAdapter);
        }

        products.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.v("Beer",BeerArray[position].getTitle());
            }
        });
    }
}
