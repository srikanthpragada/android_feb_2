package com.st.first;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CourseActivity extends AppCompatActivity {
    Spinner spCourses;
    RadioButton rbMorning, rbEvening;
    CheckBox cbMaterial;
    TextView tvFee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        spCourses  = (Spinner)  findViewById(R.id.spCourses);
        rbMorning  = (RadioButton)  findViewById(R.id.rbMorning);
        rbEvening  = (RadioButton)  findViewById(R.id.rbEvening);
        cbMaterial  = (CheckBox)  findViewById(R.id.cbMaterial);
        tvFee  = (TextView)  findViewById(R.id.tvFee);

        HandleEvents handler =  new HandleEvents();
        rbMorning.setOnCheckedChangeListener(handler);
        rbEvening.setOnCheckedChangeListener(handler);
        cbMaterial.setOnCheckedChangeListener(handler);

        spCourses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                calculateFee();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        calculateFee();
    }

    class HandleEvents implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
              calculateFee();
        }
    }


    public void calculateFee() {

        int fee = 4000;

        switch( spCourses.getSelectedItemPosition() )
        {
            case 1: fee = 5000; break;
            case 2: fee = 4500; break;
        }

        if(rbMorning.isChecked())
             fee -= fee  * 10/100;

        if(cbMaterial.isChecked())
             fee += 500;

        tvFee.setText( String.valueOf(fee));
    }
}


Layout
--------

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="com.st.first.CourseActivity">

    <TextView
        android:text="Select Course"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <Spinner
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/spCourses"
        android:entries="@array/courses"
        android:layout_gravity="center_horizontal" />

    <RadioGroup
        android:gravity="center"
        android:orientation="horizontal"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">

        <RadioButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Morning"
            android:id="@+id/rbMorning" />

        <RadioButton
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:checked="true"
            android:text="Evening"
            android:id="@+id/rbEvening" />
    </RadioGroup>

    <CheckBox
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Course Material"
        android:id="@+id/cbMaterial"
        android:layout_gravity="center_horizontal" />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textAppearance="?android:attr/textAppearanceLarge"
        android:text=""
        android:id="@+id/tvFee"
        android:layout_gravity="center_horizontal" />


</LinearLayout>

