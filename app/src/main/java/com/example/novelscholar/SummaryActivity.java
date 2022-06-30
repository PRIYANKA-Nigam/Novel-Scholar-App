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
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import static com.example.novelscholar.MainActivity2.redirectActivity;

public class SummaryActivity extends AppCompatActivity { DrawerLayout drawerLayout;
    RecyclerView.LayoutManager layoutManager;RecyclerView recyclerView;
    List<Model> list; Adapter2 adapter2;
    String[] text={"Half GirlFriend","The Alchemist","The Kite Runner","The Diary of a young Girl",
            "The God of small thing","Attitude is Everything","Gulliver's Travel",
            "One Night at the call centre","Three Mistakes of my Life","Pride & Prejudice","Black Sheep",
            "The Monk who sold his Ferrari","The merchant of Venice" ,"Rich Dad Poor Dad" ,"Black Beauty","Midnight Children"
    };
    int[] image={R.drawable.half_girl, R.drawable.the_alchemist,R.drawable.the_kite_runner, R.drawable.the_diary,R.drawable.the_god, R.drawable.attitude,
            R.drawable.gullivers_travel, R.drawable.one_night,R.drawable.mistakes, R.drawable.pride_and_prejudice,R.drawable.black_sheep,
            R.drawable.the_monk, R.drawable.the_merchant_of_vanice, R.drawable.rich_dad,R.drawable.black_beauty,R.drawable.midnight};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        drawerLayout=(DrawerLayout)findViewById(R.id.ndraw);
        recyclerView = (RecyclerView) findViewById(R.id.rec);
        list = new ArrayList<>(); adapter2 = new Adapter2(this, list.size(), list);
        layoutManager = new LinearLayoutManager(this); recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true); int count = 0;
        for (String Name : text) { list.add(new Model(Name, image[count++]));
            recyclerView.setAdapter(adapter2); }
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.summary);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() { @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.novel:
                    startActivity(new Intent(getApplicationContext(),MainActivity3.class));
                    Toast.makeText(SummaryActivity.this,"Read The Novel Stories...",Toast.LENGTH_LONG).show();
                    overridePendingTransition(0,0);
                    return true;
                case R.id.summary:
                    return true;
                case R.id.bookmark:
                    startActivity(new Intent(getApplicationContext(),Bookmark.class));
                    Toast.makeText(SummaryActivity.this,"Add BookMark for Important Content...",Toast.LENGTH_LONG).show();
                    overridePendingTransition(0,0);
                    return true;
                case R.id.audio:
                    startActivity(new Intent(getApplicationContext(),AudioActivity.class));
                    Toast.makeText(SummaryActivity.this,"Listen to the Novel Summary ...",Toast.LENGTH_LONG).show();
                    overridePendingTransition(0,0);
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