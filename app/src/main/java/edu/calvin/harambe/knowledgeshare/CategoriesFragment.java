package edu.calvin.harambe.knowledgeshare;

/**
 * Categories Fragment (CategoriesFragment.java)
 * This fragments provides the filtering capability
 * based on categories
 *
 * @version: 1.0 (Fall, 2016)
 */

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

import java.util.ArrayList;

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        categories = PreferenceManager.getDefaultSharedPreferences(getActivity());
    }

    @Override
    public void onResume() {
        super.onResume();
        administration = categories.getBoolean("administrationPreference", false);
        careerDevelopment = categories.getBoolean("careerDevelopmentPreference", false);
        danceGuild = categories.getBoolean("danceGuildPreference", false);
        campusMinistries = categories.getBoolean("campusMinistriesPreference", false);
        //populateLists();
        this.setConstraint();
        categories.registerOnSharedPreferenceChangeListener(this);
    }

    public void setConstraint() {

        NewsActivity.emailList.clear();
        if (administration) {
            NewsActivity.emailList.add("president@calvin.edu");
            NewsActivity.emailList.add("provost@calvin.edu");
            NewsActivity.emailList.add("payroll@calvin.edu");
        }
        if (careerDevelopment) {
            NewsActivity.emailList.add("career@calvin.edu");
            NewsActivity.emailList.add("kdykhouse@calvin.edu");
        }
        categories.registerOnSharedPreferenceChangeListener(this);
        /*
        if (NewsActivity.constraint != "") {
            NewsActivity.constraint = NewsActivity.constraint.substring(0, NewsActivity.constraint.length() - 1);
        }
        NewsActivity.constraint = "http://153.106.116.73:8089/monopoly/player/'" + NewsActivity.constraint + "'";
        System.out.println(NewsActivity.constraint);
        */
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
        administrationList.add("provost@calvin.edu");
        administrationList.add("payroll@calvin.edu");
        careerDevelopmentList.add("career@calvin.edu");
    }
}
