package edu.calvin.harambe.knowledgeshare;

/**
 * News Card Activity (NewsCardActivity.java)
 * This class provides a simple activity for viewing a full card
 *
 * @version: 1.0 (Fall, 2016)
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NewsCardActivity extends AppCompatActivity {

    private TextView headline;
    private TextView sender;
    private TextView story;
    private TextView date;

    /**
     * onCreate
     * This method creates the view for the activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_card);
        headline = (TextView) findViewById(R.id.ncHeadline);
        sender = (TextView) findViewById(R.id.ncSender);
        story = (TextView) findViewById(R.id.ncStory);
        date = (TextView) findViewById(R.id.ncDate);
        Bundle passedInfo = getIntent().getExtras();
        headline.setText(passedInfo.getString("headlinePass"));
        sender.setText(passedInfo.getString("senderPass"));
        story.setText(passedInfo.getString("storyPass"));
        String dateString = passedInfo.getString("dateMonthPass") + " " + passedInfo.getString("dateDayPass");
        date.setText(dateString);
    }
}
