package com.xu.java8.Stream;

public class Person {
    Person() { i = (j++ != 0) ? ++j : --j; }
    public int i;
    public static int j = 0;
    Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    Integer rate;

    public Person(Integer age, Integer rate) {
        this.age = age;
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", rate=" + rate +
                '}';
    }
}
