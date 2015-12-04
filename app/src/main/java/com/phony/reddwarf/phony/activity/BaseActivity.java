package com.phony.reddwarf.phony.activity;

import android.app.Activity;
import android.app.AlertDialog;

import com.phony.reddwarf.phony.R;

/**
 * Created by RedDwarf on 12/3/2015.
 */
public class BaseActivity extends Activity {

    protected void showMessage(String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage(message);
        dialog.setPositiveButton(R.string.ok, null);
        dialog.create().show();
    }
}
