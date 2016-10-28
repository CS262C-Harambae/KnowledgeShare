package edu.calvin.harambe.knowledgeshare;

/**
 * News Activity (NewsActivity.java)
 * This class provides the workings for the News Activity
 * This activity could be called our "main" activity,
 * as it is the platform in which the other classes fit
 *
 * @author: Corey Noble (cjn8)
 * @version: 1.0 (Fall, 2016)
 */

// Imports (Android)
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;

// Imports (Java)
import java.util.ArrayList;
import java.util.List;

// Activity class
public class NewsActivity extends AppCompatActivity {

    // Instance variables
    private RecyclerView recyclerView;
    private NewsCardAdapter adapter;
    private List<NewsCard> cardList;

    // Initialize activity and build the card list
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        cardList = new ArrayList<>();
        adapter = new NewsCardAdapter(this, cardList);
        RecyclerView.LayoutManager harambeLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(harambeLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        setupCards();
    }

    // Add cards (now they are just test cards)
    private void setupCards() {
        NewsCard card = new NewsCard("Breaking News", "Calvin strikes oil", 1, 1);
        cardList.add(card);

        card = new NewsCard("Dance Guild", "You can ignore this announcement", 1, 1);
        cardList.add(card);

        card = new NewsCard("$8228/#%042734", "Yet another poorly formatted title...", 1, 1);
        cardList.add(card);

        card = new NewsCard("FLU CLINIC - Health Services - October 20", "Calvin College Health Services is hosting another flu clinic on Thursday, October 20, from 10 a.m. to 2 p.m. The initial check-in point will be located in Health Services.\nDue to its ineffectiveness, flu mist will not be available this year.  Only the flu shot will be available.", 1, 1);
        cardList.add(card);

        card = new NewsCard("Philosophy Faculty Book Reception", "The Philosophy Department at Calvin College would like to invite you to attend our Faculty Book Reception, Thursday, October 20, from 3:30 to 5:30 PM\nThe reception will offer students, staff, and faculty the opportunity to hear a short presentation by each of our faculty members on their recent publications.", 1, 1);
        cardList.add(card);

        adapter.notifyDataSetChanged();
    }

    // Create the options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    // Go to different activity if selected from the options menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.aboutActivity:
                startActivity(new Intent(NewsActivity.this, AboutActivity.class));
                return true;
            case R.id.harambeActivity:
                startActivity(new Intent(NewsActivity.this, HarambeActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
