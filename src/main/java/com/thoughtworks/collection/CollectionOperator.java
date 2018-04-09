package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        if (left < right) {
            IntStream intStream = IntStream.range(left, right + 1);
            return intStream.boxed().collect(Collectors.toList());
        }
        IntStream intStream = IntStream.range(right, left + 1);
        List<Integer> res = intStream.boxed().collect(Collectors.toList());
        Collections.reverse(res);
        return res;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        return getListByInterval(left, right).stream().filter(integer -> integer % 2 == 0).collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).boxed().filter(integer -> integer%2==0).collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length-1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> list= Arrays.stream(secondArray).boxed().collect(Collectors.toList());
        return Arrays.stream(firstArray).boxed().filter(integer -> list.contains(integer)).collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> res=Arrays.stream(firstArray).collect(Collectors.toList());
        res.addAll(Arrays.asList(secondArray));
        return res.stream().distinct().collect(Collectors.toList());
    }
}
