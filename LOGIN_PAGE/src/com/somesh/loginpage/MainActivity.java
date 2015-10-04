 package com.somesh.loginpage;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText name,number;
	Button login,clear;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		name=(EditText) findViewById(R.id.name);
		number=(EditText) findViewById(R.id.number);
		login=(Button) findViewById(R.id.login);
		clear=(Button) findViewById(R.id.clear);
		clear.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				name.setText("");
				number.setText("");
				
			}
			
		});
		
		login.setOnClickListener(new OnClickListener(){
			String s;
			double d;

			@TargetApi(Build.VERSION_CODES.GINGERBREAD)
			@Override
			public void onClick(View arg0) {
				if( name.getText().toString().length() !=0){
					s="welcome"+" "+name.getText().toString();
				}
				else{
					s="welcome"+" "+"user";
				}
				
				if(!(number.getText().toString().isEmpty())){
					d=Double.parseDouble(number.getText().toString());
				}
				else{
					Toast.makeText(MainActivity.this, "please enter a number", Toast.LENGTH_SHORT);
				}
				
				
				Intent intent=new Intent(MainActivity.this, FirstActivity.class);
				intent.putExtra("100", s);
				intent.putExtra("101", d);
				startActivity(intent);
				
			}
			
		});
		
		
	}

	

}
