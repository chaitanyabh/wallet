package com.example.walletmanager;

import org.achartengine.ChartFactory;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;

public class PieChart {

	public Intent getIntent(Context context)

	{

		String[] catagories = { "Food", "Fuel", "Movie", "Rent", "Travel",
				"Gift", "Other" };

		int[] totalarray = gettopCategories(context);
		CategorySeries series = new CategorySeries("pie demo");

		for (int i = 0; i < totalarray.length; i++) {

			series.add(catagories[i], totalarray[i]);
		}

		int[] colors = { Color.BLUE, Color.BLACK, Color.RED, Color.GREEN,
				Color.GRAY, Color.DKGRAY, Color.MAGENTA };
		DefaultRenderer re = new DefaultRenderer();
		for (int color : colors) {
			SimpleSeriesRenderer s = new SimpleSeriesRenderer();
			s.setColor(color);
			re.setBackgroundColor(color);
			re.addSeriesRenderer(s);
		}
		Intent intent = ChartFactory.getPieChartIntent(context, series, re,
				"pie");
		return intent;

	}

	public int[] gettopCategories(Context context) {
		String[] catagories = { "Food", "Fuel", "Movie", "Rent", "Travel",
				"Gift", "Other" };
		Data dat = new Data(context);
		dat.open();
		int[] totalarray = new int[7];
		for (int i = 0; i < catagories.length; i++) {

			totalarray[i] = dat.gettotalfrmCategory(catagories[i]);
			Log.d("cval", totalarray[i] + " total");

		}

		return totalarray;
	}

}
