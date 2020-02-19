package com.xu.java8.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CycliBarrierDemo {

    private static Integer LONGZHU = 7;
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(LONGZHU, () -> {
            System.out.println("召唤神龙！");
        });
        for (int i = 1; i <=LONGZHU; i++) {
            new Thread(() -> {
                System.out.println("收集到第" + Thread.currentThread().getName() + "颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("释放第"+ Thread.currentThread().getName() + "颗龙珠");
            }, String.valueOf(i)).start();
        }

    }
}
