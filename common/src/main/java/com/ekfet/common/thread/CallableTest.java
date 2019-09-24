package com.ekfet.common.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws Exception {
        FutureTask<String> task=new FutureTask(new TestCallable());
        task.run();
        String a=  task.get();
        System.out.println(a);
    }

    static class TestCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "test";
        }
    }
}
