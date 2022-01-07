package cn.dunkwan.problems.problem370;

public class Solution {
    int[] diff;

    int[] nums;

    public int[] getModifiedArray(int length, int[][] updates) {
        nums = new int[length];
        diff = initDiffArray(nums);

        for (int i = 0; i < updates.length; i++) {
            diff[updates[i][0]] += updates[i][2];
            diff[updates[i][1] + 1] -= updates[i][2];
        }

        return recoverNums();

    }

    // initializing difference array
    int[] initDiffArray(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i] - nums[i - 1];
        }
        return result;
    }

    // recoverred by difference array
    int[] recoverNums() {
        int[] result = new int[diff.length];
        result[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            result[i] = result[i - 1] + diff[i];
        }
        return result;
    }

}
