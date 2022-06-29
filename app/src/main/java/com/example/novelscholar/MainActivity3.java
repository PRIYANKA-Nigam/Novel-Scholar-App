package com.example.novelscholar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import static com.example.novelscholar.MainActivity2.redirectActivity;

public class MainActivity3 extends AppCompatActivity {
 DrawerLayout drawerLayout;
    RecyclerView.LayoutManager layoutManager;RecyclerView recyclerView;
    List<Model> list; Adapter adapter;
    String[] text={"Gulliver's Travel","Attitude is Everything","Black Sheep","Boundaries when to say Yes",
            "Call of Wild","Harry Potter and the Philospher's Stone","Growing up Spiritually",
            "Half GirlFriend","One Indian Girl","Rich Dad Poor Dad","The Alchemist",
            "The Monk who sold his Ferrari"
    };
    int[] image={R.drawable.half_girl, R.drawable.p1,R.drawable.half_girl, R.drawable.p1,R.drawable.half_girl, R.drawable.p1,
            R.drawable.half_girl, R.drawable.p1,R.drawable.half_girl, R.drawable.p1,R.drawable.half_girl,
            R.drawable.p1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        drawerLayout=(DrawerLayout)findViewById(R.id.ndraw);
        recyclerView = (RecyclerView) findViewById(R.id.rec);
        list = new ArrayList<>(); adapter = new Adapter(this, list.size(), list);
        layoutManager = new LinearLayoutManager(this); recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true); int count = 0;
        for (String Name : text) { list.add(new Model(Name, image[count++]));
            recyclerView.setAdapter(adapter); }
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.novel);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.novel:
                        return true;
                    case R.id.summary:
                        startActivity(new Intent(getApplicationContext(),SummaryActivity.class));
                        Toast.makeText(MainActivity3.this,"Read The Novel Summaries...",Toast.LENGTH_LONG).show();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.bookmark:
                        startActivity(new Intent(getApplicationContext(),Bookmark.class));
                        Toast.makeText(MainActivity3.this,"Add BookMark for Important Content...",Toast.LENGTH_LONG).show();
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.audio:
                        startActivity(new Intent(getApplicationContext(),AudioActivity.class));
                        Toast.makeText(MainActivity3.this,"Listen to the Novel Summary ...",Toast.LENGTH_LONG).show();
                        overridePendingTransition(0,0);
                        return true;
                }
                return false; }
        });
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