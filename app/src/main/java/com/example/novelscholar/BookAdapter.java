package com.example.novelscholar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {
    Context context;
    List<Book> books;
    int resources;

    public BookAdapter(@NonNull Context context, int resource, List<Book> books) {
        super(context, resource,books);
        this.context = context;
        this.books = books;
        this.resources = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(resources,null,false);
        TextView t1=view.findViewById(R.id.textView);
        TextView t2=view.findViewById(R.id.textView2);
        ImageView im=view.findViewById(R.id.imageView);
        Book book=books.get(position);
        t1.setText(book.getTitle());
        t2.setText(book.getAuthor());
        im.setVisibility(View.VISIBLE);
        if (book.getFinished()>0){
            im.setVisibility(View.INVISIBLE);
        }

        return view;
    }
}
