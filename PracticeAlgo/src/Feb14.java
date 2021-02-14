

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Feb14 {

    static int max1 = 0;

    static void palindrome(String word) {
        boolean dp[][] = new boolean[word.length()][word.length()];
        for (int i = 0; i < word.length(); i++) {
            for (int j = i; j < word.length(); j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (i + 1 == j) {
                    dp[i][j] = true;
                } else {
                    if (word.charAt(i) == word.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        int board[][] = new int[dp.length][dp.length];
        for (int i = 0; i < word.length(); i++) {
            for (int j = i; j < word.length(); j++) {
                if (i == j) {
                    board[i][j] = 0;
                } else if (i + 1 == j) {
                    if (word.charAt(i) == word.charAt(j)) {
                        board[i][j] = 0;
                    } else {
                        board[i][j] = 1;
                    }
                } else {
                    if (word.charAt(i) == word.charAt(j) && dp[i][j]) {
                        board[i][j] = 0;
                    } else {
                        int k = i + 1;
                        int p = 0;
                        int min = Integer.MAX_VALUE;
                        for (int m = 0; m < j; m++) {
                            min = Math.min(min, board[m][k]);
                            k++;
                        }
                        board[i][j] = min + 1;
                    }
                }
            }
        }
        System.out.print(board[board.length - 1][board.length - 1]);
    }

    public static void main(String[] args) {
        reversebit(10);
    }

    static void reversebit(int n) {
        int d = 32;
        int sum = 0;
        boolean f = true;
        int r = 0;
        while (d != 0) {
            int v = 1 << d;
            if (f == false) {
                if ((v & n) != 0) {
                    sum = sum | 1 << r;
                }
                r++;
            } else if ((v & n) != 0 && f == true) {
                sum = sum | 1 << r++;
                f = false;
            }
            d--;
        }
        System.out.println(Integer.toBinaryString(sum));
        System.out.println(Integer.toBinaryString(n));
    }

    static void divide() {

    }

    static void getone(int n) {
        while (n != 0) {
            if (n == 1) {
                System.out.print(max1);
                break;
            } else if (n == 2) {
                System.out.print(max1 + 1);
                break;
            } else if (n == 3) {
                System.out.print(max1 + 2);
                break;
            } else if ((n & 3) == 3) {
                n = n + 1;
                max1++;
            } else if ((n & 3) == 1) {
                n = n - 1;
                max1++;
            } else {
                n = n >> 1;
                max1++;
            }
        }
        System.out.print(max1);
    }

    static void allrepaetingexpect(int arr[]) {
        int val = 0;
        for (int i = 0; i < arr.length; i++) {
            val = val ^ arr[i];
        }
        int su1 = 0;
        int su2 = 0;
        int v = val & -val;
        for (int i = 0; i < arr.length; i++) {
            if ((v & arr[i]) == 0) {
                su1 = su1 ^ arr[i];
            } else {
                su2 = su2 ^ arr[i];
            }
        }
        System.out.print(su1 + "  " + su2);

    }

    static void minmumskils(int arr[], int i, int val, int count) {
        if (i == arr.length) {
            if (val == i << arr.length - 1) {
                System.out.print(count);
            }
            return;
        }
        minmumskils(arr, i + 1, val | arr[i], count + 1);
        minmumskils(arr, i + 1, val, count);
    }

    static void josphes(ArrayList<Integer> ar, int n, int i) {
        if (ar.size() == 1) {
            System.out.print(ar);
            return;
        }

        if (i >= ar.size()) {
            i = 0;
        }
        if (n >= 4) {
            ar.remove(i);
            n = 0;
        }

        josphes(ar, n + 1, i + 1);

    }

    static void rightmostbit(int n) {
        while (n != 0) {
            int v = n & -n;
            System.out.println(Integer.toBinaryString(n));
            n = n - v;
        }
    }

    static int smajhan(int egg, int height) {
        if (height == 0 || height == 1) {
            return height;
        }
        if (egg == 1) {
            return height;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= height; i++) {
            int v = smajhan(egg - 1, height - 1);
            int w = smajhan(egg, height - i);
            int dx = Math.max(v, w) + 1;
            min = Math.min(dx, min);
        }
        return min;
    }

    static void getmax(int arr[], int idx, int fdx, int value, boolean bf) {
        if (idx > fdx) {


            max1 = Math.max(max1, value);
            return;
        }
        if (bf == true) {

            value = value + arr[idx];
            getmax(arr, idx + 1, fdx, value, false);
            value = value - arr[idx];
            value = value + arr[fdx];
            getmax(arr, idx, fdx - 1, value, false);
            value = value - arr[fdx];
        } else {
            value = value - arr[idx];
            getmax(arr, idx + 1, fdx, value, true);
            value = value + arr[idx];
            value = value - arr[fdx];
            getmax(arr, idx, fdx - 1, value, true);
            value = value + arr[fdx];
        }

    }

    static int value(int arr[], int value, int idx, int fdx, boolean bf) {
        if (fdx < idx) {
            return 0;
        }
        if (bf == true) {
            int v = value(arr, value + arr[idx], idx + 1, fdx, false) + arr[idx];
            max1 = Math.max(max1, v);
            int w = value(arr, value + arr[fdx], idx, fdx - 1, false) + arr[fdx];
            max1 = Math.max(max1, w);
            return Math.max(v, w);
        } else {
            int v = value(arr, value, idx + 1, fdx, true) - arr[idx];
            int w = value(arr, value, idx, fdx - 1, true) - arr[fdx];

            return Math.min(v, w);
        }

    }

    static void perfectsquare(int n) {
        int dp[] = new int[n];
        dp[1] = 1;

        for (int i = 2; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                if (j == Math.sqrt(i)) {
                    min = Math.min(0, min);
                    break;
                } else {

                    min = Math.min(dp[i - j * j], min);
                }
            }
            dp[i] = min + 1;

        }
        Arrays.stream(dp).forEach(a -> System.out.print(a + " "));
    }

    static int minimumcurts(String word, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (isaplindrome(word.substring(i, j + 1))) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int a = minimumcurts(word, i, k);
            int b = minimumcurts(word, k + 1, j);
            int val = a + b + 1;
            min = Math.min(min, val);
        }
        return min;
    }

    private static boolean isaplindrome(String substring) {
        int i = 0;
        int j = substring.length() - 1;
        while (i < j) {
            if (substring.charAt(i) != substring.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    static void chords(int n) {
        int dp[] = new int[n / 2];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; 2 * i < n; i++) {
            int v = i - 1;
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum = sum + dp[j] * dp[v];
                v--;
            }
            dp[i] = sum;
        }
        Arrays.stream(dp).forEach(a -> System.out.print(a + " "));
    }


    static int palidrome(String a, int i, int j) {
        if (i == j) {
            return 1;
        }
        if (a.charAt(i) == a.charAt(j)) {
            return 2 + palidrome(a, i + 1, j - 1);
        }
        return Math.max(palidrome(a, i + 1, j), palidrome(a, i, j - 1));
    }

    static void tiling(int m, int n) {
        int dp[] = new int[n];
        for (int i = 1; i < n; i++) {
            if (i < m) {
                dp[i] = i;
            } else if (i == m) {
                dp[i] = i * 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - m];
            }
        }
    }

    static void maximumbridge(List<Cordinates> list) {
        Collections.sort(list, (a, b) -> a.x - b.x);
        int dp[] = new int[list.size()];
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(i).y > list.get(j).y && dp[j] + 1 < dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }

        }
    }

    static class Cordinates {
        int x;
        int y;

        public Cordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
