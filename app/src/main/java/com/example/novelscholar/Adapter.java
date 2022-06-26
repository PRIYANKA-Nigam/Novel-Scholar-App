package com.example.novelscholar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.My>{
    Context context; int size; List<Model> list;

    public Adapter(Context context, int size, List<Model> list) {
        this.context = context;
        this.size = size;
        this.list = list;
    }


    @NonNull
    @Override
    public My onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.photo,parent,false);
        return new My(v);
    }

    @Override
    public void onBindViewHolder(@NonNull My holder, int position) {
        final Model models=list.get(position);
        holder.textView.setText(models.getText());
        holder.imageView.setImageResource(models.getImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(view.getContext(),Novel2Activity.class);
                i.putExtra("text",position); view.getContext().startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class My extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        CardView cardView;
        public My(@NonNull View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.textView);
            imageView=(ImageView)itemView.findViewById(R.id.imageView2);
            cardView=(CardView)itemView.findViewById(R.id.card);
        }
    }
}
