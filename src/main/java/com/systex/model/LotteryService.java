package com.systex.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

public class LotteryService {


    private Random random = new Random();


    public ArrayList<Integer>[] getNumber(int groups, LinkedList<Integer> excludes) {
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] result = new ArrayList[groups]; 

        for (int i = 0; i < groups; i++) {
            result[i] = generateNumbers(excludes); 
        }

        return result;
    }


    private ArrayList<Integer> generateNumbers(LinkedList<Integer> excludes) {
        Set<Integer> numbers = new HashSet<>(); 
        while (numbers.size() < 6) { 
            int randomNumber = random.nextInt(49) + 1; 
            if (!excludes.contains(randomNumber)) { 
                numbers.add(randomNumber); 
            }
        }
        return new ArrayList<>(numbers); 
    }
}
