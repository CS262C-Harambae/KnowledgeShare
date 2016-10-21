package edu.calvin.harambe.knowledgeshare;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class NewsCardAdapter extends RecyclerView.Adapter<NewsCardAdapter.HarambeViewHolder> {
    private Context cardContext;
    private List<NewsCard> cardList;

    public class HarambeViewHolder extends RecyclerView.ViewHolder {
        public TextView headline;
        public TextView story;

        public HarambeViewHolder(View view) {
            super(view);
            headline = (TextView) view.findViewById(R.id.headline);
            story = (TextView) view.findViewById(R.id.story);
        }
    }

    public NewsCardAdapter(Context cardContext, List<NewsCard> cardList) {
        this.cardContext = cardContext;
        this.cardList = cardList;
    }

    @Override
    public HarambeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card, parent, false);
        return new HarambeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final HarambeViewHolder holder, int position) {
        NewsCard card = cardList.get(position);
        holder.headline.setText(card.getHeadline());
        holder.story.setText(card.getStory());
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }
}
