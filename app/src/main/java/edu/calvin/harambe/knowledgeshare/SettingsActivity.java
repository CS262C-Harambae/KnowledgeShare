package edu.calvin.harambe.knowledgeshare;

/**
 * Settings Activity (SettingsActivity.java)
 * This class provides the workings for the Settings Activity
 *
 * @version: 1.0 (Fall, 2016)
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

public class SettingsActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_settings);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new CategoriesFragment()).commit();
    }

    public void selectItem(View view) {
        //NewsActivity.emailList.clear();
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.administrationCheck:
                if (checked) {
                    NewsActivity.emailList.add("random@calvin.edu");
                }
                break;
            case R.id.careerDevelopmentCheck:
                if (checked) {
                    NewsActivity.emailList.add("health@calvin.edu");
                }
                break;
        }
    }
}
