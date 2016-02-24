package com.st.dialogsdemo;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PreferencesDemoActivity extends Activity {
	 private static final String FILE = "feb2";
	 EditText  editName, editPassword;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_preferencesdemo);
	        editName = (EditText)  this.findViewById(R.id.editName);
	        editPassword = (EditText)  this.findViewById(R.id.editPassword);	        
	    }
	 
	    public void savePrefs(View v) {
	    	
	    	SharedPreferences  prefs = this.getSharedPreferences(FILE, Context.MODE_PRIVATE );  //1
	    	
	    	SharedPreferences.Editor editor = prefs.edit();  //2
	    
	    	editor.putString("uname",  editName.getText().toString());  // 3
	    	editor.putString("password",  editPassword.getText().toString());
	    	editor.commit();  // 4
	    	Toast.makeText(this,"Saved Preferences", Toast.LENGTH_LONG).show();
	    }
			 

	    public void showPrefs(View v) {
	    	SharedPreferences  prefs = this.getSharedPreferences(FILE,Context.MODE_PRIVATE );
	    	String uname = prefs.getString("uname","srikanth");  // key, defaultvalue
	    	String password = prefs.getString("password","");
	    	
	    	Toast.makeText(this,
	    			 String.format("Uname : %s\nPassword : %s", uname,password),
  					 Toast.LENGTH_LONG).show();
	    }
}


activity_preferncesdemo.xml
---------------------------
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical" >

    <TextView
        android:id="@+id/textView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Username :" />

    <EditText
        android:id="@+id/editName"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" >

        <requestFocus />
    </EditText>

    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Password :" />

    <EditText
        android:id="@+id/editPassword"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="textPassword" />
  <Button
        android:id="@+id/button1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="savePrefs"
        android:text="Save Preferences" />
  <Button
        android:id="@+id/button2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:onClick="showPrefs"
        android:text="Show Preferences" />

</LinearLayout>



















