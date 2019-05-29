package com.example.pokelist.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.pokelist.R;
import com.example.pokelist.model.Pojo;

import java.util.ArrayList;

public class PokeAdapterList extends RecyclerView.Adapter<PokeAdapterList.PokeViewHolder> {

     Context context;
     ArrayList<Pojo> pokelist;

    public PokeAdapterList(Context context) {
        this.context = context;
        pokelist = new ArrayList<>();
    }

    @NonNull
    @Override
    public PokeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.poke_card, viewGroup, false);
        return new PokeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokeViewHolder pokeViewHolder, int i) {
        Pojo p = pokelist.get(i);
        pokeViewHolder.name.setText(p.getName());

        Glide.with(context)
                .load("http://pokeapi.co/media/sprites/pokemon/"+ p.getNumber() + ".png")
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(pokeViewHolder.url);
    }

    @Override
    public int getItemCount() {
        return pokelist.size();
    }

    public void addPokemonList(ArrayList<Pojo> listapokemon){
        pokelist.addAll(listapokemon);
        notifyDataSetChanged();

    }

    public class PokeViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private ImageView url;

        public PokeViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.namepoke);
            url = (ImageView) itemView.findViewById(R.id.img_poke);


        }
    }
}
