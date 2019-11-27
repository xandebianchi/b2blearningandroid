package com.example.b2blearning;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ListAdapter extends ArrayAdapter<Beer> {

    Context mContext;
    int mLayoutResource;
    Beer mData[] = null;


    public ListAdapter(@NonNull Context context, int resource, @NonNull Beer[] data) {
        super(context, resource, data);
        this.mContext = context;
        this.mLayoutResource = resource;
        this.mData = data;

    }

    @Nullable
    @Override
    public Beer getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View list = convertView;
        //Inflate the layout for a single row
        LayoutInflater inflater = LayoutInflater.from(mContext);
        list = inflater.inflate(mLayoutResource, parent, false);

        //get a reference to the different view elements we wish to update
        ImageView imageView = list.findViewById(R.id.imgProd);
        TextView nameView = list.findViewById(R.id.nameProd);
        TextView descView = list.findViewById(R.id.descProd);
        TextView priceView = list.findViewById(R.id.priceProd);

        //Get the data from the data array
        Beer beer = mData[position];

        //Setting the view to reflect the data we need to display
        nameView.setText(beer.getTitle());
        descView.setText(beer.getDescription());
        priceView.setText(beer.getPrice());

//        int resId = mContext.getResources().getIdentifier(beer.getNameOfImage(), "drawable", mContext.getPackageName());
//        imageView.setImageResource(resId);


        //returning the row view
        return list;

    }
}
