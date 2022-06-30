package com.example.novelscholar;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.My> {
    Context context; int size; List<Music> list;
    private MediaPlayer mediaPlayer;
    private boolean flag=true;
    public MusicAdapter(Context context, int size, List<Music> list) {
        this.context = context;
        this.size = size;
        this.list = list;
    }

    @NonNull
    @Override
    public MusicAdapter.My onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.songs_item_list,parent,false);
        return new My(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicAdapter.My holder, int position) {
        final Music music=list.get(position);
        holder.song.setText(music.getSongName());
        holder.textView_artist.setText(music.getArtist());
        holder.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag){
                    mediaPlayer=MediaPlayer.create(context,music.getSongs());
                    flag=false;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    holder.play.setImageResource(R.drawable.play);
                }
                else {
                    mediaPlayer.start();
                    holder.play.setImageResource(R.drawable.pause);
                }
                mediaPlayer.start();
            }
        });
        holder.pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!flag){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    flag=true;
                }
                holder.pause.setImageResource(R.drawable.pauses);
            }
        });
        holder.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos=mediaPlayer.getCurrentPosition();
                if(mediaPlayer.isPlaying() && pos>5000) {
                    pos -= 5000; mediaPlayer.seekTo(pos);
                }
            }
        });
        holder.front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos=mediaPlayer.getCurrentPosition();
                if(mediaPlayer.isPlaying()) {
                    pos += 5000; mediaPlayer.seekTo(pos);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class My extends RecyclerView.ViewHolder {
        TextView song,textView_artist;
        ImageView play,pause,back,front;
        CardView cardView;
        public My(@NonNull View itemView) {
            super(itemView);
            song=itemView.findViewById(R.id.tt2);
            textView_artist=itemView.findViewById(R.id.tt3);
            play=itemView.findViewById(R.id.img2);
            pause=itemView.findViewById(R.id.img3);
            back=itemView.findViewById(R.id.img4);
            front=itemView.findViewById(R.id.img5);
            cardView=(CardView)itemView.findViewById(R.id.card);
        }
    }
}