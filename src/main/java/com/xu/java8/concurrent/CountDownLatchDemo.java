package com.xu.java8.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static Integer COUNT = 5;
    public static void main(String[] args) throws Exception {
//        closeDoor();
        yitongtianxia();
    }

    public static void yitongtianxia()throws  Exception{
        CountDownLatch countDownLatch = new CountDownLatch(COUNT);

        for (int i = 1; i <COUNT+1; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 国，被灭");
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }, CountryEnum.forEachCountEnum(i).getRetMessage()).start();
        }
//        CountryEnum.forEachCountEnum(1).
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t 秦国一统华夏");

    }

    /**
     * 下自习，所有同学都下课后班长才下课
     * @throws Exception
     */

    public static void closeDoor()throws  Exception{
        CountDownLatch countDownLatch = new CountDownLatch(COUNT);

        for (int i = 0; i <COUNT; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 下课，出门");
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t 班长下课关门");

    }
}
