package com.example.quizapp;

import android.content.ContentValues;
import android.content.Context;

import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper
{
	
	 private static final int DATABASE_VERSION = 1;  
	   private static final String DATABASE_NAME = "Quiz";  
	   

	public DBHelper(Context context) {
		
		super(context, DATABASE_NAME,null , DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		 String Question = "CREATE TABLE QUE(NO INTEGER PRIMARY KEY,QUESTION TEXT,OPTION1 TEXT,OPTION2 TEXT,OPTION3 TEXT,ANSWER TEXT)";  
	     db.execSQL(Question);  
	     
	    
	     
		
	}
	
	void addQUE(int no,String question, String opt1, String opt2, String opt3, String ans)
	{
		SQLiteDatabase db =this.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put("NO",no);
		values.put("QUESTION",question);
		values.put("OPTION1",opt1);
		values.put("OPTION2",opt2);
		values.put("OPTION3",opt3);
		values.put("ANSWER",ans);
		
		db.insert("QUE", null, values);
		db.close();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}


}

