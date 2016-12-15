package edu.calvin.harambe.knowledgeshare;

/**
 * News Holder (NewsHolder.java)
 * This class converts a card into an activity
 *
 * @version: 1.0 (Fall, 2016)
 */

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsHolder extends RecyclerView.ViewHolder {
    TextView headline;
    TextView sender;
    TextView story;
    TextView dateMonth;
    TextView dateDay;
    
    /**
     * NewsHolder
     * This class creates a holder for the information to send it to the news card activity
     *
     * @param v, a View
     */
    public NewsHolder(View v) {
        super(v);
        this.headline = (TextView) v.findViewById(R.id.headline);
        this.sender = (TextView) v.findViewById(R.id.sender);
        this.story = (TextView) v.findViewById(R.id.story);
        this.dateMonth = (TextView) v.findViewById(R.id.dateMonth);
        this.dateDay = (TextView) v.findViewById(R.id.dateDay);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NewsCardActivity.class);
                intent.putExtra("headlinePass", headline.getText().toString());
                intent.putExtra("senderPass", sender.getText().toString());
                intent.putExtra("storyPass", story.getText().toString());
                intent.putExtra("dateMonthPass", dateMonth.getText().toString());
                intent.putExtra("dateDayPass", dateDay.getText().toString());
                v.getContext().startActivity(intent);
            }
        });
    }
}
