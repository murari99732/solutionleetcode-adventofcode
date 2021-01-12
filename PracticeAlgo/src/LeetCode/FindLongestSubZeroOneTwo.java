package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindLongestSubZeroOneTwo {
    

    static void longestsubarrayonetwozero(int arr[]) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> zero= new HashMap<>();
        HashMap<Integer, Integer> one=new HashMap<>();
        HashMap<Integer, Integer> two= new HashMap<>();
        zero.put(0,0);
        zero.put(1,0);
        zero.put(2,0);
        for (int i = 0; i < arr.length; i++) {
            zero.put(arr[i],zero.getOrDefault(arr[i], 0)+1);
            int i1 = zero.get(2) - zero.get(1);
            int i2=zero.get(1)-zero.get(0);
           if(map.containsKey(i2+"##"+i1))
           {
               System.out.println(map.get(i2+"##"+i1)+"   "+i);
           }
           else
           {
               map.put(i2+"##"+i1,i);
           }

        }
    }

    public static void main(String[] args) {
        longestsubarrayonetwozero(new int[]{1,1,2,0,1,0,1,2,1,2,2,0,1});
    }

   
}





