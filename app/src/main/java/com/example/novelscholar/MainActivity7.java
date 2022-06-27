package com.example.novelscholar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.novelscholar.MainActivity2.redirectActivity;

public class MainActivity7 extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        drawerLayout =(DrawerLayout)findViewById(R.id.rdraw);
        button=(Button)findViewById(R.id.bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              try  { //when play store available initialise uri
                    Uri uri = Uri.parse("market://details?id=" + getPackageName());
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }catch (ActivityNotFoundException e){  //when play store unavailable initialise uri
                  Uri uri=Uri.parse("https://play.google.com/store/apps/details?id="+getPackageName());
                  Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                  intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                  startActivity(intent);
              }
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
        redirectActivity(this,SearchMeaning.class);
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
      recreate();
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