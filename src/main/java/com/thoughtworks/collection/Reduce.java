package com.thoughtworks.collection;

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
        return this.arrayList.stream().filter(integer -> integer % 2 == 0).findFirst().get();
    }

    public int getIndexOfFirstEven() {
        return this.arrayList.indexOf(getFirstEven());
    }

    public boolean isEqual(List<Integer> arrayList) {
        return this.arrayList.equals(arrayList);
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
        SingleLink singleLink1 = new SingleLinkImplement<Integer>(this.arrayList);
        for (int i = 0; i < this.arrayList.size(); ++i) {
            singleLink.addTailPointer(this.arrayList.get(i));
        }
        return singleLink1.size() % 2 == 0 ? ((Integer) singleLink1.getNode(singleLink1.size() / 2) + (Integer) singleLink1.getNode(singleLink1.size() / 2 + 1)) / 2.0 : (Integer) singleLink1.getNode(singleLink1.size() / 2);
    }

    public int getLastOdd() {
        return this.arrayList.stream().filter(integer -> integer % 2 == 1).reduce((first, second) -> second).get();
    }

    public int getIndexOfLastOdd() {
        return this.arrayList.indexOf(getLastOdd());
    }
}

