package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int max = rightBorder > leftBorder ? rightBorder : leftBorder;
        int min = leftBorder < rightBorder ? leftBorder : rightBorder;
        IntStream intStream = IntStream.range(min, max + 1);
        return intStream.map(i -> i % 2 == 0 ? i : 0).reduce(0, Integer::sum);
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int max = rightBorder > leftBorder ? rightBorder : leftBorder;
        int min = leftBorder < rightBorder ? leftBorder : rightBorder;
        IntStream intStream = IntStream.range(min, max + 1);
        return intStream.map(i -> i % 2 == 1 ? i : 0).reduce(0, Integer::sum);
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(i -> 3 * i + 2).mapToInt(Integer::intValue).sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().map(integer -> integer % 2 == 1 ? integer * 3 + 2 : integer).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().map(integer -> integer % 2 == 1 ? 3 * integer + 5 : 0).mapToInt(Integer::intValue).sum();
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List<Integer> list = arrayList.stream().filter(integer -> integer % 2 == 0).collect(Collectors.toList());
        Collections.sort(list);
        return list.size() % 2 == 0 ? (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2.0 : list.get(list.size() / 2);
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        List<Integer>list =arrayList.stream().filter(integer -> integer%2==0).collect(Collectors.toList());
        return (double)list.stream().reduce(0,Integer::sum)/list.size();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        throw new NotImplementedException();
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> list = arrayList.stream().map(integer -> integer * 3).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; ++i) {
            result.add(list.get(i) + list.get(i + 1));
        }
        return result;
    }
}
