package com.yqf.athl.dt;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.yqf.athl.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 算法第四版 p95 基于链表实现的队列
 * @param <T>
 */
public class LinkedQueue<T> {

//    private Queue queue = new ArrayBlockingQueue(10000000);

    private Node first;
    private Node last;
    private int size;
    private class Node {
        private T val;
        private Node next;
    }


    public void enqueue(T item){
        Node node = new Node();
        node.val = item;

        if (first == null) {
           last= first = node;

        }else{
            last.next = node;
            last = last.next;
        }
        size++;

    }

    public T dequeue(){
        T val = first.val;

        if (first!=null && first == last) {
            first = last = null;

        }else if (first ==null){
            throw new RuntimeException("美东西了");

        }else {
            Node next = first.next;
            first.next = null;
            first = next;
        }
        size--;
        return val;

    }

    public boolean isempty(){
        return first == null;
    }
    public int size(){
        return size;
    }
    public static void main(String[] args) {
        LinkedQueue<Integer> linkedQueue = new LinkedQueue();
        List<Integer> collect = Arrays.stream(Utils.getIntegers(new Random())).collect(Collectors.toList());
        for (Integer d : collect) {
            linkedQueue.enqueue(d);
        }
        ArrayList<Integer> d23 = Lists.newArrayList();
        while (!linkedQueue.isempty()) {
            d23.add(linkedQueue.dequeue());
        }

        Preconditions.checkArgument(d23.equals(collect));

    }
}
