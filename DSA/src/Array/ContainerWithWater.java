package Array;

import java.util.List;

public class ContainerWithWater {

    public static void main(String[] args){
        //int[] input = new int[]{1,8,6,2,5,4,9,3,7};
        int[] input = new int[]{2,3,4,5,18,17,6};
        //int[] input = new int[]{1,1};
        int area = containerWithWater(input);
        System.out.println(area);
    }

    public static int containerWithWater(int[] height){

        int left=0;
        int right=height.length-1;
        int area=0;

        while(left<right){
            int temparea = ((right-left)*Math.min(height[left],height[right]));
            /*if(height[left]<height[right]){
                left++;
            }else right--;*/
            int distance = (height[left]<height[right])? left++:right--;
            area=(temparea>area)?temparea:area;
        }
        return area;
    }
}
