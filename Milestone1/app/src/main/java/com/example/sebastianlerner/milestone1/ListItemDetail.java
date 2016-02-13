package com.example.sebastianlerner.milestone1;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.Adapter;


/**
 * Created by sebastianlerner on 2/13/16.
 */
public class ListItemDetail extends Activity  {
    public int pos;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listitem);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        // Here we turn your string.xml in an array
        String[] myKeys = getResources().getStringArray(R.array.sections);

        TextView myTextView = (TextView) findViewById(R.id.textView);
        myTextView.setText(myKeys[position]);
        pos = position;


    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked

           ListView lvItems = (ListView) findViewById(R.id.listView1);
           lvItems.setItemChecked(pos, checked);
        //need to change lvItems, update it's

        Log.i("HelloListView", "Has been checked/unchecked");

    }

}