package sortingvisualization.sorts;

import javafx.scene.chart.XYChart;
import sortingvisualization.common.SortTask;
import sortingvisualization.common.SwapItem;

/**
 *
 * @author 
 */
public class GnomeSort extends SortTask {

    public GnomeSort(XYChart.Series<String, Integer> chartData) {
        super(chartData);
    }

    @Override
    protected void doSorting() {
        int n = chartData.getData().size();
        int temp;
        int index = 0;
        
        while(index < n){
            if(index == 0){
                index++;
            }
            if (getValueAt(index) >= getValueAt(index - 1)){
                index++;
            }else
            {
                temp = 0;
                SwapItem swapItem = new SwapItem(chartData.getData().get(index), index-1);
                    updateValue(swapItem);
                    comparisonCount += 1;
                    updateComparisonMessage();
                    waitOnFlag();
                    
                    index--;
            }     
        } 
        return;
    }

    @Override
    public Runnable getSwapCode(SwapItem swapItem) {
        return () -> {
            try {
                if (swapItem != null) {
                    int index = swapItem.getOriginalIndex();
                    setValueAt(index, getValueAt(index-1));
                    setValueAt(index-1, swapItem.getItemToSwap().getYValue());
                }
                flag.set(true);
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        };
    }
}
