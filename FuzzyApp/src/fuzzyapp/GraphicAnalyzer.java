/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzyapp;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Turing
 */
public class GraphicAnalyzer {


    public void drawXYLineChart(String[] actualAndPredictedValues) {
       
//        String[] actualAndPredictedValues= {"0 0","3 3.38", "4 3", "2 1.5", "4 0", "4 4"};        
        
        GraphicAnalyzer abc = new GraphicAnalyzer();
        abc.drawChartFrame(abc.createXYLineChart(abc.createDataset(actualAndPredictedValues)),"Cardiac Diagnoser - Accuracy Analyzer");
         
    }
    
    
    private XYDataset createDataset(String[] actualAndPredictedValues) {
        final XYSeries predictedSeries = new XYSeries("Predicted Results");


        for(int i =0 ; i<actualAndPredictedValues.length ; i++){
//        Assign the value set to an Array    
        String temp = actualAndPredictedValues[i];
//        Split the two values in the i th value set
        String[] splittedActualAndPredictedValue = temp.split("\\s+");            
//        Assign values to variables 
        Double actualValue=Double.parseDouble(splittedActualAndPredictedValue[0]);
        Double predictedValue=Double.parseDouble(splittedActualAndPredictedValue[1]); 
//        Insert data into predicted XY series        
        predictedSeries.add(actualValue, predictedValue);
        }      
        
        final XYSeries optimumSeries = new XYSeries("Optimum Results");
        optimumSeries.add(0.0, 0.0);
        optimumSeries.add(1.0, 1.0);
        optimumSeries.add(2.0, 2.0);
        optimumSeries.add(3.0, 3.0);
        optimumSeries.add(4.0, 4.0);           
        
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(predictedSeries);     
        dataset.addSeries(optimumSeries);
        
        return dataset;
    }    
    
    private JFreeChart createXYLineChart(XYDataset dataset) {    
        JFreeChart xyLineChart = ChartFactory.createXYLineChart(
                "Accuracy Analysis", // chart title
                "Actual Value",     // x axis label
                "Predicted Value",  // y axis label
                dataset,            // data
                PlotOrientation.VERTICAL, 
                true, // include legend
                true, // tooltips
                false // urls
        );
        
        final XYPlot plot = xyLineChart.getXYPlot();
        
        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);        

        return xyLineChart;
    }
    
    private void drawChartFrame(JFreeChart xyLineChart, String FrameName) {        
        ChartFrame cframeXYLinceChart = new ChartFrame(FrameName, xyLineChart);  
        
        cframeXYLinceChart.setSize(800, 600);
        cframeXYLinceChart.setVisible(true);  
    }
}
