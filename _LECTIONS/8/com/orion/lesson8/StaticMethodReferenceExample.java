package com.orion.lesson8;

import java.util.ArrayList;
import java.util.List;

public class StaticMethodReferenceExample {


    public static void main(String[] args) {


        List<String> someStrings = new ArrayList<>(List.of("a", "B", "c", "ASD", "s"));


        System.out.println(someStrings);

      //  someStrings.removeIf(str -> str.toLowerCase().equals(str));
      //  someStrings.removeIf(StaticMethodReferenceExample::deleteInLowerCase);

        //   RemoveByLength remover = new RemoveByLength(1);
        RemoveByLength remover = new RemoveByLength(3);
        someStrings.removeIf(remover::removeByLength);
        System.out.println(someStrings);



    }

    public static boolean deleteInLowerCase(String str) {
        return str.toLowerCase().equals(str);
    }


    public static class RemoveByLength {
        final int lengthToRemove;

        public RemoveByLength(int lengthToRemove) {
            this.lengthToRemove = lengthToRemove;
        }

        public boolean removeByLength(String str) {
            return str.length() == lengthToRemove;
        }
    }


}
