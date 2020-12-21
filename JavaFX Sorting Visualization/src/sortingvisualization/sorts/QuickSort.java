
/**
 * Giam
 */

package sortingvisualization.sorts;


import javafx.scene.chart.XYChart;
import sortingvisualization.common.SortTask;
import sortingvisualization.common.SwapItem;

public class QuickSort extends SortTask{

    public QuickSort(XYChart.Series<String, Integer> chartData) {
        super(chartData);
    }
       
    int counter;
    int pivot;
    @Override
    protected void doSorting() {
        int n = chartData.getData().size();
        int begin = 0; 
        int end = n-1;
        int i;
        
        quickSort(begin, end);
        
          
    }

    
    public int quickSort(int begin, int end){
    
      if(end <= begin){
          return 0;
      }
      
      pivot = partition(begin, end);
      System.out.println("PIVOT "+pivot);
      quickSort(begin,pivot-1);
      quickSort(pivot+1, end);
      return 0;
    }
    
    //partition
    public int partition(int begin, int end){
        pivot = end;   
        counter = begin;
        
        for(int i = begin; i<end; i++){
            if(getValueAt(i)<getValueAt(pivot)){
                SwapItem swapItem = new SwapItem(chartData.getData().get(counter),i);   
                
                updateValue(swapItem);
                comparisonCount +=1;
                updateComparisonMessage();
                waitOnFlag();
                
                counter++;                
            }
            int x = getValueAt(i); 
            System.out.println("ARRAY KE-"+i+ " "+String.valueOf(x));
        }   
            
        SwapItem swapItem = new SwapItem(chartData.getData().get(pivot),counter);
       
        updateValue(swapItem);
        comparisonCount += 1;
        updateComparisonMessage();
        waitOnFlag();
       
         
        return counter;
    }
    
    @Override
    public Runnable getSwapCode(SwapItem swapItem) {
        return () -> {
            if (swapItem != null) {
                int pivot = swapItem.getOriginalIndex();
                int i = swapItem.getSecondIndex();
                setValueAt(counter, getValueAt(i));
                setValueAt(i, swapItem.getItemToSwap().getYValue());
            }
            flag.set(true);
        };
    }
}

    
