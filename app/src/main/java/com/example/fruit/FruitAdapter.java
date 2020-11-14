package com.example.fruit;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resuorceId;
    public FruitAdapter(Context context, int textViewResuorceId, List<Fruit> objects){
        super(context,textViewResuorceId,objects);
        resuorceId=textViewResuorceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resuorceId,parent,false);
        ImageView fruitImage=(ImageView) view.findViewById(R.id.fruit_im);
        TextView fruitNmae=(TextView) view.findViewById(R.id.fruit_name);
        fruitImage.setImageResource(fruit.getImage());
        fruitNmae.setText(fruit.getName());
        return view;
    }
}
