package com.example.walletmanager;

import java.util.ArrayList;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Statistics extends ActionBarActivity {

	private Button b4;
	private Button b3;
	private Button b2;
	private Button b1;
	private Button b6;
	private ImageView image;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.statistics);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		b4 = (Button) findViewById(R.id.button4);
		b4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent i = new Intent(Statistics.this, Charts.class);
				startActivity(i);

				overridePendingTransition(R.anim.abc_fade_in,
						R.anim.abc_fade_out);

			}
		});

		image = (ImageView) findViewById(R.id.imageView1);
		image.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i4 = new Intent(Statistics.this, MainActivity.class);
				startActivity(i4);

				overridePendingTransition(R.anim.abc_fade_in,
						R.anim.abc_fade_out);

			}
		});

	}

	public void viewData(View v) {

		// creating new intent using ViewActivity Class and start activity to
		// show table data

		Intent i = new Intent(this, ViewActivity.class);
		startActivity(i);

		overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);

	}

	public void dateClcik(View v) {

		// creating new intent using ViewActivity Class and start activity to
		// show table data

		Intent i = new Intent(this, ViewActivity1.class);
		startActivity(i);

		overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);

	}

	public void incomeClick(View v) {

		// creating new intent using ViewActivity Class and start activity to
		// show table data

		Intent i = new Intent(this, ViewActivity2.class);
		startActivity(i);

		overridePendingTransition(R.anim.abc_fade_in, R.anim.abc_fade_out);

	}

}
