package com.somesh.emergency_contact;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	ListView calllistview;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		calllistview=(ListView) findViewById(R.id.calllistview);
		final String[]call={"POLICE","AMBULANCE","FIRE","ACCIDENT HELPLINE","HELPLINE-1","HELPLINE-2"};
		final Bundle contact=new Bundle();
		contact.putString("POLICE", "100");
		contact.putString("AMBULANCE", "101");
		contact.putString("FIRE", "108");
		contact.putString("ACCIDENT HELPLINE", "4444");
		contact.putString("HELPLINE-1", "9437033057");
		contact.putString("HELPLINE-2", "9686620929");
		
		
	ArrayAdapter<String>adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, call);
	calllistview.setAdapter(adapter);
	calllistview.setOnItemClickListener(new OnItemClickListener(){

		/*Author:Somesh Dhal
		 * (non-Javadoc)
		 * @see android.widget.AdapterView.OnItemClickListener#onItemClick(android.widget.AdapterView, android.view.View, int, long)
		 */
		
		
		
		
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long arg3) {
		makecall(call[position],contact);
			
		}
		
	});
	
		
		
		
	}
	protected void makecall(String c,Bundle contact){
		Intent intent=new Intent(Intent.ACTION_DIAL);
		intent.setData(Uri.parse("tel:"+contact.getString(c)));
		startActivity(intent);
	}

	

}
