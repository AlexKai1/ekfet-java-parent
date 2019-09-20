package com.ekfet.spring.ioc;

import org.springframework.beans.factory.FactoryBean;

public class DriverFactoryBean implements FactoryBean {
    @Override
    public boolean isSingleton() {
        return false;
    }

    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
