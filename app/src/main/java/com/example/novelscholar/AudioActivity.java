package com.example.novelscholar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import static com.example.novelscholar.MainActivity2.redirectActivity;

public class AudioActivity extends AppCompatActivity { DrawerLayout drawerLayout;
    private ListView listView; private ArrayList<Music> my_main_list;
    private MusicAdapter musicAdapter;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        drawerLayout=(DrawerLayout)findViewById(R.id.adraw);
        listView=(ListView)findViewById(R.id.ll);
        textView=(TextView)findViewById(R.id.tt);
        textView.setSelected(true);
        my_main_list=new ArrayList<>();
        my_main_list.add(new Music("Half GirlFriend","Chetan Bhagat",R.raw.half_girl_audio));
        my_main_list.add(new Music("Half GirlFriend","Chetan Bhagat",R.raw.half_girl_audio));
        my_main_list.add(new Music("Half GirlFriend","Chetan Bhagat",R.raw.half_girl_audio));
        my_main_list.add(new Music("Half GirlFriend","Chetan Bhagat",R.raw.half_girl_audio));
        my_main_list.add(new Music("Half GirlFriend","Chetan Bhagat",R.raw.half_girl_audio));
        my_main_list.add(new Music("Half GirlFriend","Chetan Bhagat",R.raw.half_girl_audio));
        my_main_list.add(new Music("Half GirlFriend","Chetan Bhagat",R.raw.half_girl_audio));
        my_main_list.add(new Music("Half GirlFriend","Chetan Bhagat",R.raw.half_girl_audio));
        my_main_list.add(new Music("Half GirlFriend","Chetan Bhagat",R.raw.half_girl_audio));
        my_main_list.add(new Music("Half GirlFriend","Chetan Bhagat",R.raw.half_girl_audio));
        my_main_list.add(new Music("Half GirlFriend","Chetan Bhagat",R.raw.half_girl_audio));
        my_main_list.add(new Music("Half GirlFriend","Chetan Bhagat",R.raw.half_girl_audio));
        MusicAdapter adapter=new MusicAdapter(this,R.layout.songs_item_list,my_main_list);
        listView.setAdapter(adapter);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.audio);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() { @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.novel:
                    startActivity(new Intent(getApplicationContext(),MainActivity3.class));
                    Toast.makeText(AudioActivity.this,"Read The Novel Stories...",Toast.LENGTH_LONG).show();
                    overridePendingTransition(0,0);
                    return true;
                case R.id.summary:
                    startActivity(new Intent(getApplicationContext(),SummaryActivity.class));
                    Toast.makeText(AudioActivity.this,"Read The Novel Summaries...",Toast.LENGTH_LONG).show();
                    overridePendingTransition(0,0);
                    return true;
                case R.id.bookmark:
                    startActivity(new Intent(getApplicationContext(),Bookmark.class));
                    Toast.makeText(AudioActivity.this,"Add BookMark for Important Content ...",Toast.LENGTH_LONG).show();
                    overridePendingTransition(0,0);
                    return true;
                case R.id.audio:
                    return true;
            }
            return false; }});
    }
    public void ClickMenu(View view){
        MainActivity2.openDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
        MainActivity2.closeDrawer(drawerLayout);
    }
    public void ClickNovel(View view){ recreate(); }
    public void ClickSearch(View view){
        redirectActivity(this,SearchMeaning.class);
    }
    public void ClickPronounciation(View view){ redirectActivity(this,MainActivity4.class); }
    public void ClickNote(View view){ redirectActivity(this,MainActivity5.class); }
    public void ClickAbout(View view){ redirectActivity(this,MainActivity6.class); }
    public void ClickRate(View view){ redirectActivity(this,MainActivity6.class); }
    public void ClickLogout(View view){ MainActivity2.logout(this); }
    @Override
    protected void onPause() { super.onPause(); MainActivity2.closeDrawer(drawerLayout); }

}