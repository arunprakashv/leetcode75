package Array;

public class TimeToBuySellStock {

    public static void main(String[] args){
        int[] input = new int[]{7,1,5,3,6,4};

        int profit = maxProfit(input);
        System.out.println(profit);
    }


    public static int maxProfit(int[] prices) {
        int profit = 0;
        if(prices.length==0) return profit;

        int minPrice=prices[0];

        for(int price:prices){
            if(price>minPrice){
                if((price-minPrice) > profit){
                    profit = price-minPrice;
                }
            }else minPrice=price;
        }
        return profit;
    }
}
