package com.yqf.athl.query;


import com.google.common.base.Preconditions;
import com.yqf.athl.utils.Utils;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 二分查找
 */
public class BinarySearch {


    public static void main(String[] args) {


        Integer[] integers = Utils.getIntegers(new Random());

//        Arrays.stream(integers).forEach(System.out::println);
        for (int i = 0; i < 100000; i++) {
            int key = new Random().nextInt(10000);
            System.out.println("要找的key" + key);
            int ortindex= Arrays.stream(integers).collect(Collectors.toList()).indexOf(key);
            System.out.println(ortindex);

            int rank = rank(integers, key);
            System.out.println(rank);

            Preconditions.checkArgument(ortindex == rank);
        }
    }

    private static int rank(Integer[] integers, int key) {


        int low = 0;
        int high = integers.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (key > integers[mid]) {
                low = mid+1;
            } else if (key < integers[mid]) {
                high = mid-1;
            } else {
                return mid;
            }

        }

        return -1;
    }

}
