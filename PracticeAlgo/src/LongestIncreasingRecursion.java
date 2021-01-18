public class LongestIncreasingRecursion {

    static void longestincreasing(int arr[], int idx, int val, String ans, int count) {
        if(idx==arr.length)
        {
            System.out.println(ans+"   "+count) ;
            return;
        }
        if (val == 0) {
            val=arr[idx];
            longestincreasing(arr, idx + 1, val, ans + arr[idx] + " ", count + 1);
            val = 0;
        }
        if (val < arr[idx]) {
            int df=val;
            val = arr[idx];
            longestincreasing(arr, idx + 1, val, ans + arr[idx] + " ", count + 1);
            val = df;
        }
        longestincreasing(arr, idx + 1, val, ans, count);

    }

    public static void main(String[] args) {
        longestincreasing(new int []{2,1,3,4,2,6,3},0,0,"",0);
    }
}
