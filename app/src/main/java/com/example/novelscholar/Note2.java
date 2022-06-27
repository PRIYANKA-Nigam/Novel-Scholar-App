package com.example.novelscholar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;

public class Note2 extends AppCompatActivity {
    static ArrayAdapter arrayAdapter;static ArrayList<String> notes=new ArrayList<>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note2);
        listView=(ListView)findViewById(R.id.ll);
        SharedPreferences sh=getApplicationContext().getSharedPreferences("com.example.noteapp", Context.MODE_PRIVATE);
        HashSet<String> set=(HashSet<String>)sh.getStringSet("notes",null);
        if (set==null){ notes.add("Example Note");
        }else { notes=new ArrayList<>(set); }
        arrayAdapter  =new ArrayAdapter(this, android.R.layout.simple_list_item_1,notes);
        listView.setAdapter(arrayAdapter); listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {@Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent=new Intent(Note2.this,Note2Helper.class);
            intent.putExtra("id",position);startActivity(intent); }});
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {@Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            new AlertDialog.Builder(Note2.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Are You Sure?")
                    .setMessage("Do You Want to delete this note").setPositiveButton("Yes", new DialogInterface.OnClickListener() {@Override
            public void onClick(DialogInterface dialog, int which) {
                notes.remove(position);arrayAdapter.notifyDataSetChanged();
                SharedPreferences sh=getApplicationContext().getSharedPreferences("com.example.noteapp", Context.MODE_PRIVATE);
                HashSet<String> set=new HashSet<>(Note2.notes);sh.edit().putStringSet("notes",set).apply(); }
            }).setNegativeButton("No",null).show();
            return true; }});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.add_note,menu);return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId()==R.id.add){ Intent intent=new Intent(getApplicationContext(),Note2Helper.class);
            startActivity(intent);return true; }return false;
    }
}