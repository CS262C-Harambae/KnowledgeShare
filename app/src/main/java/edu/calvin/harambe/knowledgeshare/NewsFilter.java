package edu.calvin.harambe.knowledgeshare;

/**
 * News Filter (NewsFilter.java)
 * This filter extends the existing Filter class for our purposes
 *
 * @version: 1.0 (Fall, 2016)
 */

import android.widget.Filter;

import java.util.ArrayList;


public class NewsFilter extends Filter {
    ArrayList<NewsCard> searchedList;
    NewsAdapter adapter;
    public NewsFilter(ArrayList<NewsCard> l, NewsAdapter a) {
        this.searchedList = l;
        this.adapter = a;
    }
    
    /**
     * performFiltering
     * This method searches for the query
     *
     * @return results, FilterResults
     * @param query, a CharSequence
     */
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
    
    /**
     * publishResults
     * This method sets the new search
     *
     * @param query, a CharSequence; results, FilterResults
     */
    @Override
    protected void publishResults(CharSequence query, FilterResults results) {
        adapter.fullList = (ArrayList<NewsCard>) results.values;
        adapter.notifyDataSetChanged();
    }
}
