package com.yqf.athl.utils;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class Utils {
    public static Integer[] getIntegers(Random random) {
        ArrayList<Integer> ints = Lists.newArrayList();
        int i1 = 10000;
        for (int i = 0; i < i1; i++) {
            ints.add(random.nextInt(10000));
        }
        return ints.stream().collect(Collectors.<Integer>toSet()).stream().collect(Collectors.toList()).toArray(new Integer[]{});
    }
}
