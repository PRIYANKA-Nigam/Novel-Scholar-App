package com.example.novelscholar;

public class Music {
    private String songName,artist;
    private int songs;

    public Music(String songName, String artist, int songs) {
        this.songName = songName;
        this.artist = artist;
        this.songs = songs;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getSongs() {
        return songs;
    }

    public void setSongs(int songs) {
        this.songs = songs;
    }
}
