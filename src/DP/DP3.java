package DP;

import java.util.Arrays;

public class DP3 {

    public int minimumCut(String s){
        int n=s.length();
        int dp[][]=new int[n][n];
        char ch[]=s.toCharArray();
        for(int e[]:dp){
            Arrays.fill(e,-1);
        }
        return minimumCutImpl(ch,0,n-1,dp);
    }
    public int minimumCutImpl(char ch[],int i,int j,int dp[][]){
        if(isPalindrome(ch,i,j)){
            return 0;
        }
       /* if(dp[i][j]!=-1){
            return dp[i][j];
        }*/
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            min=Math.min(min,minimumCutImpl(ch,i,k,dp)+minimumCutImpl(ch,k+1,j,dp)+1);
        }
        return dp[i][j]=min;
    }
    public boolean isPalindrome(char ch[],int i,int j){
        while(i<j){
            if(ch[i]!=ch[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        DP3 dp3=new DP3();
        String s="ababbbabbabab";
        long start=System.currentTimeMillis();
        System.out.println("start "+start);
        System.out.println(dp3.minimumCut(s));
        System.out.println("end "+System.currentTimeMillis());
        System.out.println(System.currentTimeMillis()-start);
    }
}
