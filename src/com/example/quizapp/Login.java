package com.example.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

	EditText tv1,tv2;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
	}
	public void btnClick(View v)
		
		{
				try {
						tv1=(EditText)findViewById(R.id.txt1);
						tv2=(EditText)findViewById(R.id.txt2);
						
						String txt =tv1.getText().toString();
						String txxt =tv2.getText().toString();
						String a  = "yash";
						if(txt.equals(a))
						{
							Intent intent = new Intent(this,InsertQue.class);
							startActivity(intent);
							
						}
						else {
							Intent intent = new Intent(this,User_Details.class);
							startActivity(intent);
							
						}
						
				}
		catch(Exception e)
		{
			
			Toast.makeText(getApplicationContext(), "Error:"+e,Toast.LENGTH_SHORT).show();
		}
		
	
}
		
	}


	