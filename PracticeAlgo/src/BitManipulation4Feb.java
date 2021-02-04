package goodPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BitManipulation4Feb {
    public static final int FIVE_SECONDS = 5000;
    public static final int MAX_Y = 400;
    public static final int MAX_X = 400;
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
        findthree(new int[]{1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 4,4,5,10, 10, 10});
    }
    static  void flip(int a, int b)
    {
        
    }

    static void findthree(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum ^ arr[i];
        }
        int s = 0;
        int pc = 0;
        while (sum != 0) {
            int v = 0;
            for (int i = 0; i < arr.length; i++) {
                if ((arr[i] & (1 << pc)) != 0) {
                    v++;
                }
            }
            if (v % 3 != 0) {
                s = s | 1 << pc;
            }
            pc++;
            int dc = sum & -sum;
            sum = sum - dc;
        }
        System.out.println(s);
    }

    static void permuattion(String word, int i, String ans, int bc) {
        if (i == word.length()) {
            System.out.println(ans + " " + bc);
            return;
        }
        if (bc > 0) {
            permuattion(word, i + 1, ans + bc + word.charAt(i), 0);
            permuattion(word, i + 1, ans, bc + 1);
        } else {
            permuattion(word, i + 1, ans + word.charAt(i), 0);
            permuattion(word, i + 1, ans, bc + 1);
        }
    }

    static void xoraddsum(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum ^ (2 * arr[i]);

        }
        System.out.println(sum);
    }

    static void samenumbeofbits(int n, int arr[], int sum) {
        if (n == 5) {

            System.out.println(sum);
            System.out.println();
            return;
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 0) {
                arr[j] = 1;
                samenumbeofbits(n + 1, arr, sum | 1 << j);
                arr[j] = 0;
            }
        }

    }

    static void nsetbits(int n) {

        int count = 0;
        while (n != 0) {
            int w = n & -n;
            n = n ^ w;
            count++;
        }
        System.out.println(count);

        for (int i = 0; i < 12; i++) {
            int count1 = 0;
            int f = i;
            while (f != 0) {
                int w = f & -f;
                f = f ^ w;
                count1++;
            }
            if (count1 == count) {
                System.out.println(i);
            }
        }
    }

    static void reducenumber(int n) {
        int count = 0;
        while (n != 1) {
            if (n == 1) {

            } else if (n == 2) {
                n = n - 1;
            } else if (n == 3) {
                n = n - 1;
            } else if ((n & 3) == 3) {
                n = n + 1 / 2;
            } else if ((n & 3) == 1) {
                n = n - 1 / 2;
            }


        }

    }

    static void allrepeating(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum ^ arr[i];
        }

        int v = sum & -sum;
        int vw = 0;
        Map<Boolean, Integer> map = new HashMap<>();
        while (vw < arr.length) {
            int d = arr[vw] & v;
            if (d == 0) {
                if (map.containsKey(false)) {
                    map.put(false, map.get(false) ^ arr[vw]);
                } else {
                    map.put(false, arr[vw]);
                }
            } else {
                if (map.containsKey(true)) {
                    map.put(true, map.get(true) ^ arr[vw]);
                } else {
                    map.put(true, arr[vw]);
                }
            }
            vw++;
        }

        System.out.println(map);
    }

    static void numberofvalidwords() {
        Scanner sc = new Scanner(System.in);
        HashMap<Character, Integer> map = new HashMap<>();

        int d = 1;
        for (int i = 0; i < 6; i++) {
            System.out.print("Enter the string:  " + i + " ");
            String abc = sc.next();
            for (int j = 0; j < abc.length(); j++) {
                if (!map.containsKey(abc.charAt(j))) {
                    map.put(abc.charAt(j), d);
                    d++;
                }
            }
            System.out.println();
        }
        System.out.println(map);
        ArrayList<String> ar = new ArrayList<>();
        ar.add("above");
        ar.add("ghsij");
        ar.add("klmsd");
        ar.add("rstuajk");
        validwords(ar, map, 0, 0);
    }

    private static void validwords(ArrayList<String> ar, HashMap<Character, Integer> map, int i, int count) {
        for (int j = 0; j < ar.size(); j++) {
            String dc = ar.get(i);
            boolean flag = true;
            for (int k = 0; k < dc.length(); k++) {
                if (map.containsKey(dc.charAt(k)) && map.get(dc.charAt(k)) < 0) {
                    Integer integer = map.get(dc.charAt(k));
                    map.put(dc.charAt(k), integer - 1);
                } else {
                    flag = false;
                    break;

                }
            }
            if (flag == false) {
                validwords(ar, map, i + 1, count + 1);
            }

        }
    }

    static void skillmap(int people[], int i, int sum, int val) {
        if (i == 4) {
            if (sum == 31) {
                System.out.println(val);
            }
            return;
        }
        skillmap(people, i + 1, sum | people[i], val * 10 + people[i]);
        skillmap(people, i + 1, sum, val);
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
