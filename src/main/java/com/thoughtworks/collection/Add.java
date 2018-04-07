package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        int sum = (min % 2) == 1 ? min : min + 1;
        for (int i = sum + 2; i < max; i += 2) {
            sum += i;
        }
        return sum;
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
        throw new NotImplementedException();
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        throw new NotImplementedException();
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
        return arrayList.stream().map(integer -> integer * 3).collect(Collectors.toList());
    }
}
