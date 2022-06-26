package com.example.novelscholar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
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