package applictaion;

import java.util.Arrays;

public class Application {
    static int fibonacci(int n, int arr[]) {
        if (n == 0) {
            return 1;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        int a = n * fibonacci(n - 1, arr);
        return arr[n] = a;
    }

    static void fibonacci(int n) {
        int arr[] = new int[n + 1];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                arr[i] = 1;
            } else if (i == 1) {
                arr[i] = 1;
            } else {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
        }
        System.out.println(arr[n]);
    }

    static void climbingstairs(int arr[]) {
        int dp[] = new int[arr.length + 1];
        for (int i = arr.length; i >= 0; i--) {
            if (i == arr.length) {
                dp[i] = 1;
            } else {
                int val = arr[i];
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= val; j++) {
                    if (i + j <= arr.length) {
                        min = Math.min(min, dp[i + j]);
                    }
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i] = min + 1;
                } else {
                    dp[i] = Integer.MAX_VALUE;
                }
            }
        }
        Arrays.stream(dp).forEach(a -> System.out.print(a + " "));
    }

    static int climbingstairsvalue(int n, int arr[]) {
        if (n < 3) {
            return n;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        int a = climbingstairsvalue(n - 1, arr);
        int b = climbingstairsvalue(n - 2, arr);
        int c = climbingstairsvalue(n - 3, arr);
        arr[n] = a + b + c;
        return a + b + c;

    }

    static void climbingstairsval(int arr[], int idx, int val, String ans) {
        if (val == 10) {
            System.out.println(ans + "            " + idx);
            return;
        } else if (val > 10) {
            return;
        }
        int value = arr[idx];
        for (int i = 1; i <= value; i++) {
            val = val + arr[i];
            climbingstairsval(arr, idx + 1, val, ans + arr[i] + " ");
            val = val - arr[i];

        }
    }

    static int climb(int arr[], int val, int idx, int brr[]) {

        if (val == 10) {
            return 1;
        } else if (val > 10) {
            return 0;
        }
        if (brr[val] != 0) {
            return brr[val];
        }
        int rgb = arr[idx];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= rgb; i++) {
            int v = climb(arr, val + arr[i], idx + 1, brr);
            min = Math.min(min, v) + 1;
        }
        brr[val] = min;

        return min;
    }

    static int climbingpath(int n, int arr[]) {
        if (n < 3) {
            return n;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        int a = climbingpath(n - 1, arr);
        int b = climbingpath(n - 2, arr);
        int c = climbingpath(n - 3, arr);
        arr[n] = a + b + c;
        return a + b + c;
    }

    static int recursionmax(int arr[], int idx, int val, String ans) {
        if (val == 10) {
            return val;
        } else if (val > 10) {
            return 0;
        }
        int temp = arr[idx];
        int sum = 0;
        for (int i = 1; i <= temp; i++) {
            sum = sum + recursionmax(arr, idx + 1, val + arr[idx], ans + arr[idx] + " ");
        }
        return sum;
    }

    static int minimumcostpath(int m[][], int x, int y, int val, Integer dp[][]) {
        if (x == m.length && y == m.length) {
            return 0;
        }
        if (x < 0 || y < 0 || x >= m.length || y >= m.length) {
            return 0;
        }

        System.out.println(m[x][y]);
        int a = minimumcostpath(m, x + 1, y, val, dp);
        int b = minimumcostpath(m, x, y + 1, val, dp);
        //  dp[x][y] = Math.max(a, b) + m[x][y];
        return Math.max(a, b) + m[x][y];

    }

    static void minimumcost(int m[][], int x, int y) {
        int dp[][] = new int[m.length][m.length];
        for (int i = m.length - 1; i >= 0; i--) {
            for (int j = m.length - 1; j >= 0; j--) {
                if (i == m.length - 1 && j == m.length - 1) {
                    dp[i][j] = m[i][j];
                } else if (j == m.length - 1) {
                    dp[i][j] = dp[i + 1][j] + m[i][j];
                } else if (i == m.length - 1) {
                    dp[i][j] = dp[i][j + 1] + m[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]) + m[i][j];
                }
            }
        }
        System.out.println(dp[0][0]);
    }

    static void matrixgold(int m[][]) {
        int dp[][] = new int[m.length][m.length];
        for (int i = m.length - 1; i >= 0; i--) {
            for (int j = 0; j < m.length; j++) {
                if (i == m.length - 1) {
                    dp[i][j] = m[i][j];
                } else if (j == 0) {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j + 1]) + m[i][j];
                } else if (j == m.length - 1) {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j]) + m[i][j];
                } else {
                    dp[i][j] = m[i][j];
                }

            }
        }
    }

    static void targestsum(int arr[], int value) {
        boolean dp[][] = new boolean[arr.length + 1][value + 1];
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j < value + 1; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else {
                    if (dp[i - 1][j]) {
                        dp[i][j] = true;
                    } else {
                        if (arr[i] >= j) {
                            dp[i][j] = dp[i - 1][j - arr[i]];
                        }
                    }
                }
            }
        }
    }

    static void combicoin(int val, int dc[], int idx, String ans) {
        if (val == 7) {
            System.out.println(ans);
            return;
        } else if (val > 7) {
            return;
        }
        for (int i = idx; i < dc.length; i++) {
            val = val + dc[i];
            combicoin(val, dc, i, ans + dc[i] + " ");
            val = val - dc[i];
        }
    }

    static void combicoin1(int val, int dc[], int idx, String ans) {
        if (val == 7) {
            System.out.println(ans);
            return;
        } else if (val > 7) {
            return;
        }
        for (int i = 0; i < dc.length; i++) {
            val = val + dc[i];
            combicoin1(val, dc, 0, ans + dc[i] + " ");
            val = val - dc[i];
        }
    }

    static void coinchangcombi(int arr[], int sum) {
        int dp[][] = new int[arr.length + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < sum + 1; j++) {
                int including = 0;
                int excluding = 0;
                if (arr[i] >= j) {
                    including = dp[i][j - arr[i - 1]];
                }
                excluding = dp[i - 1][j];
                dp[i][j] = including + excluding;

            }
        }
    }

    static void coinchangeprobli(int arr[], int sum) {
        int dp[] = new int[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < sum+1; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] <= i) {
                    dp[i] = dp[i - arr[j]] + 1;
                }
            }
        }

        Arrays.stream(dp).forEach(a -> System.out.print(a + " "));
    }

    public static void main(String[] args) {
        coinchangeprobli(new int[]{2, 3, 5}, 7);

    }
}
