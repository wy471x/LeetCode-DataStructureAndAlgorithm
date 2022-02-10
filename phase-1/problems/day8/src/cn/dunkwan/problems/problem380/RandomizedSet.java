package cn.dunkwan.problems.problem380;

import java.util.ArrayList;
import java.util.List;

public class RandomizedSet {
    List<Integer> values;

    public RandomizedSet() {
        values = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (values.contains(val)) {
            return false;
        }
        values.add(val);
        return true;
    }

    public boolean remove(int val) {
        return values.remove(Integer.valueOf(val));
    }

    public int getRandom() {
        return values.get((int)Math.random() % values.size());
    }
}
