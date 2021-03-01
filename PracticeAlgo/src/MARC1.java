package practice;

import java.awt.*;
import java.util.List;
import java.util.*;

public class MARC1 {
    public static final int FIVE_SECONDS = 5000;
    public static final int MAX_Y = 400;
    public static final int MAX_X = 400;
    static int x[] = {};
    static int y[] = {};

    public static void main(String... args) throws Exception {
      
        Robot robot = new Robot();
        Random random = new Random();
        while (true) {
            robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
            Thread.sleep(FIVE_SECONDS);
        }
    }

    static void knightproblem(int board[][], int dx, int dy, int count, int chess[][]) {

        for (int i = 0; i < 8; i++) {
            int vx = dx + x[i];
            int vy = dy + y[i];
            if (vx >= 0 && vx < board.length && vx >= 0 && vx < board.length) {
                chess[vx][vy] = chess[vx][vy] / 8;
            }
        }


    }

    static void getmap(int arr[]) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], false);
        }
        int max = 0;
        for (Integer it : map.keySet()) {
            int val = it;
            int count = 0;
            if (map.get(val) == false) {
                while (map.get(val) == false) {
                    map.put(val, true);
                    val = val - 1;
                    count++;
                }
                int dc = val + 1;
                while (map.get(dc) == false) {
                    map.put(dc, true);
                    dc = dc + 1;
                    count++;
                }
            }
            max = Math.max(count, max);
        }
    }

    static void largestcompo(int arr[]) {
        int parent[] = new int[10000];
        Arrays.fill(parent, -1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 2; j <= Math.sqrt(arr[i]); j++) {
                if (arr[i] % j == 0) {
                    getParent(parent, arr[i], j);
                    getParent(parent, arr[i], arr[i] / j);
                }
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
    }

    private static void getParent(int[] parent, int val, int des) {
        int v = getchild(parent, val);
        int w = getchild(parent, des);
        if (v != w) {
            parent[w] = v;
        }
    }

    private static int getchild(int[] parent, int des) {
        if (parent[des] == -1) {
            return des;
        }
        parent[des] = getchild(parent, parent[des]);
        return parent[des];
    }

    static int minimumcost(int arr[], HashMap<Integer, Integer> map, int val, int word, String ans) {
        int v = minimumcost(arr, map, val + 1, word, ans) + map.get(1);
        int w = arr[val];
        int k = val;
        for (k = val; k < arr.length; k++) {
            if (arr[k] >= w + 7) {
                break;
            }
        }
        int t = minimumcost(arr, map, val + k, word, ans) + map.get(7);
        for (k = val; k < arr.length; k++) {
            if (arr[k] >= w + 31) {
                break;
            }
        }
        int r = minimumcost(arr, map, val + k, word, ans) + map.get(30);
        return Math.min(v, Math.min(t, r));
    }

    static int findvalue(int arr[], int indx, boolean isflag, int count, HashMap<String, Integer> map) {
        if (indx >= arr.length || count == 0) {
            return 0;
        }
        String word = indx + "#" + isflag + "#" + count;
        if (map.containsKey(word)) {
            return map.get(word);
        }

        if (isflag == true) {
            int val = findvalue(arr, indx + 1, false, count, map) - arr[indx];
            int wal = findvalue(arr, indx + 1, true, count, map);
            map.put(word, Math.max(val, wal));
            return Math.max(val, wal);
        } else {
            int val = findvalue(arr, indx + 1, true, count - 1, map) + arr[indx];
            int wal = findvalue(arr, indx + 1, false, count, map);
            map.put(word, Math.max(val, wal));
            return Math.max(val, wal);
        }
    }

    static List<Integer> listadd(String word) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '+' || c == '-' || c == '/' || c == '*') {
                String a = word.substring(0, i);
                String b = word.substring(i + 1);
                List<Integer> listadd = listadd(a);
                List<Integer> listsub = listadd(b);
                for (Integer it : listadd) {
                    for (Integer bt : listsub) {
                        if (c == '+') {
                            list.add(it + bt);
                        } else if (c == '-') {
                            list.add(it - bt);
                        } else if (c == '*') {
                            list.add(it * bt);
                        } else if (c == '/') {
                            list.add(it / bt);
                        }
                    }
                }
            }
        }
        if (word.length() == 1) {
            list.add(Integer.parseInt(String.valueOf(word.charAt(0))));
            return list;
        } else
            return list;

    }

    static List<Integer> differnetwaysaddparent(String word, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            ArrayList<Integer> bc = new ArrayList<>();
            bc.add(Integer.parseInt(String.valueOf(word.charAt(start))));
            return bc;
        }
        ArrayList<Integer> cr = new ArrayList<>();
        for (int i = start + 1; i < end; i = i + 2) {
            List<Integer> a = differnetwaysaddparent(word, i, start);
            List<Integer> b = differnetwaysaddparent(word, start + 1, end);


            for (Integer it : a) {
                for (Integer bt : b) {
                    if (word.charAt(i) == '+') {
                        cr.add(it + bt);
                    } else if (word.charAt(i) == '-') {
                        cr.add(it - bt);
                    } else {
                        cr.add(it * bt);
                    }

                }
            }


        }
        return cr;

    }

    static void merge(int arr[], int start, int end) {
        if (start >= end)
            return;

        int mid = (start + end) / 2;
        merge(arr, start, mid);
        merge(arr, mid + 1, end);
        mergesort(arr, start, mid, end);
    }

    private static int[] mergesort(int[] brr, int start, int mid, int end) {
        int arr[] = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (brr[i] < brr[j]) {
                arr[k++] = brr[i];
                i++;
            } else if (brr[i] > brr[j]) {
                arr[k++] = brr[j];
                j++;
            }
        }
        while (i <= mid) {
            arr[k++] = brr[i];
            i++;
        }
        while (j <= end) {
            arr[k++] = brr[j];
            j++;
        }
        int p = 0;
        for (int l = start; l <= end; l++) {
            brr[l] = arr[l - start];
        }
        return brr;

    }

    static boolean search(Trie trie, String word, int i) {
        if (trie == null) {
            return false;
        }
        if (word.length() == i) {
            return trie.isflag;
        }
        if (word.charAt(i) == '.') {
            for (int j = 0; j < 26; j++) {
                if (trie.tries[j] != null) {
                    boolean search = search(trie.tries[word.charAt(j) - 'A' + 1], word, i + 1);
                    if (search) {
                        return true;
                    }
                }

            }
        } else {
            boolean search = search(trie.tries[word.charAt(i) - 'A' + 1], word, i + 1);
            if (search) {
                return true;
            }
        }
        return false;
    }

    static class Cordinate {
        int x;
        int y;
        int count = 1;

        public Cordinate(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static class Trie {
        boolean isflag;
        Trie[] tries;

        Trie() {
            tries = new Trie[26];
            isflag = false;
        }
    }
}
