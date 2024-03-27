package views;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import models.Arquero;

public class DispersionGraphicPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private XYSeriesCollection xyDataset;
	private ChartPanel chartPanel; 

	public DispersionGraphicPanel() {
		setLayout(new BorderLayout());
		xyDataset = new XYSeriesCollection();
		JFreeChart xylineChart = ChartFactory.createXYLineChart(Constants.TEXT_TITLE_GRAPH, Constants.TEXT_X,
			Constants.TEXT_Y, xyDataset, PlotOrientation.VERTICAL, false, true, false);
		XYPlot plot = xylineChart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.ORANGE);
		renderer.setSeriesPaint(1, Color.BLUE);
		renderer.setSeriesPaint(2, Color.BLACK);
		renderer.setSeriesStroke(0, new BasicStroke(4.0f));
		renderer.setSeriesStroke(1, new BasicStroke(3.0f));
		renderer.setSeriesStroke(2, new BasicStroke(2.0f));
		plot.setRenderer(renderer);
		chartPanel = new ChartPanel(xylineChart);
		add(chartPanel, BorderLayout.CENTER);
	}

	public void graphicPlayerData(ArrayList<Arquero> competitors) {
		for (int i = 0; i < competitors.size(); i++) {
			XYSeries player = new XYSeries(competitors.get(i).getNombre());
			for (int j = 0; j < competitors.get(i).getPuntosPorVuelta().size(); j++) {
				double labs = (double) competitors.get(i).getPuntosPorVuelta().get(j);
				player.add((j + 1), labs);
			}
			xyDataset.addSeries(player);
		}
	}

}