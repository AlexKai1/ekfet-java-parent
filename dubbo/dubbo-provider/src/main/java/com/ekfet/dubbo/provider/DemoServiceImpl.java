package com.ekfet.dubbo.provider;


import org.apache.dubbo.config.annotation.Service;

import java.util.UUID;

@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String getUserName() {
        return UUID.randomUUID().toString();
    }
}
