package com.example.studentsmanagerandroind;

import java.io.Serializable;

public class Student implements Serializable {
    private String name, adress, gender;
    private int tel, age;

    public Student(String name, String adress, String gender, int tel, int age) {
        this.name = name;
        this.adress = adress;
        this.gender = gender;
        this.tel = tel;
        this.age = age;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", gender='" + gender + '\'' +
                ", tel=" + tel +
                ", age=" + age +
                '}';
    }
}
