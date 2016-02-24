package com.st.dialogsdemo;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class HorizontalProgressDialogActivity extends AppCompatActivity {

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_dialog);

    }

    public void invoke(View v) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMessage("Downloading please wait...");
        progressDialog.setMax(10);
        progressDialog.setCancelable(true);
        progressDialog.setOnCancelListener( new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                Toast.makeText(getApplicationContext(), "You cancelled dialog", Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });
        ProgressThread thread = new ProgressThread();
        thread.start();
        progressDialog.show();
    }

    class ProgressThread extends Thread {
        int count=0;
        public void run() {
            while ( count <= 10) {
                try {
                    Thread.sleep(1000);
                    count ++;
                    progressDialog.setProgress(count);
                }
                catch (Exception e) {
                    return;
                }
            } // while
            progressDialog.dismiss();
        } // end of run
    }

}
