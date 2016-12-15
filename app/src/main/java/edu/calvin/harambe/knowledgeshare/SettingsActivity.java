package edu.calvin.harambe.knowledgeshare;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    public StringBuilder tempConstraint = new StringBuilder();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_settings);
        final SharedPreferences categories = getPreferences(Context.MODE_PRIVATE);
        //final CheckBox administrationCheck = (CheckBox) findViewById(R.id.administrationCheck);
        final CheckBox campusMinistriesCheck = (CheckBox) findViewById(R.id.campusMinistriesCheck);
        final CheckBox careerDevelopmentCheck = (CheckBox) findViewById(R.id.careerDevelopmentCheck);
        final CheckBox danceGuildCheck = (CheckBox) findViewById(R.id.danceGuildCheck);
        //final CheckBox humanResourcesCheck = (CheckBox) findViewById(R.id.humanResourcesCheck);
        final CheckBox bookstoreCheck = (CheckBox) findViewById(R.id.bookstoreCheck);
        final CheckBox financesCheck = (CheckBox) findViewById(R.id.financialCheck);
        final CheckBox healthCheck = (CheckBox) findViewById(R.id.healthCheck);
        final CheckBox msdoisdoCheck = (CheckBox) findViewById(R.id.MSDOCheck);
        final CheckBox serviceLearningCheck = (CheckBox) findViewById(R.id.slCheck);
        final CheckBox audiovisualCheck = (CheckBox) findViewById(R.id.audiovisualCheck);
        final CheckBox studentLifeCheck = (CheckBox) findViewById(R.id.studentLifeCheck);
        final CheckBox acadDeptCheck = (CheckBox) findViewById(R.id.acadDeptCheck);
        final CheckBox miscellaneousCheck = (CheckBox) findViewById(R.id.miscellaneousCheck);
        //selectItem();

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
        bookstoreCheck.setChecked(categories.getBoolean("bookstore", false));
        bookstoreCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = categories.edit();
                editor.putBoolean("bookstore", bookstoreCheck.isChecked());
                editor.commit();
            }
        });
        financesCheck.setChecked(categories.getBoolean("financial", false));
        financesCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = categories.edit();
                editor.putBoolean("financial", financesCheck.isChecked());
                editor.commit();
            }
        });
        healthCheck.setChecked(categories.getBoolean("health", false));
        healthCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = categories.edit();
                editor.putBoolean("health", healthCheck.isChecked());
                editor.commit();
            }
        });
        msdoisdoCheck.setChecked(categories.getBoolean("msdoisdo", false));
        msdoisdoCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = categories.edit();
                editor.putBoolean("msdoisdo", msdoisdoCheck.isChecked());
                editor.commit();
            }
        });
        serviceLearningCheck.setChecked(categories.getBoolean("serviceLearning", false));
        serviceLearningCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = categories.edit();
                editor.putBoolean("serviceLearning", serviceLearningCheck.isChecked());
                editor.commit();
            }
        });
        audiovisualCheck.setChecked(categories.getBoolean("audiovisual", false));
        audiovisualCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = categories.edit();
                editor.putBoolean("audiovisual", audiovisualCheck.isChecked());
                editor.commit();
            }
        });
        studentLifeCheck.setChecked(categories.getBoolean("studentLife", false));
        studentLifeCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = categories.edit();
                editor.putBoolean("studentLife", studentLifeCheck.isChecked());
                editor.commit();
            }
        });
        acadDeptCheck.setChecked(categories.getBoolean("acadDept", false));
        acadDeptCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = categories.edit();
                editor.putBoolean("acadDept", acadDeptCheck.isChecked());
                editor.commit();
            }
        });
        miscellaneousCheck.setChecked(categories.getBoolean("miscellaneous", false));
        miscellaneousCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = categories.edit();
                editor.putBoolean("miscellaneous", miscellaneousCheck.isChecked());
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
        filterList.add("amh72@students.calvin.edu");
        filterList.add("jrk54@students.calvin.edu");
        filterList.add("amh72@students.calvin.edu");
        filterList.add("nieuwr@calvin.edu");
        filterList.add("jp53@students.calvin.edu");
        filterList.add("lrf6@calvin.edu");
        filterList.add("rlg28@students.calvin.edu");
        filterList.add("amp52@students.calvin.edu");
        filterList.add("cwolffis@calvin.edu");
        filterList.add("ree4@students.calvin.edu");
        filterList.add("aclark47@calvin.edu");
        filterList.add("dka2@calvin.edu");
        filterList.add("ree4@students.calvin.edu");
        filterList.add("jp53@students.calvin.edu");
        filterList.add("jhz2@calvin.edu");
        filterList.add("rcrow@calvin.edu");
        filterList.add("sav36@calvin.edu");
        filterList.add("jrw23@calvin.edu");
        filterList.add("amh72@students.calvin.edu");
        filterList.add("hhr2@calvin.edu");
        filterList.add("rdm8@calvin.edu");
        filterList.add("slc@calvin.edu");
        filterList.add("led33@students.calvin.edu");
        filterList.add("ema25@students.calvin.edu");
        filterList.add("coracz@calvin.edu");
        filterList.add("ma24@calvin.edu");
        filterList.add("kow2@calvin.edu");
        filterList.add("jbritton@calvin.edu");
        filterList.add("health@calvin.edu");
        filterList.add("payroll@calvin.edu");
        filterList.add("heerly@calvin.edu");
        filterList.add("peb3@calvin.edu");
        filterList.add("mjg44@calvin.edu");
        filterList.add("cgl4@calvin.edu");
        filterList.add("calvin@bkstr.com");
        filterList.add("humanresources@calvin.edu");
        filterList.add("briton@calvin.edu");
        filterList.add("mag24@calvin.edu");
        filterList.add("alg35@calvin.edu");
        filterList.add("dhonner@calvin.edu");
        filterList.add("thubers@calvin.edu");
        filterList.add("emw27@calvin.edu");
        filterList.add("ajn8@calvin.edu");
        filterList.add("slp33@students.calvin.edu");
        filterList.add("lct6@students.calvin.edu");
        filterList.add("ptw3@students.calvin.edu");
        filterList.add("nws2@students.calvin.edu");
        filterList.add("jrk54@students.calvin.edu");
        filterList.add("tje4@calvin.edu");
        filterList.add("hhr2@calvin.edu");
        filterList.add("campusministries@calvin.edu");
        filterList.add("stobja@calvin.edu");
        filterList.add("pastormary@calvin.edu");
        filterList.add("mwp4@calvin.edu");
        filterList.add("jr224@calvin.edu");
        filterList.add("psr2@calvin.edu");
        filterList.add("jcs33@calvin.edu");
        filterList.add("rat9@calvin.edu");
        filterList.add("kvhulst@calvin.edu");
        filterList.add("cicwdir@calvin.edu");
        filterList.add("cad24@calvin.edu");
        filterList.add("zand@calvin.edu");
        filterList.add("amp52@students.calvin.edu");
        filterList.add("dd35@students.calvin.edu");
        filterList.add("slt8@calvin.edu");
        filterList.add("career@calvin.edu");
        filterList.add("kdykhous@calvin.edu");
        filterList.add("tdj4@calvin.edu");
        filterList.add("cbt4@calvin.edu");
        filterList.add("bcok@calvin.edu");
        filterList.add("lbl3@calvin.edu");
        filterList.add("mec6@calvin.edu");
        filterList.add("bspeyers@calvin.edu");
        filterList.add("bj24@calvin.edu");
        filterList.add("rwt2@calvin.edu");
        filterList.add("careerstudent@calvin.edu");
        filterList.add("johncalvin@calvin.edu");
        filterList.add("brac@calvin.edu");
        filterList.add("svploeg@calvin.edu");
        filterList.add("kde2@calvin.edu");
        filterList.add("rjb42@calvin.edu");
        filterList.add("sav36@calvin.edu");
        filterList.add("thubers@calvin.edu");
        filterList.add("lopa@calvin.edu");
        boolean careerCenterChecked = ((CheckBox) findViewById(R.id.careerDevelopmentCheck)).isChecked();
        boolean campusMinistriesChecked = ((CheckBox) findViewById(R.id.campusMinistriesCheck)).isChecked();
        boolean danceGuildChecked = ((CheckBox) findViewById(R.id.danceGuildCheck)).isChecked();
        boolean bookstoreChecked = ((CheckBox) findViewById(R.id.bookstoreCheck)).isChecked();
        boolean financialChecked = ((CheckBox) findViewById(R.id.financialCheck)).isChecked();
        boolean healthChecked = ((CheckBox) findViewById(R.id.healthCheck)).isChecked();
        boolean MSDOChecked = ((CheckBox) findViewById(R.id.MSDOCheck)).isChecked();
        boolean slChecked = ((CheckBox) findViewById(R.id.slCheck)).isChecked();
        boolean audiovisualChecked = ((CheckBox) findViewById(R.id.audiovisualCheck)).isChecked();
        boolean studentLifeChecked = ((CheckBox) findViewById(R.id.studentLifeCheck)).isChecked();
        boolean acadDeptChecked = ((CheckBox) findViewById(R.id.acadDeptCheck)).isChecked();
        boolean miscellaneousChecked = ((CheckBox) findViewById(R.id.miscellaneousCheck)).isChecked();
        if (careerCenterChecked) {
            filterList.remove("career@calvin.edu");
            filterList.remove("kdykhous@calvin.edu");
            filterList.remove("tdj4@calvin.edu");
            filterList.remove("cbt4@calvin.edu");
            filterList.remove("bcok@calvin.edu");
            filterList.remove("lbl3@calvin.edu");
            filterList.remove("mec6@calvin.edu");
            filterList.remove("bspeyers@calvin.edu");
            filterList.remove("bj24@calvin.edu");
            filterList.remove("rwt2@calvin.edu");
            filterList.remove("careerstudent@calvin.edu");
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
            filterList.remove("kvhulst@calvin.edu");
            filterList.remove("cicwdir@calvin.edu");
            filterList.remove("cad24@calvin.edu");
            filterList.remove("zand@calvin.edu");
            filterList.remove("amp52@students.calvin.edu");
            filterList.remove("dd35@students.calvin.edu");
            filterList.remove("slt8@calvin.edu");
        }
        if (danceGuildChecked) {
            filterList.remove("slp33@students.calvin.edu");
            filterList.remove("lct6@students.calvin.edu");
            filterList.remove("ptw3@students.calvin.edu");
            filterList.remove("nws2@students.calvin.edu");
            filterList.remove("jrk54@students.calvin.edu");
            filterList.remove("tje4@calvin.edu");
            filterList.remove("hhr2@calvin.edu");
        }
        if (bookstoreChecked) {
            filterList.remove("mjg44@calvin.edu");
            filterList.remove("cgl4@calvin.edu");
            filterList.remove("calvin@bkstr.com");
        }

        if (financialChecked) {
            filterList.remove("payroll@calvin.edu");
            filterList.remove("heerly@calvin.edu");
            filterList.remove("peb3@calvin.edu");
        }

        if (healthChecked) {
            filterList.remove("health@calvin.edu");
        }

        if (MSDOChecked) {
            filterList.remove("ma24@calvin.edu");
            filterList.remove("kow2@calvin.edu");
            filterList.remove("jbritton@calvin.edu");
        }

        if (slChecked) {

        }

        if (audiovisualChecked) {

        }

        if (studentLifeChecked) {
            filterList.remove("rcrow@calvin.edu");
            filterList.remove("sav36@calvin.edu");
            filterList.remove("jrw23@calvin.edu");
            filterList.remove("amh72@students.calvin.edu");
            filterList.remove("hhr2@calvin.edu");
            filterList.remove("rdm8@calvin.edu");
            filterList.remove("slc@calvin.edu");
            filterList.remove("led33@students.calvin.edu");
            filterList.remove("ema25@students.calvin.edu");
            filterList.remove("coracz@calvin.edu");

        }

        if (acadDeptChecked) {
            filterList.remove("ree4@students.calvin.edu");
            filterList.remove("aclark47@calvin.edu");
            filterList.remove("dka2@calvin.edu");
            filterList.remove("ree4@students.calvin.edu");
            filterList.remove("jp53@students.calvin.edu");
            filterList.remove("jhz2@calvin.edu");
        }

        if (miscellaneousChecked) {
            filterList.remove("amh72@students.calvin.edu");
            filterList.remove("jrk54@students.calvin.edu");
            filterList.remove("amh72@students.calvin.edu");
            filterList.remove("nieuwr@calvin.edu");
            filterList.remove("jp53@students.calvin.edu");
            filterList.remove("lrf6@calvin.edu");
            filterList.remove("rlg28@students.calvin.edu");
            filterList.remove("amp52@students.calvin.edu");
            filterList.remove("cwolffis@calvin.edu");
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
