package com.example.novelscholar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static com.example.novelscholar.MainActivity2.redirectActivity;

public class Bookmark extends AppCompatActivity {
    Context context;DBHelper dbHelper;private ListView listView;private TextView textView;private Button button;
    private List<Book> books;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);
        drawerLayout=(DrawerLayout)findViewById(R.id.ndraw);
        context=this;
        dbHelper=new DBHelper(context);
        listView=(ListView)findViewById(R.id.ll);
        textView=(TextView)findViewById(R.id.textView4);
        button=(Button)findViewById(R.id.button);
        int count=dbHelper.countBooks();
        textView.setText("You have "+count +" books");
        books=new ArrayList<>();
        books=dbHelper.getAllBooks();
        BookAdapter bookAdapter=new BookAdapter(context,R.layout.single_book,books);
        listView.setAdapter(bookAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,AddBook.class));
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book book=books.get(position);
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                String finishRead=new SimpleDateFormat("dd/MM/yy").format(book.getStarted());
                if(book.getFinished()==0){
                    finishRead="Still Reading";

                }
                builder.setTitle(book.getTitle()).setMessage("By "+book.getAuthor()+
                        "\n\n\n" +new SimpleDateFormat("dd/MM/yy").format(book.getStarted())+"\n"+finishRead +"\n\n"+ book.getReview()+ "\n")
                        .setPositiveButton("Finished Reading", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                book.setFinished(System.currentTimeMillis());
                                dbHelper.updateBook(book);
                                startActivity(new Intent(context,Bookmark.class));

                            }
                        })
                        .setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dbHelper.deleteBooks(book.getId());
                                startActivity(new Intent(context,Bookmark.class));
                            }
                        }).setNeutralButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(context,AddBook.class);
                        intent.putExtra("id",String.valueOf(book.getId()));
                        startActivity(intent);
                    }
                }).show();

            }
        });
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.bookmark);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() { @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.novel:
                    startActivity(new Intent(getApplicationContext(),MainActivity3.class));
                    Toast.makeText(Bookmark.this,"Read The Novel Stories...",Toast.LENGTH_LONG).show();
                    overridePendingTransition(0,0);
                    return true;
                case R.id.summary:
                    startActivity(new Intent(getApplicationContext(),SummaryActivity.class));
                    Toast.makeText(Bookmark.this,"Read The Novel Summaries...",Toast.LENGTH_LONG).show();
                    overridePendingTransition(0,0);
                    return true;
                case R.id.bookmark:
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