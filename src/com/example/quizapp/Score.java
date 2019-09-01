package com.example.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Score extends Activity {
	TextView t1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_score);
		
		Bundle bundle = getIntent().getExtras();
		String n =bundle.getString("name");
		
		t1=(TextView)findViewById(R.id.txtview2);
		
		Intent intent = getIntent();
		int score =intent.getIntExtra("total",0);
		String s=score+"";
		t1.setText(s);
		
		Toast.makeText(getApplicationContext(),"Score is:"+n, Toast.LENGTH_SHORT).show();

	}
}
