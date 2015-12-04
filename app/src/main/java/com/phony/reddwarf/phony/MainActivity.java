package com.phony.reddwarf.phony;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by RedDwarf on 11/13/2015.
 */
public class MainActivity extends Activity implements PostExecuteInterface {

    private int clickCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    @Override
    protected void onResume() {
        super.onResume();
        clickCounter = Prefs.getClickCounts(this);
    }

    public void incrementCounter(View view) {
        clickCounter++;
        Prefs.setClickCount(this, clickCounter);
        TextView counterTextview = (TextView)findViewById(R.id.click_counter);
        String valueString = String.format(getResources().getString(R.string.value_string), clickCounter);
        counterTextview.setText(valueString);
    }

    public void launchNextActivity(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void asyncIncrement(View view) {
        AsyncIncrementTask asyncTask = new AsyncIncrementTask(this, false);
        asyncTask.execute();
    }

    @Override
    public void waitComplete() {
        incrementCounter(null);
    }

    @Override
    public void failure(Exception e) {
        showMessage(e.getMessage());
    }

    private void showMessage(String message) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage(message);
        dialog.setPositiveButton(R.string.ok, null);
        dialog.create().show();
    }
}
