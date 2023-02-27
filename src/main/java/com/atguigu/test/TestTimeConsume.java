package com.atguigu.test;

import java.io.Serializable;

/**
 * Description ==> TODO
 * BelongsProject ==> juc01
 * BelongsPackage ==> com.atguigu.test
 * Version ==> 1.0
 * CreateTime ==> 2023-02-27 12:57:01
 * Author ==> _02雪乃赤瞳楪祈校条祭_艾米丽可锦木千束木更七草荠_制作委员会_start
 */
public class TestTimeConsume {


    public static void main(String[] args) {

        long start  = System.currentTimeMillis();

//        测试一下更大的数目看看有什么区别
//        serial();//第一次:554毫秒 第二次:564毫秒 第三次:562毫秒

        concurrent(start);//第一次:573毫秒 第二次:542毫秒 第三次:570毫秒

        long end  = System.currentTimeMillis();

        System.out.println("消耗时间:"+(end-start)+"毫秒");

    }

    public static void serial(){
        long num01 = 0;
        for (long i = 0; i < 1000000000; i++) {
            num01++;
        }
        System.out.println("结果:"+num01);
    }

    public static void concurrent(long start){
            new Thread(()->{
                serial();

                long end  = System.currentTimeMillis();

                System.out.println("消耗时间:"+(end-start)+"毫秒");
            }).start();
    }


}
