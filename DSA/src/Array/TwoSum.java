package Array;

import java.util.*;


public class TwoSum {


    public static void main(String[] args){
        int[] input = new int[]{10, 15, 20, 25, 30};
        int target = 45;
        int[] sum = twoSum(input, target);
        System.out.println(sum[0] +","+sum[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int num = target - nums[i];
            if(map.containsKey(num)){
                return new int[]{i,map.get(num)};
            }else{
                map.put(nums[i],i);
            }
        }
        return new int[]{};
    }
}
