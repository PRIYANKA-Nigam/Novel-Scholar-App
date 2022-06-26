package com.example.novelscholar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.novelscholar.MainActivity2.redirectActivity;

public class SearchMeaning extends AppCompatActivity {
DrawerLayout drawerLayout; Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_meaning);
        drawerLayout=(DrawerLayout)findViewById(R.id.sdraw);
        button=(Button)findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(SearchMeaning.this, Meaning2.class);
                startActivity(intent1);
            }
        });
    }
    public void ClickMenu(View view){
        MainActivity2.openDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
        MainActivity2.closeDrawer(drawerLayout);
    }
    public void ClickNovel(View view){
        redirectActivity(this,MainActivity3.class);
    }
    public void ClickSearch(View view){
        recreate();
    }
    public void ClickPronounciation(View view){
        redirectActivity(this,MainActivity4.class);
    }
    public void ClickNote(View view){
        redirectActivity(this,MainActivity5.class);
    }
    public void ClickAbout(View view){
        redirectActivity(this,MainActivity6.class);
    }
    public void ClickRate(View view){
        redirectActivity(this,MainActivity7.class);
    }
    public void ClickLogout(View view){
        MainActivity2.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity2.closeDrawer(drawerLayout);
    }
}