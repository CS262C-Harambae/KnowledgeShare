package edu.calvin.harambe.knowledgeshare;

/**
 * News Card Adapter (NewsCardAdapter.java)
 * This class creates an adapter for the News Card object
 *
 * @author: Corey Noble (cjn8)
 * @version: 1.0 (Fall, 2016)
 */

// Imports (Android)
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

// Imports (Java)
import java.util.List;

// Adapter class
public class NewsCardAdapter extends RecyclerView.Adapter<NewsCardAdapter.HarambeViewHolder> {
    
    // Instance variables
    private Context cardContext;
    private List<NewsCard> cardList;

    // Inner class for making RecyclerView.ViewHolder work for us
    public class HarambeViewHolder extends RecyclerView.ViewHolder {
        
        // Instance variables
        public TextView headline;
        public TextView story;

        // Explicit constructor
        public HarambeViewHolder(View view) {
            super(view);
            headline = (TextView) view.findViewById(R.id.headline);
            story = (TextView) view.findViewById(R.id.story);
        }
    }

    // Adapter for News Card object
    public NewsCardAdapter(Context cardContext, List<NewsCard> cardList) {
        this.cardContext = cardContext;
        this.cardList = cardList;
    }

    // Initialize adapter
    @Override
    public HarambeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card, parent, false);
        return new HarambeViewHolder(itemView);
    }

    // Updater
    @Override
    public void onBindViewHolder(final HarambeViewHolder holder, int position) {
        NewsCard card = cardList.get(position);
        holder.headline.setText(card.getHeadline());
        holder.story.setText(card.getStory());
    }

    // Get size of cardList
    @Override
    public int getItemCount() {
        return cardList.size();
    }
}
