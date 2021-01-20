package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class DynamicProgramming20Jan {
    static void minimumjumps(int arr[]) {
        Integer dp[] = new Integer[arr.length + 1];
        dp[arr.length] = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > 0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= arr[i]; j++) {
                    if (i + j < dp.length && dp[i + j] != null) {
                        min = Math.min(dp[i + j], min);
                    }
                }
                if (min != Integer.MAX_VALUE)
                    dp[i] = min + 1;
                else
                    dp[i] = null;
            }
        }
        Arrays.stream(dp).forEach(a -> System.out.print(a + " "));
        System.out.println();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 3, 4, ""));
        while (!q.isEmpty()) {
            Node poll = q.poll();
            if (poll.jumps == 1) {
                System.out.println(poll.path);
            }
            for (int i = 1; i <= poll.src; i++) {
                if (dp[poll.index + i] != null) {
                    if (dp[poll.index + i] == poll.jumps - 1 && poll.index + i < arr.length) {
                        q.add(new Node(poll.index + i, arr[poll.index + i], poll.jumps - 1, poll.path + arr[poll.index]));
                    }
                }
            }
        }


    }

    static void distinctsubseq(String a) {
        int dp[] = new int[a.length()];
        dp[0] = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 1; i < a.length(); i++) {
            if (map.containsKey(a.charAt(i))) {
                int v = map.get(a.charAt(i));
                int val = dp[v - 1];
                dp[i] = dp[i - 1] * 2 - val;
                map.put(a.charAt(i), i);

            } else {
                map.put(a.charAt(i), i);
                dp[i] = dp[i - 1] * 2;

            }
        }
    }

    static void maximumlength(int arr[]) {
        int dp[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                dp[i] = 0;
            } else {
                int max = 0;
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j]) {
                        max = Math.max(dp[j], max);
                    }
                }
                dp[i] = max + 1;
            }
        }
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(dp.length - 1, dp[dp.length - 1], arr[dp.length - 1], ""));
        while (!q.isEmpty()) {
            Node poll = q.poll();
            for (int j = 0; j < poll.index; j++) {
                if (dp[j] == poll.jumps - 1) {
                    q.add(new Node(j, dp[j], arr[j], poll.path + arr[j] + " "));
                }
            }
        }
    }

    static void maximumgold(int m[][]) {
        int dp[][] = new int[m.length][m.length];
        for (int i = m.length - 1; i >= 0; i--) {
            for (int j = m.length - 1; j >= 0; j--) {
                if (i == j) {
                    dp[i][j] = m[i][j];
                } else if (i == m.length - 1) {
                    dp[i][j] = m[i][j] + dp[i][j];
                } else if (j == m.length - 1) {
                    dp[i][j] = m[i][j] + dp[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]) + m[i][j];
                }
            }
        }
        Queue<Cordinate> q = new LinkedList<>();
        q.add(new Cordinate(0, 0, ""));
        while (!q.isEmpty()) {
            Cordinate poll = q.poll();
        }
        System.out.println(m[0][0]);

    }

    static void printsubset(int arr[], int sum) {
        boolean brr[][] = new boolean[arr.length][sum];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < sum; j++) {
                if (arr[i] < j) {
                    brr[i][j] = brr[i - 1][j];
                } else {
                    if (j <= arr[i]) {
                        brr[i][j] = brr[i - 1][j - arr[i]];
                    }
                }
            }
        }
        Queue<SubValue> q = new LinkedList<>();
        q.add(new SubValue(arr.length - 1, arr.length - 1, arr[arr.length - 1], ""));
        while (!q.isEmpty()) {
            SubValue poll = q.poll();
            if (brr[poll.idx - 1][poll.idy - poll.idx]) {
                q.add(new SubValue(poll.idx - 1, poll.idy - poll.idx, arr[poll.idx - 1], "" + poll.idy));
            }
        }

    }

    public static void main(String[] args) {
        minimumjumps(new int[]{3, 3, 0, 2, 1, 2, 4, 2, 0, 0});
    }

    static class SubValue {
        int idx;
        int idy;
        int value;
        String path;

        public SubValue(int idx, int idy, int value, String path) {
            this.idx = idx;
            this.idy = idy;
            this.value = value;
            this.path = path;
        }
    }

    static class Cordinate {
        int x;
        int y;
        String path;

        public Cordinate(int x, int y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }

    static class Node {
        Integer index;
        Integer src;
        Integer jumps;
        String path;

        public Node(Integer index, Integer src, Integer jumps, String path) {
            this.index = index;
            this.src = src;
            this.jumps = jumps;
            this.path = path;
        }
    }
}
