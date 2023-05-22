package com.example.studentsmanagerandroind;

import java.io.Serializable;

public class Student implements Serializable {
    private String name, address, gender;
    private int id, tel, age;

    public Student(String name, String address, String gender, int tel, int age, int id) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.tel = tel;
        this.age = age;
        this.id = id;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", adress='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", tel=" + tel +
                ", age=" + age +
                '}';
    }
}
