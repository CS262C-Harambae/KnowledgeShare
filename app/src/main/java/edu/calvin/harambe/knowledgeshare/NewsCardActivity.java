package edu.calvin.harambe.knowledgeshare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NewsCardActivity extends AppCompatActivity {

    private TextView headline;
    private TextView sender;
    private TextView story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_card);
        headline = (TextView) findViewById(R.id.ncHeadline);
        sender = (TextView) findViewById(R.id.ncSender);
        story = (TextView) findViewById(R.id.ncStory);
        Bundle passedInfo = getIntent().getExtras();
        headline.setText(passedInfo.getString("headlinePass"));
        sender.setText(passedInfo.getString("senderPass"));
        story.setText(passedInfo.getString("storyPass"));
    }
}
