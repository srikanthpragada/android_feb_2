package com.st.first;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {

    EditText editMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        editMessage = (EditText) findViewById(R.id.editMessage);
        Intent intent = getIntent();
        editMessage.setText(intent.getStringExtra("message"));
    }

    public void exitActivity(View v) {
        this.finish();
    }
}

Activity_third.xml
--------------------

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="com.st.first.ThirdActivity">

    <EditText
        android:id="@+id/editMessage"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <Button
        android:text="Exit"
        android:onClick="exitActivity"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
</LinearLayout>


