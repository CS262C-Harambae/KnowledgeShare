package edu.calvin.harambe.knowledgeshare;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

import java.util.ArrayList;

/**
 * Created by cjn8 on 11/19/2016.
 */

public class CategoriesFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
    private SharedPreferences categories;
    private boolean administration;
    private ArrayList<String> administrationList = new ArrayList<String>();
    private boolean careerDevelopment;
    private ArrayList<String> careerDevelopmentList = new ArrayList<String>();
    private boolean danceGuild;
    private ArrayList<String> danceGuildList;
    private boolean campusMinistries;
    private ArrayList<String> campusMinistriesList;
    private ArrayList<String> reservedList;
    private String tempConstraint = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        this.setConstraint();
        categories = PreferenceManager.getDefaultSharedPreferences(getActivity());
    }

    @Override
    public void onResume() {
        super.onResume();
        administration = categories.getBoolean("administrationPreference", false);
        careerDevelopment = categories.getBoolean("careerDevelopmentPreference", false);
        danceGuild = categories.getBoolean("danceGuildPreference", false);
        campusMinistries = categories.getBoolean("campusMinistriesPreference", false);
        populateLists();
        this.setConstraint();
        categories.registerOnSharedPreferenceChangeListener(this);
    }

    public void setConstraint() {
        tempConstraint = "";
        //NewsActivity.constraint = new StringBuilder();
        //NewsActivity.emailList.clear();
        if (administration) {
            for (int i = 0; i < administrationList.size(); i++) {
                tempConstraint.concat(administrationList.get(i));
                tempConstraint.concat("|");
            }
        }
        if (careerDevelopment) {
            for (int i = 0; i < careerDevelopmentList.size(); i++) {
                tempConstraint.concat(careerDevelopmentList.get(i));
                tempConstraint.concat("|");
            }
        }
        categories.registerOnSharedPreferenceChangeListener(this);

        if (!tempConstraint.isEmpty()) {
            tempConstraint = tempConstraint.substring(0, NewsActivity.constraint.length() - 1);
            String beginning = "'";
            NewsActivity.constraint.append(beginning);
            NewsActivity.constraint.append(tempConstraint);
            NewsActivity.constraint.append(beginning);
            //NewsActivity.constraint = "'" + tempConstraint + "'";
        }
        //NewsActivity.constraint = "'" + tempConstraint + "'";
        System.out.println("Constraint: " + NewsActivity.constraint);

    }

    @Override
    public void onPause() {
        categories.unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences categories, String key) {
        if (key.equals("administrationPreference")) {
            administration = categories.getBoolean(key, true);
        }
        if (key.equals("careerDevelopmentPreference")) {
            administration = categories.getBoolean(key, true);
        }
        if (key.equals("danceGuildPreference")) {
            administration = categories.getBoolean(key, true);
        }
        if (key.equals("administrationPreference")) {
            administration = categories.getBoolean(key, true);
        }
    }
    private void populateLists() {
        administrationList.add("president@calvin.edu");
        administrationList.add("brac@calvin.edu");
        administrationList.add("svploeg@calvin.edu");
        administrationList.add("kde2@calvin.edu");
        administrationList.add("rjb42@calvin.edu");
        administrationList.add("sav36@calvin.edu");
        administrationList.add("thubers@calvin.edu");
        administrationList.add("lopa@calvin.edu");
        careerDevelopmentList.add("career@calvin.edu");
        careerDevelopmentList.add("kdykhous@calvin.edu");
        careerDevelopmentList.add("tdj4@calvin.edu");
        careerDevelopmentList.add("cbt4@calvin.edu");
        careerDevelopmentList.add("bcok@calvin.edu");
        careerDevelopmentList.add("lbl3@calvin.edu");
        careerDevelopmentList.add("mec6@calvin.edu");
        careerDevelopmentList.add("bspeyers@calvin.edu");
        careerDevelopmentList.add("bj24@calvin.edu");
        careerDevelopmentList.add("rwt2@calvin.edu");
    }
}
