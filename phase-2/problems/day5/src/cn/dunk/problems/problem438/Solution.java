package cn.dunk.problems.problem438;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {

    private Map<Character, Integer> targetMap;
    private Map<Character, Integer> windowMap;
    public List<Integer> findAnagrams(String s, String p) {
        targetMap = new HashMap<>();
        windowMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            targetMap.put(p.charAt(i), targetMap.getOrDefault(p.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int start = 0;
        int valid = 0;
        List<Integer> res = new LinkedList<>();
        while (right < s.length()) {
            // 窗口右边界移动
            Character c = s.charAt(right);
            right++;
            if (targetMap.containsKey(c)) {
                //
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                if (targetMap.get(c).equals(windowMap.get(c))) {
                    valid++;
                }
            }
            // 窗口左边界移动条件
            // 当窗口内元素个数大于等于p串时，可进行左边界移动
            while (right - left >= p.length()) {
                // 有效个数等于p串长度时，直接添加起始下标
                if (valid == targetMap.size()) {
                    start = left;
                    res.add(start);
                }
                Character d = s.charAt(left);
                left++;
                if (targetMap.containsKey(d)) {
                    if (targetMap.get(d).equals(windowMap.get(d))) {
                        valid--;
                    }
                    windowMap.put(d, windowMap.get(d) - 1);
                }
            }
        }
        return res;
    }
}
