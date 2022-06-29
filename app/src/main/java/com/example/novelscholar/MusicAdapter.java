package com.example.novelscholar;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Music> musicArrayList;
    private MediaPlayer mediaPlayer;
    private boolean flag = true;

    public MusicAdapter(Context context, int layout, ArrayList<Music> musicArrayList) {
        this.context = context;
        this.layout = layout;
        this.musicArrayList = musicArrayList;
    }

    @Override
    public int getCount() {
        return musicArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return musicArrayList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        final ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            convertView = viewHolder.convertview;
        } else {
        }
        final Music music = musicArrayList.get(position);
        viewHolder.song.setText(music.getSongName());
        viewHolder.textView_artist.setText(music.getArtist());
        viewHolder.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    mediaPlayer = MediaPlayer.create(context, music.getSongs());
                    flag = false;
                }
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    viewHolder.play.setImageResource(R.drawable.play);
                } else {
                    mediaPlayer.start();
                    viewHolder.play.setImageResource(R.drawable.pause);
                }
                mediaPlayer.start();
            }
        });
        viewHolder.pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!flag) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    flag = true;
                }
                viewHolder.pause.setImageResource(R.drawable.pauses);
            }
        });
        viewHolder.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = mediaPlayer.getCurrentPosition();
                if (mediaPlayer.isPlaying() && pos > 5000) {
                    pos -= 5000;
                    mediaPlayer.seekTo(pos);
                }
            }
        });
        viewHolder.front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = mediaPlayer.getCurrentPosition();
                if (mediaPlayer.isPlaying()) {
                    pos += 5000;
                    mediaPlayer.seekTo(pos);
                }
            }
        });
        return convertView;
    }

    public class ViewHolder {
        TextView song, textView_artist;
        ImageView play, pause, back, front;
        private View convertview;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        public ViewHolder() {
            convertview = layoutInflater.inflate(layout, null);
            song = convertview.findViewById(R.id.tt2);
            textView_artist = convertview.findViewById(R.id.tt3);
            play = convertview.findViewById(R.id.img2);
            pause = convertview.findViewById(R.id.img3);
            back = convertview.findViewById(R.id.img4);
            front = convertview.findViewById(R.id.img5);

        }
    }
}