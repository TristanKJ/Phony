package com.phony.reddwarf.phony.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.phony.reddwarf.phony.R;

/**
 * Created by RedDwarf on 12/3/2015.
 */
public class CharacterListAdapter extends BaseAdapter {

    private final String[] data;
    private final LayoutInflater layoutInflator;

    public CharacterListAdapter(Activity activity, String[] data) {
        this.layoutInflator = activity.getLayoutInflater();
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    /**
     * item being worked on, reusible convertView
     * runs once for each position on the list
     */
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflator.inflate(R.layout.character_list_row, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.name);
        name.setText(data[position]);

        return convertView;
    }
}
