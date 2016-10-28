package edu.calvin.harambe.knowledgeshare;

/**
 * Harambe Activity (HarambeActivity.java)
 * This class provides the workings for the Harambe Activity
 * (perhaps this will be integrated into AboutActivity.java...)
 *
 * @author: Corey Noble (cjn8)
 * @version: 1.0 (Fall, 2016)
 */

// Imports
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// Activity class
public class HarambeActivity extends AppCompatActivity {

    // Initialize activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harambe);
    }
}
