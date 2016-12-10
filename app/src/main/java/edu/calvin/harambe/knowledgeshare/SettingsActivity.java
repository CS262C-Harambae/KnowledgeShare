package edu.calvin.harambe.knowledgeshare;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Settings Activity (SettingsActivity.java)
 * This activity provides the category filters
 * It populates checkboxes and filter accordingly
 *
 * @version 1.0
 */

public class SettingsActivity extends AppCompatActivity {
    public ArrayList<String> administrationList = new ArrayList<String>();
    public ArrayList<String> careerDevelopmentList = new ArrayList<String>();
    public StringBuilder tempConstraint = new StringBuilder();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_settings);
        final SharedPreferences categories = getPreferences(Context.MODE_PRIVATE);
        final CheckBox administrationCheck = (CheckBox) findViewById(R.id.administrationCheck);
        final CheckBox careerDevelopmentCheck = (CheckBox) findViewById(R.id.careerDevelopmentCheck);
        final CheckBox campusMinistriesCheck = (CheckBox) findViewById(R.id.campusMinistriesCheck);
        final CheckBox danceGuildCheck = (CheckBox) findViewById(R.id.danceGuildCheck);
        final CheckBox humanResourcesCheck = (CheckBox) findViewById(R.id.humanResourcesCheck);
        final CheckBox bookstoreCheck = (CheckBox) findViewById(R.id.bookstoreCheck);
        //selectItem();
        administrationCheck.setChecked(categories.getBoolean("administration", false));
        administrationCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = categories.edit();
                editor.putBoolean("administration", administrationCheck.isChecked());
                editor.commit();
            }
        });
        careerDevelopmentCheck.setChecked(categories.getBoolean("careerDevelopment", false));
        careerDevelopmentCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = categories.edit();
                editor.putBoolean("careerDevelopment", careerDevelopmentCheck.isChecked());
                editor.commit();
            }
        });
        campusMinistriesCheck.setChecked(categories.getBoolean("campusMinistries", false));
        campusMinistriesCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = categories.edit();
                editor.putBoolean("campusMinistries", campusMinistriesCheck.isChecked());
                editor.commit();
            }
        });
        danceGuildCheck.setChecked(categories.getBoolean("danceGuild", false));
        danceGuildCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = categories.edit();
                editor.putBoolean("danceGuild", danceGuildCheck.isChecked());
                editor.commit();
            }
        });
        humanResourcesCheck.setChecked(categories.getBoolean("humanResources", false));
        humanResourcesCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = categories.edit();
                editor.putBoolean("humanResources", humanResourcesCheck.isChecked());
                editor.commit();
            }
        });
        bookstoreCheck.setChecked(categories.getBoolean("bookstore", false));
        bookstoreCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = categories.edit();
                editor.putBoolean("bookstore", bookstoreCheck.isChecked());
                editor.commit();
            }
        });
        //selectItem();
        
        //getFragmentManager().beginTransaction().replace(android.R.id.content, new CategoriesFragment()).commit();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //selectItem();
    }


    public void applyFilters(View view) {
        //NewsActivity.emailList.clear();
        tempConstraint = new StringBuilder();
        tempConstraint.delete(0, tempConstraint.length());
        NewsActivity.constraint = new StringBuilder();
        NewsActivity.constraint.delete(0, NewsActivity.constraint.length());
        //tempConstraint.append("'");
        System.out.print("Constraint check 1: " + tempConstraint + "\n");
        ArrayList<String> filterList = new ArrayList<String>();
        filterList.add("johncalvin@calvin.edu");
        filterList.add("brac@calvin.edu");
        filterList.add("svploeg@calvin.edu");
        filterList.add("kde2@calvin.edu");
        filterList.add("rjb42@calvin.edu");
        filterList.add("sav36@calvin.edu");
        filterList.add("thubers@calvin.edu");
        filterList.add("lopa@calvin.edu");
        filterList.add("career@calvin.edu");
        filterList.add("kdykhouse@calvin.edu");
        filterList.add("tdj4@calvin.edu");
        filterList.add("cbt4@calvin.edu");
        filterList.add("bcok@calvin.edu");
        filterList.add("lbl3@calvin.edu");
        filterList.add("mec6@calvin.edu");
        filterList.add("bspeyers@calvin.edu");
        filterList.add("bj24@calvin.edu");
        filterList.add("rwt2@calvin.edu");
        filterList.add("campusministries@calvin.edu");
        filterList.add("stobja@calvin.edu");
        filterList.add("pastormary@calvin.edu");
        filterList.add("mwp4@calvin.edu");
        filterList.add("jr224@calvin.edu");
        filterList.add("psr2@calvin.edu");
        filterList.add("jcs33@calvin.edu");
        filterList.add("rat9@calvin.edu");
        filterList.add("slp33@students.calvin.edu");
        filterList.add("humanresources@calvin.edu");
        filterList.add("briton@calvin.edu");
        filterList.add("mag24@calvin.edu");
        filterList.add("alg35@calvin.edu");
        filterList.add("dhonner@calvin.edu");
        filterList.add("thubers@calvin.edu");
        filterList.add("emw27@calvin.edu");
        filterList.add("ajn8@calvin.edu");
        filterList.add("mjg44@calvin.edu");
        filterList.add("cgl4@calvin.edu");
        filterList.add("calvin@bkstr.com");
        boolean administrationChecked = ((CheckBox) findViewById(R.id.administrationCheck)).isChecked();
        boolean careerCenterChecked = ((CheckBox) findViewById(R.id.careerDevelopmentCheck)).isChecked();
        boolean campusMinistriesChecked = ((CheckBox) findViewById(R.id.campusMinistriesCheck)).isChecked();
        boolean danceGuildChecked = ((CheckBox) findViewById(R.id.danceGuildCheck)).isChecked();
        boolean humanResourcesChecked = ((CheckBox) findViewById(R.id.humanResourcesCheck)).isChecked();
        boolean bookstoreChecked = ((CheckBox) findViewById(R.id.bookstoreCheck)).isChecked();
        if (administrationChecked) {
            //System.out.print("YES");
            filterList.remove("johncalvin@calvin.edu");
            filterList.remove("brac@calvin.edu");
            filterList.remove("svploeg@calvin.edu");
            filterList.remove("kde2@calvin.edu");
            filterList.remove("rjb42@calvin.edu");
            filterList.remove("sav36@calvin.edu");
            filterList.remove("thubers@calvin.edu");
            filterList.remove("lopa@calvin.edu");
            /*
            for (int i = 0; i < administrationList.size(); i++) {
                tempConstraint.append(administrationList.get(i));
                tempConstraint.append("%7C");
            }*/
            //.out.print("Constraint:" + tempConstraint);
            //System.out.print("Constraint");
        }
        if (careerCenterChecked) {
            filterList.remove("career@calvin.edu");
            filterList.remove("kdykhouse@calvin.edu");
            filterList.remove("tdj4@calvin.edu");
            filterList.remove("cbt4@calvin.edu");
            filterList.remove("bcok@calvin.edu");
            filterList.remove("lbl3@calvin.edu");
            filterList.remove("mec6@calvin.edu");
            filterList.remove("bspeyers@calvin.edu");
            filterList.remove("bj24@calvin.edu");
            filterList.remove("rwt2@calvin.edu");
            /*
            for (int i = 0; i < careerDevelopmentList.size(); i++) {
                tempConstraint.append(careerDevelopmentList.get(i));
                tempConstraint.append("%7C");
            }*/
        }
        if (campusMinistriesChecked) {
            filterList.remove("campusministries@calvin.edu");
            filterList.remove("stobja@calvin.edu");
            filterList.remove("pastormary@calvin.edu");
            filterList.remove("mwp4@calvin.edu");
            filterList.remove("jr224@calvin.edu");
            filterList.remove("psr2@calvin.edu");
            filterList.remove("jcs33@calvin.edu");
            filterList.remove("rat9@calvin.edu");
        }
        if (danceGuildChecked) {
            filterList.remove("slp33@students.calvin.edu");
        }
        if (humanResourcesChecked) {
            filterList.remove("humanresources@calvin.edu");
            filterList.remove("briton@calvin.edu");
            filterList.remove("mag24@calvin.edu");
            filterList.remove("alg35@calvin.edu");
            filterList.remove("dhonner@calvin.edu");
            filterList.remove("thubers@calvin.edu");
            filterList.remove("emw27@calvin.edu");
            filterList.remove("ajn8@calvin.edu");
        }
        if (bookstoreChecked) {
            filterList.remove("mjg44@calvin.edu");
            filterList.remove("cgl4@calvin.edu");
            filterList.remove("calvin@bkstr.com");
        }
        for (int i = 0; i < filterList.size(); i++) {
            tempConstraint.append(filterList.get(i));
            tempConstraint.append("%7C");
        }
        if (!filterList.isEmpty()) {
            tempConstraint.setLength(tempConstraint.length() - 3);
        }
        //tempConstraint.append("'");
        //System.out.print("\n" + tempConstraint + "\n");
        NewsActivity.constraint.append(tempConstraint);
        Toast confirmation = Toast.makeText(getApplicationContext(), "Filters Applied", Toast.LENGTH_SHORT);
        confirmation.show();
    }
/*
    public void selectItem() {
        NewsActivity.emailList.clear();
        //tempConstraint.append("'");
        boolean administrationChecked = ((CheckBox) findViewById(R.id.administrationCheck)).isChecked();
        boolean careerCenterChecked = ((CheckBox) findViewById(R.id.careerDevelopmentCheck)).isChecked();
        boolean campusMinistriesChecked = ((CheckBox) findViewById(R.id.campusMinistriesCheck)).isChecked();
        boolean danceGuildChecked = ((CheckBox) findViewById(R.id.danceGuildCheck)).isChecked();
        boolean humanResourcesChecked = ((CheckBox) findViewById(R.id.humanResourcesCheck)).isChecked();
        boolean bookstoreChecked = ((CheckBox) findViewById(R.id.bookstoreCheck)).isChecked();
        if (administrationChecked) {
            NewsActivity.emailList.add("president@calvin.edu");
            NewsActivity.emailList.add("brac@calvin.edu");
            NewsActivity.emailList.add("svploeg@calvin.edu");
            NewsActivity.emailList.add("kde2@calvin.edu");
            NewsActivity.emailList.add("rjb42@calvin.edu");
            NewsActivity.emailList.add("sav36@calvin.edu");
            NewsActivity.emailList.add("thubers@calvin.edu");
            NewsActivity.emailList.add("lopa@calvin.edu");
        }
        if (careerCenterChecked) {
            NewsActivity.emailList.add("career@calvin.edu");
            NewsActivity.emailList.add("kdykhous@calvin.edu");
            NewsActivity.emailList.add("tdj4@calvin.edu");
            NewsActivity.emailList.add("cbt4@calvin.edu");
            NewsActivity.emailList.add("bcok@calvin.edu");
            NewsActivity.emailList.add("lbl3@calvin.edu");
            NewsActivity.emailList.add("mec6@calvin.edu");
            NewsActivity.emailList.add("bspeyers@calvin.edu");
            NewsActivity.emailList.add("bj24@calvin.edu");
            NewsActivity.emailList.add("rwt2@calvin.edu");
        }
        if (campusMinistriesChecked) {
            NewsActivity.emailList.add("campusministries@calvin.edu");
            NewsActivity.emailList.add("stobja@calvin.edu");
            NewsActivity.emailList.add("pastormary@calvin.edu");
            NewsActivity.emailList.add("mwp4@calvin.edu");
            NewsActivity.emailList.add("jr224@calvin.edu");
            NewsActivity.emailList.add("psr2@calvin.edu");
            NewsActivity.emailList.add("jcs33@calvin.edu");
            NewsActivity.emailList.add("rat9@calvin.edu");
        }
        if (danceGuildChecked) {
            NewsActivity.emailList.add("slp33@students.calvin.edu");
        }
        if (humanResourcesChecked) {
            NewsActivity.emailList.add("humanresources@calvin.edu");
            NewsActivity.emailList.add("briton@calvin.edu");
            NewsActivity.emailList.add("mag24@calvin.edu");
            NewsActivity.emailList.add("alg35@calvin.edu");
            NewsActivity.emailList.add("dhonner@calvin.edu");
            NewsActivity.emailList.add("thubers@calvin.edu");
            NewsActivity.emailList.add("emw27@calvin.edu");
            NewsActivity.emailList.add("ajn8@calvin.edu");
        }
        if (bookstoreChecked) {
            NewsActivity.emailList.add("mjg44@calvin.edu");
            NewsActivity.emailList.add("cgl4@calvin.edu");
            NewsActivity.emailList.add("calvin@bkstr.com");
        }
    }*/
}
