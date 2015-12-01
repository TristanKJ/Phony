package com.phony.reddwarf.phony;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by RedDwarf on 11/24/2015.
 */
public class NextActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_activity_view);
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
}
