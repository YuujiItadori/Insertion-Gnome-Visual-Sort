package sortingvisualization.sorts;

import javafx.scene.chart.XYChart;
import sortingvisualization.common.SortTask;
import sortingvisualization.common.SwapItem;

/**
 *
 * @author Gian
 */
public class Bubblebenar extends SortTask {

    public Bubblebenar(XYChart.Series<String, Integer> chartData) {
        super(chartData);
    }

    @Override
    protected void doSorting() {
        int n = chartData.getData().size();
        for (int i = 0; i < n; i++) {
            comparisonCount += 1;
            for (int j = 1; j < (n - i); j++) {
                if (getValueAt(j - 1) > getValueAt(j)) {
                    System.out.println("ini array ke 0 "+getValueAt(0));
                    System.out.println("ini array ke 1 "+getValueAt(1));
                    System.out.println("ini array ke 2 "+getValueAt(2));
                    System.out.println("ini array ke 3 "+getValueAt(3));
                    System.out.println("ini array ke 4 "+getValueAt(4));
                    System.out.println("before (j-1) "+(j-1)+" "+getValueAt(j-1));
                    System.out.println("before (j) "+(j)+" "+getValueAt(j));
                    SwapItem swapItem = new SwapItem(chartData.getData().get(j - 1), j);
                    updateValue(swapItem);
                    System.out.println("after (j-1) "+(j-1)+" "+getValueAt(j-1));
                    System.out.println("after (j) "+(j)+" "+getValueAt(j));
                    System.out.println("ini array ke 0 "+getValueAt(0));
                    System.out.println("ini array ke 1 "+getValueAt(1));
                    System.out.println("ini array ke 2 "+getValueAt(2));
                    System.out.println("ini array ke 3 "+getValueAt(3));
                    System.out.println("ini array ke 4 "+getValueAt(4));
                    comparisonCount += 2;
                    updateComparisonMessage();
                    waitOnFlag();
                }
            }
            System.out.println("Completed index: " + i);
        }
    }   
  
    
    @Override
    public Runnable getSwapCode(SwapItem swapItem) {
        return () -> {
            try {
                if (swapItem != null) {
                    
                    int j = swapItem.getOriginalIndex();
                    setValueAt(j - 1, getValueAt(j));
                    setValueAt(j, swapItem.getItemToSwap().getYValue());
                    
                    System.out.println("Setelah di SWAP");
                    System.out.println("j= "+(j)+" swapItem.getOriginalIndex()= "+(swapItem.getOriginalIndex()));
                    System.out.println("j "+j+getValueAt(j));
                    System.out.println("j-1"+(j-1)+" "+getValueAt(j-1));
                    System.out.println("swapItem.getItemToSwap().getYValue() "+(swapItem.getItemToSwap().getYValue()));
                }
                flag.set(true);
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        };
    }
}
