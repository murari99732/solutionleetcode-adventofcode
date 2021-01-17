

public class DynamicProgramming18Jan {

    static int fibonacci(int v, int arr[]) {
        if (v <= 1) {
            return v;
        }
        if (arr[v] != 0) {
            return arr[v];
        }
        System.out.println(v);
        int a = fibonacci(v - 2, arr);
        int b = fibonacci(v - 1, arr);
        arr[v] = a + b;
        return a + b;
    }

    static int countstairs(int n, int arr[]) {
        if (n <= 2) {
            return 1;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        int a = countstairs(n - 1, arr);
        int b = countstairs(n - 2, arr);
        int c = countstairs(n - 3, arr);
        arr[n] = a + b + c;
        return a + b + c;
    }

    static void ncountstairs(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        for (int i = 1; i < n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else if (i == 2) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        System.out.println(dp[n - 1]);
    }

    static int minimumsteps(int n, int dp[]) {
        if (n < 2) {
            return 1;
        }
        if (dp[n] == 0) {
            return dp[n];
        }
        int a = minimumsteps(n - 1, dp);
        int b = minimumsteps(n - 2, dp);
        int c = minimumsteps(n - 3, dp);
        int i = Math.min(a, Math.min(b, c)) + 1;
        dp[n] = i;
        return i;
    }

    static void climbstairs(int arr[], int idx, int val, String ans, int count) {

        if (val == 9) {
            System.out.println(ans + "   " + count);
            return;
        } else if (val > 9) {
            return;
        } else if (idx > 9) {
            return;
        }
        val = val + arr[idx];


        climbstairs(arr, val, val, ans + arr[idx], count + 1);
        val = val - arr[idx];

        climbstairs(arr, idx + 1, val, ans, count);

    }

    public static void main(String[] args) {
        climbstairs(new int[]{2, 1, 2, 3, 4, 2, 1, 1, 2, 1, 2, 1}, 0, 0, "", 0);

    }
}
