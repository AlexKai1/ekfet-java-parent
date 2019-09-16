package com.ekfet.jvm;

import java.net.URL;

public class Jvm {
//    private static ClassLoader classLoader = ClassLoader.getPlatformClassLoader();
private static ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    public static void main(String[] args) {
        URL[] urLs = sun.misc.Launcher. getBootstrapClassPath () . getURLs () ;
        Package [] packages=classLoader.getDefinedPackages();
        for (Package pkg:packages){
            System.out.println(pkg.getName());
        }
    }
}
