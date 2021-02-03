package goodPractice;

import java.util.ArrayList;

public class BitMani {
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
        bitmanipulation();
    }

    static void bitmanipulation() {
        int v = 24;
        while (v != 0) {
            int dx = v & -v;

        }

        int vx = 13;
        int wx = 1 << 2;  // ~0010=  1101
        System.out.println(v & (~wx));
        //Bits off formula at particular position

        int vw = 13;
        int ww = 1 << 2;
        System.out.println(v | ww);//bits on

        System.out.println(Integer.toBinaryString(v));
        int w = (~v);
        System.out.println(Integer.toBinaryString(v & (w + 1)));
        int vd = (24 & -24);
        System.out.println(Integer.toBinaryString(vd));

    }


}
