package com.example.walletmanager;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	private Button income;
	private Button transaction;
	private Button statistics;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		income = (Button) findViewById(R.id.button1);
		transaction = (Button) findViewById(R.id.button2);
		statistics = (Button) findViewById(R.id.button3);
		income.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent intent = new Intent(MainActivity.this, Income.class);
				startActivity(intent);
		

				overridePendingTransition(R.anim.abc_fade_in,
						R.anim.abc_fade_out);
			}
		});
		transaction.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent1 = new Intent(MainActivity.this,
						Transaction.class);
				startActivity(intent1);
				

				overridePendingTransition(R.anim.abc_fade_in,
						R.anim.abc_fade_out);
			}
		});
		statistics.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent2 = new Intent(MainActivity.this, Statistics.class);
				startActivity(intent2);
			

				overridePendingTransition(R.anim.abc_fade_in,
						R.anim.abc_fade_out);
			}
		});
	}

}
