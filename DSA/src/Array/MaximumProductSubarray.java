package Array;

public class MaximumProductSubarray {

    public static void main(String[] args){
        int[] input = new int[]{0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0};
        int max = maxProdSubArray(input);
        System.out.println(max);

    }

    public static int maxProdSubArray(int[] nums){
        int n = nums.length;
        int leftProduct = 1;
        int rightProduct=1;
        int ans=nums[0];

        for(int i=0;i<n;i++){
            leftProduct = leftProduct ==0?1:leftProduct;
            rightProduct = rightProduct ==0?1:rightProduct;

            leftProduct = leftProduct * nums[i];
            rightProduct=rightProduct*nums[n-1-i];

            ans=Math.max(ans,Math.max(rightProduct,leftProduct));
        }
        return ans;
        /*int ans=nums[0];
        int min=1;
        int max=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                min=1;
                max=1;
                ans=Math.max(ans,nums[i]);
                continue;
            }
            int temp=min;
            min = Math.min(nums[i], Math.min(min*nums[i],max*nums[i]));
            max = Math.max(nums[i], Math.max(temp*nums[i],max*nums[i]));
            ans=Math.max(ans,max);
        }
        return ans;*/
    }
}
