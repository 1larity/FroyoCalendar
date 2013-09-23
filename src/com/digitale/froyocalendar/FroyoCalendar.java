package com.digitale.froyocalendar;

import com.digitale.calcontrol.Calcontrol;

import android.os.Bundle;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class FroyoCalendar extends Activity {

	private static final int REQUEST_CODE = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_froyo_calendar);
		Button button  = (Button) findViewById(R.id.button1);
		final Calcontrol calendar = new Calcontrol(getApplication());
		
		
		
		button.setOnClickListener(new OnClickListener() {
			

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.setComponent(new ComponentName("com.digitale.calcontrol","com.digitale.calcontrol.Main"));
				startActivityForResult(intent, REQUEST_CODE);
				String output = calendar.getUserDate() + " button output";
				
			}
		});
			}
	
	@Override 
	public void onActivityResult(int requestCode, int resultCode, Intent data) {     
		 if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
			    if (data.hasExtra("returnDate")) {
			      Toast.makeText(this, "User set: date " + data.getExtras().getString("returnDate"),
			        Toast.LENGTH_SHORT).show();
			    }
		 }else if (resultCode == RESULT_CANCELED && requestCode == REQUEST_CODE)
		 {
			    if (data.hasExtra("returnDate")) {
			      Toast.makeText(this,"User cancelled: date "+ data.getExtras().getString("returnDate"),
			        Toast.LENGTH_SHORT).show();
			    }
		 }
	}
	

}
