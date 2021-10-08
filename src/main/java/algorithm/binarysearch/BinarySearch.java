package algorithm.binarysearch;

/**
 * @program: practice
 * @description:
 * @author: Sansanli
 * @create: 2021-10-06 14:13
 */

public class BinarySearch {


  /*  给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
*/
    public int binarySearch(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid = (right + left) / 2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }

/*
    二分查找是一种在每次比较之后将查找空间一分为二的算法。每次需要查找集合中的索引或元素时，都应该考虑二分查找。如果集合是无序的，我们可以总是在应用二分查找之前先对其进行排序。
    二分查找一般由三个主要部分组成：
    预处理 —— 如果集合未排序，则进行排序。
    二分查找 —— 使用循环或递归在每次比较后将查找空间划分为两半。
    后处理 —— 在剩余空间中确定可行的候选者。

    模版一：
    int binarySearch(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length - 1;
        while(left <= right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){ return mid; }
            else if(nums[mid] < target) { left = mid + 1; }
            else { right = mid - 1; }
        }

        // End Condition: left > right
        return -1;
    }

初始条件：left = 0, right = length-1
终止：left > right
向左查找：right = mid-1
向右查找：left = mid+1

    */



/*    题目： 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。

    由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。*/

    public int mySqrt(int x) {
        if(x<2) return x;
        int min = 1;
        int max = x;
        while (min <= max){
            int mid = ( min + max ) / 2;
            int v = x/mid;
            if(v==mid) return mid;
            if(v<mid) max = mid - 1;
            if(v>mid) min = mid + 1;
        }
        return max;
    }

/*
    给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
    假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
    你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
    */

    public int findDuplicate(int[] nums) {
/*
        二分查找的思路是先猜一个数（有效范围 [left..right] 里位于中间的数 mid），然后统计原始数组中 小于等于 mid 的元素的个数 cnt
*/
        int length = nums.length;
        int max = length-1;
        int min = 1;

        while (min<max){
            int mid = (min+max)/2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count += 1;
                }
            }
            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个，此时重复元素一定出现在 [1..4] 区间里
            if (count > mid) {
                // 重复元素位于区间 [left..mid]
                max = mid;
            } else {
                // if 分析正确了以后，else 搜索的区间就是 if 的反面区间 [mid + 1..right]
                min = mid + 1;
            }
        }
        return min;
    }




    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();

        int[] nums = new int[]{-9,0,3,5,7,8,10,14,24,45,53};
        int pos = binarySearch.binarySearch(nums,8);
        System.out.println("Pos is:"+pos);
    }
}
