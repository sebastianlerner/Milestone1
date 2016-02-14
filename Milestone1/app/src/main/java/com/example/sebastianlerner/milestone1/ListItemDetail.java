package com.example.sebastianlerner.milestone1;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.util.SparseBooleanArray;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.view.View;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.Adapter;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by sebastianlerner on 2/13/16.
 */
public class ListItemDetail extends Activity  {
    public int pos;
    public boolean checked;
    private ArrayList<String> items = new ArrayList<>(Arrays.asList("Streak the lawn", "Eat a gus burger", "Eat at all 3 dining halls", "IM sport", "Quarry", "Carter Mountain", "High-five Dean Groves", "Steam tunnels", "Survivor hour @ Bilt", "Paint Beta Bridge", "All-nighter in Clem", "Sunday funday", "Foxfield"));

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listitem);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);
        checked = intent.getBooleanExtra("checked", false);

        // Here we turn your string.xml in an array
        String[] myKeys = getResources().getStringArray(R.array.sections);

        TextView myTextView = (TextView) findViewById(R.id.textView);
        ListView lvItems = (ListView) findViewById(R.id.listView1);

        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_checked, items);
        lvItems.setAdapter(itemsAdapter);

        lvItems.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        myTextView.setText(myKeys[position]);


        CheckBox cb1 = (CheckBox)findViewById(R.id.btnAddItem);
        cb1.setChecked(checked);
        pos = position;


    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean check = ((CheckBox) view).isChecked();
        checked = check;

        // Check which checkbox was clicked

        ListView lvItems = (ListView) findViewById(R.id.listView1);

        Log.i("InListItemDetail", "pos: " + pos);
        Log.i("InListItemDetail", "checked: " + checked);

        SparseBooleanArray sparseBooleanArray = lvItems.getCheckedItemPositions();
        String[] myKeys = getResources().getStringArray(R.array.sections);




        Log.i("HelloListView", "Has been checked/unchecked");

    }

    public void onBackPressed() {
        Intent intentMessage=new Intent();


        // put the message to return as result in Intent
        intentMessage.putExtra("checked",checked);
        intentMessage.putExtra("position", pos);
        Log.i("Back", "Back pressed and sending: " + checked);

        // Set The Result in Intent
        setResult(2,intentMessage);
        // finish The activity
        finish();

    }



}