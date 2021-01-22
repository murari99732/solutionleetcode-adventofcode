public class UnBoundedKnapsack {

  public static int getMaxProfit(int[] wt, int[] pr, int totalCapacity) {
    if(wt.length == 0 || pr.length == 0 || totalCapacity <= 0) {
      return 0;
    }
    
    int numberOfWeights = wt.length;
    
    int[][] arr = new int[numberOfWeights][totalCapacity + 1];
    
    for(int i = 0; i < numberOfWeights; i++) {
      for(int j = 1; j <= totalCapacity; j++) {
        
        int includingCurrentWeightProfit = 0;
        int excludingCurrentWeightProfit = 0;
        
        if(wt[i] <= j) {
          includingCurrentWeightProfit = pr[i] + arr[i][j - wt[i]];
        }
        
        if(i > 0) {
          excludingCurrentWeightProfit = arr[i - 1][j];
        }
        
        arr[i][j] = Math.max(includingCurrentWeightProfit, excludingCurrentWeightProfit);
      }
    }
    
    return arr[numberOfWeights - 1][totalCapacity];
  }
   static void knapsack(int weight[], int idx, int profit[], int sum, int val, int dc, String ans) {
        if (val == sum) {
            System.out.println(ans + "                  " + val + "                " + dc);
            return;
        } else if (val > sum) {
            return;
        }

        for (int i = 0; i < weight.length; i++) {
            val = val + weight[i];
            knapsack(weight, idx, profit, sum, val, dc + profit[i], ans + weight[i]);
            val = val - weight[i];
        }
    }
  public static void main(String[] args) {
    
    int[] wt = {1, 2, 3, 5};
    int[] pr = {1, 4, 7, 10};
    
    int totalCapacity = 8;
    
    System.out.println(UnBoundedKnapsack.getMaxProfit(wt, pr, totalCapacity));
    
  }

}
