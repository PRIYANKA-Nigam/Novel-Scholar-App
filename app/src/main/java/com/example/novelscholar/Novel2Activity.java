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
                pdfView.fromAsset("THE-ALCHEMIST-pdf-free-download.pdf").load();
                break;
            case 2:
                pdfView.fromAsset("The-Kite-Runner-PDF-booksfree.org_.pdf").load();
                break;
            case 3:
                pdfView.fromAsset("the_diary_of_a_young_girl.pdf").load();
                break;
            case 4:
                pdfView.fromAsset("the_god_of_small_thing_by_arundhati_roy.pdf").load();
                break;
            case 5:
                pdfView.fromAsset("attitude_is_everything.pdf").load();
                break;
            case 6:
                pdfView.fromAsset("Gullivers-Travels-Jonathan-Swift-www.indianpdf.com_-Download-eBook-Novel-Free-Online.pdf").load();
                break;
            case 7:
                pdfView.fromAsset("instapdf.in-chetan-bhagat-one-night-at-the-call-centre-414.pdf").load();
                break;
            case 8:
                pdfView.fromAsset("instapdf.in-chetan-bhagat-three-mistakes-of-my-life-895.pdf").load();
                break;
            case 9:
                pdfView.fromAsset("pride_and_prejudice.pdf").load();
                break;
            case 10:
                pdfView.fromAsset("black-sheep.pdf").load();
                break;
            case 11:
                pdfView.fromAsset("The Monk who sold his ferrari - Robin Sharma (PDF) [Qwerty80].pdf").load();
                break;
            case 12:
                pdfView.fromAsset("The-Merchant-of-Venice-PDF.pdf").load();
                break;
            case 13:
                pdfView.fromAsset("Rich-Dad-Poor-Dad-eBook.pdf").load();
                break;
            case 14:
                pdfView.fromAsset("black-beauty-anna-sewell.pdf").load();
                break;
            case 15:
                pdfView.fromAsset("Magical Realism Reflected in the Salman Rushdie’s Novel Midnight’s Children 33 IJAMH-1084-SHABIR AHMAD.pdf").load();
                break;
            case 16:
                pdfView.fromAsset("119-2014-04-09-Wuthering Heights.pdf").load();
                break;
            case 17:
                pdfView.fromAsset("a-little-princess-001-chapter-1-sara.pdf").load();
                break;
            case 18:
                pdfView.fromAsset("Alice_in_Wonderland.pdf").load();
                break;
            case 19:
                pdfView.fromAsset("awaken_the_giant_within.pdf").load();
                break;
            case 20:
                pdfView.fromAsset("Love Never Fails By Kenneth E. Hagin ( PDFDrive ).pdf").load();
                break;
            case 21:
                pdfView.fromAsset("The Palace of Illusions by Chitra Banerjee Divakaruni.pdf").load();
                break;
            case 22:
                pdfView.fromAsset("The-Great-Gatsby.pdf").load();
                break;
            case 23:
                pdfView.fromAsset("the-pilgrim-s-progress-en.pdf").load();
                break;
            case 24:
                pdfView.fromAsset("joy_in_the_morning_by_mary_raymond_shipman_andrews.pdf").load();
                break;
            case 25:
                pdfView.fromAsset("little-women.pdf").load();
                break;
            case 26:
                pdfView.fromAsset("The Prince and the Dressmaker.pdf").load();
                break;
            case 27:
                pdfView.fromAsset("The-Wedding-Date-pdf-free-download.pdf").load();
                break;
            case 28:
                pdfView.fromAsset("Beloved_by_Toni_Morrison.pdf").load();
                break;
            case 29:
                pdfView.fromAsset("One Hundred Years of Solitude ( PDFDrive ).pdf").load();
                break;
            case 30:
                pdfView.fromAsset("To Kill A Mockingbird - Full Text PDF.pdf").load();
                break;
            case 31:
                pdfView.fromAsset("The-Midnight-Library-PDF.pdf").load();
                break;
            case 32:
                pdfView.fromAsset("a passage to india ( PDFDrive ).pdf").load();
                break;
            case 33:
                pdfView.fromAsset("16-05-2021-051456The-Obstacle-Is-the-Way.pdf").load();
                break;
            case 34:
                pdfView.fromAsset("Boundaries.pdf").load();
                break;
            case 35:
                pdfView.fromAsset("Lord of the Flies PDF ( PDFDrive ).pdf").load();
                break;
            case 36:
                pdfView.fromAsset("Orwell-1949 1984.pdf").load();
                break;
            case 37:
                pdfView.fromAsset("Praying-to-Get-Results-by-Kenneth-E-Hagin-pdf.pdf").load();
                break;
            case 38:
                pdfView.fromAsset("sacred_games-vikram_chandra.pdf").load();
                break;
            case 39:
                pdfView.fromAsset("Signs-Posts-on-the-Road-to-Success-Kenyon.pdf").load();
                break;
            case 40:
                pdfView.fromAsset("the_fault_in_our_stars.pdf").load();
                break;
            case 41:
                pdfView.fromAsset("woman-in-white.pdf").load();
                break;
            case 42:
                pdfView.fromAsset("the_age_of_innocence.pdf").load();
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