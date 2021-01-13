package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class Recursion {

    static int j = 0;

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


    public static void main(String[] args) {
        int ab[] = new int[5];
        int a = indexadd(new int[]{2, 3, 4, 5, 6, 4, 7, 8, 4}, 0, ab, 0);
        Arrays.stream(ab).forEach(b -> System.out.print(b + " "));
        System.out.println();
        int[] indexaddpreorder = indexaddpreorder(new int[]{2, 3, 4, 5, 6, 4, 7, 8, 4}, 0, new int[5], 0);
        Arrays.stream(indexaddpreorder).forEach(b -> System.out.print(b + " "));
    }
}
