package LeetCode;



import java.util.ArrayList;
import java.util.Arrays;

public class Recursion {

    static int j = 0;
    static String pat[] = {"ABC", "DEF", "FGH", "IJK"};

    static ArrayList<Integer> decreasing(int n, ArrayList<Integer> ar) {
        if (n == 0) {
            return ar;
        }
        ar.add(n);
        ArrayList<Integer> br = decreasing(n - 1, ar);

        return br;

    }

    static void display(int n) {
        if (n == 0) {
            return;
        }

        display(n - 1);
        System.out.println(n);
    }

    static int[] arrayvalue(int n, int arr[], int i) {
        if (n == 0) {
            return arr;
        }
        arr[i++] = n;
        arr = arrayvalue(n - 1, arr, i++);
        return arr;
    }

    static void decreasingincreasing(int n, int arr[], int i) {
        if (n == 0) {
            Arrays.stream(arr).forEach(a -> System.out.print(a + "   "));
            return;
        }
        arr[i] = n;
        decreasingincreasing(n - 1, arr, i + 1);
        System.out.println(arr[i]);
    }

    static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    static int factorialw(int n, int val) {
        if (n == 0) {
            return val;
        }
        val = val * n;
        return factorialw(n - 1, val);
    }

    static int linerpow(int x, int v, int dc) {
        if (v == 0) {
            return dc;
        }
        dc = dc * x;
        return linerpow(x, v - 1, dc);
    }

    static void towerofhanoi(ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c) {
        int v = a.remove(a.size() - 1);
        b.add(v);
        towerofhanoi(a, b, c);

    }

    static void displayarray(int arr[], int i) {
        if (i == 0) {
            return;
        }
        System.out.println(arr[i]);
        displayarray(arr, i - 1);
    }

    static int maximumdisplay(int arr[], int i) {
        if (i == 0) {
            return 0;
        }
        int a = maximumdisplay(arr, i - 1);
        return Math.max(a, arr[i]);
    }

    static int findfirstoccurrence(int arr[], int i) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == 4) {
            return 2;
        }
        int b = findfirstoccurrence(arr, i + 1);
        if (b != -1) {
            return b;
        } else {
            return b;
        }
    }

    static int findfirstoccurrence1(int arr[], int i) {
        if (i == arr.length) {
            return -1;
        }

        int b = findfirstoccurrence1(arr, i + 1);
        if (arr[i] == 4) {
            return i;
        }
        if (b != -1) {
            return b;
        } else {
            return b;
        }

    }

    static int indexadd(int arr[], int i, int brr[], int k) {
        if (i == arr.length) {
            return 0;
        }

        int v = indexadd(arr, i + 1, brr, k);
        if (arr[i] == 4) {
            brr[v] = i;
            return v + 1;
        } else {
            return v;
        }
    }

    static int[] indexaddpreorder(int[] arr, int i, int[] brr, int k) {
        if (i == arr.length) {
            return brr;
        }
        if (arr[i] == 4) {
            brr[k++] = i;
        }
        brr = indexaddpreorder(arr, i + 1, brr, k);
        return brr;
    }

    static ArrayList<String> getsubsequnce(String a, int i) {
        if (a.length() == i) {
            ArrayList<String> cr = new ArrayList<>();
            cr.add("");
            return cr;
        }
        ArrayList<String> br = getsubsequnce(a, i + 1);
        ArrayList<String> dr = new ArrayList<>();
        for (String cb : br) {
            dr.add(cb + a.charAt(i));
            dr.add(cb + "");
        }
        return dr;

    }

    static ArrayList<String> getkeypad(String a, int i) {
        if (a.length() == i) {
            ArrayList<String> dr = new ArrayList<>();
            dr.add("");
            return dr;
        }
        ArrayList<String> temp = getkeypad(a, i + 1);
        ArrayList<String> rt = new ArrayList<>();
        int w = Integer.parseInt(String.valueOf(a.charAt(i)));
        String word = pat[w];
        for (int j = 0; j < word.length(); j++) {
            char wd = word.charAt(j);
            for (String it : temp) {
                rt.add(it + wd);
            }
        }
        return rt;
    }

    static ArrayList<String> stairs(int n) {
        if (n == 0) {
            ArrayList<String> tr = new ArrayList<>();
            tr.add("");
            return tr;
        }

        ArrayList<String> a = stairs(n - 1);
        ArrayList<String> b = stairs(n - 2);
        ArrayList<String> c = stairs(n - 3);
        ArrayList<String> ar = new ArrayList<>();
        for (String it : a) {
            ar.add(it + "1");
        }
        for (String it : b) {
            ar.add(it + "2");
        }
        for (String it : c) {
            ar.add(it + "3");
        }
        return ar;
    }

    static ArrayList<String> mazepath(int m[][], int x, int y) {
        if (x == m.length - 1 && y == m.length - 1) {
            ArrayList<String> dr = new ArrayList<>();
            dr.add("");
            return dr;
        }
        if (x < 0 || y < 0 || x > m.length - 1 || y > m.length - 1) {
            ArrayList<String> cr = new ArrayList<>();
            return cr;
        }
        ArrayList<String> a = mazepath(m, x, y + 1);
        ArrayList<String> b = mazepath(m, x + 1, y);
        ArrayList<String> c = new ArrayList<>();
        for (String it : a) {
            c.add(it + "V");
        }
        for (String it : b) {
            c.add(it + "H");
        }
        return c;

    }

    static ArrayList<String> diagonalmaze(int m[][], int x, int y) {
        if (x < 0 || y < 0 || x > m.length || y > m.length) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }
        if (x == m.length && y == m.length) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }
        ArrayList<String> a = new ArrayList<>();
        ArrayList<String> b = new ArrayList<>();
        ArrayList<String> c = new ArrayList<>();
        for (int i = x; i <= m.length; i++) {
            a = diagonalmaze(m, i + 1, y);
            ArrayList<String> dc = new ArrayList<>();
            for (String it : a) {
                dc.add(it + "H");
            }

        }
        for (int i = y; i <= m.length; i++) {
            b = diagonalmaze(m, x, i + 1);
            ArrayList<String> dc = new ArrayList<>();
            for (String it : b) {
                dc.add(it + "V");
            }
            return dc;
        }
        for (int i = x, j = y; i <= m.length && j <= m.length; i++, j++) {
            c = diagonalmaze(m, i + 1, j + 1);
            ArrayList<String> dc = new ArrayList<>();
            for (String it : c) {
                dc.add(it + "D");
            }
            return dc;
        }

        return null;
    }

    static void subsequnce(String a, int i, String ans) {
        if (i == a.length()) {
            System.out.println(ans);
            return;
        }
        subsequnce(a, i + 1, ans + a.charAt(i));
        subsequnce(a, i + 1, ans);
    }

    static void subsequncearray(String a, int i, String arr[], int j) {
        if (i == a.length()) {
            Arrays.stream(arr).forEach(ab -> System.out.print(ab + " "));
            System.out.println();
            return;
        }
        int f = j;
        arr[j] = String.valueOf(a.charAt(i));
        subsequncearray(a, i + 1, arr, j + 1);

        subsequncearray(a, i + 1, arr, j);
    }

    static void subsequncearraylist(String a, int i, ArrayList<String> arr) {
        if (i == a.length()) {
            arr.stream().forEach(ab -> System.out.print(ab + " "));
            System.out.println();
            return;
        }
        int f = j;
        arr.add(String.valueOf(a.charAt(i)));
        subsequncearraylist(a, i + 1, arr);
        arr.remove(arr.size() - 1);

        subsequncearraylist(a, i + 1, arr);
    }

    public static void main(String[] args) {

        subsequncearraylist("ABC", 0, new ArrayList<>());
    }
}

