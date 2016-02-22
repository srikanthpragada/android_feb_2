package com.srikanthpragada.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CourseActivity extends AppCompatActivity {
    ListView lvCourses;
    ArrayList<Map<String,String>> courses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        lvCourses = (ListView) findViewById(R.id.lvCourses);

        HashMap<String,String> c1 = new HashMap<>();
        c1.put("name", "Java Core");
        c1.put("fee", "5000");

        courses.add(c1);

        c1 = new HashMap<>();
        c1.put("name","Java Advanced");
        c1.put("fee", "6000");

        courses.add(c1);

        c1 = new HashMap<>();
        c1.put("name","Android Programming");
        c1.put("fee", "5500");

        courses.add(c1);

        SimpleAdapter sa = new SimpleAdapter(this,courses, R.layout.course_layout,
                                             new String[] {"name","fee"},
                                             new int[] { R.id.tvName, R.id.tvFee});
        lvCourses.setAdapter(sa);
    }

    public void calculate(View v) {
         int total = 0;

         for(int i=0; i < lvCourses.getChildCount(); i++) {
             View c = lvCourses.getChildAt(i);
             // check whether checkbox is selected
             CheckBox cb = (CheckBox) c.findViewById(R.id.chkSelected);
             TextView tv = (TextView) c.findViewById(R.id.tvFee);

             if ( cb.isChecked()) {
                 total +=  Integer.parseInt(tv.getText().toString());
             }


        }
        Toast.makeText(this, "Total Fee : " +  String.valueOf(total), Toast.LENGTH_LONG).show();
    }
}

activity_course.xml
-------------------
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="com.srikanthpragada.demo.CourseActivity">

    <ListView
        android:id="@+id/lvCourses"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"></ListView>

    <Button
        android:text="Calculate"
        android:onClick="calculate"
        android:layout_gravity="center"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

</LinearLayout>

course_layout.xml
-----------------
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal" android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView android:id="@+id/tvName"
              android:layout_weight="1"
              android:layout_width="wrap_content"
              android:layout_height="match_parent" />


    <TextView android:id="@+id/tvFee"
        android:layout_width="150dp"
        android:layout_height="match_parent" />

    <CheckBox
        android:id="@+id/chkSelected"
        android:layout_width="wrap_content"
        android:layout_height="match_parent" />

</LinearLayout>
