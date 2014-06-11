package com.example.walletmanager;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Income extends Activity implements OnClickListener {

	private EditText et1;
	private EditText et2;
	private EditText et3;
	private ImageView image;
	private ImageView image1;
	private ImageView image2;
	private Calendar cal;
	private int day;
	private int month;
	private int year;
	private ImageButton ib;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.income);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		ib = (ImageButton) findViewById(R.id.imageButton1);
		et1 = (EditText) findViewById(R.id.editText1);
		et2 = (EditText) findViewById(R.id.editText2);
		et3 = (EditText) findViewById(R.id.editText3);
		cal = Calendar.getInstance();
		day = cal.get(Calendar.DAY_OF_MONTH);
		month = cal.get(Calendar.MONTH);
		year = cal.get(Calendar.YEAR);
		image = (ImageView) findViewById(R.id.imageView1);
		image1 = (ImageView) findViewById(R.id.imageView3);
		image2 = (ImageView) findViewById(R.id.imageView2);

		final Data dbHelper;
		dbHelper = new Data(Income.this);
		dbHelper.open();
		image.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				dbHelper.insertDetails(et1.getText().toString(), et2.getText()
						.toString(), et3.getText().toString());
				Toast.makeText(getApplicationContext(), "saved",
						Toast.LENGTH_LONG).show();
				Intent i1 = new Intent(Income.this, MainActivity.class);
				startActivity(i1);
				finish();
			}
		});
		image1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent i2 = new Intent(Income.this, Transaction.class);
				startActivity(i2);
				overridePendingTransition(R.anim.abc_fade_in,R.anim.abc_fade_out);

			}
		});
		image2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent i3 = new Intent(Income.this, MainActivity.class);
				startActivity(i3);
				finish();
				overridePendingTransition(R.anim.abc_fade_in,R.anim.abc_fade_out);

			}
		});

		ib.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		showDialog(0);

	}

	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id) {
		return new DatePickerDialog(this, datePickerListener, year, month, day);
	}

	private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(DatePicker view, int selectedYear,
				int selectedMonth, int selectedDay) {
			et2.setText(selectedDay + " / " + (selectedMonth + 1) + " / "
					+ selectedYear);
		}
	};

}
