package goodPractice;

import java.util.ArrayList;
import java.util.Scanner;

public class BitMani4Feb {
    static int i = 0;

    static void permutate(ArrayList<String> ar, String ans, boolean b[], int v) {
        if (v == 3) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < ar.size(); i++) {
            if (b[i] == false) {
                b[i] = true;
                permutate(ar, ans + ar.get(i) + "  ", b, v + 1);
                b[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Integer> ar = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the value");
            int n = sc.nextInt();
            ArrayList<String> it = new ArrayList<>();
            int sum = 0;
            while (n != 0) {
                System.out.println("Enter the value" + n);
                String next = sc.next();
                it.add(next);
                if (next.equals("A")) {
                    sum = sum + 2 ^ 4;
                } else if (next.equals("B")) {
                    sum = sum + 2 ^ 3;
                } else if (next.equals("C")) {
                    sum = sum + 2 ^ 2;
                } else if (next.equals("D")) {
                    sum = sum + 2 ^ 1;
                } else if (next.equals("E")) {
                    sum = sum + 2 ^ 0;
                }
                n--;
            }
            ar.add(sum);
        }
        skillmap(ar, 0, 0, 2 ^ 5 + 2 ^ 3 + 2 ^ 2 + 2 ^ 1 + 2 ^ 0);
    }

    static void skillmap(ArrayList<Integer> ar, int i, int value, int sum) {
        if (i == ar.size()) {
            if (value == sum) {
                System.out.println(ar);
            }
            return;
        }
        skillmap(ar, i + 1, value + ar.get(i), sum);
        skillmap(ar, i + 1, value, sum);
    }

    static void greycode(int n, String ans) {
        if (n == 0) {
            System.out.println(ans);
            return;
        }
        greycode(n - 1, 1 + ans);
        greycode(n - 1, 0 + ans);
    }

    static ArrayList<String> greycode(int n) {
        if (n == 0) {
            ArrayList<String> dc = new ArrayList<>();
            dc.add(0 + "");
            dc.add(1 + "");
            return dc;
        }
        ArrayList<String> br = greycode(n - 1);
        ArrayList<String> cr = new ArrayList<>();
        for (String it : br) {
            cr.add(0 + it);
            cr.add(1 + it);
        }
        return cr;
    }

    static void jospheous(int n) {
        int i = 1;
        int vc = 1;
        while (i * i <= n) {
            vc = i * i;
            i = i + 1;
        }
        System.out.println(i + "  " + vc);
        int dc = n - vc;
        System.out.println(dc * 2 + 1);


    }

    static void bitmanipulation() {
        int v = 31;
        int c = 0;
        while (v != 0) {
            int dx = v & -v;
            v = v - dx;
            c++;
        }
        System.out.println(c);

    }


}
