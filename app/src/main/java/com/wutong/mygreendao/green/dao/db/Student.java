package com.wutong.mygreendao.green.dao.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by HP on 2019/7/20.
 */


@Entity
public class Student {
    @Id(autoincrement = true)
    Long id;
    @Unique
    int studentNo;//学号
    int age; //年龄
    String name;//姓名
    String school;//姓名
    String wife;//姓名
    String farther;
    @Generated(hash = 650810927)
    public Student(Long id, int studentNo, int age, String name, String school,
            String wife, String farther) {
        this.id = id;
        this.studentNo = studentNo;
        this.age = age;
        this.name = name;
        this.school = school;
        this.wife = wife;
        this.farther = farther;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getStudentNo() {
        return this.studentNo;
    }
    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return this.school;
    }
    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentNo=" + studentNo +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", school='" + school + '\'' +
                ", wife='" + wife + '\'' +
                ", farther='" + farther + '\'' +
                '}';
    }

    public String getWife() {
        return this.wife;
    }
    public void setWife(String wife) {
        this.wife = wife;
    }
    public String getFarther() {
        return this.farther;
    }
    public void setFarther(String farther) {
        this.farther = farther;
    }
}
