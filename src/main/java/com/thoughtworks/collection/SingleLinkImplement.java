package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingleLinkImplement<T> implements SingleLink<T> {
    //节点类
    private class Node {
        private T data;
        private Node next;

        public Node() {

        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    int size;

    public SingleLinkImplement() {
        head = null;
        tail = null;
    }

    public SingleLinkImplement(List<T> items) {
        for (int i = 0; i < items.size(); ++i) {
            addTailPointer(items.get(i));
        }
    }

    public Node getNodebyIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("单链表索引越界");
        }
        Node curr = head;
        for (int i = 0; i < size && curr.next != null; ++i, curr = curr.next) {
            if (i == index - 1) {
                return curr;
            }
        }
        return null;
    }

    @Override
    public T getHeaderData() {
        return this.head.data;
    }

    @Override
    public T getTailData() {
        return this.tail.data;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean deleteFirst() {
        if (size == 0) {
            return false;
        }
        head = head.next;
        return true;
    }

    @Override
    public boolean deleteLast() {
        if (this.size == 0)
            return false;
        Node prev = getNodebyIndex(size - 1);
        Node deleteNode = prev.next;
        prev.next = deleteNode.next;
        return true;
    }

    @Override
    public void addHeadPointer(T item) {
        head = new Node(item, head);
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    @Override
    public void addTailPointer(T item) {
        if (head == null) {
            head = new Node(item, null);
            tail = head;
            size++;
            return;
        }
        Node nextNode = new Node(item, null);
        tail.next = nextNode;
        tail = nextNode;
        size++;
    }

    @Override
    public T getNode(int index) {
        return getNodebyIndex(index).data;
    }
}
