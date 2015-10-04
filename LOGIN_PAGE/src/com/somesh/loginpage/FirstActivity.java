package com.somesh.loginpage;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends Activity {
	TextView textview,text1,text2,text3;
	TextView addition,multiplication,substraction;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		textview=(TextView) findViewById(R.id.textView);
		addition=(TextView) findViewById(R.id.addition);
		multiplication= (TextView) findViewById(R.id.multiplication);
		substraction= (TextView) findViewById(R.id.substraction);
		text1=(TextView) findViewById(R.id.textView1);
		text2=(TextView) findViewById(R.id.textView2);
		text3=(TextView) findViewById(R.id.textView3);

		
		
	String s1;
	double d;
	double d1=5;

	Intent intent=getIntent();
	Bundle b1=intent.getExtras();
	 s1=(String) b1.getSerializable("100");
	textview.setText(s1);
	d=(Double) b1.getSerializable("101");
	text1.setText(String.valueOf(d+d1));
	text2.setText(String.valueOf(d*d1));
	text3.setText(String.valueOf(d-d1));
	

}
}