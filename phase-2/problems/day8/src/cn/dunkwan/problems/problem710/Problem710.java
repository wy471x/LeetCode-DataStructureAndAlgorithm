package cn.dunkwan.problems.problem710;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Problem710 {
    public static void main(String[] args) {
//        Random random = new Random();
//        int[] values = new int[]{2, 3};
//        List<Integer> nums = Arrays.stream(values).boxed().collect(Collectors.toList());
//        int res = random.nextInt(5);
//        while (nums.contains(res)) {
//            res = random.nextInt(5);
//        }
//        System.out.println(res);
        int[] nums = new int[]{2, 3, 5};
        Solution solution = new Solution(7, nums);
        System.out.println(solution.pick());
    }
}
