package edu.calvin.harambe.knowledgeshare;

/**
 * News Activity (NewsActivity.java)
 * This class provides the workings for the News Activity
 * This activity could be called our "main" activity,
 * as it is the platform in which the other classes fit
 *
 * @version 0.4 Beta (Fall, 2016)
 */

// Imports

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Activity class
public class NewsActivity extends AppCompatActivity {

    // Instance variables
    //public static String constraint = "http://153.106.116.73:8089/news/articles";
    private RecyclerView recyclerView;
    private SearchView searchView;
    private NewsAdapter adapter;
    private ArrayList<NewsCard> cardList = new ArrayList<>();
    public static ArrayList<String> emailList = new ArrayList<>();
    private ArrayList<NewsCard> tempList;
    public static StringBuilder constraint = new StringBuilder();
    //public GetArticleTask articleTask = new GetArticleTask();

    // Initialize activity and build the card list
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        searchView = (SearchView) findViewById(R.id.searchBar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //cardList = testCards();
        //tempList = testCards();


        //adapter.notifyDataSetChanged();
        new GetArticleTask().execute(createURL(constraint.toString()));
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        new GetArticleTask().execute(createURL(constraint.toString()));
        //cardList = tempList;
        //adapter.notifyDataSetChanged();
        //filterByCategory();
        //emailList.clear();
    }

    /*
    public void filterByCategory() {
        cardList.clear();
        for (int i = 0; i < tempList.size(); i++) {
            cardList.add(tempList.get(i));
        }
        int cardSize = cardList.size();

        if (cardList.size() > 0) {
            for (int i = 0; i < cardList.size(); i++) {
                for (int j = 0; j < emailList.size(); j++) {
                    if (cardList.get(i).getSender().equals(emailList.get(j))) {
                        cardList.remove(i);
                        i = 0;
                        j = 0;
                    }
                }
            }
            //adapter.notifyDataSetChanged();
        }
        adapter.notifyDataSetChanged();
        //emailList.clear();
        //cardList = tempList;
    }*/

    public URL createURL(String constraint) {
        try {
            StringBuilder urlString = new StringBuilder();
            //System.out.print(constraint);
            if (constraint.length() > 0) {
                urlString.append("http://cs262.cs.calvin.edu:8083/news/article/");
                urlString.append(constraint);
                //System.out.print(urlString.toString());
            }
            else {
                urlString.append("http://cs262.cs.calvin.edu:8083/news/articles");
            }
            String muhURL = urlString.toString();
            //System.out.print(muhURL);
            URL myURL = new URL(muhURL);
            System.out.print(myURL);
            return myURL;
            //return new URL(muhURL);
        } catch (Exception e) {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }
        return null;
    }

    public class GetArticleTask extends AsyncTask<URL, Void, JSONArray> {
        @Override
        protected JSONArray doInBackground(URL... params) {
            //System.out.print("Params: " + params[0]);
            HttpURLConnection connection = null;
            StringBuilder result = new StringBuilder();
            try {
                connection = (HttpURLConnection) params[0].openConnection();
                //System.out.println(connection.getResponseCode());
                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }
                    try {
                        //System.out.print("SUCCESS");
                        return new JSONArray(result.toString());
                    } catch (JSONException je) {
                        //System.out.print("FAILURE2");
                        JSONArray jArray = new JSONArray();
                        jArray.put(new JSONObject(result.toString()));
                        return jArray;
                    }
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.print("FAILURE1");
                e.printStackTrace();
            } finally {
                connection.disconnect();
            }
            return null;
        }

        @Override
        protected void onPostExecute(JSONArray player) {
            if (player != null) {
                convertJSONtoArrayList(player);
                NewsActivity.this.updateDisplay();
            } else {
                Toast.makeText(NewsActivity.this, "NOPE", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void convertJSONtoArrayList(JSONArray players) {
        cardList = new ArrayList<NewsCard>(); // clear old player data
        tempList = new ArrayList<NewsCard>();
        try {
            for (int i = 0; i < players.length(); i++) {
                JSONObject currentPlayer = players.getJSONObject(i);
                cardList.add(new NewsCard(
                        currentPlayer.has("subject") ? currentPlayer.getString("subject") : "No Headline",
                        currentPlayer.has("sender") ? currentPlayer.getString("sender") : "No Name",
                        currentPlayer.has("body") ? currentPlayer.getString("body") : "No Story",
                        currentPlayer.has("date") ? currentPlayer.getString("date") : "No Date"));
                tempList.add(new NewsCard(
                        currentPlayer.has("subject") ? currentPlayer.getString("subject") : "No Headline",
                        currentPlayer.has("sender") ? currentPlayer.getString("sender") : "No Name",
                        currentPlayer.has("body") ? currentPlayer.getString("body") : "No Story",
                        currentPlayer.has("date") ? currentPlayer.getString("date") : "No Date"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void updateDisplay() {
        if (cardList == null) {
            Toast.makeText(NewsActivity.this, "FAILURE", Toast.LENGTH_SHORT).show();
        }
        ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
        for (NewsCard item : cardList) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("subject", item.getHeadline());
            map.put("sender", item.getSender());
            map.put("body", item.getStory());
            map.put("date", item.getDate());
            data.add(map);
        }

        int resource = R.layout.news_card;
        String[] from = {"subject", "sender", "body", "date"};
        int[] to = {R.id.headline, R.id.sender, R.id.story, R.id.dateDay};
        adapter = new NewsAdapter(this, cardList);
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }

    // Add cards (now they are just test cards)
    private ArrayList<NewsCard> testCards() {
        ArrayList<NewsCard> cardList = new ArrayList<>();
        NewsCard card = new NewsCard("New Calvin StudentNews App", "johncalvin@calvin.edu", "There is a new app for Calvin StudentNews. Download from the Google Play Store.", "11-21-2016");
        cardList.add(card);

        card = new NewsCard("Career Center Closed", "kdykhouse@calvin.edu", "Calvin's Career Center will be closed on Wednesday, August 3, for a staff retreat. We apologize for any inconvenience this may cause.", "11-21-2016");
        cardList.add(card);

        card = new NewsCard("I'm Prez Leroy, son", "president@calvin.edu", "I run this place, yo.", "11-18-2016");
        cardList.add(card);

        card = new NewsCard("And I'm the Provost", "brac@calvin.edu", "My name is Cheryl Brandsen", "11-18-2016");
        cardList.add(card);

        card = new NewsCard("Pay Day for Student Employees", "payroll@calvin.edu", "It is pay day for Student employees! Please take a minute to review your electronic advice in the portal.", "11-21-2016");
        cardList.add(card);

        card = new NewsCard("Student Life Announcement", "sav36@calvin.edu", "Student life is very important to me. Thank you.",  "11-18-2016");
        cardList.add(card);

        card = new NewsCard("Careers are for development", "career@calvin.edu", "Get a career here!", "11-18-2016");
        cardList.add(card);

        card = new NewsCard("Spanish 301 students lead Spanish Chapel Tuesday", "zand@calvin.edu", "On Tuesday a group of Spanish 301 students will lead us in praise and will reflect with us on the theme of forgiveness. Come join us in the Commons Lecture Hall at 10:00AM.", "11-21-2016");
        cardList.add(card);

        card = new NewsCard("Flu Clinic TODAY at Health Services", "health@calvin.edu", "Calvin College Health Services is hosting a final flu clinic today from 10AM to 2PM. The initial check-in point will be located in Health Services.", "11-21-2016");
        cardList.add(card);

        card = new NewsCard("Web Time Entry in the Portal due on Monday, Nov. 21, by 4:00PM", "payroll@calvin.edu", "Calvin strikes oil", "11-21-2016");
        cardList.add(card);

        card = new NewsCard("Career Development fair", "mec6@calvin.edu", "Come to this fair.", "11-18-2016");
        cardList.add(card);

        card = new NewsCard("Dance Guild", "slp33@students.calvin.edu", "Join Dance Guild! Come on, please?", "11-18-2016");
        cardList.add(card);

        card = new NewsCard("Dance Guild", "slp33@students.calvin.edu", "COME ON!!!!", "11-18-2016");
        cardList.add(card);

        card = new NewsCard("Dance Guild", "slp33@students.calvin.edu", "It's fun, I promise!", "11-18-2016");
        cardList.add(card);

        card = new NewsCard("Dance Guild", "slp33@students.calvin.edu", "NO! WE'RE LOW ON PERFORMERS!", "11-18-2016");
        cardList.add(card);

        card = new NewsCard("O Lord My God", "campusministries@calvin.edu", "How Great Thou Art", "11-18-2016");
        cardList.add(card);

        card = new NewsCard("When I in awesome wonder", "stobja@calvin.edu", "How Great Thou Art", "11-18-2016");
        cardList.add(card);

        card = new NewsCard("Consider all", "mwp4@calvin.edu", "How Great Thou Art", "11-18-2016");
        cardList.add(card);

        card = new NewsCard("The Worlds thy hands have made", "pastormary@calvin.edu", "How Great Thou Art", "11-18-2016");
        cardList.add(card);

        card = new NewsCard("$8228/#%042734", "random@calvin.edu", "Yet another poorly formatted title...", "11-18-2016");
        cardList.add(card);

        //card = new NewsCard("FLU CLINIC - Health Services - October 20", "email", "Calvin College Health Services is hosting another flu clinic on Thursday, October 20, from 10 a.m. to 2 p.m. The initial check-in point will be located in Health Services.\nDue to its ineffectiveness, flu mist will not be available this year.  Only the flu shot will be available.", 0, 1, "11-18-2016");
        //cardList.add(card);

        //card = new NewsCard("Philosophy Faculty Book Reception", "NULL", "The Philosophy Department at Calvin College would like to invite you to attend our Faculty Book Reception, Thursday, October 20, from 3:30 to 5:30 PM\nThe reception will offer students, staff, and faculty the opportunity to hear a short presentation by each of our faculty members on their recent publications.", 0, 1, "11-18-2016");
        //cardList.add(card);

        return cardList;
    }

    // Create the options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchBarItem = menu.findItem(R.id.searchBar);
        searchView = (SearchView) MenuItemCompat.getActionView(searchBarItem);
        searchView.setIconifiedByDefault(true);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });
        return true;
    }

    // Go to different activity if selected from the options menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.aboutActivity:
                startActivity(new Intent(NewsActivity.this, AboutActivity.class));
                return true;
            case R.id.helpActivity:
                startActivity(new Intent(NewsActivity.this, HelpActivity.class));
                return true;
            case R.id.categoryFragment:
                //getFragmentManager().beginTransaction().replace(android.R.id.content, new CategoriesFragment()).commit();
                startActivity(new Intent(NewsActivity.this, SettingsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}