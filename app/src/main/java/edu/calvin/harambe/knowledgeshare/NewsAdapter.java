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
 * News Adapter (NewsAdapter.java)
 * This adapter creates a Filterable RecyclerView
 * It also formats the information that is displayed
 * on the cards
 *
 * @version 1.0.1
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

    /**
     * onCreateViewHolder
     * This method creates the view for the activity
     */
    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card, null);
        NewsHolder holder = new NewsHolder(v);
        return holder;
    }
    
    /**
     * onBindViewHolder
     * This method binds the view holder
     */
    @Override
    public void onBindViewHolder(NewsHolder h, int position) {
        NewsCard card = fullList.get(position);
        h.headline.setText(card.getHeadline());
        h.sender.setText(card.getSender());
        h.story.setText(card.getStory());
        String subDate = card.getDate();
        subDate = subDate.substring(5, 10);
        String day = subDate.substring(3, 5);
        String month = subDate.substring(0, 2);
        if (month.equals("01")) {
            month = "January";
        }
        else if (month.equals("02")) {
            month = "February";
        }
        else if (month.equals("03")) {
            month = "March";
        }
        else if (month.equals("04")) {
            month = "April";
        }
        else if (month.equals("05")) {
            month = "May";
        }
        else if (month.equals("06")) {
            month = "June";
        }
        else if (month.equals("07")) {
            month = "July";
        }
        else if (month.equals("08")) {
            month = "August";
        }
        else if (month.equals("09")) {
            month = "September";
        }
        else if (month.equals("10")) {
            month = "October";
        }
        else if (month.equals("11")) {
            month = "November";
        }
        else if (month.equals("12")) {
            month = "December";
        }
        h.dateMonth.setText(month);
        if (day.substring(0, 1).equals("0")) {
            day = day.substring(1, 2);
        }
        h.dateDay.setText(day);
    }

    /**
     * getItemCount
     * This method counts the items in the list
     *
     * @return fullList.size(), an int
     */
    @Override
    public int getItemCount() {
        return fullList.size();
    }
    
    /**
     * getFilter
     * This method creates a filter
     *
     * @return filter, a NewsFilter
     */
    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new NewsFilter(searchedList, this);
        }
        return filter;
    }
}

