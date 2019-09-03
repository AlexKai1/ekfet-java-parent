package com.ekfet.dync.compile.javassist;

import javassist.*;
import javassist.bytecode.AccessFlag;

import java.lang.reflect.Field;

public class Javassist {
    public static void main(String[] args) {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.makeClass("com.ekfet.dync.complie.A");
        ctClass.setInterfaces(new CtClass[]{classPool.makeInterface("java.lang.Cloneable")});
        try {
            CtField ctField = new CtField(CtClass.intType, "id", ctClass);
            ctField.setModifiers(AccessFlag.PUBLIC);
            ctClass.addField(ctField);
            CtConstructor constructor = CtNewConstructor.make("public A(int id){this.id=id;}", ctClass);
            CtMethod helloM = CtNewMethod.make("public void hello(String des){ System.out.println(des);}", ctClass);
            ctClass.addMethod(helloM);
            ctClass.writeFile();

            Field[] fields = ctClass.toClass().getFields();
            System.out.println("属性名称：" + fields[0].getName() + "  属性类型：" + fields[0].getType());
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
}
