package goodPractice;

import java.util.*;

public class PracticeFEB6 {
    public static final int FIVE_SECONDS = 5000;
    public static final int MAX_Y = 400;
    public static final int MAX_X = 400;
    static int i = 0;
    static int count = 0;

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

    public static int removeDuplicates(int[] nums) {
        int temp[] = nums.clone();
        int count = 0;
        int i = 0;
        int k = 0;
        while (i < temp.length) {
            if (i + 1 < temp.length && temp[i] == temp[i + 1]) {
                while (i + 1 < temp.length && temp[i] == temp[i + 1]) {
                    i++;
                }
                nums[k++] = temp[i];
                i++;
                count++;
            } else {
                nums[k++] = temp[i];
                count++;
                i++;
            }
        }
        System.out.print(count);
        return count;

    }

    static long inversionCount(long arr[], long N) {
        long i = 0l;
        long j = N - 1l;
        while (i < j) {
            if ((long) arr[(int) i] > (long) arr[(int) j]) {
                return j - i + 1;
            }
            j--;
        }
        return 0;
    }

    static long countPairs(int x[], int y[], int n, int m) {
        Arrays.sort(x);
        Arrays.sort(y);

        int i = 0;
        int j = m;
        int v = 0;
        long count = 0;
        while (i < n) {
            int k = m - 1;
            while (k >= 0) {
                while (v < n) {
                    long dx = (long) Math.pow(x[i], y[k]);
                    long dy = (long) Math.pow(y[k], x[v]);
                    if (dx > dy) {
                        count++;
                    }
                    v++;
                }
                k--;
            }
            i++;


        }
        return count;

    }

    static int countTriplet(int arr[], int n) {
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        int count = 0;
        while (i < j) {
            int k = j - 1;
            int sum = 0;
            int v = i;

            while (v < k) {
                if (arr[v] + arr[k] == arr[j]) {
                    count++;
                    v++;
                    k--;
                } else if (arr[v] + arr[k] < arr[j]) {
                    v++;
                } else if (arr[v] + arr[k] > arr[j]) {
                    k--;
                }
            }
            j--;

        }
        return count;

    }

    static void bitget(int arr[]) {
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            n = n | arr[i];
        }

        int p = 0;
        int count = 0;
        while (n != 0) {
            int sumo = 0;
            int sum1 = 0;
            for (int i = 0; i < arr.length; i++) {
                int v = 1 << p;
                if ((arr[i] & v) == 0) {
                    sumo = sumo + 1;
                } else {
                    sum1 = sum1 + 1;
                }
            }
            int d = sum1 * sumo * 2;
            count = count + d;
            p++;
            int gh = p & -p;
            p = p - gh;
        }
    }

    static void swap(int n) {
        int w = n << 1;
        int t = n >> 1;
    }

    static void solve(int n) {
        int v = ((n << 3) - n) >> 3;
        System.out.println(v);

    }

    static void copysets(int start, int end, int first, int second) {
        while (start < end) {
            int p = first & (1 << start);
            if (p != 0) {
                second = second | 1 << start;
            } else {
                second = second & (~(1 << start));
            }
            start++;
        }
        System.out.println(Integer.toBinaryString(second));
    }

    static void poweroftwo(int n) {
        int v = n & -n;
        n = n - v;
        if (n != 0) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }

    static void counthrice(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum ^ arr[i];
        }
        int p = 0;
        int add = 0;
        ArrayList<Integer> ar = new ArrayList<>();
        while (sum != 0) {
            int v = sum & -sum;
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                int w = arr[i] & (1 << p);
                if (w != 0) {
                    count++;
                }
            }
            if (count % 3 != 0)
                add = add | 1 << p;

            p++;
            sum = sum - v;
        }
        System.out.println(add);

    }

    private static void sumxor(int[] ints) {
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum = sum ^ (ints[i] << 1);
        }
        System.out.println(sum);
    }

    static void countze(int n) {
        int count = 0;
        while (n != 0) {
            if (n == 2) {
                n = 1;
                count++;
            } else if (n == 1) {
                n = 0;
                count++;
            } else if (n == 3) {
                n = 2;
                count++;
            } else if ((n & 3) == 1) {
                n = (n - 1) >> 2;
                count++;
            } else if ((n & 3) == 3) {
                n = (n + 1) >> 2;
                count++;
            } else if (n % 2 == 0) {
                n = n >> 1;
                count++;
            }
        }
        System.out.println(count);
    }

    static void counttriplets(int arr[]) {
        Arrays.sort(arr);
        int i = 0;
        int sum = 0;
        int j = arr.length - 1;
        int count = 0;
        while (i < j) {
            int f = i;
            int d = j - 1;
            while (f < d) {
                if (arr[f] + arr[d] == arr[j]) {
                    System.out.println(arr[f] + " " + arr[d] + "  " + arr[j]);
                    f++;
                    d--;
                    count++;
                } else if (arr[f] + arr[d] > arr[j]) {
                    f++;
                } else if (arr[f] + arr[d] > arr[j]) {
                    d--;
                }
            }
            j--;
        }
    }

    static void allrepating(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum ^ arr[i];
        }

        int sumv = 0;
        int sumb = 0;
        for (int i = 0; i < arr.length; i++) {
            int v = sum & -sum;
            if (arr[i] - v == 0) {
                sumv = sumv ^ arr[i];
            } else {
                sumb = sumb ^ arr[i];
            }
        }
    }

    private static void minimumnumberofdev(ArrayList<Integer> ar, int i, int sum) {
        if (i == ar.size()) {
            if (sum == (1 << ar.size() - 1)) {
                System.out.println(sum);
            }
        }
        minimumnumberofdev(ar, i + 1, sum | ar.get(i));
        minimumnumberofdev(ar, i, sum);
    }

    static void kenghin(int n) {
        int count = 0;
        while (n != 0) {
            int v = n & -n;
            n = n - v;
            count++;
        }
        System.out.println(count);
    }

    static void rightmostbit(int n) {
        System.out.println(Integer.toBinaryString(n));
        int v = (~n);
        int w = v + 1;
        System.out.println(Integer.toBinaryString(w & n));
    }

    static void bitmanip(int n) {
        int v = ~n;
        System.out.println(Integer.toBinaryString(v));
        System.out.println(Integer.toBinaryString(1 >>> 3));
    }

    static void minimumxor(int arr[]) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int sum = arr[i] ^ arr[i + 1];
            System.out.println(sum);
        }
    }

    static void reverse(int n) {
        boolean flag = false;
        int np = 0;
        int sum = 0;
        for (int i = 31; i >= 0; i--) {

            if (flag == true) {
                if ((n & (1 << i)) != 0) {
                    sum = sum | 1 << np;
                    np++;
                } else {
                    np++;
                }

            } else if ((n & (1 << i)) != 0) {
                flag = true;
                sum = sum | 1 << np;
                np++;
            }

        }
        System.out.println(Integer.toBinaryString(sum));
        System.out.println(Integer.toBinaryString(n));
    }

    static void countbits(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            int v = i;
            while (v != 0) {
                int vc = v & -v;
                v = v - vc;
                count++;

            }
        }
        System.out.println(count);
    }

    static void counteven(int arr[]) {
        int value = 0;
        for (int i = 0; i < arr.length; i++) {
            value = value ^ arr[i];
        }
        int p = 0;
        int sum = 0;
        while (value != 0) {
            int countz = 0;
            int counto = 0;
            for (int i = 0; i < arr.length; i++) {
                int d = arr[i] & (1 << p);
                if (d == 0) {
                    countz++;
                } else {
                    counto++;
                }
            }
            sum = sum + counto * countz * 2;


            int f = value & -value;
            p++;
            value = value - f;
        }
        System.out.println(sum);
    }

    static void countodd(int arr[]) {
        int value = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int sum = arr[i] ^ arr[j];
                while (sum != 0) {
                    int v = sum & -sum;
                    sum = sum - v;
                    value++;
                }

            }
        }
        System.out.println(value);
    }

    static void swapoddeven(int n) {
        int v = 0XAAAAAAAA;
        int w = 0X55555555;
        int ev = v & n;
        int fr = v & w;
        ev = ev << 1;
        fr = fr >> 1;
        System.out.println(ev | fr);
    }

    static void divide(int n) {

        System.out.println(((n << 3) - n) >> 3);
        System.out.println(n >> 3);
    }

    static void powertwo(int pow) {
        int count = 0;
        while (pow != 0) {
            int dc = pow & -pow;
            pow = pow - dc;
            count++;
        }
        if (count == 1) {
            System.out.println("true");
        }
    }

    static void copyset(int a, int b, int ec, int fc) {
        System.out.println(Integer.toBinaryString(a) + "  " + Integer.toBinaryString(b));
        int p = fc;
        while (p <= ec) {
            int w = 1 << p;

            int dc = a & w;
            if (dc != 0) {
                b = b | w;
            }
            p++;
        }
        System.out.println(Integer.toBinaryString(a) + "  " + Integer.toBinaryString(b));
        System.out.println(b);

    }

    static void flip(int a, int b) {
        int w = a ^ b;
        int pc = 0;
        int count = 0;
        while (w != 0) {
            int dc = 1 << pc;
            if ((w | dc) != (b | dc)) {
                count++;
            }
            int wc = w & -w;
            w = w - wc;
        }
        System.out.println(count);
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

    public static void main(String[] args) {

    }

    public static int maxProfit(int[] prices, int sum, int i, boolean isafe, HashMap<String, Integer> map) {
        if (prices.length == i) {
            count = Math.max(count, sum);
            return count;
        }
        if (map.containsKey(prices[i] + "##" + sum)) {
            return map.get(prices[i] + "##" + sum);
        }
        if (isafe == true) {
            int b = maxProfit(prices, sum - prices[i], i + 1, false, map);
            int c = maxProfit(prices, sum, i + 1, true, map);
        } else {
            maxProfit(prices, sum + prices[i], i + 1, true, map);
            maxProfit(prices, sum, i + 1, false, map);
        }

    }


}
