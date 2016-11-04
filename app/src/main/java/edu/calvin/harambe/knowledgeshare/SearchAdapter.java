package edu.calvin.harambe.knowledgeshare;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cjn8 on 11/2/2016.
 */

public class SearchAdapter extends ArrayAdapter<NewsCard> {

    private static class ViewHolder {
        public TextView headline;
        public TextView sender;
        public ImageView color;
    }

    public SearchAdapter(Context context, ArrayList<NewsCard> cardList) {
        super(context, 0, cardList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final NewsCard card = getItem(position);
        ViewHolder searchViewHolder;
        if (convertView == null) {
            searchViewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.news_card, parent, false);
            searchViewHolder.headline = (TextView) convertView.findViewById(R.id.headline);
            searchViewHolder.sender = (TextView) convertView.findViewById(R.id.sender);
            searchViewHolder.color = (ImageView) convertView.findViewById(R.id.colorBar);
            convertView.setTag(searchViewHolder);
        }
        else {
            searchViewHolder = (ViewHolder) convertView.getTag();
        }
        searchViewHolder.headline.setText(card.getHeadline());
        searchViewHolder.sender.setText(card.getSender());
        searchViewHolder.color.setBackgroundColor(Color.rgb(185, 79, 247));
        return convertView;
    }
}
