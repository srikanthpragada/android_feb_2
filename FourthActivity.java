package com.st.first;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FourthActivity extends AppCompatActivity {

    EditText editMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        editMessage = (EditText)  findViewById( R.id.editMessage);
    }

    public void exitActivity(View v) {
        Intent intent = getIntent();
        String  msg =  editMessage.getText().toString();
        if ( msg.length() != 0) {
            intent.putExtra("message",msg );
            this.setResult(Activity.RESULT_OK, intent);
        }
        else
            this.setResult(Activity.RESULT_CANCELED);

        this.finish();
    }
}


activity_fourth.xml
------------------
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="com.st.first.FourthActivity">

    <EditText
        android:id="@+id/editMessage"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <Button
        android:text = "Exit"
        android:onClick="exitActivity"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

</LinearLayout>
