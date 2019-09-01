package com.example.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class User_Details extends Activity {

	EditText tv1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user__details);
		
		
		
	}
	


	public void btnClick(View v)
	
		{
				try {
						tv1=(EditText)findViewById(R.id.txt1);
						String txt =tv1.getText().toString();
						Intent intent = new Intent(this,Question.class);
						intent.putExtra("name", txt);
						startActivity(intent);
						
				}
		catch(Exception e)
		{
			
			Toast.makeText(getApplicationContext(), "Error:"+e,Toast.LENGTH_SHORT).show();
		}
		
	
}
	
}
