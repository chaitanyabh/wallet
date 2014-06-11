package com.example.walletmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DHelper extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 2;
	private static final String DATABASE_NAME = "Income";
	private static final String TABLE_CREATE = "create table incomevalues(_id integer primary key autoincrement,"
			+ "amount text not null,date text not null,description text not null);";
	private static final String TABLE_CREATE1 = "create table transactionvalues(_id integer primary key autoincrement,"
			+ "amount text not null,catagory text not null,date1 text not null,description1 text not null);";
	public DHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(TABLE_CREATE);
		db.execSQL(TABLE_CREATE1);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CREATE);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CREATE1);

		onCreate(db);
	}

}
