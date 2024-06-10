package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args){
        int[] input = new int[]{1,2,3,1};

        boolean duplicate = containsDuplicate(input);
        System.out.println(duplicate);
    }

    public static boolean containsDuplicate(int[] nums){

        Set<Integer> visited = new HashSet<>();
        /*for(int num:nums){
            if(visited.contains(num)){
                return true;
            }else visited.add(num);
        }
        return false;*/

        for(int num:nums){
            if(!visited.add(num)){
                return true;
            }
        }
        return false;
    }
}

