package com.example.e_learningdemo;


import java.util.ArrayList;

import android.app.ListActivity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TaskActivity extends ListActivity {
    
	
	private ListView listView;
	private ArrayList<String> programlist;
	public long q;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //overridePendingTransition(R.anim.anim_in,R.anim.anim_out);
                
        
        fillProgramList();
        setUpList();      
    }
	@Override
	public void onBackPressed() {
	    super.onBackPressed();
	   // overridePendingTransition(R.anim.anim_in2, R.anim.anim_out2);
	}
	private void setUpList() {
		
		setListAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_list_item_1, programlist));
		listView = getListView();
		
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
								int position,long id) {
				
				 
			}
		});
	}
	
	
	private void fillProgramList() {
		programlist = new ArrayList<String>();
				programlist.add("Test Scores");
				programlist.add("Tests");

				programlist.add("View Statistics");
				programlist.add("Edit Profile");
				programlist.add("Open Web Application");


			
}}