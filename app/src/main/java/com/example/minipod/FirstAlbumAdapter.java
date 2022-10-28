package com.example.minipod;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FirstAlbumAdapter extends RecyclerView.Adapter<FirstAlbumAdapter.ViewHolder> {

    // Array[] of song information
    MediaPlayer player;
    public String[] nameSet;
    public int[] imageSet;
    public int[] songSet;

    // ArrayList of song info
    ArrayList<String[]> nameList;
    ArrayList<int[]> imageList;
    ArrayList<int[]> songList;

    // Constructor
    public FirstAlbumAdapter(String[] name, int[] images, int[] song){
        nameSet = name;
        imageSet = images;
        songSet = song;
      }

    @Override
    public FirstAlbumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FirstAlbumAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.getTextView().setText(nameSet[position]);
        holder.getImageView().setImageResource(imageSet[position]);
        final String infoName = nameSet[position];
        final int infoImage = imageSet[position];

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),PlaySong.class);

                // sending current position of song
                intent.putExtra("position",position);

                // passing array of songs, names, images
                nameList = new ArrayList<>();
                imageList = new ArrayList<>();
                songList = new ArrayList<>();

                nameList.add(nameSet);
                imageList.add(imageSet);
                songList.add(songSet);

                intent.putExtra("songArray",songList.get(0));
                intent.putExtra("nameArray",nameList.get(0));
                intent.putExtra("imageArray",imageList.get(0));

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return nameSet.length;
    }

    // ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView textView1;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            textView1 = (TextView) itemView.findViewById(R.id.title);
            cardView = (CardView) itemView.findViewById(R.id.carView);
        }
        public TextView getTextView() {
            return textView1;
        }
        public ImageView getImageView() {
            return imageView;
        }

        public CardView getCardView() {
            return cardView;
        }
    }

}
