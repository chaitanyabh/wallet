package com.example.walletmanager;

import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;

public class BarChart {

	public Intent getIntent(Context context) {

		String[] catagories = { "Food", "Fuel", "Movie", "Rent", "Travel",
				"Gift", "Other" };

		int[] totalarray = gettopCategories(context);
		CategorySeries series = new CategorySeries("Transaction");
		for (int i = 0; i < totalarray.length; i++) {
			series.add(catagories[i], totalarray[i]);
		}
		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
		dataset.addSeries(series.toXYSeries());

		XYSeriesRenderer r = new XYSeriesRenderer();
		r.setColor(Color.rgb(50, 139, 8));
		r.setDisplayChartValues(true);
		r.setChartValuesSpacing((float) 5.5d);
		r.setLineWidth((float) 10.5d);

		XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
		renderer.setChartTitle("All Transactions");
		renderer.setShowAxes(true);
		renderer.setShowGrid(true);
		renderer.addSeriesRenderer(r);
		renderer.setBarSpacing(.5);
		renderer.setApplyBackgroundColor(true);
		renderer.setBackgroundColor(Color.WHITE);
		renderer.setXAxisMin(0);
		renderer.setXLabels(0);

		for (int j = 0; j < catagories.length; j++) {
			renderer.addXTextLabel(j + 1, catagories[j]);
		}

		renderer.setPanEnabled(true, true);

		Intent intent = ChartFactory.getBarChartIntent(context, dataset,
				renderer, Type.DEFAULT);
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
