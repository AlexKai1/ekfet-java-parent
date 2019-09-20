package com.ekfet.spring.ioc;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.util.Arrays;

/**
 * Bean装在
 */
public class BeanDefinitionReaderExample {
    public static void main(String[] args) {
        //注册中心
        BeanDefinitionRegistry beanDefinitionRegistry = new SimpleBeanDefinitionRegistry();
        //xml注册读取器
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanDefinitionRegistry);
        //资源读取器
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("spring-ioc.xml");
        //装在构建bean定义
        reader.loadBeanDefinitions(resource);
        System.out.println(Arrays.toString(beanDefinitionRegistry.getBeanDefinitionNames()));
        System.out.println(beanDefinitionRegistry.getBeanDefinition("helloSpring4"));
    }
}
