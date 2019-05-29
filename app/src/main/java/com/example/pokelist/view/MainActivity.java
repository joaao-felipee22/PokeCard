package com.example.pokelist.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.GridLayout;
import android.widget.Toast;

import com.example.pokelist.R;
import com.example.pokelist.controller.PokeAdapterList;
import com.example.pokelist.model.Client;
import com.example.pokelist.model.GetApi;
import com.example.pokelist.model.Pojo;
import com.example.pokelist.model.PokeList;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PokeAdapterList adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_poke);
        adapter = new PokeAdapterList(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);


        retrofitResponse();
    }

    private void retrofitResponse(){

        GetApi service = Client.getClient().create(GetApi.class);

        Call<PokeList> call = service.getAllCards();
        call.enqueue(new Callback<PokeList>() {


            @Override
            public void onResponse(Call<PokeList> call, Response<PokeList> response) {
                if(response.isSuccessful()){

                    PokeList pokeList = response.body();
                    ArrayList<Pojo> pojoArrayList = pokeList.getResults();

                    adapter.addPokemonList(pojoArrayList);
                }
            }

            @Override
            public void onFailure(Call<PokeList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ocorreu um erro, tente mais tarde!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
