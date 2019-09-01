package com.example.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import android.widget.TextView;
import android.widget.Toast;

public class Question extends Activity {
	
	TextView tv1,tv2,tv3,tv4,tv5,tv6;
	String no,que,a,b,d,ans,n;
	int qno=1;
	int s=0;
	
	
	
	DBHelper dbhelper ;
	SQLiteDatabase newdb ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
		
		Bundle bundle = getIntent().getExtras();
		String n =bundle.getString("name");
		Toast.makeText(getApplicationContext(),""+n, Toast.LENGTH_SHORT).show();

		
		tv1=(TextView)findViewById(R.id.txtview1);
		tv2=(TextView)findViewById(R.id.txtview2);
		tv3=(TextView)findViewById(R.id.txtview3);
		tv4=(TextView)findViewById(R.id.txtview4);
		
		
		setQuestion();
	}
	
	
	

	public void nextQues()
	{
		Intent intent = new Intent(this,Score.class);
		intent.putExtra("total", s);
		startActivity(intent);
	
	}
	
	
	public void setQuestion()
	{
		try {
			dbhelper = new DBHelper(getApplicationContext());
			newdb =dbhelper.getWritableDatabase();
			Cursor c = newdb.rawQuery("Select *from QUE WHERE NO="+qno+"", null);
		
			if(c!=null)
			{			
				if(c.moveToFirst())
				{
					 do 
		    		  {
			    		   no = c.getInt(0)+"";
			    		   que = c.getString(1);
			    		   a = c.getString(2);
			    		   b = c.getString(3);
			    		   d = c.getString(4);
			    		   ans = c.getString(5);
			    		  
			    		  tv1.setText(que);
			    		  tv2.setText(a);
			    		  tv3.setText(b);
			    		  tv4.setText(d);
			    		}while (c.moveToNext());
				}			
			}		
		}
		catch (SQLiteException se ) 
		  {
			  Log.e(getClass().getSimpleName(), "Could not create or Open the database");
		  } 	  
	}
	
	
	
	public void btnA(View v)
	{
		
		
		
		if(ans.equals(a))
		{
			tv2.setBackgroundColor(Color.GREEN);
			
			s=s+1;
			Toast.makeText(getApplicationContext(),"Right Answer"+s, Toast.LENGTH_SHORT).show();
		
			
		}
		else
		{
			tv2.setBackgroundColor(Color.RED);
			Toast.makeText(getApplicationContext(),"Wrong Answer", Toast.LENGTH_SHORT).show();
		}
		
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
		@Override
		public void run() {
		//Do something after 100ms
			
			tv2.setBackgroundColor(Color.BLUE);
			tv3.setBackgroundColor(Color.BLUE);
			tv4.setBackgroundColor(Color.BLUE);
			qno=qno+1;
			if(qno==4)
			{
				nextQues();
			}
			else
			{
			
			
			setQuestion();
			}
		  }
		}, 2000);
		
	
	}
	
	public void btnB(View v)
	{
		if(ans.equals(b))
		{
			tv3.setBackgroundColor(Color.GREEN);
			s=s+1;
			Toast.makeText(getApplicationContext(),"Right Answer"+s, Toast.LENGTH_SHORT).show();
			
			
		}
		else
		{
			tv3.setBackgroundColor(Color.RED);
			Toast.makeText(getApplicationContext(),"Wrong Answer", Toast.LENGTH_SHORT).show();			
		}
		
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
		@Override
		public void run() {
		//Do something after 100ms
			
			tv2.setBackgroundColor(Color.BLUE);
			tv3.setBackgroundColor(Color.BLUE);
			tv4.setBackgroundColor(Color.BLUE);
			qno=qno+1;
			if(qno==4)
			{
				nextQues();
			}
			else
			{
			
			
			setQuestion();
			}

			
		  }
		}, 2000);
		
		
	}
	
	public void btnC(View v)
	{
		if(ans.equals(d))
		{
			tv4.setBackgroundColor(Color.GREEN);
			s=s+1;
			Toast.makeText(getApplicationContext(),"Right Answer"+s, Toast.LENGTH_SHORT).show();
			
			
			
		}
		else
		{
			tv4.setBackgroundColor(Color.RED);
			Toast.makeText(getApplicationContext(),"Wrong Answer", Toast.LENGTH_SHORT).show();
		}
		
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
		@Override
		public void run() {
		//Do something after 100ms
			
			tv2.setBackgroundColor(Color.BLUE);
			tv3.setBackgroundColor(Color.BLUE);
			tv4.setBackgroundColor(Color.BLUE);
			qno=qno+1;
			if(qno==4)
			{
				nextQues();
			}
			else
			{
			
			
			setQuestion();
			}

			
		  }
		}, 2000);
		
		
	}

}
