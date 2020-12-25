package sortingvisualization.sorts;

import javafx.scene.chart.XYChart;
import sortingvisualization.common.SortTask;
import sortingvisualization.common.SwapItem;

/**
 *
 * @author Gian
 */
public class  GnomeSort2 extends SortTask {

    public GnomeSort2(XYChart.Series<String, Integer> chartData) {
        super(chartData);
    }

    @Override
    protected void doSorting() {
        int n = chartData.getData().size();
        int i = 0;
        try{
            while(i<n){
                System.out.println("[0] "+getValueAt(0));
                System.out.println("[1] "+getValueAt(1));
                System.out.println("[2] "+getValueAt(2));
                System.out.println("[3] "+getValueAt(3));
                System.out.println("[4] "+getValueAt(4));
                
                if (i == 0) i++;
                
                if (getValueAt(i) >= getValueAt(i-1)) i++;
                
                else {
                   
                    System.out.println("BEFORE SWAP");
                    System.out.println("["+i+"] = "+getValueAt(i));
                    System.out.println("["+(i-1)+"] = "+getValueAt(i-1));

                    SwapItem swapItem = new SwapItem(chartData.getData().get(i-1), i);
                    updateValue(swapItem);
                    comparisonCount += 1;
                    updateComparisonMessage();
                    waitOnFlag();
                    
                    i--;
                }
                    
                    System.out.println("AFTER SWAP");
      //              System.out.println("["+i+"] = "+getValueAt(i));
      //              System.out.println("["+(i-1)+"] = "+getValueAt(i-1));
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
                 
                    System.out.println("WHEN THIS CALL, TO UPDATE");
                    int i = swapItem.getOriginalIndex();
                    
                    System.out.println("["+i+"] = "+getValueAt(i));
                    System.out.println("["+(i-1)+"] = "+getValueAt(i-1));
                    int temp = getValueAt(i);
                    
                    System.out.println("PROSES SWAP-NYA DISINI.....");
                    setValueAt(i, getValueAt(i-1));
                    setValueAt(i-1, temp);
                    
                //    if (i>0){
                //    System.out.println("AFTER SWAP");
                 //   System.out.println(i+ " [i] "+getValueAt(i)+" [i-1] "+getValueAt(i-1));
                 //  }
                }
          //       System.out.println("AFTER SWAP");
            //     System.out.println(i+ " [i] "+getValueAt(i)+" [i-1] "+getValueAt(i-1));
                
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        
    };
}
    
}
