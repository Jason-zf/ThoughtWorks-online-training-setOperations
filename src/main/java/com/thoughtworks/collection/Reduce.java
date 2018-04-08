package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collections;
import java.util.List;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return Collections.max(this.arrayList);
    }

    public double getMinimum() {
        return Collections.min(this.arrayList);
    }

    public double getAverage() {
        return this.arrayList.stream().mapToInt(value -> value).average().getAsDouble();
    }

    public double getOrderedMedian() {
        Collections.sort(this.arrayList);
        return this.arrayList.size() % 2 == 0 ? (this.arrayList.get(this.arrayList.size() / 2 - 1) + this.arrayList.get(this.arrayList.size() / 2)) / 2.0 : this.arrayList.get(this.arrayList.size() / 2);
    }

    public int getFirstEven() {
        throw new NotImplementedException();
    }

    public int getIndexOfFirstEven() {
        throw new NotImplementedException();
    }

    public boolean isEqual(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
        throw new NotImplementedException();
    }

    public int getLastOdd() {
        throw new NotImplementedException();
    }

    public int getIndexOfLastOdd() {
        throw new NotImplementedException();
    }
}
