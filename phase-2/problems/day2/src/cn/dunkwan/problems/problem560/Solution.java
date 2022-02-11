package cn.dunkwan.problems.problem560;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        // 定义并初始化一个前缀和数组
        int length = nums.length;
        int[] prefixSum = new int[length+1];
        for (int i = 0; i < length; i++) {
            // 计算前缀和
            prefixSum[i+1] = nums[i] + prefixSum[i];
        }

        // 通过前缀和数组中前后元素的差值来判断是否符合条件
        int n = 0;
        for (int i = 1; i < length + 1; i++) {
            for (int j = 0; j <= i; j++) {
                if (prefixSum[i] - prefixSum[j] == k) {
                    n++;
                }
            }
        }
        return n;
    }
}
