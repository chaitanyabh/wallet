package com.example.walletmanager;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class Adapter  extends CursorAdapter 
{

	public Adapter(Context context, Cursor c) {
        super(context, c);
    }
	@Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // when the view will be created for first time,
        // we need to tell the adapters, how each item will look
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View retView = inflater.inflate(R.layout.single, parent, false);
 
        return retView;
    }
	@Override
    public void bindView(View view, Context context, Cursor cursor) {
        // here we are setting our data
        // that means, take the data from the cursor and put it in views
 
        TextView tv = (TextView) view.findViewById(R.id.textView2);
        tv.setText(cursor.getString(cursor.getColumnIndex(cursor.getColumnName(1))));

}
	
}


