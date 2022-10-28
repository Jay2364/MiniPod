package com.example.minipod;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AlbumModelAdapter extends ArrayAdapter<AlbumModel> {

    public AlbumModelAdapter(@NonNull Context context, ArrayList<AlbumModel> arrayList) {
        super(context, 0, arrayList);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.album_item, parent, false);
        }
        AlbumModel albumModel = getItem(position);
        TextView tv = listitemView.findViewById(R.id.textView);
        ImageView iv = listitemView.findViewById(R.id.imageView);
        tv.setText(albumModel.getName());
        iv.setImageResource(albumModel.getImage());
        return listitemView;
    }
}
