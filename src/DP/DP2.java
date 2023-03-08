package DP;

import java.util.Arrays;

public class DP2 {
    public int minCoin(int sum,int coins[]){
        int dp[]=new int[sum+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        minCoinImpl(sum,coins,dp);
        return dp[sum];
    }
    public int minCoinImpl(int n,int coins[],int dp[]){
        if(n<0){
            return Integer.MAX_VALUE;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            min=Math.min(min,minCoinImpl(n-coins[i],coins,dp));
        }
        dp[n]=min+1;
        return dp[n];
    }
}
