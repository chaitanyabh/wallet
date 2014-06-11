package com.example.walletmanager;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewActivity1 extends Activity{

	
	SQLiteDatabase db = null;
    String TableName = "transactionvalues";
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
 
            int Column1 = c.getColumnIndex("date1");
            int Column2 = c.getColumnIndex("amount");

            
          

 
            c.moveToFirst();
             
            if (c != null) {
 
                do {
                    String date1 = c.getString(Column1);
                    int amount = c.getInt(Column2);
                     
                   
                    Data = Data + date1 +"\t\t" + amount +"\n\n";
                     
                } while (c.moveToNext());
            }

            TextView tv = new TextView(this);
            tv.setTextSize(18F);
            tv.setTextColor(Color.WHITE);
           //tv.setBackgroundColor(Color.DKGRAY);
            tv.setText("\n"+"date1 \t\t\t |   amount \t _________________________\n"+Data);
            //setContentView(tv);  
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
