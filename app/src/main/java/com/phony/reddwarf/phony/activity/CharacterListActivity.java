package com.phony.reddwarf.phony.activity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.phony.reddwarf.phony.R;
import com.phony.reddwarf.phony.adapter.CharacterListAdapter;

/**
 * Created by RedDwarf on 12/3/2015.
 */
public class CharacterListActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_list_activity);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListView list = (ListView) findViewById(R.id.list);
        String[] data = new String[]{"Kitai Moonbeam","Montblanc Arcana","Oiki Lothar","Akasha Arcana","Gunjar Octavian","Persephone Arcana","Asuna Arcana","Lisbeth Arcana","Lyra Arcana","Silica Arcana"};
    list.setAdapter(new CharacterListAdapter(this, data));

    TextView empty = (TextView) findViewById(R.id.empty);
        list.setEmptyView(empty);
    }
}
