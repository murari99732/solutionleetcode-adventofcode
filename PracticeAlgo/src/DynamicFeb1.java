import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class DynamicFeb1 {
    public static void main(String[] args) {
        catlan(10);
    }


    static void catlan(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            int sum = 0;

            for (int j = 0, k = i - 1; j < i && k >= 0; j++, k--) {
                sum = sum + dp[k] * dp[j];
            }
            dp[i] = sum;
        }
        System.out.println(dp[n - 1]);
    }

    static int palindrome(String a, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (a.charAt(i) == a.charAt(j)) {
            return 2 + palindrome(a, i + 1, j - 1);
        }
        return Math.max(palindrome(a, i + 1, j), palindrome(a, i, j - 1));
    }

    static int subsuqnceval(String a, String b, int i, int j, int count) {
        if (a.length() == i || b.length() == j) {
            return count;
        }
        int v = 0;
        if (a.charAt(i) == b.charAt(j)) {
            v = subsuqnceval(a, b, i + 1, j + 1, count + 1);
        }
        return Math.max(subsuqnceval(a, b, i + 1, j, 0), Math.max(subsuqnceval(a, b, i, j + 1, 0), v));

    }

    static int subsequnce(String a, String b, int i, int j, int dp[][]) {
        if (a.length() == i || b.length() == j) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (a.charAt(i) == b.charAt(j)) {
            return dp[i][j] = 1 + subsequnce(a, b, i + 1, j + 1, dp);
        }
        return dp[i][j] = Math.max(subsequnce(a, b, i + 1, j, dp), subsequnce(a, b, i, j + 1, dp));
    }

    static void knapsackpro(int weight[], int price[], int sum) {
        int dp[][] = new int[weight.length + 1][sum + 1];
        for (int i = 1; i < weight.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int currweigh = weight[i - 1];
                int include = 0;
                int exlcude = 0;
                if (currweigh >= j) {
                    include = dp[i - 1][j - weight[i]] + price[i - 1];
                }
                if (i > 0) {
                    exlcude = dp[i - 1][j];
                }
                dp[i][j] = Math.max(include, exlcude);
            }
        }
        Queue<Rate> q = new LinkedList<>();
        q.add(new Rate(dp.length - 1, dp.length - 1, dp[dp.length - 1][dp.length - 1], ""));
        while (!q.isEmpty()) {
            Rate poll = q.poll();
            if (dp[poll.x - 1][poll.y] > dp[poll.x - 1][poll.y - weight[poll.x]]) {
                q.add(new Rate(poll.x - 1, poll.y, dp[poll.x - 1][poll.y], poll.ans + weight[poll.x] + " "));
            } else {
                q.add(new Rate(poll.x - 1, poll.y - weight[poll.x], dp[poll.x - 1][poll.y - weight[poll.x]], poll.ans + weight[poll.x] + " "));
            }
        }
    }

    static void longestincreasingsub(int arr[]) {

        int dp[] = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] + 1 < dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        Queue<Longest> q = new LinkedList<>();
        q.add(new Longest(arr.length - 1, dp[arr.length - 1], arr.length - 1 + " "));
        while (!q.isEmpty()) {
            Longest poll = q.poll();
            int max = 0;
            for (int i = 0; i < poll.dx; i++) {
                if (poll.dx != i) {
                    max = Math.max(max, dp[i]);
                }
            }
        }


    }

    static void countdistinct(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int dp[] = new int[str.length() + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            if (map.containsKey(str.charAt(i - 1))) {
                Integer integer = map.get(str.charAt(i - 1));
                dp[i] = dp[i - 1] * 2 - dp[integer - 1];
                map.put(str.charAt(i - 1), i);

            } else {
                map.put(str.charAt(i - 1), i);
                dp[i] = dp[i - 1] * 2;
            }
        }
        Arrays.stream(dp).forEach(a -> System.out.print(a + " "));
    }

    static void printallapths(int arr[]) {
        int dp[] = new int[arr.length + 1];
        dp[arr.length] = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int value = arr[i];
            if (value != 0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= value; j++) {
                    if (i + j < dp.length)
                        min = Math.min(min, dp[i + j]);
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i] = min + 1;
                } else {
                    dp[i] = Integer.MAX_VALUE;
                }
            } else {
                dp[i] = Integer.MAX_VALUE;
            }

        }
        Arrays.stream(dp).forEach(a -> System.out.print(a + " "));
        Queue<Jumps> q = new LinkedList<>();
        int i = 0;
        while (dp[i] == 5) {
            q.add(new Jumps(i, dp[i], arr[i], i + " "));
            i++;
        }
        while (!q.isEmpty()) {
            Jumps poll = q.poll();

            System.out.println(poll.ans);


            for (int j = 0; j < arr.length; j++) {
                if (poll.dx - 1 == dp[j]) {
                    q.add(new Jumps(j, dp[j], arr[j], poll.ans + j + "  "));
                }
            }
        }
    }

    static void findmin(int board[][]) {
        int dp[][] = new int[board.length][board.length];
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = board.length - 1; j >= 0; j--) {
                if (i == board.length - 1 && j == board.length - 1) {
                    dp[i][j] = board[i][j];
                } else if (i == board.length - 1) {
                    dp[i][j] = dp[i][j + 1] + board[i][j];
                } else if (j == board.length - 1) {
                    dp[i][j] = dp[i + 1][j] + board[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + dp[i][j];
                }
            }
        }
        Queue<Bridge> q = new LinkedList<>();
        q.add(new Bridge(0, 0, dp[0][0], board[0][0], board[0][0] + " "));
        while (!q.isEmpty()) {
            Bridge poll = q.poll();
            if (poll.x == board.length - 2 && poll.y == board.length - 2) {
                System.out.println(poll.ans);
            }
            if (dp.length > poll.x + 1 && dp.length > poll.y + 1 && dp[poll.x + 1][poll.y] < dp[poll.x][poll.y + 1]) {
                q.add(new Bridge(poll.x + 1, poll.y, dp[poll.x + 1][poll.y], board[poll.x + 1][poll.y], poll.ans + board[poll.x + 1][poll.y] + " "));
            } else if (dp.length > poll.x + 1 && dp.length > poll.y + 1 && dp[poll.x + 1][poll.y] > dp[poll.x][poll.y + 1]) {
                q.add(new Bridge(poll.x, poll.y + 1, dp[poll.x][poll.y + 1], board[poll.x][poll.y + 1], poll.ans + board[poll.x][poll.y + 1] + " "));
            } else if (dp.length > poll.x + 1 && dp.length > poll.y + 1 && dp[poll.x + 1][poll.y] == dp[poll.x][poll.y + 1]) {
                q.add(new Bridge(poll.x + 1, poll.y, dp[poll.x + 1][poll.y], board[poll.x + 1][poll.y], poll.ans + board[poll.x + 1][poll.y] + " "));
                q.add(new Bridge(poll.x, poll.y + 1, dp[poll.x][poll.y + 1], board[poll.x][poll.y + 1], poll.ans + board[poll.x][poll.y + 1] + " "));
            }

        }
    }

    static void biotnice(int arr[]) {
        int dp[] = new int[arr.length];
        Arrays.fill(dp, 1);
        int sdp[] = new int[arr.length];
        Arrays.fill(sdp, 1);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        Arrays.stream(dp).forEach(a -> System.out.print(a + " "));
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[i] > arr[j] && sdp[i] < sdp[j] + 1) {
                    sdp[i] = sdp[j] + 1;
                }
            }
        }
        System.out.println();
        Arrays.stream(sdp).forEach(a -> System.out.print(a + " "));
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            min = Math.max(min, dp[i] + sdp[i]);
        }
        System.out.println(min);
    }

    static void nonoverlapping(Bridge bridges[]) {
        Arrays.sort(bridges, (a, b) -> a.x - b.x);
        int dp[] = new int[bridges.length];
        for (int i = 1; i < bridges.length; i++) {
            for (int j = 0; j < i; j++) {
                if (bridges[i].y > bridges[j].y && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }

            }
        }

    }

    static void countplaindromstring(String word) {
        boolean dp[][] = new boolean[word.length()][word.length()];
        int count = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = i; j < dp.length; j++) {
                if (i == j) {
                    dp[i][j] = true;
                    count++;
                } else if (i + 1 == j) {
                    if (word.charAt(i) == word.charAt(j)) {
                        count++;
                        dp[i][j] = true;
                    }
                } else {
                    if (dp[i + 1][j - 1] && word.charAt(i) == word.charAt(j)) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    static class Rate {
        int x;
        int y;
        int dvalue;
        String ans;

        public Rate(int x, int y, int dvalue, String ans) {
            this.x = x;
            this.y = y;
            this.dvalue = dvalue;
            this.ans = ans;
        }
    }

    static class Longest {
        int idx;
        int dx;
        String ans;

        public Longest(int idx, int dx, String ans) {
            this.idx = idx;
            this.dx = dx;
            this.ans = ans;
        }
    }

    static class Jumps {
        int x;
        int dx;
        int jx;
        String ans;

        public Jumps(int x, int dx, int jx, String ans) {
            this.x = x;
            this.dx = dx;
            this.jx = jx;
            this.ans = ans;
        }
    }

    static class Bridge {
        int x;
        int y;
        int dvalue;
        int bvalue;
        String ans;

        public Bridge(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Bridge(int x, int y, int dvalue, int bvalue, String ans) {
            this.x = x;
            this.y = y;
            this.dvalue = dvalue;
            this.bvalue = bvalue;
            this.ans = ans;
        }
    }

}
