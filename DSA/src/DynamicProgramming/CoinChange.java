package DynamicProgramming;

public class CoinChange {
    public static void main(String[] args){
        int[] nums = new int[]{1,2,5};
        int amount = 5;
        int count = coinChange(nums, amount);
        System.out.println(count);
    }
    public static int coinChange(int[] nums, int amount){
        if(amount < 1) return 0;
        int[] minAmountEach = new int[amount+1];
        for(int i=1;i<amount+1;i++){
            minAmountEach[i]=Integer.MAX_VALUE;
            for(int coin: nums){
                if(coin<=i && minAmountEach[i-coin]!=Integer.MAX_VALUE){
                    minAmountEach[i]=Math.min(minAmountEach[i], 1+minAmountEach[i-coin]);
                }
            }
        }
        if(minAmountEach[amount]==Integer.MAX_VALUE) return -1;
        return minAmountEach[amount];
    }
}
