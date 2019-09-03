package com.ekfet.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;

import java.util.concurrent.ExecutionException;

public class RedisCommon {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RedisClient redisClient = RedisClient.create("redis://192.168.1.112:6379");
        StatefulRedisConnection connection = redisClient.connect();
        RedisAsyncCommands<String, String> redisAsyncCommands = connection.async();
        redisAsyncCommands.set("com.ekfet.redis", "1");
        String a = redisAsyncCommands.get("com.ekfet.redis").get();
        System.out.println(a);

    }
}
