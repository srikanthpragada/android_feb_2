package com.st.dialogsdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AlertDialogActivity extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        textView = (TextView) findViewById(R.id.textView);
    }

    public void invoke(View v) {
        showDialog(1);
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        switch (id) {
            case 1:
                return getAlertDialog();
            default:
                return null;
        }
    }

    public Dialog getAlertDialog () {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to quit dialog?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        textView.setText("You selected YES!");
                    }
                });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                textView.setText("You selected NO!");
            }
        });

        builder.setTitle("Confirmation");
        builder.setIcon(R.mipmap.ic_launcher);
        return builder.create();
    }

}

activity_alert_dialog.xml
-----------------------------
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="com.st.first.AlertDialogActivity">

    <Button
        android:text="Invoke Alert"
        android:onClick="invoke"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

</LinearLayout>

