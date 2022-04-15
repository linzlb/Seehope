package com.linzlb.lambda;

public class Person {
    private String name;
    private Integer age;
    private Integer score;
    private String sex;

    public Person() {
    }

    public Person(String name, Integer age, Integer score, String sex) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", sex='" + sex + '\'' +
                '}';
    }
}