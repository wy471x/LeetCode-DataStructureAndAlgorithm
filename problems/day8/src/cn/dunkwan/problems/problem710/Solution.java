package cn.dunkwan.problems.problem710;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Solution {
    int sz;
    Map<Integer, Integer> map;
    Random random = new Random();

    public Solution(int n, int[] blacklist) {
        map = new HashMap<>();
        sz = n - blacklist.length;

        for (int b : blacklist) {
            map.put(b, 666);
        }

        int last = n - 1;
        for (int b : blacklist) {
            if (b >= sz) {
                continue;
            }

            while (map.containsKey(last)) {
                last--;
            }
            map.put(b, last);
            last--;
        }
    }

    public int pick() {
        int index = random.nextInt(sz);
        if (map.containsKey(index)) {
            return map.get(index);
        }
        return index;
    }
}
