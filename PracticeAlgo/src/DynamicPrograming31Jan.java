import java.util.Arrays;

public class DynamicPrograming31Jan {
    public static void main(String[] args) {
        countplaindromstring("ABABCDEABACD");

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

    static class Bridge {
        int x;
        int y;

        public Bridge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
