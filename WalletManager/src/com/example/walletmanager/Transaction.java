package com.example.walletmanager;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Transaction extends Activity implements OnClickListener,
		OnItemSelectedListener {
	private EditText et1;
	private EditText et2;
	private EditText et3;

	private ImageView image;
	private ImageView image1;
	private ImageView image3;
	private Calendar cal;
	private int day;
	private int month;
	private int year;
	private ImageButton ib;
	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.transaction);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		String[] catagories = { "Food", "Fuel", "Movie", "Rent", "Travel",
				"Gift", "Other" };
		ib = (ImageButton) findViewById(R.id.imageButton1);
		image = (ImageView) findViewById(R.id.imageView1);
		image1 = (ImageView) findViewById(R.id.imageView2);
		image3 = (ImageView) findViewById(R.id.imageView3);
		et1 = (EditText) findViewById(R.id.editText1);
		et2 = (EditText) findViewById(R.id.editText2);
		et3 = (EditText) findViewById(R.id.editText3);
		cal = Calendar.getInstance();
		day = cal.get(Calendar.DAY_OF_MONTH);
		month = cal.get(Calendar.MONTH);
		year = cal.get(Calendar.YEAR);
		final Spinner spinner11 = (Spinner) findViewById(R.id.spinner1);
		spinner11.setOnItemSelectedListener(this);
		ArrayAdapter aa = new ArrayAdapter(this,
				android.R.layout.simple_spinner_item, catagories);
		aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner11.setAdapter(aa);

		final Data dbHelper;
		dbHelper = new Data(Transaction.this);
		dbHelper.open();

		image.setOnClickListener(new OnClickListener() {

			private TextView tv;

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dbHelper.insertDetails1(et1.getText().toString(), spinner11
						.getSelectedItem().toString(),
						et2.getText().toString(), et3.getText().toString());
				Toast.makeText(getApplicationContext(), "saved",
						Toast.LENGTH_SHORT).show();
				Intent i2 = new Intent(Transaction.this, MainActivity.class);
				startActivity(i2);
				finish();

			}

		});

		image1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i3 = new Intent(Transaction.this, MainActivity.class);
				startActivity(i3);
				finish();
				

				overridePendingTransition(R.anim.abc_fade_in,
						R.anim.abc_fade_out);

			}
		});
		image3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String data = dbHelper.getData();
				Message.message(getApplicationContext(), data);

			}
		});

		ib.setOnClickListener(this);

	}

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

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

}
