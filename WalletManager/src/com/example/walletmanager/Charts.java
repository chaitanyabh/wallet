package com.example.walletmanager;



import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Charts extends ActionBarActivity{

	private ImageView image1;
	private ImageView image2;
	private ImageView image3;
	private ImageView image5;
	private ImageView image4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.charts);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		image4 = (ImageView) findViewById(R.id.imageView4);
		image5 = (ImageView) findViewById(R.id.imageView5);
		image4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i5=new Intent(Charts.this,MainActivity.class);
				startActivity(i5);
				finish();

			}
		});
		image5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i6=new Intent(Charts.this,Statistics.class);
				startActivity(i6);
				finish();

			}
		});
	}
	
		
		public void barMethod(View view)
		{
			BarChart b=new BarChart();
			Intent LineIntent=b.getIntent(this);
			startActivity(LineIntent);
		}
		public void pieMethod(View view)
		{
			PieChart b=new PieChart();
			Intent i=b.getIntent(this);
			startActivity(i);
		
		}
		
		
	}

