package com.orion.lesson5;

import java.util.NoSuchElementException;

public class IteratorExample {



    public static class ArrayIterator<T> {
        final T[] array;
        int counter = 0;

        public T next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[counter++];
        }

        public ArrayIterator(T[] array) {
            this.array = array;
        }

        public boolean hasNext() {
            return counter < array.length && array[counter] != null;
        }
    }


    public static void main(String[] args) {

        String[] strs = new String[10];
        strs[0] = "1";
        strs[1] = "2";


        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            System.out.println(str);
        }

        ArrayIterator<String> iterator = new ArrayIterator<>(strs);

        while (iterator.hasNext()) {
            final String next = iterator.next();
            System.out.println(next);
        }


    }
}
