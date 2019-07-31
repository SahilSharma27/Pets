package com.example.android.pets;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PetAdapter extends ArrayAdapter <Pet> {
    public PetAdapter(Activity context, ArrayList<Pet> pets) {
        super(context,0,pets);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Pet currentPet = getItem(position);
        View listItemView = convertView;
        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        TextView name=listItemView.findViewById(R.id.name);
        name.setText(currentPet.getName());
        TextView breed=listItemView.findViewById(R.id.breed);
        breed.setText(currentPet.getBreed());
        return listItemView;
    }


}

