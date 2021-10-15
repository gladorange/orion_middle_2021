package com.orion.lesson5;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PairExample {

    static class PairIterator<T> implements Iterator<T> {

        int pointer = 1;

        final Pair<T> pair;

        PairIterator(Pair<T> pair) {
            this.pair = pair;
        }

        @Override
        public boolean hasNext() {
            return pointer < 3;
        }

        @Override
        public T next() {
            if (pointer == 1) {
                pointer++;
                return pair.first;
            } else if (pointer == 2) {
                pointer++;
                return pair.second;
            }

            throw new NoSuchElementException();
        }
    }

    static class Pair<TYPE> implements Iterable<TYPE>{
        TYPE first;
        TYPE second;


        public Pair(TYPE first, TYPE second) {
            this.first = first;
            this.second = second;
        }

        public TYPE getFirst() {
            return first;
        }

        public TYPE getSecond() {
            return second;
        }

        @Override
        public Iterator<TYPE> iterator() {
            return new PairIterator<>(this);
        }
    }


    public static void main(String[] args) {
        Pair<String> p = new Pair<>("one", "second");

    //    System.out.println(p.getFirst().length());
     //   System.out.println(p.getSecond());

        Pair<Double> p2 = new Pair<>(42.5d,13d);
        final Double first = p2.getFirst();
        // System.out.println(first.intValue());

        for (Double aDouble : p2) {
            System.out.println(aDouble);
        }


    }


}
