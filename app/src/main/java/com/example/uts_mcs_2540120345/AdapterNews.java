package com.example.uts_mcs_2540120345;

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

import java.io.Serializable;
import java.util.ArrayList;

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.viewHolder>{
    private ArrayList<News> NewsList = new ArrayList<>();
    Context context;
    News news;

    public AdapterNews(ArrayList<News> NewsList, Context context){
        this.NewsList = NewsList;
        this.context = context;
    }
    public void setNewsList(ArrayList<News> NewsList){
        this.NewsList = NewsList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public AdapterNews.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_news,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterNews.viewHolder holder, int position) {
        news = NewsList.get(position);
        holder.title.setText(news.getTitle());
        holder.Description.setText(news.getDesc());
        holder.img.setImageResource(news.getImage());
    }

    @Override
    public int getItemCount() {
        return NewsList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView title, Description;
        ImageView img;
        private CardView mCardView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_newsTitle);
            Description = itemView.findViewById(R.id.tv_newsDesc);
            img = itemView.findViewById(R.id.gambar);
            mCardView = itemView.findViewById(R.id.item_news);
            mCardView.setOnClickListener(e->{
                Intent intent = new Intent(context, NewsPage.class);
                context.startActivity(intent);
            });

        }
    }
}
