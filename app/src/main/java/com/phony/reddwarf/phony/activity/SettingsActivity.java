package com.phony.reddwarf.phony.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.phony.reddwarf.phony.Prefs;
import com.phony.reddwarf.phony.R;

/**
 * Created by RedDwarf on 11/24/2015.
 */
public class SettingsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity_view);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        updatingUI();
    }

    private void updatingUI() {
        int clickCount = Prefs.getClickCounts(this);
        TextView text = (TextView) findViewById(R.id.click_counter);
        String textString = String.format(getString(R.string.value_string), clickCount);
        text.setText(textString);
    }

    public void resetClickCounter(View view)
    {
        Prefs.setClickCount(this, 0);
        updatingUI();
    }

    public void finishSettingsActivity(View view)
    {
        this.finish();
    }
}
