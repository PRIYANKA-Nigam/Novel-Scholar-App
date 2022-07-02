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

public class Summary2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary2);
        PDFView pdfView=(PDFView)findViewById(R.id.pd);
        int s=getIntent().getIntExtra("text",0);
        switch (s) {
            case 0:
                pdfView.fromAsset("halfGirl.pdf").load();
                break;
            case 1:
                pdfView.fromAsset("SodaPDF-converted-the_alchemist.pdf").load();
                break;
            case 2:
                pdfView.fromAsset("SodaPDF-converted-the_kite_runner.pdf").load();
                break;
            case 3:
                pdfView.fromAsset("the_diary_of_the_young_girl.pdf").load();
                break;
            case 4:
                pdfView.fromAsset("the_god_of_small_thing.pdf").load();
                break;
            case 5:
                pdfView.fromAsset("SodaPDF-converted-attitude.pdf").load();
                break;
            case 6:
                pdfView.fromAsset("SodaPDF-converted-gulliver.pdf").load();
                break;
            case 7:
                pdfView.fromAsset("SodaPDF-converted-one_night_at_the_call_centre.pdf").load();
                break;
            case 8:
                pdfView.fromAsset("SodaPDF-converted-three_mistakes.pdf").load();
                break;
            case 9:
                pdfView.fromAsset("SodaPDF-converted-pride_and_prejudice.pdf").load();
                break;
            case 10:
                pdfView.fromAsset("SodaPDF-converted-black_sheep.pdf").load();
                break;
            case 11:
                pdfView.fromAsset("SodaPDF-converted-the_monk.pdf").load();
                break;
            case 12:
                pdfView.fromAsset("SodaPDF-converted-the_merchant_of.pdf").load();
                break;
            case 13:
                pdfView.fromAsset("SodaPDF-converted-rich_dad.pdf").load();
                break;
            case 14:
                pdfView.fromAsset("SodaPDF-converted-black_beauty.pdf").load();
                break;
            case 15:
                pdfView.fromAsset("SodaPDF-converted-midnight_children.pdf").load();
                break;
            case 16:
                pdfView.fromAsset("SodaPDF-converted-wuthering.pdf").load();
                break;
            case 17:
                pdfView.fromAsset("SodaPDF-converted-little_princess.pdf").load();
                break;
            case 18:
                pdfView.fromAsset("the_alice.pdf").load();
                break;
            case 19:
                pdfView.fromAsset("SodaPDF-converted-awaken_the_giant.pdf").load();
                break;
            case 20:
                pdfView.fromAsset("SodaPDF-converted-love_never_fails.pdf").load();
                break;
            case 21:
                pdfView.fromAsset("the_palace.pdf").load();
                break;
            case 22:
                pdfView.fromAsset("the_great_gatsby.pdf").load();
                break;
            case 23:
                pdfView.fromAsset("SodaPDF-converted-pilgrim_progress.pdf").load();
                break;
            case 24:
                pdfView.fromAsset("joy_in_the_morning.pdf").load();
                break;
            case 25:
                pdfView.fromAsset("little-women-001-part-1-chapter-1-playing-pilgrims.pdf").load();
                break;
            case 26:
                pdfView.fromAsset("the_prince.pdf").load();
                break;
            case 27:
                pdfView.fromAsset("the_wedding_date.pdf").load();
                break;
            case 28:
                pdfView.fromAsset("beloved.pdf").load();
                break;
            case 29:
                pdfView.fromAsset("One_hundred.pdf").load();
                break;
            case 30:
                pdfView.fromAsset("SodaPDF-converted-to_kill_a_mocking_bird.pdf").load();
                break;
            case 31:
                pdfView.fromAsset("midnight_library.pdf").load();
                break;
            case 32:
                pdfView.fromAsset("a_paasage_to_india.pdf").load();
                break;
            case 33:
                pdfView.fromAsset("obstacle.pdf").load();
                break;
            case 34:
                pdfView.fromAsset("SodaPDF-converted-boundaries.pdf").load();
                break;
            case 35:
                pdfView.fromAsset("SodaPDF-converted-lord_of_the_flies.pdf").load();
                break;
            case 36:
                pdfView.fromAsset("SodaPDF-converted-nine.pdf").load();
                break;
            case 37:
                pdfView.fromAsset("SodaPDF-converted-praying_to_get_results.pdf").load();
                break;
            case 38:
                pdfView.fromAsset("SodaPDF-converted-sacred_game.pdf").load();
                break;
            case 39:
                pdfView.fromAsset("Theroadtosuccsess-Chapterand2.pdf").load();
                break;
            case 40:
                pdfView.fromAsset("SodaPDF-converted-the_fault_in_our_stars.pdf").load();
                break;
            case 41:
                pdfView.fromAsset("SodaPDF-converted-the_women_in_white.pdf").load();
                break;
            case 42:
                pdfView.fromAsset("SodaPDF-converted-the_age_of_innocense.pdf").load();
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
                Intent intent1 = new Intent(Summary2Activity.this, SummaryActivity.class);
                startActivity(intent1);
                break;
            case R.id.meaning:
                Intent intent2 = new Intent(Summary2Activity.this, Meaning.class);
                startActivity(intent2);
                break;
            case R.id.pronounciation:
                Intent intent3 = new Intent(Summary2Activity.this, Pronounciation.class);
                startActivity(intent3);
                break;
            case R.id.note:
                Intent intent4 = new Intent(Summary2Activity.this, Note.class);
                startActivity(intent4);
                break;
            case R.id.globe:
                Intent intent5 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(intent5);
                break;
        }
        return super.onOptionsItemSelected(item); }
}