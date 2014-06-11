package com.example.walletmanager;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ViewActivity2 extends Activity{

	SQLiteDatabase db = null;
    String TableName = "incomevalues";
    String Data = "";
	RelativeLayout rel;
 
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        rel = (RelativeLayout)findViewById(R.id.lay);
         
        try {
 
            db = this.openOrCreateDatabase("Income", MODE_PRIVATE, null);
             
            //getting the cursor object 
             
            Cursor c = db.rawQuery("SELECT * FROM " + TableName, null);
 
            int Column1 = c.getColumnIndex("amount");
            int Column2 = c.getColumnIndex("date");

            
          

 
            c.moveToFirst();
             
            if (c != null) {
 
                do {
                    int amount = c.getInt(Column1);
                    String date = c.getString(Column2);

                   
                    Data = Data + amount +"\t\t" + date +"\n\n";
                     
                } while (c.moveToNext());
            }
 
            TextView tv = new TextView(this); 
            tv.setTextSize(18F);
            tv.setTextColor(Color.WHITE);
            //tv.setBackgroundColor(Color.DKGRAY);
            tv.setText("\n"+"amount \t |   date \t\n ______________________________\n"+Data);
            rel.addView(tv);  
             
        }
 
        catch (Exception e) {
             
            Log.e("Error", "Error", e);
             
            Toast.makeText(getBaseContext(), "No Data found   ", Toast.LENGTH_LONG).show();
             
        } finally {
            if (db != null)
                db.close();
        }
    }
	
}
