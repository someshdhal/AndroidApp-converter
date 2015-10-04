package com.example.coverter;

import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi") public class MainActivity extends Activity {
	
	Button calculate,cancel;
	Spinner spinner12;
	EditText field1,field2;
	
	
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        field1=(EditText) findViewById(R.id.field1);
        field2=(EditText) findViewById(R.id.field2);
        calculate=(Button) findViewById(R.id.calculate);
        cancel=(Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				field1.setText("");
				field2.setText("");
				
			}
        	
        });
        
        spinner12=(Spinner) findViewById(R.id.spinner1);
        final String[]mak={"length","temperature","currency"};
        
  
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, mak);
        spinner12.setAdapter(adapter);
        spinner12.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				switch(position){
			
			case 0:
				field1.setText("");
			       field2.setText("");
			      calculatedistance();
			      break;
			      
			case 1:
				field1.setText("");
			       field2.setText("");
			       calculatetemperature();
			       break;
			       
			case 2:
				field1.setText("");
		             field2.setText("");   
		            calculatecurrency();
		            break;
		             	  
			default:
				break;
			
			}
				
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        }
    
    
    
    
    protected void calculatedistance(){
    	field1.setHint(" kilometer");
    	field2.setHint(" meter");
    	
    	calculate.setOnClickListener(new OnClickListener(){

			
			 public void onClick(View arg0) {
				
				if(!(field1.getText().toString().isEmpty())){
					double km=Double.parseDouble(field1.getText().toString());
    				field2.setText(String.valueOf(km*1000));

				}
				else if(!(field2.getText().toString().isEmpty())){
					double mt=Double.parseDouble(field2.getText().toString());
					field1.setText(String.valueOf(mt/1000));

					
				}
				else{
					Toast.makeText(MainActivity.this, "please enter a value in any field", Toast.LENGTH_SHORT).show();
				}
				
				
				
			}
    		
    	});
    	
     }
    
    protected void calculatetemperature(){
    	
    	field1.setHint(" Celsius");
    	field2.setHint(" Farenheit");
    	calculate.setOnClickListener(new OnClickListener(){

		
			 @SuppressLint("NewApi") public void onClick(View v) {
				if(!(field1.getText().toString().isEmpty())){
					double cs=Double.parseDouble(field1.getText().toString());
					field2.setText(String.valueOf(cs*1.8+32));


				}
				else if(!(field2.getText().toString().isEmpty())){
					double fh=Double.parseDouble(field2.getText().toString());
					field1.setText(String.valueOf((fh-32)*5/9));


				}
				else{
					Toast.makeText(MainActivity.this, "please enter a value in any field", Toast.LENGTH_SHORT).show();
				}
				
				
				
			}
    		
    	});
    	
    	
    	
    }
    
    
     public void calculatecurrency(){
    	field1.setHint(" Rupee");
    	field2.setHint(" Dollar");
    	calculate.setOnClickListener(new OnClickListener(){

			 @SuppressLint("NewApi") @Override
			public void onClick(View v) {
				if(!(field1.getText().toString().isEmpty())){
					double rp=Double.parseDouble(field1.getText().toString());
					field2.setText(String.valueOf(rp/66.19));

				}
				else if(!(field2.getText().toString().isEmpty())){
					double dl=Double.parseDouble(field2.getText().toString());
					field1.setText(String.valueOf(dl*66.19));


					
					
					
				}
				else{
					Toast.makeText(MainActivity.this, "please enter a value in any field", Toast.LENGTH_SHORT).show();
				}

				
				
			}
    		
    	});
    }
    
   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
