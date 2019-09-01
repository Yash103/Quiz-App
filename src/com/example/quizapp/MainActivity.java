package com.example.quizapp;




import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;



public class MainActivity extends Activity {

	Handler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	


	handler=new Handler();
	handler.postDelayed(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			Intent intent = new Intent(MainActivity.this,Login.class);
			startActivity(intent);
			finish();
			
			
		}
	},3000);
	
}
	
	
}
