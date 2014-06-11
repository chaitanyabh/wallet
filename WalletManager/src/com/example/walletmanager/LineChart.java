package com.example.walletmanager;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

public class LineChart {

	public Intent getIntent(Context context) {
		
		int [] x={1,2,3,4,5,6,7,8,9,10};
		int[] y={30,34,45,57,77,89,100,111,123,145};
		TimeSeries series=new TimeSeries("line");
		for(int i=0;i<x.length;i++)
		{
			series.add(x[i],y[i]);
		}
		int [] xx={10,9,8,7,6,5,4,3,2,1};
		int[] yy={145,123,111,100,89,77,57,45,34,30};
		TimeSeries series1=new TimeSeries("line1");
		for(int i=0;i<xx.length;i++)
		{
			series1.add(xx[i],yy[i]);
		}
		XYMultipleSeriesDataset dataset=new XYMultipleSeriesDataset();
		dataset.addSeries(series);
		dataset.addSeries(series1);
		XYSeriesRenderer r=new XYSeriesRenderer();
		r.setColor(Color.RED);
		r.setPointStyle(PointStyle.DIAMOND);
		r.setFillPoints(true);
		XYSeriesRenderer r1=new XYSeriesRenderer();
		r1.setColor(Color.GREEN);
		r1.setPointStyle(PointStyle.SQUARE);
		r1.setFillPoints(true);
		XYMultipleSeriesRenderer renderer=new XYMultipleSeriesRenderer();
		renderer.setChartTitle("line chart");
		renderer.addSeriesRenderer(r);
		renderer.addSeriesRenderer(r1);
		Intent intent=ChartFactory.getLineChartIntent(context,dataset,renderer,"line new");
		return intent;
		
	}

}
