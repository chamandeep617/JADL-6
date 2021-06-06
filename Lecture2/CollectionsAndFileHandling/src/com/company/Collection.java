package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Collection {

    public static HashMap<Integer,Integer> createMap(ArrayList<Integer> A){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(Integer element : A){
            if(map.containsKey(element)){
                map.put(element,map.get(element)+1);
            }else{
                map.put(element,1);
            }
        }
        return map;
    }

    public static int findDifference(ArrayList<Integer> A, int B){
        HashMap<Integer,Integer> map = createMap(A);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int element : A){
            min = Math.min(min,element);
            max = Math.max(max,element);
        }

        while(B > 0){
            if(map.get(min) < map.get(max)){
                int count = map.get(min);
                if(count > B) break;
                B -= count;

                if(map.containsKey(min+1)){
                    map.put(min+1,map.get(min)+map.get(min+1));
                }else{
                    map.put(min+1,map.get(min));
                }

                map.remove(min);
                min = min+1;
            }else{
                int count = map.get(max);
                if(count > B) break;
                B -= count;

                if(map.containsKey(max-1)){
                    map.put(max-1,map.get(max)+map.get(max-1));
                }else{
                    map.put(max-1,map.get(max));
                }
                map.remove(max);
                max = max-1;
            }

        }
        return max - min;
    }

    public static void main(String[] args) {
        System.out.println(findDifference(new ArrayList<>(Arrays.asList(2,2,3,3,4,6,7,7,9)),5));
    }
}
