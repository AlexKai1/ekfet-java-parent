package com.ekfet.common.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author radish.zhou
 * @version v 1.0
 * @ClassName: ConditionTest
 * @date 2018/10/21 12:53
 */
public class ConditionTest {

    private final ReentrantLock reentrantLock = new ReentrantLock();
    private final Condition condition = reentrantLock.newCondition();

    public static void main(String[] args) {
        ConditionTest test = new ConditionTest();
        test.test();

    }

    public void test() {
        Thread thread1 = new Thread(() -> {
            reentrantLock.lock();
            System.out.println(Thread.currentThread().getName() + "getTestLock.......");
            try {
                condition.await();
                System.out.println(Thread.currentThread().getName() + "condition Awit");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();

        });
        thread1.start();
        new Thread(() -> {
            reentrantLock.lock();
            System.out.println(Thread.currentThread().getName() + "getTestLock++++");
            try {
                condition.signalAll();
                System.out.println(Thread.currentThread().getName() + "signalAll");
            } catch (Exception e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();

        }).start();
    }
}
