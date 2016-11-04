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
import android.content.Intent;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

// Imports (Java)
import java.util.ArrayList;
import java.util.List;

// Adapter class
public class NewsCardAdapter extends RecyclerView.Adapter<NewsCardAdapter.HarambeViewHolder> implements Filterable {
    
    // Instance variables
    private Context cardContext;
    private ArrayList<NewsCard> cardList;
    private ArrayList<NewsCard> backupList;

    // Inner class for making RecyclerView.ViewHolder work for us
    public class HarambeViewHolder extends RecyclerView.ViewHolder {
        
        // Instance variables
        public TextView headline;
        public TextView sender;
        public TextView story;
        public ImageView color;

        // Explicit constructor
        public HarambeViewHolder(View view) {
            super(view);
            headline = (TextView) view.findViewById(R.id.headline);
            sender = (TextView) view.findViewById(R.id.sender);
            story = (TextView) view.findViewById(R.id.story);
            color = (ImageView) view.findViewById(R.id.colorBar);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), NewsCardActivity.class);
                    intent.putExtra("headlinePass", headline.getText().toString());
                    intent.putExtra("senderPass", sender.getText().toString());
                    intent.putExtra("storyPass", story.getText().toString());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }

    // Adapter for News Card object
    public NewsCardAdapter(Context cardContext, ArrayList<NewsCard> cardList) {
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
        holder.sender.setText(card.getSender());
        holder.story.setText(card.getStory());
        Integer colorBlack = 0;
        Integer colorBlue = 1;
        Integer colorRed = 2;
        Integer colorPurple = 3;
        Integer colorGreen = 4;
        Integer colorYellow = 5;
        Integer intBlack = Integer.compare(card.getColor(), colorBlack);
        boolean isBlack = (intBlack != 1);
        Integer intBlue = Integer.compare(card.getColor(), colorBlue);
        boolean isBlue = (intBlue != 1);
        Integer intRed = Integer.compare(card.getColor(), colorRed);
        boolean isRed = (intRed != 1);
        Integer intPurple = Integer.compare(card.getColor(), colorPurple);
        boolean isPurple = (intPurple != 1);
        Integer intGreen = Integer.compare(card.getColor(), colorGreen);
        boolean isGreen = (intGreen != 1);
        Integer intYellow = Integer.compare(card.getColor(), colorYellow);
        boolean isYellow = (intYellow != 1);
        if (isBlack) {
            holder.color.setBackgroundColor(Color.rgb(0, 0, 0));
        }
        else if (isBlue) {
            holder.color.setBackgroundColor(Color.rgb(11, 94, 229));
        }
        else if (isRed) {
            holder.color.setBackgroundColor(Color.rgb(229, 29, 11));
        }
        else if (isPurple) {
            holder.color.setBackgroundColor(Color.rgb(174, 11, 229));
        }
        else if (isGreen) {
            holder.color.setBackgroundColor(Color.rgb(14, 184, 54));
        }
        else if (isYellow) {
            holder.color.setBackgroundColor(Color.rgb(238, 242, 7));
        }
    }

    // Get size of cardList
    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                final FilterResults oReturn = new FilterResults();
                final ArrayList<NewsCard> results = new ArrayList<NewsCard>();
                if (backupList == null) {
                    backupList = cardList;
                    if (constraint != null) {
                        if (backupList != null & backupList.size() > 0) {
                            for (final NewsCard g : backupList) {
                                if (g.getHeadline().toLowerCase().contains(constraint.toString())) {
                                    results.add(g);
                                }
                                else if (g.getSender().toLowerCase().contains(constraint.toString())) {
                                    results.add(g);
                                }
                                else if (g.getStory().toLowerCase().contains(constraint.toString())) {
                                    results.add(g);
                                }
                            }
                        }
                        oReturn.values = results;
                    }
                }
                return oReturn;

            }
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                cardList = (ArrayList<NewsCard>)results.values;
                notifyDataSetChanged();
            }
        };
    }
}
