package com.ekfet.common.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author radish.zhou
 * @version v 1.0
 * @ClassName: CountDownLatchTest
 * @date 2018/10/21 17:07
 */
public class CountDownLatchTest {

    private final static CountDownLatch countDownLatch=new CountDownLatch(3);

    private  static ExecutorService executorService= newFixedThreadPool(5);

    public static void main(String[] args) throws Exception {

        System.out.println("start============");
        executorService.execute(()->{

            try {
                Thread.sleep(3000);
                System.out.println("test1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();

        });
        executorService.execute(()->{
            System.out.println("test2");
            countDownLatch.countDown();
        });
        executorService.execute(()->{
            System.out.println("test3");
            countDownLatch.countDown();
        });

        countDownLatch.await();
        System.out.println("end============");
    }



}
