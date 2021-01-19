

import java.util.Arrays;
import java.util.List;

public class DynamicProgramming19Jan {

    static void longestincreasing(int arr[], int idx, int val, String ans, int count) {
        if (idx == arr.length) {
            System.out.println(ans + "   " + count);
            return;
        }
        if (val == 0) {
            val = arr[idx];
            longestincreasing(arr, idx + 1, val, ans + arr[idx] + " ", count + 1);
            val = 0;
        }
        if (val < arr[idx]) {
            int df = val;
            val = arr[idx];
            longestincreasing(arr, idx + 1, val, ans + arr[idx] + " ", count + 1);
            val = df;
        }
        longestincreasing(arr, idx + 1, val, ans, count);
    }

    static void longestincreasaing(int arr[]) {
        int dp[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {

        }
    }

    static void findlargestnumber(List<Integer> arr, int start, int end) {
        if (start > end) {
            arr.stream().forEach(a -> System.out.print(a + " "));
            return;
        }
        if (start == end) {
            arr.stream().forEach(a -> System.out.print(a + " "));
            return;
        }
        if (arr.get(start) < arr.get(end)) {
            int temp = arr.get(start);
            int stemp = arr.get(end);
            arr.remove(start);
            arr.add(start, stemp);
            arr.remove(end);
            arr.add(end, temp);
            findlargestnumber(arr, start + 1, end - 1);
        } else {
            findlargestnumber(arr, start, end - 1);
        }

    }

    static void longesticreasing(int arr[]) {
        int dp[] = new int[arr.length];
        Arrays.fill(dp, 1);
        int min = 0;
        int max = 0;
        for (int i = 1; i < arr.length; i++) {

            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    max = min;
                }
            }
            dp[i] = min;
        }
        System.out.println(max);
    }

    static void maximumsum(int arr[]) {
        int dp[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = arr[i];
        }
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] + arr[i]) {
                    dp[i] = dp[j] + arr[i];
                    max = Math.max(max, dp[j]);
                }
            }

        }
        System.out.println(max);
    }

    static int longestcommonsubseq(String a, String w, int i, int j, Integer dp[][]) {
        if (a.length() == i) {
            return 0;
        }
        if (w.length() == j) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int b = 0;
        if (a.charAt(0) == w.charAt(0)) {
            b = 1 + longestcommonsubseq(a.substring(i), w.substring(j), i + 1, j - 1, dp);
        }
        int bv = Math.max(b, Math.max(longestcommonsubseq(a.substring(i), w, i + 1, j, dp), longestcommonsubseq(a, w.substring(j), i, j - 1, dp)));
        dp[i][j] = bv;
        return bv;
    }


    static void tragetsum(int arr[], int target) {
        boolean dp[][] = new boolean[arr.length][target + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 0; i <= target; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= target; j++) {

                if (dp[i - 1][j]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    if (arr[i] <= j)
                        if (dp[i - 1][j - arr[i]]) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = false;
                        }
                }
            }
        }
        System.out.println(dp[arr.length - 1][target]);
    }

    static void coinschange(int arr[], int val, int idx, String ans, boolean brr[]) {

        if (val == 7) {
            System.out.println(ans);
            return;
        } else if (val > 7) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (brr[i] == false) {
                val = val + arr[i];
                brr[i] = true;
                coinschange(arr, val, idx + 1, ans + arr[i], brr);
                val = val - arr[i];
                brr[i] = false;
            }
        }
    }

    static void coinsmainy(int arr[], String ans, int val) {
        if (val == 7) {
            System.out.println(ans);
            return;
        } else if (val > 7)
            return;

        for (int i = 0; i < arr.length; i++) {
            val = val + arr[i];
            coinsmainy(arr, ans + arr[i] + " ", val);
            val = val - arr[i];
        }
    }

    static void coinchange(int arr[], int sum) {
        int dp[][] = new int[arr.length + 1][sum + 1];
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                int including = 0;
                int excluding = 0;
                excluding = dp[i - 1][j];
                if (arr[i] >= j) {
                    including = dp[i][j - arr[i]];
                }
                dp[i][j] = including + excluding;
            }
        }
    }

    static void coinchangelots(int arr[], int sum) {
        int dp[][] = new int[arr.length + 1][sum + 1];
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                int include = 0;
                int exclude = 0;
                if (arr[i] < j) {
                    include = dp[i - 1][j];
                }
                if (arr[i] >= j) {
                    exclude = dp[i][j - arr[i]];
                }
                dp[i][j] = Math.max(include, exclude) + 1;

            }
        }
    }

    static void maximumwieght(int weight[], int price[], int idx, int maxweight, int val, int wei, String ans) {
        if (idx == 4) {
            if (val == maxweight) {
                System.out.println(ans);
                return;
            } else if (val > maxweight) {
                return;
            }
            return;
        }
        wei = wei + weight[idx];
        val = val + price[idx];
        maximumwieght(weight, price, idx + 1, maxweight, val, wei, ans + weight[idx] + " ");
        wei = wei - weight[idx];
        val = val - price[idx];
        maximumwieght(weight, price, idx + 1, maxweight, val, wei, ans);


    }

    static void maximumcoins(int price[], int weight[], int sum) {
        int dp[][] = new int[price.length][weight.length];
        for (int i = 0; i < price.length; i++) {
            for (int j = 0; j <= sum; j++) {

                int include = 0;
                int exclude = 0;
                if (weight[i] >= j) {
                    include = dp[i - 1][j - weight[i]] + price[i];
                }
                dp[i][j] = Math.max(dp[i - 1][j], exclude);
            }
        }
    }

    static void maximumcoisnvale(int weight[], int price[], int sum) {
        int dp[][] = new int[weight.length + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= sum; j++) {
                int exclude = 0;
                int include = 0;
                if (weight[i] >= j) {
                    include = dp[i][j - weight[i]] + price[i];
                }
                dp[i][j] = Math.max(include, dp[i - 1][j]);
            }
        }

    }

    static void consexutivezero() {

        int idx = 1;
        int idy = 1;
        for (int i = 1; i < 5; i++) {
            int newdx = idy;
            int newdy = idx + idy;
            idx = newdx;
            idy = newdy;

        }

    }

    static void decodeways(int arr[]) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                a = 1;
            } else if (i == 1) {
                if (arr[0] * 10 + arr[1] <= 26) {
                    b = 2;
                } else {
                    b = 1;
                }
            } else {
                int bc = 0;
                int bd = 0;
                if (arr[i - 1] * 10 + arr[i] <= 26) {
                    bc = a;
                }
                if (arr[i] != 0) {
                    bd = b;
                }
                a = b;
                b = bc + bd;
            }
        }
        System.out.println(b);
    }

    static void adjacentelementnottaken(int arr[]) {
        int dp[] = new int[arr.length];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                dp[i] = arr[i];
            } else if (i == 1) {
                dp[i] = arr[i];
            } else {
                dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
                max = dp[i];

            }
        }
        System.out.println(max);
    }

    static  void maximumadjacent(int arr[], int idx, int val, boolean flag)
    {
        if(idx==arr.length)
        {
            System.out.println(val);
            return;
        }
        if(flag==false)
        {
            maximumadjacent(arr,idx+1, val+arr[idx], true);
            maximumadjacent(arr, idx+1,val,false);
        }
        else
        {
            maximumadjacent(arr,idx+1, val, false);
        }
    }

    public static void main(String[] args) {
        maximumadjacent(new int[]{2, 3, 1, 0, 1, 1},0,0,false);

    }

}
