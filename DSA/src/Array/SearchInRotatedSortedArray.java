package Array;

public class SearchInRotatedSortedArray {

    public static void main(String[] args){
        int[] input = new int[]{3,1};
        int target = 1;
        int index = searchInRotatedSortedArray(input, target);
        System.out.println(index);

    }

    public static int searchInRotatedSortedArray(int[] nums,int target){
        int index = -1;
        int n = nums.length;
        int start = 0;
        int end = n-1;

        while(start<=end){
            int mid = (start+end)/2;
            if(target==nums[mid]) return mid;
            if(nums[start]<=nums[mid]){
                if(target>=nums[start]&&target<nums[mid]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }else{
                if(target>nums[mid]&&target<=nums[end]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
        }
     return index;
    }
}
