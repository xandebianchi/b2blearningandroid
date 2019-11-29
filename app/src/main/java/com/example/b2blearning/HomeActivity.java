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
            new Beer("Cerveja Antarctica Original 600ml Caixa (12 Unidades)", "Reconhecida por preservar sua essência, tradição e qualidade desde 1931, a Cerveja Antarctica Original 600 ml (com 12 unidades) é uma Standard American Lager de sabor suave, leve amargor e aroma de lúpulo, além de refrescância única — garantida por sua alta carbonatação. A caixa com 12 garrafas de 600 ml é ideal para dividir com amigos, enquanto harmonizam o sabor Original com petiscos, lulas fritas, ostras ou finas fatias de salame.", "R$ 95,88"),
            new Beer("Cerveja Budweiser 330ml Pack (6 Unidades)", "A cerveja Budweiser é uma standard American lager de sabor leve, cor clara e aroma discreto. Maturada com madeira Beechwood, pra um sabor marcante no começo e suave no final. Garanta sua Budweiser em lata, long neck ou garrafa.", "R$ 20,94"),
            new Beer("Skol", "350 mL", "R$ 3,00"),
            new Beer("Original", "600 mL", "R$7,00" ),
            new Beer("Serrana", "355 mL", "R$ 1,79"),
            new Beer("Bohemia", "350 mL", "R$ 4,00"),
            new Beer("Serra Malte", "600 mL", "R$ 7,00"),
            new Beer("Corona", "310 mL", "R$ 6,00"),
            new Beer("Stella Artois", "275", "3,50"),
            new Beer("Budweiser", "330 mL", "R$ 4,00"),
            new Beer("Beck's", "330 mL", "R$ 5,00"),
    };

    private TextView welcome;
    private ListView products;
    private ListAdapter mListAdapter;


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
