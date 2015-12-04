package com.phony.reddwarf.phony.task;

import android.os.AsyncTask;

import com.phony.reddwarf.phony.PostExecuteInterface;

/**
 * Created by RedDwarf on 11/30/2015.
 */
public class AsyncIncrementTask extends AsyncTask<Void, Void, Boolean> {
    private final boolean testing;
    private InterruptedException e;

    private final PostExecuteInterface after;

    public AsyncIncrementTask(PostExecuteInterface after, boolean testing) {
        this.after = after;
        this.testing = testing;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            this.e = e;
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    protected void onPostExecute(Boolean b) {
        if (testing) {
            b = false;
            e = new InterruptedException("Just testing...");
        }
        if (b)
            after.waitComplete();
        else
            after.failure(e);
    }

}
