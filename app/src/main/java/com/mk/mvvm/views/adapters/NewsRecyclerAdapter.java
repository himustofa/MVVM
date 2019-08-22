package com.mk.mvvm.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mk.mvvm.R;
import com.mk.mvvm.models.ArticleModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.ViewHolder> {

    private ArrayList<ArticleModel> arrayList;
    private Context context;
    private int lastPosition = -1;

    public NewsRecyclerAdapter(Context context, ArrayList<ArticleModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_recycler_item_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ArticleModel model = arrayList.get(position);

        holder.layoutAuthor.setText(model.getAuthor());
        holder.layoutTitle.setText(model.getTitle());
        holder.layoutDescription.setText(model.getDescription());
        holder.layoutUrl.setText(model.getUrl());
        holder.layoutPublishedAt.setText(model.getPublishedAt());
        holder.layoutContent.setText(model.getContent());

        Picasso.get().load(model.getUrlToImage()).into(holder.layoutUrlToImage);

        holder.layoutNewsModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //alertDialog(v, model.getTitle(), model.getUrl());
                Toast.makeText(context, "You clicked "+model.getAuthor(), Toast.LENGTH_SHORT).show();
            }
        });

        // Here you apply the animation when the view is bound
        setAnimation(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView layoutUrlToImage;

        public TextView layoutAuthor;
        public TextView layoutTitle;
        public TextView layoutDescription;
        public TextView layoutUrl;
        public TextView layoutPublishedAt;
        public TextView layoutContent;

        public LinearLayout layoutNewsModel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutUrlToImage = (ImageView) itemView.findViewById(R.id.layout_url_to_image);

            layoutAuthor = (TextView) itemView.findViewById(R.id.layout_author);
            layoutTitle = (TextView) itemView.findViewById(R.id.layout_title);
            layoutUrl = (TextView) itemView.findViewById(R.id.layout_description);
            layoutDescription = (TextView) itemView.findViewById(R.id.layout_url);
            layoutPublishedAt = (TextView) itemView.findViewById(R.id.layout_published_at);
            layoutContent = (TextView) itemView.findViewById(R.id.layout_content);

            layoutNewsModel = (LinearLayout) itemView.findViewById(R.id.layout_news_model);
        }
    }

    //====================================================| Here is the key method to apply the animation
    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

}
