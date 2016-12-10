package edu.calvin.harambe.knowledgeshare;

/**
 * About Activity (AboutActivity.java)
 * This class provides the workings for the About Activity
 *
 * @version: 1.0 (Fall, 2016)
 */

// Imports

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

// Activity class
public class HelpActivity extends AppCompatActivity {

    // Initialize activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }
}
