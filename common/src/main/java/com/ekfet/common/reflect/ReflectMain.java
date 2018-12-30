package com.ekfet.common.reflect;

import java.lang.reflect.Method;

/**
 * @author radish.zhou
 * @version v 1.0
 * @ClassName: ReflectMain
 * @date 2018/12/26 21:41
 */
public class ReflectMain {

    public static void main(String[] args) throws Exception {
        new ReflectMain().test();
//        Map<String,String> map= Map.of("a","b");
    }

    public void test() throws Exception{
        Class<?> clazz = Class.forName("java.lang.Integer");
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        Object obj=clazz.getDeclaredConstructor().newInstance();
        Method method=clazz.getMethod("valueOf", String.class);
       Object one=  method.invoke(obj,"23");
        System.out.println(one);

//        Object object = method.invoke("1");
//        System.out.println(object);
    }
}
