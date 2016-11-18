package edu.calvin.harambe.knowledgeshare;

import android.widget.Filter;

import java.util.ArrayList;

/**
 * Created by cjn8 on 11/8/2016.
 */

public class NewsFilter extends Filter {
    ArrayList<NewsCard> searchedList;
    NewsAdapter adapter;
    public NewsFilter(ArrayList<NewsCard> l, NewsAdapter a) {
        this.searchedList = l;
        this.adapter = a;
    }
    @Override
    protected FilterResults performFiltering(CharSequence query) {
        FilterResults results = new FilterResults();
        if (query != null && query.length() > 0) {
            query = query.toString().toUpperCase();
            ArrayList<NewsCard> searchResults = new ArrayList<NewsCard>();
            for (int i = 0; i < searchedList.size(); i++) {
                if (searchedList.get(i).getHeadline().toUpperCase().contains(query)) {
                    searchResults.add(searchedList.get(i));
                }
                else if (searchedList.get(i).getSender().toUpperCase().contains(query)) {
                    searchResults.add(searchedList.get(i));
                }
                else if (searchedList.get(i).getStory().toUpperCase().contains(query)) {
                    searchResults.add(searchedList.get(i));
                }
            }
            results.count = searchResults.size();
            results.values = searchResults;
        }
        else {
            results.count = searchedList.size();
            results.values = searchedList;
        }
        return results;
    }
    @Override
    protected void publishResults(CharSequence query, FilterResults results) {
        adapter.fullList = (ArrayList<NewsCard>) results.values;
        adapter.notifyDataSetChanged();
    }
}