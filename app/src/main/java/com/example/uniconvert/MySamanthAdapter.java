package com.example.uniconvert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MySamanthAdapter extends ArrayAdapter<Dimension>{
    private Context mContext;
    private int mResource;


    public MySamanthAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Dimension> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(mResource, parent, false);
        ImageView image = convertView.findViewById(R.id.image);
        TextView txtname = convertView.findViewById(R.id.txtname);
        image.setImageResource(getItem(position).getImage());
        txtname.setText(getItem(position).getDim());
        return convertView;
//        convertView = layoutInflater.inflate (mResource, parent, attachToRoot: false);
//        ImageView image = convertView. findViewById(R.id.image);
//        TextView txtname = convertView. findViewById(R.id.txtname);
//        image.setImageResource(getItem(position) getImage());
//        txtname.setText(getItem(position).getName());
//        return convertView;




    }
}

