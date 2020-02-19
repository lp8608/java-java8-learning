package com.xu.java8.concurrent;


import java.util.concurrent.*;
class HoldLockThread implements Runnable{

    private String locka;
    private String lockb;

    public HoldLockThread(String locka, String lockb) {
        this.locka = locka;
        this.lockb = lockb;
    }

    @Override
    public void run() {
        synchronized (locka){
            System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + locka + "\t 尝试获取" + lockb);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockb){
                System.out.println(Thread.currentThread().getName() + "\t 自己持有：" + lockb + "\t 尝试获取" + locka);
            }
        }
    }

}
/**
 * @author lipengak
 * @Description 死锁例子
 * @Date 2019/10/7 0:57
 * @Copyright 2019-2020
 * 死锁是指两个或两个以上的进程在执行过程中
 * 因争夺资源造成的一种相互等待的现象，
 * 若无外力干涉那他们将无法推进下去
 */
public class DeadLockDemo {

    public static void main(String[] args) {
        String locka = "locka";
        String lockb = "lockb";
        new Thread(new HoldLockThread(locka,lockb), "aaa").start();
        new Thread(new HoldLockThread(lockb,locka), "bbb").start();

        //排查线程死锁
        /**
         * linux  ps -ef|grep xxx
         * window 下java运行程序，也有类似ps查看进程的命令 但是目前我们需要查询的只是java
         * jps = java版本的ps : jps -l
         * 查看进程堆栈信息：jstack pid
         *
         */

    }


}
