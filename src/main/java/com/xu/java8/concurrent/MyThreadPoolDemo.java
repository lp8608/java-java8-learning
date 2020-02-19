package com.xu.java8.concurrent;

import java.util.concurrent.*;

/**
 * @author lipengak
 * @Description 自定义线程池
 * @Date 2019/10/6 23:33
 * @Copyright 2019-2020
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        // CPU密集型 ： CPU密集型 ： cpu数+1
        // IO密集型： cpu数/(1 - 0.9)
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        threadPoolInit(threadPool);
    }


    /**
    * @Description jdk自带线程池
    * @Date   2019/10/6 23:41
    *
    */
    public static void threadPoolInit(ExecutorService threadPool) {
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        ExecutorService threadPool = Executors.newCachedThreadPool();


        try{
            for (int i = 0; i < 10; i++) {
                threadPool.execute(()->{
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            threadPool.shutdown();

        }
    }
}
