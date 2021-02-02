package goodPractice;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Dynamic2feb {
    public static void main(String[] args) {
        int maxfreq = maxfreq("AABBC", "ABC");
        System.out.println(maxfreq);

    }

    static int maxfreq(String a, String b) {
        if (a.length() == 0 && b.length() == 0) {
            return 1;
        }
        if (a.length() == 0) {
            return 0;
        }
        if (b.length() == 0) {
            return 1;
        }

        int sum = 0;
        int bsum = 0;
        if (a.charAt(0) == b.charAt(0)) {
            sum = maxfreq(a.substring(1), b.substring(1));
        }

        bsum = maxfreq(a.substring(1), b);

        return sum + bsum;
    }

    static void kadancemaxk(int arr[]) {
        ArrayDeque<Integer> ar = new ArrayDeque<>();
        int i = 0;
        for (i = 0; i < 4; i++) {
            ar.add(arr[i]);
        }
        int max = 0;
        for (int k = i; k < arr.length; k++) {
            Integer reduce = ar.stream().reduce(0, (a, b) -> a + b);
            max = Math.max(reduce, max);
            ar.removeFirst();
            ar.addLast(arr[k]);

        }
        System.out.println(max);
    }

    static void kadanes(int arr[]) {
        int i = 0;
        int sum = 0;
        int max = 0;
        while (i < arr.length) {

            sum = sum + arr[i];
            max = Math.max(max, sum);
            if (arr[i] < 0) {
                sum = 0;
            }
            i++;
        }
        System.out.println(sum);
    }

    static void maximumsquare(int sum) {
        int dp[] = new int[sum];
        dp[0] = 0;
        int v = 0;
        for (int i = 1; i < sum; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= i; j++) {
                if (j * j <= i) {
                    min = Math.min(min, dp[i - j * j]);
                }
            }
            dp[i] = dp[min] + 1;
        }
        Arrays.stream(dp).forEach(a -> System.out.print(a + " "));
    }

    static int eggdrop(int egg, int floor) {
        if (egg == 1) {
            return floor;
        }
        if (floor == 0 || floor == 1) {
            return floor;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < floor; i++) {
            int a = eggdrop(egg - 1, i - 1);
            int b = eggdrop(egg, floor - i);
            int i1 = Math.max(a, b) + 1;
            min = Math.min(min, i1);
        }
        return min;
    }

    static int evalutaeexpression(String word, int start, int end, boolean istrue) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            if (istrue == true) {
                return 1;
            } else {
                if (istrue == false) {
                    return 0;
                }
            }
        }
        for (int i = start; i < end; i = i + 2) {
            int t1 = evalutaeexpression(word, start + 1, i, true);
            int t2 = evalutaeexpression(word, start + 1, i, false);
            int t3 = evalutaeexpression(word, i + 1, end, true);
            int t4 = evalutaeexpression(word, i + 1, end, false);
            int ans = 0;
            if (word.charAt(i) == '|') {
                if (istrue == true) {
                    ans = ans + t1 * t2 + t1 * t3 * t1;
                } else {
                    ans = t2 * t3;
                }
            }
            if (word.charAt(i) == '|') {
                if (istrue == true) {
                    ans = ans + t1 * t2 + t1 * t3 * t1;
                } else {
                    ans = t2 * t3;
                }
            }
        }
        return 0;
    }

    static int evaluate(String word, int x, int y) {
        for (int i = x + 1; i < y; i = i + 2) {
            int a = evaluate(word, x, i + 1);
            int b = evaluate(word, i + 1, y);

        }
        return 0;
    }

    static int mcm(int word[], int start, int end) {
        if (start >= end) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            int a = mcm(word, start, i);
            int b = mcm(word, i + 1, end);
            int v = word[start - 1] * word[i] * word[end];
            min = min = Math.min(v + a + b, min);

        }
        return min;
    }

    static int palindromepartition(String ans, int start, int end, int m[][]) {
        if (start > end) {
            return 0;
        }
        if (m[start][end] != 0) {
            return m[start][end];
        }
        if (ispalindrome(ans.substring(start, end)) == true) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            int a = palindromepartition(ans, start, i, m);
            int b = palindromepartition(ans, i + 1, end, m);
            int val = a + b + 1;
            min = Math.min(val, min);

        }
        m[start][end] = min;
        return min;
    }

    private static boolean ispalindrome(String substring) {
        int i = 0;
        int j = substring.length() - 1;
        while (i <= j) {
            if (substring.charAt(i) != substring.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


}
