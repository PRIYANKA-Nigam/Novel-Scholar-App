package com.example.novelscholar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddBook extends AppCompatActivity {
    Context context;DBHelper dbHelper;
    EditText e1,e2,e3;
    Button b;
    TextView t;long updateDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        context=this;
        dbHelper=new DBHelper(context);
        t=(TextView)findViewById(R.id.textView3);
        String id=getIntent().getStringExtra("id");
        e1=(EditText)findViewById(R.id.editTextTextPersonName);
        e2=(EditText)findViewById(R.id.editTextTextPersonName2);
        e3=(EditText)findViewById(R.id.editTextTextPersonName3);
        b=(Button)findViewById(R.id.button2);
        if (id!=null){
            t.setText("Update Your Book");
            Book book=dbHelper.getBook(Integer.parseInt(id));
            e1.setText(book.getTitle());
            e2.setText(book.getAuthor());
            e3.setText(book.getReview());
            updateDate=book.getStarted();
            b.setText("Update Book");

        }

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                long date=System.currentTimeMillis();
                Book book=new Book(s1,s2,s3,date,0);
                if (id!=null){
                    book.setId(Integer.parseInt(id));
                    dbHelper.addBook(book);
                    startActivity(new Intent(context,Bookmark.class));
                }else { book.setStarted(updateDate);
                    dbHelper.addBook(book);
                    startActivity(new Intent(context,Bookmark.class));
                }
            }
        });

    }
}