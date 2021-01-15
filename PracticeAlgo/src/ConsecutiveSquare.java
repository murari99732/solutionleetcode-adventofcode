

import java.util.ArrayList;
import java.util.HashMap;

public class ConsecutiveSquare {

    public static void main(String[] args) {
        //n ->will be starting point
        // size-> size of sequence
        //range-> range for which you want to find means value should include between 1 to 30
        //check-> so that now value should be repeated so
        
        //if you want to repeat value just remove boolean flag it will work and put all if else into one code
        getvalue(0,15, new ArrayList<>(),20,new boolean[20]);
    }
    static void getvalue(int n, int size, ArrayList<Integer> ar, int range, boolean check[]) {
        if(n==size)
        {
            System.out.println(ar);
            return;
        }
        for (int i = 1; i < range; i++) {
            if (ar.size() == 0) {
                ar.add(i);
                check[i] = true;
                getvalue(n+1,size, ar,range, check);
                check[i] = false;
            }
            else if(check[i]==false)
            {
                int val=ar.get(ar.size()-1);
                if(checkPerfectSquare(val+i))
                {
                    check[i]=true;
                    ar.add(i);
                    getvalue(n+1,size, ar,range, check);
                    ar.remove(ar.size()-1);
                    check[i]=false;
                }
            }
        }
    }
    static boolean checkPerfectSquare(double x)
    {
        double sq = Math.sqrt(x);
        return ((sq - Math.floor(sq)) == 0);
    }

}

