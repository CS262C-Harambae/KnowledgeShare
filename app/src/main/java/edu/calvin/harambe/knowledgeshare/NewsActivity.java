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
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

// Imports (Java)
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

// Activity class
public class NewsActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    // Instance variables
    //private EditText searchBox;
    //private Button searchButton;
    private RecyclerView recyclerView;
    private SearchView searchView;
    private NewsCardAdapter mainAdapter;
    //private NewsCardAdapter displayAdapter;
    //private NewsCardAdapter searchAdapter;
    private ArrayList<NewsCard> cardList;
    //private ArrayList<NewsCard> displayList;
    //private ArrayList<NewsCard> searchList;

    // Initialize activity and build the card list
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        //searchBox = (EditText) findViewById(R.id.searchBar);
        //searchButton = (Button) findViewById(R.id.searchButton);
        cardList = new ArrayList<>();
        mainAdapter = new NewsCardAdapter(this, cardList);
        processCards();
        //displayList = cardList;
        //searchList = cardList;
        //displayAdapter = new NewsCardAdapter(this, displayList);
        //searchAdapter = new NewsCardAdapter(this, searchList);

        //recyclerView.setAdapter(mainAdapter);
/*
        searchBox.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId != EditorInfo.IME_ACTION_SEND) {
                    String query = searchBox.getText().toString();
                    searchCards(query);
                    return true;
                }
                return false;
            }
        });*/
        //searchListView = (ListView) findViewById(R.id.searchListView);
        //searchView = (SearchView) findViewById(R.id.search_view);

        //searchList

        RecyclerView.LayoutManager harambeLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(harambeLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mainAdapter);
        //searchListView.setAdapter(mainAdapter);

        formatCards();
    }


    @Override
    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            mainAdapter.getFilter().filter("");
        }
        else {
            mainAdapter.getFilter().filter(newText.toString());
        }
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return true;
    }

    // Add cards (now they are just test cards)
    private void processCards() {
        NewsCard card = new NewsCard("Breaking News", "provost@calvin.edu", "Calvin strikes oil", 0, 1);
        cardList.add(card);

        card = new NewsCard("Dance Guild", "random@calvin.edu", "You can ignore this announcement", 0, 1);
        cardList.add(card);

        card = new NewsCard("$8228/#%042734", "notReallyWorthLookingAt@calvin.edu", "Yet another poorly formatted title...", 0, 1);
        cardList.add(card);

        card = new NewsCard("FLU CLINIC - Health Services - October 20", "email", "Calvin College Health Services is hosting another flu clinic on Thursday, October 20, from 10 a.m. to 2 p.m. The initial check-in point will be located in Health Services.\nDue to its ineffectiveness, flu mist will not be available this year.  Only the flu shot will be available.", 0, 1);
        cardList.add(card);

        card = new NewsCard("Philosophy Faculty Book Reception", "NULL", "The Philosophy Department at Calvin College would like to invite you to attend our Faculty Book Reception, Thursday, October 20, from 3:30 to 5:30 PM\nThe reception will offer students, staff, and faculty the opportunity to hear a short presentation by each of our faculty members on their recent publications.", 0, 1);
        cardList.add(card);

        mainAdapter.notifyDataSetChanged();
    }
/*
    public void searchCards(String query) {
        searchList.clear();
        for (int i = 0; i < displayList.size(); i++) {
            if (displayList.get(i).getHeadline().contains(query)) {
                searchList.add(displayList.get(i));
            } else if (displayList.get(i).getSender().contains(query)) {
                searchList.add(displayList.get(i));
            } else if (displayList.get(i).getStory().contains(query)) {
                searchList.add(displayList.get(i));
            }
        }
        recyclerView.setAdapter(searchAdapter);
        searchAdapter.notifyDataSetChanged();
    }*/

    public void formatCards() {
        for (int i = 0; i < cardList.size(); i++) {
            NewsCard currentCard = cardList.get(i);
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
        mainAdapter.notifyDataSetChanged();
    }

    // Create the options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchActionBarItem = menu.findItem(R.id.searchActionBarItem);
        searchView = (SearchView) MenuItemCompat.getActionView(searchActionBarItem);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(true);
        return true;
    }

    // Go to different activity if selected from the options menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
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
