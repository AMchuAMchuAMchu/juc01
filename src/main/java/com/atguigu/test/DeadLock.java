package com.atguigu.test;

import java.util.concurrent.TimeUnit;

/**
 * Description ==> TODO
 * BelongsProject ==> juc01
 * BelongsPackage ==> com.atguigu.test
 * Version ==> 1.0
 * CreateTime ==> 2023-02-27 17:43:14
 * Author ==> _02雪乃赤瞳楪祈校条祭_艾米丽可锦木千束木更七草荠_制作委员会_start
 */
public class DeadLock {
    public static void main(String[] args) {
        Object lock01 = new Object();

        Object lock02 = new Object();

        new Thread(()->{
            synchronized (lock01){
                System.out.println("AA..");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock02){
                    System.out.println("BB..");
                }
            }
        },"T1").start();

        new Thread(()->{
            synchronized (lock02){
                System.out.println("CC..");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock01){
                    System.out.println("DD..");
                }
            }
        },"T2").start();



    }
}
