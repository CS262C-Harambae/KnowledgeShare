package edu.calvin.harambe.knowledgeshare;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;

/**
 * Created by cjn8 on 11/9/2016.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsHolder> implements Filterable {
    Context context;
    ArrayList<NewsCard> fullList, searchedList;
    NewsFilter filter;
    public NewsAdapter(Context c, ArrayList<NewsCard> l) {
        this.context = c;
        this.fullList = l;
        this.searchedList = l;
        //formatCards();
    }

    /*
    public void formatCards() {
        for (int i = 0; i < fullList.size(); i++) {
            NewsCard currentCard = fullList.get(i);
            if (currentCard.getSender().equals("provost@calvin.edu")) {
                currentCard.setColor(1);
            }
            else if (currentCard.getSender().equals("random@calvin.edu")) {
                currentCard.setColor(2);
            }
            else if (currentCard.getSender().equals("NULL")) {
                currentCard.setColor(3);
            }
            else if (currentCard.getSender().equals("email")) {
                currentCard.setColor(4);
            }
        }
        this.notifyDataSetChanged();
    }*/
    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card, null);
        NewsHolder holder = new NewsHolder(v);
        return holder;
    }
    @Override
    public void onBindViewHolder(NewsHolder h, int position) {
        NewsCard card = fullList.get(position);
        h.headline.setText(card.getHeadline());
        h.sender.setText(card.getSender());
        h.story.setText(card.getStory());
        String subDate = card.getDate();
        subDate = subDate.substring(0, 5);
        h.date.setText(subDate);
    }
        /*
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
        /*
        if (isBlack) {
            h.colorBar.setBackgroundColor(Color.rgb(0, 0, 0));
        }
        else if (isBlue) {
            h.colorBar.setBackgroundColor(Color.rgb(11, 94, 229));
        }
        else if (isRed) {
            h.colorBar.setBackgroundColor(Color.rgb(229, 29, 11));
        }
        else if (isPurple) {
            h.colorBar.setBackgroundColor(Color.rgb(174, 11, 229));
        }
        else if (isGreen) {
            h.colorBar.setBackgroundColor(Color.rgb(14, 184, 54));
        }
        else if (isYellow) {
            h.colorBar.setBackgroundColor(Color.rgb(238, 242, 7));
        }*/

    @Override
    public int getItemCount() {
        return fullList.size();
    }
    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new NewsFilter(searchedList, this);
        }
        return filter;
    }
}
