package com.example.novelscholar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    private RecyclerView recyclerView;
    private ArrayList<Music> my_main_list;
    private MusicAdapter musicAdapter;
    RecyclerView.LayoutManager layoutManager;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        drawerLayout=(DrawerLayout)findViewById(R.id.adraw);
       recyclerView=(RecyclerView)findViewById(R.id.rec);
        textView=(TextView)findViewById(R.id.tt);
        textView.setSelected(true);
        my_main_list=new ArrayList<>();
        musicAdapter=new MusicAdapter(this,my_main_list.size(),my_main_list);
        layoutManager = new LinearLayoutManager(this); recyclerView.setLayoutManager(layoutManager);
       int count = 0;
        my_main_list.add(new Music("Half GirlFriend","Chetan Bhagat",R.raw.half_girl_audio));
        my_main_list.add(new Music("The Alchemist","Paulo Coelho",R.raw.alchemist));
        my_main_list.add(new Music("The Kite Runner","Khaled Hosseini",R.raw.kite));
        my_main_list.add(new Music("The diary of a young Girl","Anne Frank",R.raw.the_diary_of_the_young_girl));
        my_main_list.add(new Music("The God of small things","Arundhati Roy",R.raw.the_god_of_small_thing));
        my_main_list.add(new Music("Attitude is Everything","Jeff Keller",R.raw.attitude));
        my_main_list.add(new Music("Gulliver's Travel","Jonathon Swift",R.raw.gulliver));
        my_main_list.add(new Music("One Night at the call centre","Chetan Bhagat",R.raw.call_centre));
        my_main_list.add(new Music("Three mistakes of my Life","Chetan Bhagat",R.raw.mistakes));
        my_main_list.add(new Music("Pride & Prejudice","Jane Austen",R.raw.pride));
        my_main_list.add(new Music("Black Sheep","Georgette Heyer",R.raw.black_sheep));
        my_main_list.add(new Music("The Monk who sold his Ferrari","Robin Sharma",R.raw.monk));
        my_main_list.add(new Music("The Merchant of Venice","William Shakespeare",R.raw.merchant));
        my_main_list.add(new Music("Rich Dad Poor Dad","Robert T",R.raw.rich_dad));
        my_main_list.add(new Music("Black Beauty","Anna Sewell",R.raw.black_beauty));
        my_main_list.add(new Music("Midnight's Children","Salman Rushdie",R.raw.midnight));
        recyclerView.setAdapter(musicAdapter);
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