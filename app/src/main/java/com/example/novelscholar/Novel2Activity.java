package com.example.novelscholar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.github.barteksc.pdfviewer.PDFView;

public class Novel2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel2);
        PDFView pdfView=(PDFView)findViewById(R.id.pd);
        int s=getIntent().getIntExtra("text",0);
        switch (s) {
            case 0:
                pdfView.fromAsset("halfGirlFriend.pdf").load();
                break;
            case 1:
                pdfView.fromAsset("halfGirlFriend.pdf").load();
                break;
            case 2:
                pdfView.fromAsset("halfGirlFriend.pdf").load();
                break;
            case 3:
                pdfView.fromAsset("halfGirlFriend.pdf").load();
                break;
            case 4:
                pdfView.fromAsset("halfGirlFriend.pdf").load();
                break;
            case 5:
                pdfView.fromAsset("halfGirlFriend.pdf").load();
                break;
            case 6:
                pdfView.fromAsset("halfGirlFriend.pdf").load();
                break;
            case 7:
                pdfView.fromAsset("halfGirlFriend.pdf").load();
                break;
            case 8:
                pdfView.fromAsset("halfGirlFriend.pdf").load();
                break;
            case 9:
                pdfView.fromAsset("halfGirlFriend.pdf").load();
                break;
            case 10:
                pdfView.fromAsset("halfGirlFriend.pdf").load();
                break;
            case 11:
                pdfView.fromAsset("halfGirlFriend.pdf").load();
                break;

        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {             //create menu bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu); }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { int id = item.getItemId();
        switch (id) {
            case R.id.home:
                Intent intent1 = new Intent(Novel2Activity.this, MainActivity3.class);
                startActivity(intent1);
                break;
            case R.id.meaning:
                Intent intent2 = new Intent(Novel2Activity.this, Meaning3.class);
                startActivity(intent2);
                break;
            case R.id.pronounciation:
                Intent intent3 = new Intent(Novel2Activity.this, Pronounciation3.class);
                startActivity(intent3);
                break;
            case R.id.note:
                Intent intent4 = new Intent(Novel2Activity.this, Note3.class);
                startActivity(intent4);
                break;
            case R.id.globe:
                Intent intent5 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(intent5);
                break;
        }
        return super.onOptionsItemSelected(item); }
}