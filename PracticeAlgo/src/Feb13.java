

import java.util.Collections;
import java.util.List;

public class Feb13 {
    
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
