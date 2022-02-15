package cn.dunk.problems.problem438;

import java.util.List;

public class Problem438 {
    public static void main(String[] args) {
        String s = "baa", p = "aa";
        Solution solution = new Solution();
        List<Integer> anagrams = solution.findAnagrams(s, p);
        for (Integer num : anagrams) {
            System.out.println(num);
        }
    }
}
