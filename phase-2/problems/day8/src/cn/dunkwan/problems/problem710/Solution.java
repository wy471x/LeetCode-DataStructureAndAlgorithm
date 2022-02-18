package cn.dunkwan.problems.problem710;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Solution {

    Random random = new Random();
    int n;
    List<Integer> nums;

    public Solution(int n, int[] blacklist) {
        this.n = n;
        nums = Arrays.stream(blacklist).boxed().collect(Collectors.toList());
    }

    public int pick() {
        int res = random.nextInt(n - 1);
        while (nums.contains(res)) {
            res = random.nextInt(n - 1);
        }
        return res;
    }
}
