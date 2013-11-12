package com.ptit.exam.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * User: thuongntt
 * Date: 11/12/13
 * Time: 12:37 AM
 */
public class NumberManager {
    public static Random random = new Random();

    public static int getRandomNumber(int maximum) {
        return random.nextInt(maximum);
    }

    public static List<Integer> getListRandomNumber(int count, int maximum) {
        List<Integer> intList = new ArrayList<Integer>();
        while (intList.size() < count) {
            boolean isDupplicate = false;
            int number = getRandomNumber(maximum);
            for (Integer integer : intList) {
                if (number == integer) {
                    isDupplicate = true;
                    break;
                }
            }
            if (!isDupplicate) {
                intList.add(number);
            }
        }
        return intList;
    }
}


