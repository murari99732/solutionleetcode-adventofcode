

import java.util.*;

public class March34 {

    public static void main(String[] args) {
        findarray(new int[]{2,6,9,11,13,17},new int[]{3,6,7,10,13,15},new int[]{4,5,6,9,11,13});
    }

    static  void findarray(int arr[], int brr[], int crr[])
    {
        int i=0;
        int j=0;
        int k=0;
        while(i<arr.length&&j<brr.length&&k<crr.length)
        {
            int min=Math.min(arr[i], Math.min(brr[j], crr[k]));
            if(min==arr[i]&& min==brr[j]&&min==crr[k])
            {
                System.out.println(arr[i]);
            }
            if(min==arr[i])
            {
                i++;
            }
            if(min==brr[j])
            {
                j++;
            }
            if(min==crr[k])
            {
                k++;
            }
        }
    }

    static void checkifcicrular(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            boolean flag = false;
            if (val < 0) {
                flag = true;
            }
            int v = arr[i];
            while (true) {
                int slow = getnext(v, i, arr, flag);
                if (slow == -1) {
                    break;
                }
                int f1 = getnext(v, i, arr, flag);
                if (f1 == -1) {
                    break;
                }
                int f2 = getnext(v, i, arr, flag);
                if (f2 == -1) {
                    break;
                }
                if (f2 == f1) {
                    System.out.print("cycle");
                    return;
                }
            }
        }
    }

    private static int getnext(int v, int i, int[] arr, boolean flag) {

        if(arr[i]>0)
        {
            if(flag==false)
            {
                return -1;
            }
        }

        if(arr[i]+i==arr[i])
        {
            return -1;
        }
        int val=arr[i]+i%arr.length;
        return val;

    }

    static void findfibonacci(int n, int sum) {

        if (n == 0) {
            System.out.println(sum + 1);
            return;
        }
        if (n == 1) {
            System.out.println(sum + 1);
            return;
        }
        findfibonacci(n - 1, sum + n);
        findfibonacci(n - 2, sum + n);
    }

    public static int largestRectangleArea(int[] heights) {

        Stack<Integer> st = new Stack<>();
        int first[] = new int[heights.length];

        for (int i = heights.length - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                st.push(i);
                first[i] = heights.length - 1;
            } else {
                while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                    st.pop();
                }
                if (st.isEmpty()) {
                    st.push(i);
                    first[i] = heights.length - 1;
                } else if (!st.isEmpty()) {
                    first[i] = st.peek();
                    st.push(i);
                }
            }
        }

        Stack<Integer> ts = new Stack<>();
        int second[] = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            if (ts.isEmpty()) {
                second[i] = 0;
                ts.push(i);
            } else {
                while (!ts.isEmpty() && heights[ts.peek()] > heights[i]) {
                    ts.pop();
                }
                if (ts.isEmpty()) {
                    second[i] = 0;
                    ts.push(i);
                } else if (!ts.isEmpty()) {
                    second[i] = ts.peek();
                    ts.push(i);
                }
            }
        }

        Arrays.stream(first).forEach(a -> System.out.print(a + " "));
        System.out.println();
        Arrays.stream(second).forEach(a -> System.out.print(a + " "));
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int val = Math.abs(first[i] + 1 - second[i] - 1);
            max = Math.max(val * heights[i], max);
        }
        System.out.print(max);
        return max;
    }

    static void nqueens(int col, int m[][]) {
        if (col >= m.length) {
            display(m);
            return;
        }
        for (int i = 0; i < m.length; i++) {
            if (isSafeVisit(m, col, i)) {
                m[col][i] = 1;
                nqueens(col + 1, m);
                m[col][i] = 0;
            }
        }
    }

    private static boolean isSafeVisit(int[][] m, int col, int row) {
        for (int i = col; i >= 0; i--) {

            if (m[i][row] == 1) {
                return false;
            }
        }
        for (int i = col, j = row; i >= 0 && j >= 0; i--, j--) {
            if (m[i][j] == 1) {
                return false;
            }
        }
        for (int i = col, j = row; i >= 0 && j < m.length; i--, j++) {
            if (m[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    private static void display(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void findmatrix(Cordiantes firstx, Cordiantes firsty, Cordiantes secondx, Cordiantes secondy) {

        int vx = Math.max(firstx.dx, secondx.dx);
        int vy = Math.max(firstx.dy, secondx.dy);

        int wx = Math.min(firsty.dx, secondy.dx);
        int wy = Math.min(firsty.dy, secondy.dy);

        int sqr1 = Math.abs(firstx.dx - secondx.dx);
        int sqr2 = Math.abs(firstx.dy - secondx.dy);

        int tqr1 = Math.abs(firsty.dx - secondy.dx);
        int tqr2 = Math.abs(firsty.dy - secondy.dy);

        int wal = sqr1 * sqr2 + tqr1 * tqr2 - (Math.abs(wx - vx) * Math.abs(vy - wy));


    }

    static void findmatrxix(int m[][]) {
        int dp[][] = new int[m.length][m.length];
        for (int i = m.length - 1; i >= 0; i--) {
            for (int j = m.length - 1; j >= 0; j--) {
                if (m[i][j] == 0) {
                    dp[i][j] = 0;
                } else if (i == m.length - 1) {
                    dp[i][j] = m[i][j];
                } else if (j == m.length - 1) {
                    dp[i][j] = m[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j] + "   ");
            }
            System.out.println();
        }
    }

    static void lengthoflargest(int arr[]) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                max = Math.max(arr[j], max);
                min = Math.min(arr[j], min);
                if (max - min == j - i + 1) {
                    count = Math.max(count, j - i);
                }
            }
        }
        System.out.print(count);
    }

    static ArrayList<Integer> getParnthese(String word) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == '+' || word.charAt(i) == '-' || word.charAt(i) == '*' || word.charAt(i) == '/') {
                ArrayList<Integer> a = getParnthese(word.substring(0, i));
                ArrayList<Integer> b = getParnthese(word.substring(i + 1));
                for (Integer it : a) {
                    for (Integer bt : b) {
                        if (word.charAt(i) == '+') {
                            list.add(it + bt);
                        } else if (word.charAt(i) == '-') {
                            list.add(it - bt);
                        } else if (word.charAt(i) == '*') {
                            list.add(it * bt);

                        }
                    }
                }
            }
        }
        if (word.length() == 1) {
            list.add(Integer.parseInt(String.valueOf(word.charAt(0))));
            return list;
        } else {
            return list;
        }
    }

    static void numberofrabbits(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        System.out.println(map);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0;
        for (Integer it : map.keySet()) {
            int v = map.get(it);
            double vc = v / (it + 1);
            if (vc % (it + 1) == 0) {
                int w = (int) vc;
                hashMap.put(it, w);
                sum = sum + w * (it + 1);
            } else {
                int w = (int) vc + 1;
                hashMap.put(it, w);
                sum = sum + w * (it + 1);
            }

        }
        System.out.print(hashMap);
        System.out.print(sum);
    }

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> p = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer it : map.keySet()) {
            p.add(it);
        }
        System.out.print(p);
        return null;

    }

    static class Cordinates {
        int value;
        int count;

        public Cordinates(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    static class Cordiantes {
        int dx;
        int dy;

        public Cordiantes(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }
    }
}
