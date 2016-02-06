package com.st.first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FactorialActivity extends AppCompatActivity {

    EditText editNumber;
    TextView textResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);

        editNumber = (EditText) findViewById( R.id.editNumber);
        textResult = (TextView) findViewById( R.id.textResult);

    }
    // handles click event of Button
    public void factorial(View v) {
        Log.i("First", "You clicked on the button!");

        int num =  Integer.parseInt( editNumber.getText().toString());

        int fact = 1;
        for (int i = 2; i <= num; i ++)
             fact = fact * i;

        textResult.setText( String.valueOf(fact));
    }

    // handles click event of Clear button
    public void clear(View v) {

        textResult.setText("");
        editNumber.setText("");
        editNumber.requestFocus();

    }
}
