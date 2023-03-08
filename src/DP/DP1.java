package DP;

import java.util.Arrays;

public class DP1 {
    public int FaboDp(int n){
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1]=1;
        FaboDpUtil(n,dp);
        return dp[n];
    }
    public int FaboDpUtil(int n,int dp[])
    {
        if(dp[n]!=-1){
            return dp[n];
        }
        /*if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }*/
        int first=FaboDpUtil(n-1,dp);
        int second=FaboDpUtil(n-2,dp);
        dp[n]=first+second;
        return dp[n];
    }
    public int rodCut(int price[],int n){
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        rodCutDp(price,n,dp);
        return dp[n];
    }
    public int rodCutDp(int price[],int n,int d[])
    {
        if(n<0){
            return Integer.MIN_VALUE;
        }
        if(d[n]!=-1){
            return d[n];
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<price.length;i++)
        {
            int value=rodCutDp(price,n-i-1,d);
            max=Math.max(max,price[i]+value);
        }
        d[n]=max;
        return d[n];
    }
}
