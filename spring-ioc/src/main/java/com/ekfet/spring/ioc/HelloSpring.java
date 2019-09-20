package com.ekfet.spring.ioc;

public class HelloSpring {
    private String index;
    private Integer age;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public HelloSpring() {
    }

    public HelloSpring(String index, Integer age) {
        this.index = index;
        this.age = age;
    }

    public static HelloSpring build() {
        return new HelloSpring();
    }
}
