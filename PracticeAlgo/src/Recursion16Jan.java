

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Recursion16Jan {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ar= new ArrayList<>();
        for(int i=0;i<3;i++)
        {
           ar.add(new ArrayList<>());
        }
        kpartitionvalue(ar,0,0);
    }

    static void kpartitionvalue(ArrayList<ArrayList<Integer>>  arrayList, int ssf, int n)
    {
        if(n==5)
        {
            System.out.println(arrayList);
            return;
        }
        for(int i=0;i<3;i++)
        {
            if(arrayList.get(i).size()>0)
            {
                arrayList.get(i).add(n);
                kpartitionvalue(arrayList, ssf,n+1);
                arrayList.get(i).remove(arrayList.get(i).size()-1);

            }
            else
            {
                arrayList.get(i).add(n);
                kpartitionvalue(arrayList,ssf+1,n+1);
                arrayList.get(i).remove(arrayList.get(i).size()-1);
           
            }
        }
    }
}

