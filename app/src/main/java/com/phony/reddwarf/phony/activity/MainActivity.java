package com.phony.reddwarf.phony.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.phony.reddwarf.phony.task.AsyncIncrementTask;
import com.phony.reddwarf.phony.PostExecuteInterface;
import com.phony.reddwarf.phony.Prefs;
import com.phony.reddwarf.phony.R;

/**
 * Created by RedDwarf on 11/13/2015.
 */
public class MainActivity extends BaseActivity implements PostExecuteInterface {

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
        Toast toast = Toast.makeText(this, "Incrementing counter in 5 seconds", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void waitComplete() {
        incrementCounter(null);
    }

    @Override
    public void failure(Exception e) {
        showMessage(e.getMessage());
    }

    public void showCharacters(View view) {
        Intent intent = new Intent(this, CharacterListActivity.class);
        startActivity(intent);
    }
}
