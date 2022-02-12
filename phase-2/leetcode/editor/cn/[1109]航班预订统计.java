//这里有 n 个航班，它们分别从 1 到 n 进行编号。 
//
// 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 
//firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。 
//
// 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。 
//
// 
//
// 示例 1： 
//
// 
//输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
//输出：[10,55,45,25,25]
//解释：
//航班编号        1   2   3   4   5
//预订记录 1 ：   10  10
//预订记录 2 ：       20  20
//预订记录 3 ：       25  25  25  25
//总座位数：      10  55  45  25  25
//因此，answer = [10,55,45,25,25]
// 
//
// 示例 2： 
//
// 
//输入：bookings = [[1,2,10],[2,2,15]], n = 2
//输出：[10,25]
//解释：
//航班编号        1   2
//预订记录 1 ：   10  10
//预订记录 2 ：       15
//总座位数：      10  25
//因此，answer = [10,25]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2 * 10⁴ 
// 1 <= bookings.length <= 2 * 10⁴ 
// bookings[i].length == 3 
// 1 <= firsti <= lasti <= n 
// 1 <= seatsi <= 10⁴ 
// 
// Related Topics 数组 前缀和 👍 307 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        Difference difference = new Difference(nums);
        difference.calc(bookings);
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
                diff[update[0] - 1] += update[2];
                if (update[1] < length) {
                    diff[update[1]] -= update[2];
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
//leetcode submit region end(Prohibit modification and deletion)
