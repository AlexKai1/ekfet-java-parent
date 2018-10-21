package com.ekfet.common.thread;

import java.util.concurrent.Semaphore;

/**
 * @author radish.zhou
 * @version v 1.0
 * @ClassName: SemaphoreTest
 * @date 2018/10/21 21:12
 */
public class SemaphoreTest {


    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <=10; i++) {
            new Thread(new Worker(i, semaphore)).start();
        }
    }

    static class Worker implements Runnable {

        private final int num;
        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                this.semaphore.acquire();
                System.out.println("工人 work num=" + this.num);
                Thread.sleep(1000);
                System.out.println("工人" + this.num + "释放出机器");
                this.semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
