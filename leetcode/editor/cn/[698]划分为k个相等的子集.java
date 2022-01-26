//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 
//
// 示例 1： 
//
// 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 
// Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩 👍 484 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 排除以下情况
        // 1. 被平分成的子集数K > 数组长度
        if (k > nums.length) return false;
        // 2. 数组总和无法被子集数整除
        int sum = 0;
        for(int v : nums) {
            sum += v;
        }
        if (sum % k != 0) return false;

        int target = sum / k;
        int[] buckets = new int[k];
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return backtrack(nums, 0, buckets, target);
    }

    private boolean backtrack(int[] nums, int index, int[] buckets, int target) {
        if (index == nums.length) {
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] != target) return false;
            }
            return true;
        }

        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] + nums[index] > target) continue;

            buckets[i] += nums[index];
            if (backtrack(nums, index + 1, buckets, target)) return true;
            buckets[i] -= nums[index];
        }
        return false;
    }





}
//leetcode submit region end(Prohibit modification and deletion)
