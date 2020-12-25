package sortingvisualization.sorts;

import javafx.scene.chart.XYChart;
import sortingvisualization.common.SortTask;
import sortingvisualization.common.SwapItem;

/**
 *
 * @author Gian
 */
public class  GnomeSort extends SortTask {

    public GnomeSort(XYChart.Series<String, Integer> chartData) {
        super(chartData);
    }

    @Override
    protected void doSorting() {
        int n = chartData.getData().size();
        int i = 0;
        try{
            while(i<n){
                
                if (i == 0) i++;
                
                if (getValueAt(i) >= getValueAt(i-1)) i++;
                
                else {


                    SwapItem swapItem = new SwapItem(chartData.getData().get(i-1), i);
                    updateValue(swapItem);
                    comparisonCount += 1;
                    updateComparisonMessage();
                    waitOnFlag();
                    
                    i--;
                }
            }

        }catch (Exception e){
            System.out.println("Something went wrong.");
        }finally{
            System.out.println("The 'try catch' is finished!");
        }
               
    }   

    
    @Override
    public Runnable getSwapCode(SwapItem swapItem) {
        return () -> {  
            try {
                if (swapItem != null) {
                    
                    int i = swapItem.getOriginalIndex();
                    int temp = getValueAt(i);
                    
                    comparisonCount += 1;
                    updateComparisonMessage();
                    
                    setValueAt(i, getValueAt(i-1));
                    setValueAt(i-1, temp);
                    
                }                
            } catch (Exception exp) {
                exp.printStackTrace();
            }     
    };
}
    
}
