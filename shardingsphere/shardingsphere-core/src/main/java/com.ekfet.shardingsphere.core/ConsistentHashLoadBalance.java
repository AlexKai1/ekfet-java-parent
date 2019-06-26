package com.ekfet.shardingsphere.core;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashLoadBalance {

    private final int virtualNum;
    static private TreeMap<Long, Integer> nodes;


    public ConsistentHashLoadBalance(int virtualNum, int shardsNum) {
        this.virtualNum = virtualNum;
        nodes = new TreeMap<Long, Integer>();
        for (int i = 0; i < shardsNum; i++) {
            for (int j = 0; j < virtualNum; j++) {
                nodes.put(hash(md5("SHARD-" + i + "-NODE-" + j), j), i);
            }
        }
    }

    public Integer getShardNum(String str) {
        Long key = hash(md5(str), virtualNum - 1);
        SortedMap<Long, Integer> tailMap = nodes.tailMap(key);
        if (tailMap.isEmpty()) {
            key = nodes.firstKey();
        } else {
            key = tailMap.firstKey();
        }
        return nodes.get(key);
    }

    public long hash(byte[] digest, int nTime) {
        long rv = ((long) (digest[3 + nTime * 4] & 0xFF) << 24)
                | ((long) (digest[2 + nTime * 4] & 0xFF) << 16)
                | ((long) (digest[1 + nTime * 4] & 0xFF) << 8)
                | (digest[0 + nTime * 4] & 0xFF);

        return rv & 0xffffffffL;
    }

    private byte[] md5(String value) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException var6) {
            throw new IllegalStateException(var6.getMessage(), var6);
        }

        md5.reset();

        byte[] bytes;
        try {
            bytes = value.getBytes("UTF-8");
        } catch (UnsupportedEncodingException var5) {
            throw new IllegalStateException(var5.getMessage(), var5);
        }

        md5.update(bytes);
        return md5.digest();
    }

    public static void main(String[] args) {
        ConsistentHashLoadBalance consistencyHash = new ConsistentHashLoadBalance(4, 8);
        //循环50次，是为了取50个数来测试效果，当然也可以用其他任何的数据来测试
        for (int i = 1; i <= 10000; i++) {
            int num = consistencyHash.getShardNum(String.valueOf(i));
            System.out.println("id：" + i + "分片：" + num);
        }
        System.out.println(consistencyHash.getShardNum("9999"));
    }

}
