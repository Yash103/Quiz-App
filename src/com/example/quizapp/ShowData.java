package com.example.quizapp;

import java.util.ArrayList;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ShowData extends ListActivity {

	 
	private ArrayList<String> results = new ArrayList<String>();
	private SQLiteDatabase newdb;
	String eid;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_show__data);
		
		try {
			
				DBHelper db = new DBHelper(this.getApplicationContext());
				newdb = db.getWritableDatabase();
				Cursor c = newdb.rawQuery("select * from QUE", null);
				results.add("NO:	QUESTION:	OPTION1:	OPTION2:	OPTION3:	ANSWER:");
				
				if(c != null)
				{					
					if(c.moveToFirst())
					{						
						do
						{
							  String no = c.getInt(0)+"";
				    		  String que = c.getString(1);
				    		  String a = c.getString(2);
				    		  String b = c.getString(3);
				    		  String d = c.getString(4);
				    		  String ans = c.getString(5);
							results.add(no+" "+que+" "+a+" "+b+" "+d+" "+ans);
							
					}
						while(c.moveToNext());
				}
					
			
		}
	}

		catch(SQLiteException se)
		{
			
			Log.e(getClass().getSimpleName(),"Could not create or open the database");
			
		}
		
		TextView tview= new TextView(this);
		tview.setText("Question Record List");
		getListView().addHeaderView(tview);
		
		
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,results));
		getListView().setTextFilterEnabled(true);
	}
	
}
	
