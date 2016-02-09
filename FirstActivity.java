package com.st.first;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FirstActivity extends Activity {

    private EditText editMessage;
    private static final  int FOURTH = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        editMessage = (EditText) findViewById(R.id.editMessage);
    }

    public void callSecond(View v) {

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }

    public void callThird(View v) {
        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra("message", editMessage.getText().toString());
        startActivity(intent);
    }

    public void callFourth(View v) {
        Intent intent = new Intent(this, FourthActivity.class);
        this.startActivityForResult( intent,FOURTH);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ( requestCode ==  FOURTH)  // result is coming from FourthActivity
        {
            if (resultCode == Activity.RESULT_OK)
                 editMessage.setText(data.getStringExtra("message"));
            else
                editMessage.setText("Srikanth Technologies");
        }
    }
}


activity_first.xml
------------------

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="com.st.first.FirstActivity">

    <EditText
        android:id="@+id/editMessage"
        android:hint="Message"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <Button
        android:text="Second Acitivity"
        android:onClick="callSecond"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <Button
        android:text="Third Acitivity"
        android:onClick="callThird"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <Button
        android:text="Fourth Acitivity"
        android:onClick="callFourth"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

</LinearLayout>



