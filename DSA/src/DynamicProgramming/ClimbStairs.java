package DynamicProgramming;

public class ClimbStairs {

    public static void main(String[] args){
        int stairs = 45;
        int steps = climbStairs(stairs);
        System.out.println(steps);
    }
    public static int climbStairs(int n){
        /*if(n==0 || n==1 ) return 1;
        return climbStairs(n-1) + climbStairs(n-2);*/
        int first =1;
        int second=2;

        if(n<=2) return n;
        for(int i =0;i<n-2;i++){
            int tmp = first + second;
            first=second;
            second=tmp;
        }
        return second;
    }
}
