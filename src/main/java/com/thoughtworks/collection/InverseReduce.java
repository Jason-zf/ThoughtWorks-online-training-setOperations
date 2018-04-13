package com.thoughtworks.collection;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        List<Integer>res =  IntStream.range(0, number).boxed().collect(Collectors.toList());
        Collections.reverse(res);
        return res.stream().filter(integer -> (number-integer)%random.nextInt(3)==0).collect(Collectors.toList());
    }
}
