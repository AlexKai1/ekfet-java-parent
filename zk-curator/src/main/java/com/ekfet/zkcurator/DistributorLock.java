package com.ekfet.zkcurator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

public class DistributorLock {
    //private final static String zkHost = "192.168.1.112:2181";

    private final static String zkDisPath = "/distributed/zook/locks/{0}/{1}";

    private static ThreadLocal<InterProcessMutex> interProcessMutexThreadLocal = new ThreadLocal<>();
    private String zkHost;
    private int maxRetries = 3;
    private CuratorFramework curatorFramework;

    public DistributorLock(String zkHost, int maxRetries) {
        this.maxRetries = maxRetries;
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, maxRetries);
        this.curatorFramework = CuratorFrameworkFactory.builder().connectString(zkHost).sessionTimeoutMs(2000).retryPolicy(retryPolicy).build();
        this.curatorFramework.start();
    }

    public boolean tryLocked(String lockName, String lockId) {
        try {
            InterProcessMutex interProcessMutex = new InterProcessMutex(curatorFramework, MessageFormat.format(zkDisPath, lockName,lockId));
            interProcessMutexThreadLocal.set(interProcessMutex);
            boolean success=interProcessMutex.acquire(1,TimeUnit.SECONDS);
            System.out.println("Success:="+success+"   tryLocked="+Thread.currentThread().getName());
            return success;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    public  void release() {
        try {
            InterProcessMutex locked = interProcessMutexThreadLocal.get();
            locked.release();
            System.out.println("release:="+Thread.currentThread().getName());
        } catch (Exception e) {
          e.printStackTrace();
        }
    }

}
