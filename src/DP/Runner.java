package DP;

public class Runner {
    public static void main(String[] args) {
     /*   DP1 dp1=new DP1();
        //System.out.println(dp1.FaboDp(5));
        int price[]={3,6,10,9,12};
        int n=5;
        System.out.println(dp1.rodCut(price,n));*/
        DP2 dp2=new DP2();
        int coins[]={8,6,1};
        int sum=13;
        System.out.println(dp2.minCoin(sum,coins));
    }
}
