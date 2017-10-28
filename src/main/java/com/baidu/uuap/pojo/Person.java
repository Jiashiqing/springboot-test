package com.baidu.uuap.pojo;

import javax.validation.constraints.Size;

public class Person {
    //ID  
    private Integer id;
    //姓名
    @Size(min = 2, max = 4)
    private String name;
    //年龄  
    private String age;
    //性别  
    private String sex;

    public Person() {
    }

    public Person(String name, String age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}