package com.company;

import java.sql.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList(Arrays.asList(1,2,3,3,4,4,5,6,123,12));

        list.stream()
             .distinct()
                .map(integer -> integer==3 ? 8 : integer)
                .filter(o -> o%3==0 || o%2==0)
                .sorted((o1, o2) -> o2.hashCode()*2-o1.hashCode())
                .forEach(System.out::println);

        Thread thread = new Thread(() -> {
            for (var i = 1; i<8; i++) {
                try {
                    System.out.println(Thread.currentThread().getName()+" "+i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set set = new HashSet();
        NavigableSet set1 = new TreeSet();
        List list1 = new Stack();
        Queue queue = new ArrayDeque();


        Collections.addAll(queue, new Integer[] {1,2,3,4,5,7,8,9});
//        queue.addAll(Arrays.asList(new Integer[] {1,2,3,4,5,6,7,8,9}));
        Thread thread1 = new Thread(() -> {
            queue.forEach(o -> {
                System.out.println(Thread.currentThread().getName()+" "+o.toString());
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
        thread.start();
       
    }
}
