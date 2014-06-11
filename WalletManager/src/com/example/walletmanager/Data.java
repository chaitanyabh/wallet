package com.example.walletmanager;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Data {

	public static final String KEY_ROWID = "_id";
	public static final String KEY_AMOUNT = "amount";
	public static final String KEY_DATE = "date";
	public static final String KEY_DESCRIPTION = "description";
	private static final String DATABASE_TABLE = "incomevalues";
	public static final String KEY_AMOUNT1 = "amount";
	public static final String KEY_CATAGORY = "catagory";
	public static final String KEY_DATE1 = "date1";
	public static final String KEY_DESCRIPTION1 = "description1";
	private static final String DATABASE_TABLE1 = "transactionvalues";
	private Context context;
	private SQLiteDatabase db;
	private DHelper dbHelper;

	public Data(Context context) {
		this.context = context;
	}

	public Data open() throws SQLException {
		dbHelper = new DHelper(context);
		db = dbHelper.getWritableDatabase();
		return this;
	}

	public long insertDetails(String amount, String date, String description) {
		ContentValues values = new ContentValues();
		values.put(KEY_AMOUNT, amount);
		values.put(KEY_DATE, date);
		values.put(KEY_DESCRIPTION, description);
		return db.insert(DATABASE_TABLE, null, values);

	}

	public String getData() {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		String[] columns = { KEY_ROWID, KEY_AMOUNT1, KEY_CATAGORY, KEY_DATE1 };
		Cursor cursor = db.query(DATABASE_TABLE1, columns, null, null, null,
				null, null);
		StringBuffer buffer = new StringBuffer();
		while (cursor.moveToNext()) {

			int _id = cursor.getInt(0);
			String amount = cursor.getString(1);
			String catagory = cursor.getString(2);
			String date1 = cursor.getString(3);

			buffer.append(_id + " " + amount + " " + catagory + " " + date1
					+ " ");
		}
		return buffer.toString();
	}

	public ArrayList<String[]> gettranDetails() {

		ArrayList<String[]> arrayholder = new ArrayList<String[]>();

		SQLiteDatabase db = dbHelper.getWritableDatabase();
		String[] columns = { KEY_ROWID, KEY_AMOUNT1, KEY_CATAGORY, KEY_DATE1 };
		Cursor cursor = db.query(DATABASE_TABLE1, columns, null, null, null,
				null, null);

		while (cursor.moveToNext()) {

			String[] array = new String[2];
			array[0] = cursor.getString(1);
			array[1] = cursor.getString(2);

			arrayholder.add(array);
		}

		return arrayholder;
	}

	public int gettotalfrmCategory(String category) 
	{
		Log.d("check", "aaaaawww1");

		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Log.d("check", "aaaaawww2");
		String[] columns = { KEY_ROWID, KEY_AMOUNT1, KEY_CATAGORY, KEY_DATE1 };
		Cursor cursor = db.query(DATABASE_TABLE1, columns, KEY_CATAGORY + "=?",
				new String[] { category }, null, null, null);

		Log.d("check", "aaaaawww");
		int total = 0;
		while (cursor.moveToNext()) {

			total += Integer.parseInt(cursor.getString(1));

		}

		return total;
	}

	public long insertDetails1(String amount, String catagory, String date1,
			String description1) {
		ContentValues values = new ContentValues();
		values.put(KEY_AMOUNT1, amount);
		values.put(KEY_CATAGORY, catagory);
		values.put(KEY_DATE1, date1);
		values.put(KEY_DESCRIPTION1, description1);
		return db.insert(DATABASE_TABLE1, null, values);

	}

	public void close() {
		dbHelper.close();
	}

}
