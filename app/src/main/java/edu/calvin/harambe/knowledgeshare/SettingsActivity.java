package edu.calvin.harambe.knowledgeshare;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.ArrayList;

/**
 * Created by cjn8 on 11/19/2016.
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
        selectItem();
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


    public void selectItem(View view) {
        //NewsActivity.emailList.clear();
        tempConstraint = new StringBuilder();
        tempConstraint.delete(0, tempConstraint.length());
        NewsActivity.constraint = new StringBuilder();
        NewsActivity.constraint.delete(0, NewsActivity.constraint.length());
        //tempConstraint.append("'");
        System.out.print("Constraint check 1: " + tempConstraint + "\n");
        boolean administrationChecked = ((CheckBox) findViewById(R.id.administrationCheck)).isChecked();
        boolean careerCenterChecked = ((CheckBox) findViewById(R.id.careerDevelopmentCheck)).isChecked();
        boolean campusMinistriesChecked = ((CheckBox) findViewById(R.id.campusMinistriesCheck)).isChecked();
        boolean danceGuildChecked = ((CheckBox) findViewById(R.id.danceGuildCheck)).isChecked();
        boolean humanResourcesChecked = ((CheckBox) findViewById(R.id.humanResourcesCheck)).isChecked();
        boolean bookstoreChecked = ((CheckBox) findViewById(R.id.bookstoreCheck)).isChecked();
        if (administrationChecked) {
            System.out.print("YES");
            administrationList.add("johncalvin@calvin.edu");
            administrationList.add("brac@calvin.edu");
            administrationList.add("svploeg@calvin.edu");
            administrationList.add("kde2@calvin.edu");
            administrationList.add("rjb42@calvin.edu");
            administrationList.add("sav36@calvin.edu");
            administrationList.add("thubers@calvin.edu");
            administrationList.add("lopa@calvin.edu");
            for (int i = 0; i < administrationList.size(); i++) {
                tempConstraint.append(administrationList.get(i));
                tempConstraint.append("%7C");
            }
            //.out.print("Constraint:" + tempConstraint);
            //System.out.print("Constraint");
        }
        if (careerCenterChecked) {
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
            for (int i = 0; i < careerDevelopmentList.size(); i++) {
                tempConstraint.append(careerDevelopmentList.get(i));
                tempConstraint.append("%7C");
            }
        }
        if (!campusMinistriesChecked) {
            NewsActivity.emailList.add("campusministries@calvin.edu");
            NewsActivity.emailList.add("stobja@calvin.edu");
            NewsActivity.emailList.add("pastormary@calvin.edu");
            NewsActivity.emailList.add("mwp4@calvin.edu");
            NewsActivity.emailList.add("jr224@calvin.edu");
            NewsActivity.emailList.add("psr2@calvin.edu");
            NewsActivity.emailList.add("jcs33@calvin.edu");
            NewsActivity.emailList.add("rat9@calvin.edu");
        }
        if (!danceGuildChecked) {
            NewsActivity.emailList.add("slp33@students.calvin.edu");
        }
        if (!humanResourcesChecked) {
            NewsActivity.emailList.add("humanresources@calvin.edu");
            NewsActivity.emailList.add("briton@calvin.edu");
            NewsActivity.emailList.add("mag24@calvin.edu");
            NewsActivity.emailList.add("alg35@calvin.edu");
            NewsActivity.emailList.add("dhonner@calvin.edu");
            NewsActivity.emailList.add("thubers@calvin.edu");
            NewsActivity.emailList.add("emw27@calvin.edu");
            NewsActivity.emailList.add("ajn8@calvin.edu");
        }
        if (!bookstoreChecked) {
            NewsActivity.emailList.add("mjg44@calvin.edu");
            NewsActivity.emailList.add("cgl4@calvin.edu");
            NewsActivity.emailList.add("calvin@bkstr.com");
        }
        tempConstraint.setLength(tempConstraint.length() - 3);
        //tempConstraint.append("'");
        //System.out.print("\n" + tempConstraint + "\n");
        NewsActivity.constraint.append(tempConstraint);
    }

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
    }
}
