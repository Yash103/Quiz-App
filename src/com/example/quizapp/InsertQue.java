package com.example.quizapp;





import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertQue extends Activity {
	

	EditText no,que,op1,op2,op3,ans;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insert_que);
		
		no =(EditText)findViewById(R.id.txt1);
		que =(EditText)findViewById(R.id.txt2);
		op1 =(EditText)findViewById(R.id.txt3);
		op2 =(EditText)findViewById(R.id.txt4);
		op3 =(EditText)findViewById(R.id.txt5);
		ans =(EditText)findViewById(R.id.txt6);
	
	
	}
	
	public void addQue(View v)
	{
		try {
			Integer t1=Integer.parseInt(no.getText().toString());
			String t2=que.getText().toString();
			String t3=op1.getText().toString();
			String t4=op2.getText().toString();
			String t5=op3.getText().toString();
			String t6=ans.getText().toString();
			
			DBHelper dbhelper = new DBHelper(this);
			dbhelper.addQUE(t1, t2, t3, t4, t5, t6);
			dbhelper.close();
	
			Toast.makeText(getApplicationContext(), "RecordInsert ",Toast.LENGTH_LONG).show();
			Intent intent = new Intent(this,Question.class);
			startActivity(intent);
			finish();
		
		}
		catch(Exception e)
		{
			Toast.makeText(getApplicationContext(), "Error :"+e,Toast.LENGTH_LONG).show();
			
		}
	}
	
	public void showData(View v)	
	{
		Intent intent = new Intent(this,ShowData.class);
		startActivity(intent);
		
	}

	
	}

