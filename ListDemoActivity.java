package com.st.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListDemoActivity extends AppCompatActivity {

    String [] months = new String[] { "Jan","Feb","Mar","Apr"};
    ArrayList<Map<String,String>>  contacts = new ArrayList<>();

    Spinner spMonths;
    ListView lvContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_demo);

        spMonths = (Spinner) findViewById(R.id.spMonths);
        lvContacts = (ListView) findViewById(R.id.lvContacts);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice, months);

        spMonths.setAdapter(adapter);

        // populate contacts

        HashMap<String,String> contact = new HashMap<>();
        contact.put("name","Larry Ellison");
        contact.put("mobile", "3939393939");
        contacts.add(contact);

        contact = new HashMap<>();
        contact.put("name","Sergy Brin");
        contact.put("mobile", "939393939");
        contacts.add(contact);

        SimpleAdapter contactsAdapter = new SimpleAdapter(this,
                 contacts,   // list
                 R.layout.contact,  // layout for each contact
                 new String[] { "name","mobile"},  // keys that are to be bound to views
                 new int[] { R.id.tvName, R.id.tvMobile}  // views in layout
        );


        lvContacts.setAdapter(contactsAdapter);
        lvContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map contact = contacts.get(position);
                Toast.makeText( ListDemoActivity.this,
                         "Mobile Number : " + contact.get("mobile"),
                         Toast.LENGTH_SHORT).show();

            }
        });


    }


}


Layout of Activity
---------------------

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="com.st.first.ListDemoActivity">

    <Spinner
        android:id="@+id/spMonths"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"></Spinner>

    <ListView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/lvContacts"
        android:layout_weight="1" />

</LinearLayout>


Layout for Contact
-------------------

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <TextView
        android:layout_width="wrap_content"
        android:layout_weight="1"
        android:layout_height="match_parent"
        android:textAppearance="?android:attr/textAppearanceLarge"
        android:id="@+id/tvName"
        android:layout_gravity="center_horizontal" />

    <TextView
        android:layout_width="120dp"
        android:layout_height="match_parent"
        android:textAppearance="?android:attr/textAppearanceMedium"
        android:id="@+id/tvMobile"
        android:gravity="right" />
</LinearLayout>


