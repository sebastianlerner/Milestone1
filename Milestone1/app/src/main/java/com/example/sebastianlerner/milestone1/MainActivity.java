package com.example.sebastianlerner.milestone1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import android.util.Log;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.content.Intent;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListAdapter;



public class MainActivity extends AppCompatActivity implements OnItemLongClickListener {
    //String[] mobileArray = {"Streak the lawn","Eat a gus burger","Eat at all 3 dining halls","Kiss a first year","Quarry","Carter Mountain","High-five Dean Groves","Steam tunnels"};
    private ArrayList<String> items = new ArrayList<>(Arrays.asList("Streak the lawn","Eat a gus burger","Eat at all 3 dining halls","IM sport","Quarry","Carter Mountain","High-five Dean Groves","Steam tunnels", "Survivor hour @ Bilt", "Paint Beta Bridge", "All-nighter in Clem", "Sunday funday", "Foxfield"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

       // FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
       // fab.setOnClickListener(new View.OnClickListener() {
         //   @Override
          //  public void onClick(View view) {
            //    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
              //          .setAction("Action", null).show();
           // }
        //});
        setContentView(R.layout.activity_main);

        ListView lvItems = (ListView) findViewById(R.id.listView1);
      //  ListView listview = (ListView) findViewById(R.id.listview1);
        lvItems.setOnItemLongClickListener(this);
       // items = new ArrayList<String>();
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_checked, items);
        lvItems.setAdapter(itemsAdapter);

        lvItems.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        Log.i("MyActivity", "hello");
        //items.add("First Item");
        //items.add("Second Item");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onItemLongClick(AdapterView<?> l, View v, int position, long id) {
        Log.i("HelloListView", "You clicked Item: " + id + " at position:" + position);
        ListView lvItems = (ListView) findViewById(R.id.listView1);

        SparseBooleanArray sparseBooleanArray = lvItems.getCheckedItemPositions();
        if(sparseBooleanArray.get(position) == true)
        {
            Log.i("HelloListView", "This has been checked");

        }
        else
        {
            Log.i("HelloListView", "This is not checked");
        }

        // Then you start a new Activity via Intent
        Intent intent = new Intent();
        intent.setClass(this, ListItemDetail.class);
        intent.putExtra("position", position);
        intent.putExtra("checked", sparseBooleanArray.get(position));
        // Or / And
        intent.putExtra("id", id);
        startActivityForResult(intent, 2);
        return true;
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);


        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2)
        {
            // fetch the message String
            boolean checked = data.getBooleanExtra("checked", false);
            int pos = data.getIntExtra("position", 0);
            Log.i("IntentTest", "Intent test: " + checked);
            ListView lvItems = (ListView) findViewById(R.id.listView1);
            lvItems.setItemChecked(pos, checked);

            // Set the message string in textView
            //textViewMessage.setText(message);

        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void testClick(View view)
    {




        Toast.makeText(this, "Test git",
                Toast.LENGTH_LONG).show();
    }
    @Override
    public void onResume()
    {



        ListView lvItems = (ListView) findViewById(R.id.listView1);

        SparseBooleanArray sparseBooleanArray = lvItems.getCheckedItemPositions();
        String[] myKeys = getResources().getStringArray(R.array.sections);

        int trues = 0;
        for(int k = 0; k < sparseBooleanArray.size(); k++)
        {

        Log.i("Test", myKeys[k] + ": " + sparseBooleanArray.valueAt(k));
            Log.i("Test2", sparseBooleanArray.size() + "");
        }

        Log.i("Test3", "test");


        super.onResume();
    }


}
