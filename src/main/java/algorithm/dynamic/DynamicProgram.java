package algorithm.dynamic;

import java.util.Arrays;

/**
 * @program: practice
 * @description:
 * @author: Sansanli
 * @create: 2021-10-06 16:02
 */

public class DynamicProgram {

/*
    解决动态规划问题的核心：找出子问题及其子问题与原问题的关系

    但重叠的子问题使得直接递归会有很多重复计算，于是就想到记忆化递归法：若能事先确定子问题的范围就可以建表存储子问题的答案。

*/


    //最大回文子串
    public String longestPalindrome(String s) {

/*

        只有 s[i+1:j-1] 是回文串，并且 s 的第 i 和 j 个字母相同时，s[i:j] 才会是回文串

        上文的所有讨论是建立在子串长度大于 2 的前提之上的，
        我们还需要考虑动态规划中的边界条件，即子串的长度为 1 或 2。
        对于长度为 1 的子串，它显然是个回文串；对于长度为 2 的子串，只要它的两个字母相同，它就是一个回文串。

        因此我们就可以写出动态规划的边界条件：
        P(i,i)=true
        P(i,i+1)=(Si==Si+1)
        最终的答案即为所有 P(i,j)=true 中 j-i+1（即子串长度）的最大值

*/
        int length = s.length();
        if(length < 2) return s;
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[length][length];

        for(int i=0; i < length ;i++){
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();


        for(int L = 2; L <= length; L++){
            for(int i = 0; i < length ; i++){
                int j = i + L - 1;
                if (j >= length) break;
                if (chars[i]!=chars[j])
                    dp[i][j] = false;
                else {
                    if( j-i < 3)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i+1][j-1];
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

/*        beginIndex -- 起始索引（包括）, 索引从 0 开始。
        endIndex -- 结束索引（不包括）。*/
        return s.substring(begin,begin+maxLen);

    }

/*
    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    */

    public int maxSubArray(int[] nums) {
        int[] maxSubs = new int[nums.length];
        maxSubs[0] = nums[0] ;
        int max = nums[0];
        for(int i=1 ; i< nums.length ; i++){
            if(maxSubs[i-1] >= 0)
                maxSubs[i] = maxSubs[i-1] + nums[i];
            else {
                maxSubs[i] = nums[i];
            }
            max = Math.max(max,maxSubs[i]);
            System.out.println("i="+i+" max="+max+" maxSubs[i]=" + maxSubs[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        DynamicProgram dynamicProgram = new DynamicProgram();
        int max = dynamicProgram.maxSubArray(nums);
        System.out.println("last max is: " + max);
    }
}
