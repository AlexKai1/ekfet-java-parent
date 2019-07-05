package com.ekfet.zkcurator;


import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ZookeeperTest {
    static int count = 0;

    @Test
    public void TestLocked() throws InterruptedException {
        final DistributorLock distributorLock = new DistributorLock("localhost:2181", 3);
        for (int i = 0; i <100; i++) {

            new Thread(() -> {

                try {
                    boolean lock = distributorLock.tryLocked("1", "1");
                    if (lock) {
                        count++;
                        System.out.println("count=" + count);
                    }else{
                        System.out.println("count3121=" + count);
                    }
                } finally {
                    distributorLock.release();
                }

            }).start();
        }

        Thread.sleep(60000);
        System.out.println(count);
    }

    @Test
    public void test2132() throws InterruptedException {
        final String zkConnect = "localhost:2181";
        final String lockPath = "/lock";

        CuratorFramework curatorClient = CuratorFrameworkFactory.newClient(zkConnect, new ExponentialBackoffRetry(1000, 3));
        curatorClient.start();
        for (int i = 1; i <= 100; i++) {
            new Thread(() -> {
                InterProcessSemaphoreMutex dMutex = new InterProcessSemaphoreMutex(curatorClient, lockPath);
                try {
                    if (dMutex.acquire(3, TimeUnit.SECONDS)) {
                        count++;
                        System.out.println("Count=" + count);
                    } else {
                        System.out.println("===============");
                    }
                } catch (Exception e) {
                    e.printStackTrace();

                } finally {
                    try {
                        dMutex.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }).start();
        }
        Thread.sleep(10000);

    }


}



