package com.example.novelscholar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class Pronounciation2 extends AppCompatActivity {
    EditText e;
    Button b1,b2;
    TextView textView;
    TextToSpeech textToSpeech ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pronounciation2);
        e=findViewById(R.id.et);b1=findViewById(R.id.bt);b2=findViewById(R.id.bt2);
        textView=(TextView)findViewById(R.id.textView);
        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override public void onInit(int status) {
                if (status==TextToSpeech.SUCCESS){ int lang=textToSpeech.setLanguage(Locale.ENGLISH); } }});
        b1.setOnClickListener(new View.OnClickListener() {@Override
        public void onClick(View v) { String s=e.getText().toString();
            int speech =textToSpeech.speak(s,TextToSpeech.QUEUE_FLUSH,null); }});
        b2.setOnClickListener(new View.OnClickListener() {@Override
        public void onClick(View v) { e.setText(" "); }});
    }
    public void bSpeech(View view) {
        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Hi Speak Something.");
        try { startActivityForResult(intent,1);
        }catch (ActivityNotFoundException e){ Toast.makeText(this,e.getMessage(),Toast.LENGTH_SHORT).show(); } }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if (resultCode==RESULT_OK && data!=null){
                    ArrayList<String> result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textView.setText(result.get(0)); }
                break; }
    }
    public boolean onCreateOptionsMenu(Menu menu) {             //create menu bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu); }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {

            case R.id.globe:
                Intent intent5 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(intent5);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}