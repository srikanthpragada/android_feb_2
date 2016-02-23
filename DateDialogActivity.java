package com.st.dialogsdemo;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class DateDialogActivity extends AppCompatActivity {


    TextView textView;
    int  day =1, month=1, year=2016;
    // EditText editDay,editMonth, editYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_dialog);
        textView = (TextView) findViewById(R.id.textView);
//        editDay = (EditText) findViewById(R.id.editDay);
//        editMonth = (EditText) findViewById(R.id.editMonth);
//        editYear= (EditText) findViewById(R.id.editYear);
    }

    public void invoke(View v) {
        showDialog(1);
    }

    @Override
    protected Dialog onCreateDialog(int id) {

        switch (id) {
            case 1:
                return getDateDialog();
            default:
                return null;
        }
    }

    public Dialog getDateDialog () {

//        year = Integer.parseInt( editYear.getText().toString());
//        month = Integer.parseInt( editMonth.getText().toString());
//        day = Integer.parseInt( editDay.getText().toString());

        Log.d("Dialogs", "In getDateDialog()");
        return 	new DatePickerDialog(this,
                mDateSetListener,
                year,month-1,day
        );
    }


    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {

                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                    DateDialogActivity.this.year = year;
                    month = monthOfYear;
                    day = dayOfMonth;
                    updateDisplay();

                }
            };

    public void updateDisplay() {
        textView.setText( String.format("%d-%d-%d",year,month + 1,day));

//        editDay.setText(String.valueOf(day));
//        editMonth.setText(String.valueOf(month + 1));
//        editYear.setText(String.valueOf(year));
    }
}


activity_date_dilaog.xml
-----------------------
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="com.st.first.DateDialogActivity">

    <Button
        android:text="Invoke Date Dialog"
        android:onClick="invoke"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <TextView
        android:id="@+id/textView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <EditText
        android:id="@+id/editYear"
        android:text="2016"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
    <EditText
        android:id="@+id/editMonth"
        android:text="1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
    <EditText
        android:id="@+id/editDay"
        android:text="1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />


</LinearLayout>

