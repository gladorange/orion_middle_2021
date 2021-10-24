package com.orion.lesson5;

public class ClosureExample {


    interface ButtonClickListener {
        void onClick();
    }


    static class SomeButtonClickListener implements ButtonClickListener{
        String variable;

        public SomeButtonClickListener(String variable) {
            this.variable = variable;
        }

        @Override
        public void onClick() {
            System.out.println(variable);
        }
    }

    public static void main(String[] args) {


        final String text = "Нажали кнопку";

        ButtonClickListener listener = new ButtonClickListener() {
            @Override
            public void onClick() {
                System.out.println(text);
            }
        };

        ButtonClickListener lambda = () -> System.out.println(text);

        ButtonClickListener anotherListener = new SomeButtonClickListener(text);
       // text = "another text";
        anotherListener.onClick(); // выведет Нажали кнопку



    }



}
