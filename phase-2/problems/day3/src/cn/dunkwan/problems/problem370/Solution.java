package cn.dunkwan.problems.problem370;

public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] nums = new int[length];
        Difference difference = new Difference(nums);
        difference.calc(updates);
        return difference.result();
    }

    class Difference {
        private int[] diff;
        private int[] res;

        public Difference(int[] nums) {
            int length = nums.length;
            diff = new int[length];
            diff[0] = nums[0];

            for (int i = 1; i < length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        public void calc(int[][] updates) {
            int length = diff.length;
            for (int[] update : updates) {
                diff[update[0]] += update[2];
                if (update[1] + 1 < length) {
                    diff[update[1] + 1] -= update[2];
                }
            }
        }

        public int[] result() {
            int length = diff.length;
            res = new int[length];
            res[0] = diff[0];
            for (int i = 1; i < length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }
}
